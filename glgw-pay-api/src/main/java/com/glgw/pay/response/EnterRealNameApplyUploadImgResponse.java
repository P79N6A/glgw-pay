package com.glgw.pay.response;

public class EnterRealNameApplyUploadImgResponse {

    private String attachPath;

    public String getAttachPath() {
        return attachPath;
    }

    public void setAttachPath(String attachPath) {
        this.attachPath = attachPath;
    }

    @Override
    public String toString() {
        return "EnterRealNameApplyUploadImgResponse{" +
                "attachPath='" + attachPath + '\'' +
                '}';
    }
}
