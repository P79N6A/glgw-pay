package com.glgw.pay.service;

import com.alibaba.fastjson.JSONObject;
import com.glgw.pay.api.EprdPromptPayApi;
import com.glgw.pay.enums.ErrorCodeConstant;
import com.glgw.pay.request.PromptPayAcquirerQueryRequest;
import com.glgw.pay.request.PromptPayAcquirerRequest;
import com.glgw.pay.response.GlgwResponse;
import com.glgw.pay.response.PromptPayAcquirerQueryResponse;
import com.glgw.pay.response.PromptPayAcquirerResponse;
import com.jd.jr.jropen.sdk.api.CommonUtilService;
import com.jd.jr.jropen.sdk.api.EprdPromptPayService;
import com.jd.jr.jropen.sdk.model.CommonRequest;
import com.jd.jr.jropen.sdk.model.CommonRequestHeader;
import com.jd.jr.jropen.sdk.model.CommonResponse;
import com.jd.jr.jropen.sdk.model.enter.PromptPayAcquirerQueryRequestBody;
import com.jd.jr.jropen.sdk.model.enter.PromptPayAcquirerQueryResponseBody;
import com.jd.jr.jropen.sdk.model.enter.PromptPayAcquirerRequestBody;
import com.jd.jr.jropen.sdk.model.enter.PromptPayAcquirerResponseBody;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.util.StringUtil;

@Service
public class EprdPromptPayServiceImpl extends BaseService implements EprdPromptPayApi {

    private static final Logger logger = LogManager.getLogger(EprdPromptPayServiceImpl.class);


    /**
     * 收银台支付接口
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public GlgwResponse<PromptPayAcquirerResponse> getAccountPayAcquirer(PromptPayAcquirerRequest request) throws Exception {
        final long reqNum = System.currentTimeMillis();
        logger.info("请求编号:{},收银台支付接口上送数据：{}", reqNum, request);


        GlgwResponse response = new GlgwResponse();

        //请求体
        PromptPayAcquirerRequestBody body = new PromptPayAcquirerRequestBody();
        body.setInMerCustomerId(request.getInMerCustomerId());   //商户平台收款用户的唯一标识
        body.setOutMerCustomerId(request.getOutMerCustomerId());  //商户平台出款用户的唯一标识，payRoleType对公时该字段必填，对私时为空
        body.setMerOrderNo(request.getMerOrderNo());    //商户订单号，唯一定位一笔订单
        body.setOrderAmount(request.getOrderAmount());    //订单金额，单位：分
        body.setMemo(request.getMemo());   //订单概述，限制30中文
        body.setCallBackUrl(request.getCallBackUrl()); //收银台支付后展示结果的页面，例如http://www.jdpay.com
        body.setPayRoleType(request.getPayRoleType());   //对公对私选项，FOR_CORPORATE：对公
        /**
         * 支付银行类型，
         * NORMAL_PAY：普通银行，由商户平台的用户自主选择银行支付，
         * 商户平台不需要传递payBankCode字段给开放平台，
         * 商户平台的用户在收银台自主选择银行支付。
         */
        body.setPayBankType(request.getPayBankType());
        body.setPayBankCode(request.getPayBankCode());//银行编码

        //请求头
        CommonRequestHeader header = setCommonRequestHeader(JSONObject.toJSONString(body));


        //请求数据
        CommonRequest<PromptPayAcquirerRequestBody> commonRequest = new CommonRequest<PromptPayAcquirerRequestBody>();
        commonRequest.setRequestHeader(header);
        commonRequest.setRequestBody(body);

        logger.info("请求编号:{},京东上送数据项={}", reqNum, commonRequest);
        EprdPromptPayService eprdPromptPayService = new EprdPromptPayService();
        CommonResponse<PromptPayAcquirerResponseBody> commonResponse = eprdPromptPayService.getAccountPayAcquirer(commonRequest);
        logger.info("请求编号:{},京东返回数据项={}", reqNum, commonResponse);

