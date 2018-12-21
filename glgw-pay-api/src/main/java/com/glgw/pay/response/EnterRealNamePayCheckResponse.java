package com.glgw.pay.response;

public class EnterRealNamePayCheckResponse {

    private String resultCode;
    private String resultDesc;
    private String partnerApplyId;
    private Integer remainCount;
    private String tradeNo;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    public String getPartnerApplyId() {
        return partnerApplyId;
    }

    public void setPartnerApplyId(String partnerApplyId) {
        this.partnerApplyId = partnerApplyId;
    }

    public Integer getRemainCount() {
        return remainCount;
    }

    public void setRemainCount(Integer remainCount) {
        this.remainCount = remainCount;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    @Override
    public String toString() {
        return "EnterRealNamePayCheckResponse{" +
                "resultCode='" + resultCode + '\'' +
                ", resultDesc='" + resultDesc + '\'' +
                ", partnerApplyId='" + partnerApplyId + '\'' +
                ", remainCount=" + remainCount +
                ", tradeNo='" + tradeNo + '\'' +
                '}';
    }
}
