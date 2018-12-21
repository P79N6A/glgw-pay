package com.glgw.pay.request;

public class EnterpriseApplyRequest {

    private String merCustomerId;

    public String getMerCustomerId() {
        return merCustomerId;
    }

    public void setMerCustomerId(String merCustomerId) {
        this.merCustomerId = merCustomerId;
    }

    @Override
    public String toString() {
        return "EnterpriseApplyRequest{" +
                "merCustomerId='" + merCustomerId + '\'' +
                '}';
    }
}
