package com.glgw.pay.enums;

public enum ErrorCodeConstant {

    SYSTEM_EXCEPTION("00000", "系统异常"),
    PARAM_NULL("10000", "参数为空"),
    PARAM_ERROR("10001", "参数错误"),


    RECORD_NULL("20000", "记录为空");

    private ErrorCodeConstant(String value, String name) {
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
