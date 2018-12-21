package com.glgw.pay.request;

public class AsyncNotifyMerMessageRequest {

    private String receiveMsg;

    public String getReceiveMsg() {
        return receiveMsg;
    }

    public void setReceiveMsg(String receiveMsg) {
        this.receiveMsg = receiveMsg;
    }

    @Override
    public String toString() {
        return "AsyncNotifyMerMessageRequest{" +
                "receiveMsg='" + receiveMsg + '\'' +
                '}';
    }
}
