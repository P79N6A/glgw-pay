package com.glgw.pay.enums;

public enum ComponentCode {

    BALANCE_EXTRACT("BALANCE_EXTRACT", "余额提现"),
    TRADE_INFO("TRADE_INFO", "交易记录查询"),
    SET_AUTHCODE("SET_AUTHCODE", "支付密码设置"),
    CHANGE_AUTHCODE("CHANGE_AUTHCODE", "支付密码修改"),
    RECOVERED_AUTHCODE("RECOVERED_AUTHCODE", "支付密码找回"),
    TRADE_INFO_WEEK("TRADE_INFO_WEEK", "查询一周流水"),
    UNBUNDLE("UNBUNDLE", "银行卡查询解绑"),
    CLOUD_AGREE("CLOUD_AGREE", "同意协议");


    private String code;
    private String desc;

    private ComponentCode(String code, String desc) {
        this.setCode(code);
        this.setDesc(desc);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "ComponentCode{" +
                "code='" + code + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
