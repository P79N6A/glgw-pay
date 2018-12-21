package com.glgw.pay.request;

/**
 * 企业注册上送项
 */
public class EnterRegisterRequest {

    private String merCustomerId;   //商户平台用户的唯一标识
    private String jrMerMobile; //商户手机号
    private String authorize;   //0：未授权；1：授权

    public String getMerCustomerId() {
        return merCustomerId;
    }

    public void setMerCustomerId(String merCustomerId) {
        this.merCustomerId = merCustomerId;
    }

    public String getJrMerMobile() {
        return jrMerMobile;
    }

    public void setJrMerMobile(String jrMerMobile) {
        this.jrMerMobile = jrMerMobile;
    }

    public String getAuthorize() {
        return authorize;
    }

    public void setAuthorize(String authorize) {
        this.authorize = authorize;
    }

    @Override
    public String toString() {
        return "EnterRegisterRequest{" +
                "merCustomerId='" + merCustomerId + '\'' +
                ", jrMerMobile='" + jrMerMobile + '\'' +
                ", authorize='" + authorize + '\'' +
                '}';
    }
}
