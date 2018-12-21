package com.glgw.pay.api;

import com.glgw.pay.request.AsyncNotifyMerMessageRequest;
import com.glgw.pay.response.AsyncNotifyMerResponse;

public interface JdAsyncNotifyMessageApi {

    //接收京东发送的异步消息
    public AsyncNotifyMerResponse parseMsg(AsyncNotifyMerMessageRequest request);

}
