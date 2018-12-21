package com.glgw.pay.request;

public class EnterAccountInfoRequest {

    private String merCustomerId;


    public String getMerCustomerId() {
        return merCustomerId;
    }

    public void setMerCustomerId(String merCustomerId) {
        this.merCustomerId = merCustomerId;
    }

    @Override
    public String toString() {
        return "EnterAccountInfoRequest{" +
                "merCustomerId='" + merCustomerId + '\'' +
                '}';
    }
}
