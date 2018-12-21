package com.glgw.pay.response;

import java.util.Date;

public class EtDefrayResponseEntryItem {

    private String bizTradeNo;
    private String outTradeNo;
    private String tradeStatus;
    private String tradeAmount;
    private Date responseDate;
    private Date finishDate;
    private String responseCode;
    private String responseMessage;
    private Date responseTime;


    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Date getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }

    public String getBizTradeNo() {
        return bizTradeNo;
    }

    public void setBizTradeNo(String bizTradeNo) {
        this.bizTradeNo = bizTradeNo;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public String getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(String tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public Date getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(Date responseDate) {
        this.responseDate = responseDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    @Override
    public String toString() {
        return "EtDefrayResponseEntryItem{" +
                "bizTradeNo='" + bizTradeNo + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", tradeStatus='" + tradeStatus + '\'' +
                ", tradeAmount='" + tradeAmount + '\'' +
                ", responseDate=" + responseDate +
                ", finishDate=" + finishDate +
                ", responseCode='" + responseCode + '\'' +
                ", responseMessage='" + responseMessage + '\'' +
                ", responseTime=" + responseTime +
                '}';
    }
}
