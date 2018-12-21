package com.glgw.pay.controller;


import com.glgw.pay.api.JdAsyncNotifyMessageApi;
import com.glgw.pay.request.AsyncNotifyMerMessageRequest;
import com.glgw.pay.response.AsyncNotifyMerResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("notifyMessage")
public class JdAsyncNotifyMessageController {

    private static final Logger logger = LogManager.getLogger(JdAsyncNotifyMessageController.class);

    @Autowired
    private JdAsyncNotifyMessageApi jdAsyncNotifyMessageApi;

    //接收京东发送的异步消息
    @RequestMapping("sendMsg")
    public AsyncNotifyMerResponse sendMsg(@RequestBody AsyncNotifyMerMessageRequest request) throws Exception {
        AsyncNotifyMerResponse response = null;

        try {
            response = jdAsyncNotifyMessageApi.parseMsg(request);
        } catch (Exception e) {
            logger.error("{}", e);
        }
        return response;
    }

}
