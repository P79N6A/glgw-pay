package com.glgw.pay.request;

public class BalanceExtractQueryRequest {

    private String merOrderNo;


    public String getMerOrderNo() {
        return merOrderNo;
    }

    public void setMerOrderNo(String merOrderNo) {
        this.merOrderNo = merOrderNo;
    }

    @Override
    public String toString() {
        return "BalanceExtractQueryRequest{" +
                "merOrderNo='" + merOrderNo + '\'' +
                '}';
    }
}
