package com.glgw.pay.request;

public class EnterRealNamePayCheckRequest {

    private String merCustomerId;
    private String partnerApplyId;
    private String amount;


    public String getPartnerApplyId() {
        return partnerApplyId;
    }

    public void setPartnerApplyId(String partnerApplyId) {
        this.partnerApplyId = partnerApplyId;
    }

    public String getMerCustomerId() {
        return merCustomerId;
    }

    public void setMerCustomerId(String merCustomerId) {
        this.merCustomerId = merCustomerId;
    }


    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "EnterRealNamePayCheckRequest{" +
                "merCustomerId='" + merCustomerId + '\'' +
                ", partnerApplyId='" + partnerApplyId + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
