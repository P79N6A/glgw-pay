package com.glgw.pay.response;

public class BalanceExtractOrderResponse {

    private String merCustomerId;
    private String merOrderNo;
    private long orderAmount;
    private String orderCode;

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

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    @Override
    public String toString() {
        return "BalanceExtractOrderResponse{" +
                "merCustomerId='" + merCustomerId + '\'' +
                ", merOrderNo='" + merOrderNo + '\'' +
                ", orderAmount=" + orderAmount +
                ", orderCode='" + orderCode + '\'' +
                '}';
    }
}
