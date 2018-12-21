package com.glgw.pay.response;

import java.util.Map;

public class EnterRealNameApplyResponse {

    private String resultCode;
    private String resultDesc;
    private String partnerApplyId;
    private String jrApplyId;
    private Map<String, String> errorMap;


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

    public String getJrApplyId() {
        return jrApplyId;
    }

    public void setJrApplyId(String jrApplyId) {
        this.jrApplyId = jrApplyId;
    }

    public Map<String, String> getErrorMap() {
        return errorMap;
    }

    public void setErrorMap(Map<String, String> errorMap) {
        this.errorMap = errorMap;
    }

    @Override
    public String toString() {
        return "EnterRealNameApplyResponse{" +
                "resultCode='" + resultCode + '\'' +
                ", resultDesc='" + resultDesc + '\'' +
                ", partnerApplyId='" + partnerApplyId + '\'' +
                ", jrApplyId='" + jrApplyId + '\'' +
                ", errorMap=" + errorMap +
                '}';
    }
}
