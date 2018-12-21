package com.glgw.pay.service;


import com.alibaba.fastjson.JSONObject;
import com.glgw.pay.api.EnterDefrayApi;
import com.glgw.pay.enums.ErrorCodeConstant;
import com.glgw.pay.request.BatchDefrayRequest;
import com.glgw.pay.response.*;
import com.jd.jr.jropen.sdk.api.BatchDefrayService;
import com.jd.jr.jropen.sdk.model.CommonRequest;
import com.jd.jr.jropen.sdk.model.CommonRequestHeader;
import com.jd.jr.jropen.sdk.model.CommonResponse;
import com.jd.jr.jropen.sdk.model.et.BatchDefrayRequestBody;
import com.jd.jr.jropen.sdk.model.et.BatchDefrayRequestEntry;
import com.jd.jr.jropen.sdk.model.et.EtDefrayResponseBody;
import com.jd.jr.jropen.sdk.model.et.EtDefrayResponseEntry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnterDefrayServiceImpl extends BaseService implements EnterDefrayApi {

    private static final Logger logger = LogManager.getLogger(EnterDefrayServiceImpl.class);

    @Value("${partnerId}")
    private String partnerId;

    /**
     * 批量代付接口
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public GlgwResponse<EtDefrayResponse> defray(BatchDefrayRequest request) throws Exception {
        final long reqNum = System.currentTimeMillis();
        logger.info("请求编号:{},批量代付接口上送数据：{}", reqNum, request);

        GlgwResponse<EtDefrayResponse> response = new GlgwResponse();

        //请求体
        BatchDefrayRequestBody body = new BatchDefrayRequestBody();
        body.setPartnerId(partnerId);
        body.setBizTradeNo(request.getBizTradeNo());
        body.setAmount(request.getAmount());
        body.setTotalNum(request.getTotalNum());
        body.setTranCode(request.getTranCode());

        if (request.getList() != null && request.getList().size() > 0) {
            List<BatchDefrayRequestEntry> entryList = new ArrayList<>();
            BatchDefrayRequestEntry entry = null;
            for (BatchDefrayRequestItem item : request.getList()) {
                entry = new BatchDefrayRequestEntry();

                entry.setBizTradeNo(item.getBizTradeNo());
                entry.setMerCustomerId(item.getMerCustomerId());
                entry.setTadType(item.getTadType());
                entry.setTradeAmount(item.getTradeAmount());
                entry.setTradeSubject(item.getTradeSubject());
                entry.setRemark(item.getRemark());
                entry.setToPersonal(item.getToPersonal());
                entry.setBankCode(item.getBankCode());
                entry.setBankAccountNo(item.getBankAccountNo());
                entry.setBankAccountName(item.getBankAccountName());
                entry.setBankName(item.getBankName());
                entry.setCity(item.getCity());
                entry.setProviences(item.getProviences());
                entry.setSubsidiaryCode(item.getSubsidiaryCode());
                entry.setSubsidiaryName(item.getSubsidiaryName());
                entry.setName(item.getName());
                entry.setCardType(item.getCardType());
                entry.setIdNumber(item.getIdNumber());
                entry.setMobileNo(item.getMobileNo());
                entry.setCustomerLoginType(item.getCustomerLoginType());
                entry.setCustomerNo(item.getCustomerNo());
                entry.setReturnParams(item.getReturnParams());
                entry.setNotifyUrl(item.getNotifyUrl());

                entryList.add(entry);
            }
            body.setList(entryList);
        }

        //请求头
        CommonRequestHeader header = setCommonRequestHeader(JSONObject.toJSONString(body));

        //请求数据
        CommonRequest<BatchDefrayRequestBody> commonRequest = new CommonRequest<BatchDefrayRequestBody>();
        commonRequest.setRequestHeader(header);
        commonRequest.setRequestBody(body);


        logger.info("请求编号:{},京东上送数据项={}", reqNum, commonRequest);
        BatchDefrayService batchDefrayService = new BatchDefrayService();
        CommonResponse<EtDefrayResponseBody> commonResponse = batchDefrayService.defray(commonRequest);
        logger.info("请求编号:{},京东返回数据项={}", reqNum, commonResponse);

        if (commonResponse != null && commonResponse.getResponseHeader() != null) {
            //先判断响应头信息
            if ("00000".equals(commonResponse.getResponseHeader().getCode())) {
                //在判断响应体信息
                if ("00000".equals(commonResponse.getResponseBody().getErrorCode())) {
                    EtDefrayResponseBody jdEtDefrayResponseBody = commonResponse.getResponseBody();
                    com.jd.jr.jropen.sdk.model.et.EtDefrayResponse jdEtDefrayResponse = jdEtDefrayResponseBody.getDatas();


                    EtDefrayResponse hjEtDefrayResponse = new EtDefrayResponse();
                    hjEtDefrayResponse.setErrorCode(jdEtDefrayResponseBody.getErrorCode());
                    hjEtDefrayResponse.setErrorMessage(jdEtDefrayResponseBody.getErrorMessage());

                    EtDefrayResponseItem hjEtDefrayResponseItem = new EtDefrayResponseItem();
                    hjEtDefrayResponseItem.setBizTradeNo(jdEtDefrayResponse.getBizTradeNo());
                    hjEtDefrayResponseItem.setOutTradeNo(jdEtDefrayResponse.getOutTradeNo());
                    hjEtDefrayResponseItem.setTradeStatus(jdEtDefrayResponse.getTradeStatus());
                    hjEtDefrayResponseItem.setOriginalOrderNo(jdEtDefrayResponse.getOriginalOrderNo());
                    if (jdEtDefrayResponse.getRecord() != null && jdEtDefrayResponse.getRecord().size() > 0) {
                        List<EtDefrayResponseEntryItem> itemList = new ArrayList<EtDefrayResponseEntryItem>();
                        EtDefrayResponseEntryItem item = null;

                        for (EtDefrayResponseEntry entry : jdEtDefrayResponse.getRecord()) {
                            item = new EtDefrayResponseEntryItem();
                            item.setBizTradeNo(entry.getBizTradeNo());
                            item.setOutTradeNo(entry.getOutTradeNo());
                            item.setTradeStatus(entry.getTradeStatus());
                            item.setTradeAmount(entry.getTradeAmount());
                            item.setResponseDate(entry.getResponseDate());
                            item.setFinishDate(entry.getFinishDate());
                            item.setResponseCode(entry.getResponseCode());
                            item.setResponseMessage(entry.getResponseMessage());
                            item.setResponseTime(entry.getResponseTime());

                            itemList.add(item);
                        }
                        hjEtDefrayResponseItem.setRecord(itemList);
                    }
                    hjEtDefrayResponse.setDatas(hjEtDefrayResponseItem);

                    response.setBody(hjEtDefrayResponse);
                    response.setSuccess();
                } else {
                    response.setFail(commonResponse.getResponseBody().getErrorCode(), commonResponse.getResponseBody().getErrorMessage());
                }
            } else {
                response.setFail(commonResponse.getResponseHeader().getCode(), commonResponse.getResponseHeader().getMsg());
            }
        } else {
            response.setFail(ErrorCodeConstant.SYSTEM_EXCEPTION.getValue(), ErrorCodeConstant.SYSTEM_EXCEPTION.getName());
        }

        logger.info("请求编号:{},批量代付接口返回数据：{}", reqNum, response);
        return response;
    }

}
