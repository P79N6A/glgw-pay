package com.glgw.pay.request;

public class EnterRealNameApplyRejectQueryRequest {

    private String merCustomerId;
    private String partnerApplyId;


    public String getMerCustomerId() {
        return merCustomerId;
    }

    public void setMerCustomerId(String merCustomerId) {
        this.merCustomerId = merCustomerId;
    }

    public String getPartnerApplyId() {
        return partnerApplyId;
    }

    public void setPartnerApplyId(String partnerApplyId) {
        this.partnerApplyId = partnerApplyId;
    }

    @Override
    public String toString() {
        return "EnterRealNameApplyRejectQueryRequest{" +
                "merCustomerId='" + merCustomerId + '\'' +
                ", partnerApplyId='" + partnerApplyId + '\'' +
                '}';
    }
}
