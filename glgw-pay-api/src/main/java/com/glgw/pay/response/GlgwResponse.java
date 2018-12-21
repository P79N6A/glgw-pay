package com.glgw.pay.response;

/**
 * 通用返回实体
 */
public class GlgwResponse<T> {

    private String code;   //返回码
    private String msg; //描述信息
    private T body;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }


    public void setSuccess() {
        this.code = "200";
    }

    public void setFail(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "GlgwResponse{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", body=" + body +
                '}';
    }
}
