package com.glgw.pay.service;

import com.alibaba.fastjson.JSONObject;
import com.glgw.pay.api.EnterpriseAccountApi;
import com.glgw.pay.enums.ErrorCodeConstant;
import com.glgw.pay.request.*;
import com.glgw.pay.response.*;
import com.jd.jr.jropen.sdk.api.CommonUtilService;
import com.jd.jr.jropen.sdk.api.EnterpriseAccountService;
import com.jd.jr.jropen.sdk.api.EnterpriseTradeQueryService;
import com.jd.jr.jropen.sdk.api.EnterpriseTradeService;
import com.jd.jr.jropen.sdk.model.CommonRequest;
import com.jd.jr.jropen.sdk.model.CommonRequestHeader;
import com.jd.jr.jropen.sdk.model.CommonResponse;
import com.jd.jr.jropen.sdk.model.enter.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.util.StringUtil;

/**
 * 企业账户相关操作
 */
@Service
public class EnterpriseAccountServiceImpl extends BaseService implements EnterpriseAccountApi {

    private static final Logger logger = LogManager.getLogger(EnterpriseAccountServiceImpl.class);


    /**
     * 企业资金账户信息查询接口
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public GlgwResponse<EnterAccountInfoResponse> queryAccountInfo(EnterAccountInfoRequest request) throws Exception {
        final long reqNum = System.currentTimeMillis();
        logger.info("请求编号:{},企业资金账户信息查询接口上送数据：{}", reqNum, request);

        GlgwResponse<EnterAccountInfoResponse> response = new GlgwResponse();

        //请求体
        EnterAccountInfoRequestBody body = new EnterAccountInfoRequestBody();
        body.setMerCustomerId(request.getMerCustomerId());

        //请求头
        CommonRequestHeader header = setCommonRequestHeader(JSONObject.toJSONString(body));

        //请求数据
        CommonRequest<EnterAccountInfoRequestBody> commonRequest = new CommonRequest();
        commonRequest.setRequestHeader(header);
        commonRequest.setRequestBody(body);


        logger.info("请求编号:{},京东上送数据项={}", reqNum, commonRequest);
        EnterpriseAccountService enterpriseAccountService = new EnterpriseAccountService();
        CommonResponse<EnterAccountInfoResponseBody> commonResponse = enterpriseAccountService.queryAccountInfo(commonRequest);
        logger.info("请求编号:{},京东返回数据项={}", reqNum, commonResponse);


        if (commonResponse != null && commonResponse.getResponseHeader() != null) {
            if ("00000".equals(commonResponse.getResponseHeader().getCode())) {
                EnterAccountInfoResponseBody responseBody = commonResponse.getResponseBody();
                if ("success".equals(responseBody.getResponseCode())) {
                    EnterAccountInfoResponse enterAccountInfoResponse = new EnterAccountInfoResponse();

                    enterAccountInfoResponse.setAmount(responseBody.getAmount());
                    enterAccountInfoResponse.setFrozenAmount(responseBody.getFrozenAmount());
                    enterAccountInfoResponse.setSettleBanance(responseBody.getSettleBanance());
                    enterAccountInfoResponse.setStatus(responseBody.getStatus());

                    response.setBody(enterAccountInfoResponse);
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

        logger.info("请求编号:{},企业资金账户信息查询接口返回数据：{}", reqNum, response);
        return response;
    }


    /**
     * 余额充值收单接口
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public GlgwResponse<BalanceRechargeOrderResponse> balanceRechargeOrder(BalanceRechargeOrderRequest request) throws Exception {
        final long reqNum = System.currentTimeMillis();
        logger.info("请求编号:{},余额充值收单接口上送数据：{}", reqNum, request);


        GlgwResponse<BalanceRechargeOrderResponse> response = new GlgwResponse();

        //请求体
        BalanceRechargeOrderRequestBody body = new BalanceRechargeOrderRequestBody();
        body.setMerCustomerId(request.getMerCustomerId());
        body.setMerOrderNo(request.getMerOrderNo());
        body.setOrderAmount(request.getOrderAmount());
        body.setCallBackUrl(request.getCallBackUrl());
        body.setMemo(request.getMemo());

        //请求头
        CommonRequestHeader header = setCommonRequestHeader(JSONObject.toJSONString(body));

        //请求数据
        CommonRequest<BalanceRechargeOrderRequestBody> commonRequest = new CommonRequest();
        commonRequest.setRequestHeader(header);
        commonRequest.setRequestBody(body);


        logger.info("请求编号:{},京东上送数据项={}", reqNum, commonRequest);
        EnterpriseTradeService enterpriseTradeService = new EnterpriseTradeService();
        CommonResponse<BalanceRechargeOrderResponseBody> commonResponse = enterpriseTradeService.balanceRechargeOrder(commonRequest);
        logger.info("请求编号:{},京东返回数据项={}", reqNum, commonResponse);


        if (commonResponse != null && commonResponse.getResponseHeader() != null) {
            if ("00000".equals(commonResponse.getResponseHeader().getCode())) {
                BalanceRechargeOrderResponseBody responseBody = commonResponse.getResponseBody();
                if ("success".equals(responseBody.getResponseCode())) {
                    BalanceRechargeOrderResponse balanceRechargeOrderResponse = new BalanceRechargeOrderResponse();

                    balanceRechargeOrderResponse.setMerCustomerId(responseBody.getMerCustomerId());
                    balanceRechargeOrderResponse.setMerOrderNo(responseBody.getMerOrderNo());
                    balanceRechargeOrderResponse.setOrderAmount(responseBody.getOrderAmount());
                    balanceRechargeOrderResponse.setCashierUrl(responseBody.getCashierUrl());
                    balanceRechargeOrderResponse.setCashierFormData(responseBody.getCashierFormData());

                    if (!StringUtil.isEmpty(responseBody.getCashierUrl()) && null != responseBody.getCashierFormData()) {
                        String formStr = CommonUtilService.buildHttpPostForm("formId", responseBody.getCashierUrl(), responseBody.getCashierFormData());
                        balanceRechargeOrderResponse.setFormStr(formStr);
                    }

                    response.setBody(balanceRechargeOrderResponse);
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

        logger.info("请求编号:{},余额充值收单接口返回数据：{}", reqNum, response);
        return response;
    }


    /**
     * 余额充值订单查询接口
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public GlgwResponse<BalanceRechargeQueryResponse> queryBalanceRechargeInfo(BalanceRechargeQueryRequest request) throws Exception {
        final long reqNum = System.currentTimeMillis();
        logger.info("请求编号:{},余额充值订单查询接口上送数据：{}", reqNum, request);


        GlgwResponse<BalanceRechargeQueryResponse> response = new GlgwResponse();

        //请求体
        BalanceRechargeQueryRequestBody body = new BalanceRechargeQueryRequestBody();
        body.setMerOrderNo(request.getMerOrderNo());

        //请求头
        CommonRequestHeader header = setCommonRequestHeader(JSONObject.toJSONString(body));

        //请求数据
        CommonRequest<BalanceRechargeQueryRequestBody> commonRequest = new CommonRequest();
        commonRequest.setRequestHeader(header);
        commonRequest.setRequestBody(body);


        logger.info("请求编号:{},京东上送数据项={}", reqNum, commonRequest);
        EnterpriseTradeQueryService enterpriseTradeQueryService = new EnterpriseTradeQueryService();
        CommonResponse<BalanceRechargeQueryResponseBody> commonResponse = enterpriseTradeQueryService.queryBalanceRechargeInfo(commonRequest);
        logger.info("请求编号:{},京东返回数据项={}", reqNum, commonResponse);


        if (commonResponse != null && commonResponse.getResponseHeader() != null) {
            if ("00000".equals(commonResponse.getResponseHeader().getCode())) {
                BalanceRechargeQueryResponseBody responseBody = commonResponse.getResponseBody();
                if ("success".equals(responseBody.getResponseCode())) {
                    BalanceRechargeQueryResponse balanceRechargeOrderResponse = new BalanceRechargeQueryResponse();

                    balanceRechargeOrderResponse.setMerCustomerId(responseBody.getMerCustomerId());
                    balanceRechargeOrderResponse.setMerOrderNo(responseBody.getMerOrderNo());
                    balanceRechargeOrderResponse.setOrderAmount(responseBody.getOrderAmount());
                    balanceRechargeOrderResponse.setOrderStatus(responseBody.getOrderStatus());
                    balanceRechargeOrderResponse.setOrderMessage(responseBody.getOrderMessage());
                    balanceRechargeOrderResponse.setJrTradeNo(responseBody.getJrTradeNo());
                    balanceRechargeOrderResponse.setBankSubmitNo(responseBody.getBankSubmitNo());
                    balanceRechargeOrderResponse.setBankName(responseBody.getBankName());

                    response.setBody(balanceRechargeOrderResponse);
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

        logger.info("请求编号:{},余额充值订单查询接口返回数据：{}", reqNum, response);
        return response;
    }


    /**
     * 余额提现收单接口
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public GlgwResponse<BalanceExtractOrderResponse> balanaceExtractOrder(BalanceExtractOrderRequest request) throws Exception {
        final long reqNum = System.currentTimeMillis();
        logger.info("请求编号:{},余额提现收单接口上送数据：{}", reqNum, request);


        GlgwResponse<BalanceExtractOrderResponse> response = new GlgwResponse();

        //请求体
        BalanceExtractOrderRequestBody body = new BalanceExtractOrderRequestBody();
        body.setMerCustomerId(request.getMerCustomerId());
        body.setMerOrderNo(request.getMerOrderNo());
        body.setOrderAmount(request.getOrderAmount());
        body.setMemo(request.getMemo());

        //请求头
        CommonRequestHeader header = setCommonRequestHeader(JSONObject.toJSONString(body));

        //请求数据
        CommonRequest<BalanceExtractOrderRequestBody> commonRequest = new CommonRequest();
        commonRequest.setRequestHeader(header);
        commonRequest.setRequestBody(body);


        logger.info("请求编号:{},京东上送数据项={}", reqNum, commonRequest);
        EnterpriseTradeService enterpriseTradeService = new EnterpriseTradeService();
        CommonResponse<BalanceExtractOrderResponseBody> commonResponse = enterpriseTradeService.balanaceExtractOrder(commonRequest);
        logger.info("请求编号:{},京东返回数据项={}", reqNum, commonResponse);


        if (commonResponse != null && commonResponse.getResponseHeader() != null) {
            if ("00000".equals(commonResponse.getResponseHeader().getCode())) {
                BalanceExtractOrderResponseBody responseBody = commonResponse.getResponseBody();
                if ("success".equals(responseBody.getResponseCode())) {
                    BalanceExtractOrderResponse balanceExtractOrderResponse = new BalanceExtractOrderResponse();

                    balanceExtractOrderResponse.setMerCustomerId(responseBody.getMerCustomerId());
                    balanceExtractOrderResponse.setMerOrderNo(responseBody.getMerOrderNo());
                    balanceExtractOrderResponse.setOrderAmount(responseBody.getOrderAmount());
                    balanceExtractOrderResponse.setOrderCode(responseBody.getOrderCode());

                    response.setBody(balanceExtractOrderResponse);
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

        logger.info("请求编号:{},余额提现收单接口返回数据：{}", reqNum, response);
        return response;
    }

    //余额提现订单查询接口
    @Override
    public GlgwResponse<BalanceExtractQueryResponse> queryBalanaceExtractInfo(BalanceExtractQueryRequest request) throws Exception {
        final long reqNum = System.currentTimeMillis();
        logger.info("请求编号:{},余额提现订单查询接口上送数据：{}", reqNum, request);


        GlgwResponse<BalanceExtractQueryResponse> response = new GlgwResponse();

        //请求体
        BalanceExtractQueryRequestBody body = new BalanceExtractQueryRequestBody();
        body.setMerOrderNo(request.getMerOrderNo());

        //请求头
        CommonRequestHeader header = setCommonRequestHeader(JSONObject.toJSONString(body));

        //请求数据
        CommonRequest<BalanceExtractQueryRequestBody> commonRequest = new CommonRequest();
        commonRequest.setRequestHeader(header);
        commonRequest.setRequestBody(body);


        logger.info("请求编号:{},京东上送数据项={}", reqNum, commonRequest);
        EnterpriseTradeQueryService enterpriseTradeQueryService = new EnterpriseTradeQueryService();
        CommonResponse<BalanceExtractQueryResponseBody> commonResponse = enterpriseTradeQueryService.queryBalanaceExtractInfo(commonRequest);
        logger.info("请求编号:{},京东返回数据项={}", reqNum, commonResponse);


        if (commonResponse != null && commonResponse.getResponseHeader() != null) {
            if ("00000".equals(commonResponse.getResponseHeader().getCode())) {
                BalanceExtractQueryResponseBody responseBody = commonResponse.getResponseBody();
                if ("success".equals(responseBody.getResponseCode())) {
                    BalanceExtractQueryResponse balanceExtractQueryResponse = new BalanceExtractQueryResponse();

                    balanceExtractQueryResponse.setMerCustomerId(responseBody.getMerCustomerId());
                    balanceExtractQueryResponse.setMerOrderNo(responseBody.getMerOrderNo());
                    balanceExtractQueryResponse.setOrderAmount(responseBody.getOrderAmount());
                    balanceExtractQueryResponse.setOrderStatus(responseBody.getOrderStatus());
                    balanceExtractQueryResponse.setOrderMessage(responseBody.getOrderMessage());
                    balanceExtractQueryResponse.setJrTradeNo(responseBody.getJrTradeNo());
                    balanceExtractQueryResponse.setBankSubmitNo(responseBody.getBankSubmitNo());
                    balanceExtractQueryResponse.setBankName(responseBody.getBankName());

                    response.setBody(balanceExtractQueryResponse);
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

        logger.info("请求编号:{},余额提现订单查询接口返回数据：{}", reqNum, response);
        return response;
    }
}
