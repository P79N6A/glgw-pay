package com.glgw.pay.response;

public class PromptPayAcquirerQueryResponse {

    private String outMerCustomerId;
    private String inMerCustomerId;
    private String merOrderNo;
    private String orderAmount;
    private String outTradeNo;
    private String bizOrderStatus;
    private String orderMessage;
    private String finishedTime;
    private String bankSubmitNo;
    private String bankName;


    public String getOutMerCustomerId() {
        return outMerCustomerId;
    }

    public void setOutMerCustomerId(String outMerCustomerId) {
        this.outMerCustomerId = outMerCustomerId;
    }

    public String getInMerCustomerId() {
        return inMerCustomerId;
    }

    public void setInMerCustomerId(String inMerCustomerId) {
        this.inMerCustomerId = inMerCustomerId;
    }

    public String getMerOrderNo() {
        return merOrderNo;
    }

    public void setMerOrderNo(String merOrderNo) {
        this.merOrderNo = merOrderNo;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getBizOrderStatus() {
        return bizOrderStatus;
    }

    public void setBizOrderStatus(String bizOrderStatus) {
        this.bizOrderStatus = bizOrderStatus;
    }

    public String getOrderMessage() {
        return orderMessage;
    }

    public void setOrderMessage(String orderMessage) {
        this.orderMessage = orderMessage;
    }

    public String getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(String finishedTime) {
        this.finishedTime = finishedTime;
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
        return "PromptPayAcquirerQueryResponse{" +
                "outMerCustomerId='" + outMerCustomerId + '\'' +
                ", inMerCustomerId='" + inMerCustomerId + '\'' +
                ", merOrderNo='" + merOrderNo + '\'' +
                ", orderAmount='" + orderAmount + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", bizOrderStatus='" + bizOrderStatus + '\'' +
                ", orderMessage='" + orderMessage + '\'' +
                ", finishedTime='" + finishedTime + '\'' +
                ", bankSubmitNo='" + bankSubmitNo + '\'' +
                ", bankName='" + bankName + '\'' +
                '}';
    }
}
