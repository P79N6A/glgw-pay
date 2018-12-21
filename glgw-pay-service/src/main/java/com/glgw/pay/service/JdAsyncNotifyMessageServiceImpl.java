package com.glgw.pay.service;

import com.glgw.pay.api.JdAsyncNotifyMessageApi;
import com.glgw.pay.request.AsyncNotifyMerMessageRequest;
import com.glgw.pay.response.AsyncNotifyMerResponse;
import com.jd.jr.jropen.sdk.api.AsyncNotifyMerMessageService;
import com.jd.jr.jropen.sdk.enums.AsyncNotifyMerMsgRespStatus;
import com.jd.jr.jropen.sdk.enums.AsyncNotifyMerMsgType;
import com.jd.jr.jropen.sdk.model.AsyncNotifyMerMessage;
import com.jd.jr.jropen.sdk.model.AsyncNotifyMerMessageHeader;
import com.jd.jr.jropen.sdk.model.message.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class JdAsyncNotifyMessageServiceImpl implements JdAsyncNotifyMessageApi {

    private static final Logger logger = LogManager.getLogger(JdAsyncNotifyMessageServiceImpl.class);


    //接收京东发送的异步消息
    @Override
    public AsyncNotifyMerResponse parseMsg(AsyncNotifyMerMessageRequest request) {
        final long reqNum = System.currentTimeMillis();
        logger.info("请求编号:{},接收京东发送的异步消息：{}", reqNum, request);


        AsyncNotifyMerResponse response = new AsyncNotifyMerResponse();

        AsyncNotifyMerMessage<AsyncNotifyMerResponseMessageBody> respMsg = new AsyncNotifyMerMessage();
        AsyncNotifyMerResponseMessageBody responseMessageBody = new AsyncNotifyMerResponseMessageBody();

        AsyncNotifyMerMessage asyncNotifyMerMessage = null;
        try {
            asyncNotifyMerMessage = AsyncNotifyMerMessageService.parse(request.getReceiveMsg());
        } catch (Exception e) {
            e.printStackTrace();

            responseMessageBody.setRespStatus(AsyncNotifyMerMsgRespStatus.FAIL.getCode());
            responseMessageBody.setRespMsg(e.getMessage());
            respMsg.setMessageBody(responseMessageBody);
            respMsg.setMessageHeader(new AsyncNotifyMerMessageHeader());
            response.setReturnMsg(AsyncNotifyMerMessageService.generateResponseMsg(respMsg));

            logger.info("请求编号:{},返回给京东的异步消息：{}", reqNum, response);
            return response;
        }

        String messageType = asyncNotifyMerMessage.getMessageHeader().getMessageType();
        //企业余额充值
        if (messageType.equals(AsyncNotifyMerMsgType.MER_BALANCE_RECHARGE.getCode())) {
            AsyncNotifyMerRechargeMessageBody body = (AsyncNotifyMerRechargeMessageBody) asyncNotifyMerMessage.getMessageBody();

        }
        //企业余额提现
        if (messageType.equals(AsyncNotifyMerMsgType.MER_BALANCE_EXTRACT.getCode())) {
            AsyncNotifyMerBalanceExtractMessageBody body = (AsyncNotifyMerBalanceExtractMessageBody) asyncNotifyMerMessage.getMessageBody();

        }
        //企业/个体工商户实名申请单状态变更通知
        if (messageType.equals(AsyncNotifyMerMsgType.MER_ENTER_REAL_NAME_RESULT.getCode())) {
            AsyncNotifyEnterRealNameApplyResultMessageBody body = (AsyncNotifyEnterRealNameApplyResultMessageBody) asyncNotifyMerMessage.getMessageBody();

        }
        //企业/个体工商户实名状态变更通知
        if (messageType.equals(AsyncNotifyMerMsgType.MER_ENTER_REAL_NAME_STATUS.getCode())) {
            AsyncNotifyEnterRealNameStatusMessageBody body = (AsyncNotifyEnterRealNameStatusMessageBody) asyncNotifyMerMessage.getMessageBody();

        }
        //企业/个体工商户失效状态提醒通知
        if (messageType.equals(AsyncNotifyMerMsgType.MER_ENTER_REAL_NAME_WARN.getCode())) {
            AsyncNotifyEnterRealNameWarnMessageBody body = (AsyncNotifyEnterRealNameWarnMessageBody) asyncNotifyMerMessage.getMessageBody();

        }
        //企业实时付款
        if (messageType.equals(AsyncNotifyMerMsgType.MER_PROMPT_PAY.getCode())) {
            AsyncNotifyMerPromptMessageBody body = (AsyncNotifyMerPromptMessageBody) asyncNotifyMerMessage.getMessageBody();

        }


        responseMessageBody.setRespStatus(AsyncNotifyMerMsgRespStatus.SUCC.getCode());
        responseMessageBody.setRespMsg(AsyncNotifyMerMsgRespStatus.SUCC.getDesc());
        respMsg.setMessageBody(responseMessageBody);
        respMsg.setMessageHeader(asyncNotifyMerMessage.getMessageHeader());
        response.setReturnMsg(AsyncNotifyMerMessageService.generateResponseMsg(respMsg));

        logger.info("请求编号:{},返回给京东的异步消息：{}", reqNum, response);
        return response;
    }
}
