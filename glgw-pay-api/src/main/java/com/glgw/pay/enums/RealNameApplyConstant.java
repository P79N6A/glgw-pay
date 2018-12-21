package com.glgw.pay.enums;

/**
 * 实名认证常量类
 */
public class RealNameApplyConstant {


    //公司类型
    public static enum CompanyType {
        ENTER("ENTER", "企业"),
        INDIVIDUAL("INDIVIDUAL", "个体工商户");

        private CompanyType(String value, String name) {
            this.value = value;
            this.name = name;
        }

        private final String value;
        private final String name;

        public String getValue() {
            return value;
        }

        public String getName() {
            return name;
        }
    }

    //营业执照证件类型
    public static enum BlicCardType {
        USC("USC", "统一社会信用代码证"),
        OCI("OCI", "多证合一"),
        BLI("BLI", "普通五证");

        private BlicCardType(String value, String name) {
            this.value = value;
            this.name = name;
        }

        private final String value;
        private final String name;

        public String getValue() {
            return value;
        }

        public String getName() {
            return name;
        }
    }


    //当前法人证件类型
    public static enum LepCardType {
        ID("ID", "身份证"),
        PAS("PAS", "护照"),
        PASHK("PASHK", "港澳通行证"),
        PASTW("PASTW", "台胞通行证");

        private LepCardType(String value, String name) {
            this.value = value;
            this.name = name;
        }

        private final String value;
        private final String name;

        public String getValue() {
            return value;
        }

        public String getName() {
            return name;
        }
    }


}
