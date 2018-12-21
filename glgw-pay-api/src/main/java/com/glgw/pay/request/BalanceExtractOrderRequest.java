package com.glgw.pay.request;

public class BalanceExtractOrderRequest {

    private String merCustomerId;
    private String merOrderNo;
    private long orderAmount;
    private String memo;


    public String getMerCustomerId() {
        return merCustomerId;
    }

    public void setMerCustomerId(String merCustomerId) {
        this.merCustomerId = merCustomerId;
    }

    public String getMerOrderNo() {
        return merOrderNo;
    }

    public void setMerOrderNo(String merOrderNo) {
        this.merOrderNo = merOrderNo;
    }

    public long getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(long orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "BalanceExtractOrderRequest{" +
                "merCustomerId='" + merCustomerId + '\'' +
                ", merOrderNo='" + merOrderNo + '\'' +
                ", orderAmount=" + orderAmount +
                ", memo='" + memo + '\'' +
                '}';
    }
}
