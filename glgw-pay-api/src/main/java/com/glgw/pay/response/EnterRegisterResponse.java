package com.glgw.pay.response;

public class EnterRegisterResponse {

    private String alais;   //商户号
    private String jrMerchantId;    //账户别名，1.0.0版本该值暂空

    public String getAlais() {
        return alais;
    }

    public void setAlais(String alais) {
        this.alais = alais;
    }

    public String getJrMerchantId() {
        return jrMerchantId;
    }

    public void setJrMerchantId(String jrMerchantId) {
        this.jrMerchantId = jrMerchantId;
    }

    @Override
    public String toString() {
        return "EnterRegisterResponse{" +
                "alais='" + alais + '\'' +
                ", jrMerchantId='" + jrMerchantId + '\'' +
                '}';
    }
}
