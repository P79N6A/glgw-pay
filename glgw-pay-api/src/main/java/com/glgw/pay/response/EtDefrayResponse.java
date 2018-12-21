package com.glgw.pay.response;

public class EtDefrayResponse {

    private String errorCode;
    private String errorMessage;
    private EtDefrayResponseItem datas;


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public EtDefrayResponseItem getDatas() {
        return datas;
    }

    public void setDatas(EtDefrayResponseItem datas) {
        this.datas = datas;
    }

    @Override
    public String toString() {
        return "EtDefrayResponse{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", datas=" + datas +
                '}';
    }
}
