package com.glgw.pay.response;

import java.util.List;

public class EtDefrayResponseItem {

    private String tradeStatus;
    private String originalOrderNo;
    private String outTradeNo;
    private String bizTradeNo;
    private List<EtDefrayResponseEntryItem> record;


    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public String getOriginalOrderNo() {
        return originalOrderNo;
    }

    public void setOriginalOrderNo(String originalOrderNo) {
        this.originalOrderNo = originalOrderNo;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getBizTradeNo() {
        return bizTradeNo;
    }

    public void setBizTradeNo(String bizTradeNo) {
        this.bizTradeNo = bizTradeNo;
    }

    public List<EtDefrayResponseEntryItem> getRecord() {
        return record;
    }

    public void setRecord(List<EtDefrayResponseEntryItem> record) {
        this.record = record;
    }

    @Override
    public String toString() {
        return "EtDefrayResponseItem{" +
                "tradeStatus='" + tradeStatus + '\'' +
                ", originalOrderNo='" + originalOrderNo + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", bizTradeNo='" + bizTradeNo + '\'' +
                ", record=" + record +
                '}';
    }
}
