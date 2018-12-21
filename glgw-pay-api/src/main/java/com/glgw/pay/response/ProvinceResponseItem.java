package com.glgw.pay.response;

import java.io.Serializable;

public class ProvinceResponseItem implements Serializable {

    private static final long serialVersionUID = 1L;
    private String provinceId;  //省份ID
    private String provinceName;    //省份名称

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    @Override
    public String toString() {
        return "ProvinceResponseItem{" +
                "provinceId='" + provinceId + '\'' +
                ", provinceName='" + provinceName + '\'' +
                '}';
    }
}
