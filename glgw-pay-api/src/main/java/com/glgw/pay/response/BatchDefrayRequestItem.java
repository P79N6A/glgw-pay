package com.glgw.pay.response;

public class BatchDefrayRequestItem {

    private String bizTradeNo;
    private String merCustomerId;
    private String tadType;
    private long tradeAmount;
    private String tradeSubject;
    private String remark;
    private String toPersonal;
    private String bankAccountName;
    private String bankAccountNo;
    private String bankCode;
    private String bankName;
    private String city;
    private String proviences;
    private String subsidiaryCode;
    private String subsidiaryName;
    private String name;
    private String cardType;
    private String idNumber;
    private String mobileNo;
    private String customerLoginType;
    private String customerNo;
    private String returnParams;
    private String notifyUrl;


    public String getBizTradeNo() {
        return bizTradeNo;
    }

    public void setBizTradeNo(String bizTradeNo) {
        this.bizTradeNo = bizTradeNo;
    }

    public String getMerCustomerId() {
        return merCustomerId;
    }

    public void setMerCustomerId(String merCustomerId) {
        this.merCustomerId = merCustomerId;
    }

    public String getTadType() {
        return tadType;
    }

    public void setTadType(String tadType) {
        this.tadType = tadType;
    }

    public long getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(long tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public String getTradeSubject() {
        return tradeSubject;
    }

    public void setTradeSubject(String tradeSubject) {
        this.tradeSubject = tradeSubject;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getToPersonal() {
        return toPersonal;
    }

    public void setToPersonal(String toPersonal) {
        this.toPersonal = toPersonal;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProviences() {
        return proviences;
    }

    public void setProviences(String proviences) {
        this.proviences = proviences;
    }

    public String getSubsidiaryCode() {
        return subsidiaryCode;
    }

    public void setSubsidiaryCode(String subsidiaryCode) {
        this.subsidiaryCode = subsidiaryCode;
    }

    public String getSubsidiaryName() {
        return subsidiaryName;
    }

    public void setSubsidiaryName(String subsidiaryName) {
        this.subsidiaryName = subsidiaryName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getCustomerLoginType() {
        return customerLoginType;
    }

    public void setCustomerLoginType(String customerLoginType) {
        this.customerLoginType = customerLoginType;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getReturnParams() {
        return returnParams;
    }

    public void setReturnParams(String returnParams) {
        this.returnParams = returnParams;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    @Override
    public String toString() {
        return "BatchDefrayRequestItem{" +
                "bizTradeNo='" + bizTradeNo + '\'' +
                ", merCustomerId='" + merCustomerId + '\'' +
                ", tadType='" + tadType + '\'' +
                ", tradeAmount=" + tradeAmount +
                ", tradeSubject='" + tradeSubject + '\'' +
                ", remark='" + remark + '\'' +
                ", toPersonal='" + toPersonal + '\'' +
                ", bankAccountName='" + bankAccountName + '\'' +
                ", bankAccountNo='" + bankAccountNo + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", bankName='" + bankName + '\'' +
                ", city='" + city + '\'' +
                ", proviences='" + proviences + '\'' +
                ", subsidiaryCode='" + subsidiaryCode + '\'' +
                ", subsidiaryName='" + subsidiaryName + '\'' +
                ", name='" + name + '\'' +
                ", cardType='" + cardType + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", customerLoginType='" + customerLoginType + '\'' +
                ", customerNo='" + customerNo + '\'' +
                ", returnParams='" + returnParams + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                '}';
    }
}
