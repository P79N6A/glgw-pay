package com.glgw.pay.request;

public class BankCnapsQueryCityRequest {

    private String provinceId;  //省份ID

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    @Override
    public String toString() {
        return "BankCnapsQueryCityRequest{" +
                "provinceId='" + provinceId + '\'' +
                '}';
    }
}
