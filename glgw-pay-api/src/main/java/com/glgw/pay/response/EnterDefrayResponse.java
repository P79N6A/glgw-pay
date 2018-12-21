package com.glgw.pay.response;

import java.util.List;

public class EnterDefrayResponse {

    private String tradeStatus; //订单交易状态
    private String originalOrderNo; //原始交易流水号
    private String outTradeNo;  //系统订单号
    private String bizTradeNo;  //交易订单号
    private List<EtDefrayResponseItem> itemList;//明细金额

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

    public List<EtDefrayResponseItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<EtDefrayResponseItem> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "EnterDefrayResponse{" +
                "tradeStatus='" + tradeStatus + '\'' +
                ", originalOrderNo='" + originalOrderNo + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", bizTradeNo='" + bizTradeNo + '\'' +
                ", itemList=" + itemList +
                '}';
    }
}
