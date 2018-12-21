package com.glgw.pay.request;

public class BankCnapsQueryByCityAndBankRequest {

    private String cityId;  //城市ID
    private String bankCode;    //银行编码
    private String channelBankCode;

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getChannelBankCode() {
        return channelBankCode;
    }

    public void setChannelBankCode(String channelBankCode) {
        this.channelBankCode = channelBankCode;
    }

    @Override
    public String toString() {
        return "BankCnapsQueryByCityAndBankRequest{" +
                "cityId='" + cityId + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", channelBankCode='" + channelBankCode + '\'' +
                '}';
    }


}
