package com.glgw.pay.response;

public class IssuerResonseItem {

    private String issuerCode;  //发卡机构编码
    private String issuerName;  //发卡机构名称
    private String issuerShort; //发卡机构简称
    private Integer cnapBankCode;   //联行号银行编码

    public String getIssuerCode() {
        return issuerCode;
    }

    public void setIssuerCode(String issuerCode) {
        this.issuerCode = issuerCode;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    public String getIssuerShort() {
        return issuerShort;
    }

    public void setIssuerShort(String issuerShort) {
        this.issuerShort = issuerShort;
    }

    public Integer getCnapBankCode() {
        return cnapBankCode;
    }

    public void setCnapBankCode(Integer cnapBankCode) {
        this.cnapBankCode = cnapBankCode;
    }

    @Override
    public String toString() {
        return "IssuerResonseItem{" +
                "issuerCode='" + issuerCode + '\'' +
                ", issuerName='" + issuerName + '\'' +
                ", issuerShort='" + issuerShort + '\'' +
                ", cnapBankCode=" + cnapBankCode +
                '}';
    }
}
