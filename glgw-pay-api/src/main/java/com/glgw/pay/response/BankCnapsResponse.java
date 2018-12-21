package com.glgw.pay.response;

public class BankCnapsResponse {

    private String bankCnaps;   //联行号
    private String bankName;    //银行名称
    private String bankCode;    //银行编码
    private String provinceId;  //省份ID
    private String provinceName;//省份名称
    private String cityId;      //城市ID
    private String cityName;    //城市名称
    private String channelBankCode;

    public String getBankCnaps() {
        return bankCnaps;
    }

    public void setBankCnaps(String bankCnaps) {
        this.bankCnaps = bankCnaps;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getChannelBankCode() {
        return channelBankCode;
    }

    public void setChannelBankCode(String channelBankCode) {
        this.channelBankCode = channelBankCode;
    }

    @Override
    public String toString() {
        return "BankCnapsResponse{" +
                "bankCnaps='" + bankCnaps + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", provinceId='" + provinceId + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", cityId='" + cityId + '\'' +
                ", cityName='" + cityName + '\'' +
                ", channelBankCode='" + channelBankCode + '\'' +
                '}';
    }
}
