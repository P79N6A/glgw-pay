package com.glgw.pay.request;

public class PromptPayAcquirerRequest {

    private String inMerCustomerId;
    private String outMerCustomerId;
    private String merOrderNo;
    private long orderAmount;
    private String callBackUrl;
    private String memo;
    private String payBankType;
    private String payBankCode;
    private String payRoleType;

    public String getInMerCustomerId() {
        return inMerCustomerId;
    }

    public void setInMerCustomerId(String inMerCustomerId) {
        this.inMerCustomerId = inMerCustomerId;
    }

    public String getOutMerCustomerId() {
        return outMerCustomerId;
    }

    public void setOutMerCustomerId(String outMerCustomerId) {
        this.outMerCustomerId = outMerCustomerId;
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

    public String getCallBackUrl() {
        return callBackUrl;
    }

    public void setCallBackUrl(String callBackUrl) {
        this.callBackUrl = callBackUrl;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getPayBankType() {
        return payBankType;
    }

    public void setPayBankType(String payBankType) {
        this.payBankType = payBankType;
    }

    public String getPayBankCode() {
        return payBankCode;
    }

    public void setPayBankCode(String payBankCode) {
        this.payBankCode = payBankCode;
    }

    public String getPayRoleType() {
        return payRoleType;
    }

    public void setPayRoleType(String payRoleType) {
        this.payRoleType = payRoleType;
    }

    @Override
    public String toString() {
        return "PromptPayAcquirerRequest{" +
                "inMerCustomerId='" + inMerCustomerId + '\'' +
                ", outMerCustomerId='" + outMerCustomerId + '\'' +
                ", merOrderNo='" + merOrderNo + '\'' +
                ", orderAmount=" + orderAmount +
                ", callBackUrl='" + callBackUrl + '\'' +
                ", memo='" + memo + '\'' +
                ", payBankType='" + payBankType + '\'' +
                ", payBankCode='" + payBankCode + '\'' +
                ", payRoleType='" + payRoleType + '\'' +
                '}';
    }
}
