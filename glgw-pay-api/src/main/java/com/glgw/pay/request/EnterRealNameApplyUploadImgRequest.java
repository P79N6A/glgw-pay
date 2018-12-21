package com.glgw.pay.request;

public class EnterRealNameApplyUploadImgRequest {

    private String merCustomerId;
    private String partnerApplyId;
    private String imgFile;
    private String attachType;

    public String getPartnerApplyId() {
        return partnerApplyId;
    }

    public void setPartnerApplyId(String partnerApplyId) {
        this.partnerApplyId = partnerApplyId;
    }

    public String getMerCustomerId() {
        return merCustomerId;
    }

    public void setMerCustomerId(String merCustomerId) {
        this.merCustomerId = merCustomerId;
    }

    public String getImgFile() {
        return imgFile;
    }

    public void setImgFile(String imgFile) {
        this.imgFile = imgFile;
    }

    public String getAttachType() {
        return attachType;
    }

    public void setAttachType(String attachType) {
        this.attachType = attachType;
    }

    @Override
    public String toString() {
        return "EnterRealNameApplyUploadImgRequest{" +
                "merCustomerId='" + merCustomerId + '\'' +
                ", partnerApplyId='" + partnerApplyId + '\'' +
                ", imgFile='" + imgFile + '\'' +
                ", attachType='" + attachType + '\'' +
                '}';
    }
}