        if (commonResponse != null && commonResponse.getResponseHeader() != null) {
            if ("00000".equals(commonResponse.getResponseHeader().getCode())) {
                PromptPayAcquirerResponseBody responseBody = commonResponse.getResponseBody();
                if ("success".equals(responseBody.getResponseCode())) {
                    PromptPayAcquirerResponse promptPayAcquirerResponse = new PromptPayAcquirerResponse();

                    promptPayAcquirerResponse.setMerOrderNo(responseBody.getMerOrderNo());
                    promptPayAcquirerResponse.setOrderAmount(responseBody.getOrderAmount());
                    promptPayAcquirerResponse.setCashierUrl(responseBody.getCashierUrl());
                    promptPayAcquirerResponse.setCashierFormData(responseBody.getCashierFormData());

                    if (!StringUtil.isEmpty(promptPayAcquirerResponse.getCashierUrl()) && null != promptPayAcquirerResponse.getCashierFormData()) {
                        String formStr = CommonUtilService.buildHttpPostForm("formId", promptPayAcquirerResponse.getCashierUrl(), promptPayAcquirerResponse.getCashierFormData());
                        promptPayAcquirerResponse.setFormStr(formStr);
                    }

                    response.setBody(promptPayAcquirerResponse);
                    response.setSuccess();
                } else {
                    response.setFail(commonResponse.getResponseBody().getResponseCode(), commonResponse.getResponseBody().getResponseDesc());
                }
            } else {
                response.setFail(commonResponse.getResponseHeader().getCode(), commonResponse.getResponseHeader().getMsg());
            }
        } else {
            response.setFail(ErrorCodeConstant.SYSTEM_EXCEPTION.getValue(), ErrorCodeConstant.SYSTEM_EXCEPTION.getName());
        }

        logger.info("请求编号:{},收银台支付接口返回数据：{}", reqNum, response);
        return response;

    }


    /**
     * 实时付款订单查询
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public GlgwResponse<PromptPayAcquirerQueryResponse> queryPromptPayOrder(PromptPayAcquirerQueryRequest request) throws Exception {
        final long reqNum = System.currentTimeMillis();
        logger.info("请求编号:{},实时付款订单查询上送数据：{}", reqNum, request);


        GlgwResponse<PromptPayAcquirerQueryResponse> response = new GlgwResponse();

        //请求体
        PromptPayAcquirerQueryRequestBody body = new PromptPayAcquirerQueryRequestBody();
        body.setMerOrderNo(request.getMerOrderNo());   //商户订单号，唯一定位一笔订单

        //请求头
        CommonRequestHeader header = setCommonRequestHeader(JSONObject.toJSONString(body));

        //请求数据
        CommonRequest<PromptPayAcquirerQueryRequestBody> commonRequest = new CommonRequest<PromptPayAcquirerQueryRequestBody>();
        commonRequest.setRequestHeader(header);
        commonRequest.setRequestBody(body);

        logger.info("请求编号:{},京东上送数据项={}", reqNum, commonRequest);
        EprdPromptPayService eprdPromptPayService = new EprdPromptPayService();
        CommonResponse<PromptPayAcquirerQueryResponseBody> commonResponse = eprdPromptPayService.queryPromptPayOrder(commonRequest);
        logger.info("请求编号:{},京东返回数据项={}", reqNum, commonResponse);

        if (commonResponse != null && commonResponse.getResponseHeader() != null) {
            if ("00000".equals(commonResponse.getResponseHeader().getCode())) {
                PromptPayAcquirerQueryResponseBody responseBody = commonResponse.getResponseBody();
                if ("success".equals(responseBody.getResponseCode())) {
                    PromptPayAcquirerQueryResponse promptPayAcquirerQueryResponse = new PromptPayAcquirerQueryResponse();
                    promptPayAcquirerQueryResponse.setOutMerCustomerId(responseBody.getOutMerCustomerId());
                    promptPayAcquirerQueryResponse.setInMerCustomerId(responseBody.getInMerCustomerId());
                    promptPayAcquirerQueryResponse.setMerOrderNo(responseBody.getMerOrderNo());
                    promptPayAcquirerQueryResponse.setOrderAmount(responseBody.getOrderAmount());
                    promptPayAcquirerQueryResponse.setOutTradeNo(responseBody.getOutTradeNo());
                    promptPayAcquirerQueryResponse.setBizOrderStatus(responseBody.getBizOrderStatus());
                    promptPayAcquirerQueryResponse.setOrderMessage(responseBody.getOrderMessage());
                    promptPayAcquirerQueryResponse.setFinishedTime(responseBody.getFinishedTime());
                    promptPayAcquirerQueryResponse.setBankSubmitNo(responseBody.getBankSubmitNo());
                    promptPayAcquirerQueryResponse.setBankName(responseBody.getBankName());

                    response.setBody(promptPayAcquirerQueryResponse);
                    response.setSuccess();
                } else {
                    response.setFail(commonResponse.getResponseBody().getResponseCode(), commonResponse.getResponseBody().getResponseDesc());
                }
            } else {
                response.setFail(commonResponse.getResponseHeader().getCode(), commonResponse.getResponseHeader().getMsg());
            }
        } else {
            response.setFail(ErrorCodeConstant.SYSTEM_EXCEPTION.getValue(), ErrorCodeConstant.SYSTEM_EXCEPTION.getName());
        }

        logger.info("请求编号:{},实时付款订单查询返回数据：{}", reqNum, response);
        return response;
    }
}
