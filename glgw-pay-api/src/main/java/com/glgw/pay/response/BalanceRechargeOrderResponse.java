package com.glgw.pay.response;

import java.util.Map;

public class BalanceRechargeOrderResponse {

    private String merCustomerId;
    private String merOrderNo;
    private long orderAmount;
    private String cashierUrl;
    private Map<String, String> cashierFormData;

    private String formStr;

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

    public String getCashierUrl() {
        return cashierUrl;
    }

    public void setCashierUrl(String cashierUrl) {
        this.cashierUrl = cashierUrl;
    }

    public Map<String, String> getCashierFormData() {
        return cashierFormData;
    }

    public void setCashierFormData(Map<String, String> cashierFormData) {
        this.cashierFormData = cashierFormData;
    }

    public String getFormStr() {
        return formStr;
    }

    public void setFormStr(String formStr) {
        this.formStr = formStr;
    }

    @Override
    public String toString() {
        return "BalanceRechargeOrderResponse{" +
                "merCustomerId='" + merCustomerId + '\'' +
                ", merOrderNo='" + merOrderNo + '\'' +
                ", orderAmount=" + orderAmount +
                ", cashierUrl='" + cashierUrl + '\'' +
                ", cashierFormData=" + cashierFormData +
                ", formStr='" + formStr + '\'' +
                '}';
    }
}
