package com.glgw.pay.request;

public class HapiLoginRequest {

    private String merCustomerId;
    private String componentCode;
    private String extJson;

    public String getMerCustomerId() {
        return merCustomerId;
    }

    public void setMerCustomerId(String merCustomerId) {
        this.merCustomerId = merCustomerId;
    }

    public String getComponentCode() {
        return componentCode;
    }

    public void setComponentCode(String componentCode) {
        this.componentCode = componentCode;
    }

    public String getExtJson() {
        return extJson;
    }

    public void setExtJson(String extJson) {
        this.extJson = extJson;
    }

    @Override
    public String toString() {
        return "HapiLoginRequest{" +
                "merCustomerId='" + merCustomerId + '\'' +
                ", componentCode='" + componentCode + '\'' +
                ", extJson='" + extJson + '\'' +
                '}';
    }
}
