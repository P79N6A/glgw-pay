package com.glgw.pay.request;

public class IssuerQueryByPIReqeset {

    /**
     * 支付工具
     * 00:快捷
     * 01:网银
     * 02:代收
     * 03:代付/付款
     *
     */
    private String piType;


    public String getPiType() {
        return piType;
    }

    public void setPiType(String piType) {
        this.piType = piType;
    }

    @Override
    public String toString() {
        return "IssuerQueryByPIReqeset{" +
                "piType='" + piType + '\'' +
                '}';
    }
}
