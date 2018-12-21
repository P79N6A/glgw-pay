package com.glgw.pay.request;

import java.util.Date;

public class EnterDefrayRequestItem {

    private String bizTradeNo;          //交易订单号
    private String tadType;             //代付类型（101代付到余额，102代付到卡，103代付到小金库）
    private String categoryCode;        //分组号
    private long tradeAmount;   //明细金额
    private String tradeSubject;        //交易描述
    private String remark;          //请求备注
    private Date requestTime;       //请求时间
    private String bankCode;    //银行代码（代付到卡）
    private String bankAccountNo;   //银行账号（代付到卡）
    private String bankAccountName; //银行账户名称（代付到卡）
    private String bankName;    //银行名称（代付到卡）
    private String userName;    //用户名（代付到卡）
    private String certificateType; //证件类型（代付到卡）
    private String idNum;       //证件号（代付到卡）
    private String customerLoginType;   //客户登录类型（代付余额和小金库）
    private String customerNo;  //客户号（代付余额和小金库）
    private String returnParams;    //返回参数
    private String notifyUrl;   //回调地址

    public String getTadType() {
        return tadType;
    }

    public void setTadType(String tadType) {
        this.tadType = tadType;
    }

    public String getBizTradeNo() {
        return bizTradeNo;
    }

    public void setBizTradeNo(String bizTradeNo) {
        this.bizTradeNo = bizTradeNo;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getTradeSubject() {
        return tradeSubject;
    }

    public void setTradeSubject(String tradeSubject) {
        this.tradeSubject = tradeSubject;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public long getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(long tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
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
        return "EnterDefrayRequestItem{" +
                "tadType='" + tadType + '\'' +
                ", bizTradeNo='" + bizTradeNo + '\'' +
                ", categoryCode='" + categoryCode + '\'' +
                ", tradeSubject='" + tradeSubject + '\'' +
                ", requestTime=" + requestTime +
                ", remark='" + remark + '\'' +
                ", tradeAmount=" + tradeAmount +
                ", bankCode='" + bankCode + '\'' +
                ", bankAccountNo='" + bankAccountNo + '\'' +
                ", bankAccountName='" + bankAccountName + '\'' +
                ", bankName='" + bankName + '\'' +
                ", userName='" + userName + '\'' +
                ", certificateType='" + certificateType + '\'' +
                ", idNum='" + idNum + '\'' +
                ", customerLoginType='" + customerLoginType + '\'' +
                ", customerNo='" + customerNo + '\'' +
                ", returnParams='" + returnParams + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                '}';
    }
}
