package com.glgw.pay.response;

public class AsyncNotifyMerResponse {

    private String returnMsg;

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    @Override
    public String toString() {
        return "AsyncNotifyMerResponse{" +
                "returnMsg='" + returnMsg + '\'' +
                '}';
    }
}
