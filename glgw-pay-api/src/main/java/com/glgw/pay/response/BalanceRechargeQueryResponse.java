package com.glgw.pay.response;

public class BalanceRechargeQueryResponse {

    private String merCustomerId;
    private String merOrderNo;
    private Long orderAmount;
    private String orderStatus;
    private String orderMessage;
    private String jrTradeNo;
    private String bankSubmitNo;
    private String bankName;


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

    public Long getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Long orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderMessage() {
        return orderMessage;
    }

    public void setOrderMessage(String orderMessage) {
        this.orderMessage = orderMessage;
    }

    public String getJrTradeNo() {
        return jrTradeNo;
    }

    public void setJrTradeNo(String jrTradeNo) {
        this.jrTradeNo = jrTradeNo;
    }

    public String getBankSubmitNo() {
        return bankSubmitNo;
    }

    public void setBankSubmitNo(String bankSubmitNo) {
        this.bankSubmitNo = bankSubmitNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public String toString() {
        return "BalanceRechargeQueryResponse{" +
                "merCustomerId='" + merCustomerId + '\'' +
                ", merOrderNo='" + merOrderNo + '\'' +
                ", orderAmount=" + orderAmount +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderMessage='" + orderMessage + '\'' +
                ", jrTradeNo='" + jrTradeNo + '\'' +
                ", bankSubmitNo='" + bankSubmitNo + '\'' +
                ", bankName='" + bankName + '\'' +
                '}';
    }
}
