package com.glgw.pay.response;

public class EnterQueryInfoResponse {

    private String merCustomerId;
    private boolean hasPayPwd;
    private String merRealStatus;

    public String getMerCustomerId() {
        return merCustomerId;
    }

    public void setMerCustomerId(String merCustomerId) {
        this.merCustomerId = merCustomerId;
    }

    public boolean isHasPayPwd() {
        return hasPayPwd;
    }

    public void setHasPayPwd(boolean hasPayPwd) {
        this.hasPayPwd = hasPayPwd;
    }

    public String getMerRealStatus() {
        return merRealStatus;
    }

    public void setMerRealStatus(String merRealStatus) {
        this.merRealStatus = merRealStatus;
    }

    @Override
    public String toString() {
        return "EnterQueryInfoResponse{" +
                "merCustomerId='" + merCustomerId + '\'' +
                ", hasPayPwd=" + hasPayPwd +
                ", merRealStatus='" + merRealStatus + '\'' +
                '}';
    }
}
