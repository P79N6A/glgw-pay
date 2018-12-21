package com.glgw.pay.request;

import java.util.List;

public class EeterDefrayRequest {

    private String loginType;
    private String partnerId;
    private String bizTradeNo;
    private String merchantNo;
    private String tranCode;
    private long amount;
    private int totalNum;
    private List<EnterDefrayRequestItem> list;

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getBizTradeNo() {
        return bizTradeNo;
    }

    public void setBizTradeNo(String bizTradeNo) {
        this.bizTradeNo = bizTradeNo;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getTranCode() {
        return tranCode;
    }

    public void setTranCode(String tranCode) {
        this.tranCode = tranCode;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public List<EnterDefrayRequestItem> getList() {
        return list;
    }

    public void setList(List<EnterDefrayRequestItem> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "EeterDefrayRequest{" +
                "loginType='" + loginType + '\'' +
                ", partnerId='" + partnerId + '\'' +
                ", bizTradeNo='" + bizTradeNo + '\'' +
                ", merchantNo='" + merchantNo + '\'' +
                ", tranCode='" + tranCode + '\'' +
                ", amount=" + amount +
                ", totalNum=" + totalNum +
                ", list=" + list +
                '}';
    }
}
