package com.glgw.pay.request;

import com.glgw.pay.response.BatchDefrayRequestItem;

import java.util.List;

public class BatchDefrayRequest {

    private String partnerId;
    private String bizTradeNo;
    private String tranCode;
    private long amount;
    private int totalNum;
    private List<BatchDefrayRequestItem> list;


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

    public List<BatchDefrayRequestItem> getList() {
        return list;
    }

    public void setList(List<BatchDefrayRequestItem> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "BatchDefrayRequest{" +
                "partnerId='" + partnerId + '\'' +
                ", bizTradeNo='" + bizTradeNo + '\'' +
                ", tranCode='" + tranCode + '\'' +
                ", amount=" + amount +
                ", totalNum=" + totalNum +
                ", list=" + list +
                '}';
    }
}
