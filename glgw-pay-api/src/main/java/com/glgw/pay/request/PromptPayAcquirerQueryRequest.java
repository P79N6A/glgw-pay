package com.glgw.pay.request;

public class PromptPayAcquirerQueryRequest {

    private String merOrderNo;


    public String getMerOrderNo() {
        return merOrderNo;
    }

    public void setMerOrderNo(String merOrderNo) {
        this.merOrderNo = merOrderNo;
    }

    @Override
    public String toString() {
        return "PromptPayAcquirerQueryRequest{" +
                "merOrderNo='" + merOrderNo + '\'' +
                '}';
    }
}
