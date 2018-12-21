package com.glgw.pay.response;

import java.util.Date;

public class EnterpriseApplyResponse {

    private Long id;
    private Date createdDate;
    private Date modifiedDate;
    private String partnerId;
    private String partnerMemberId;
    private String isAgree;
    private String merchantId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getPartnerMemberId() {
        return partnerMemberId;
    }

    public void setPartnerMemberId(String partnerMemberId) {
        this.partnerMemberId = partnerMemberId;
    }

    public String getIsAgree() {
        return isAgree;
    }

    public void setIsAgree(String isAgree) {
        this.isAgree = isAgree;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    @Override
    public String toString() {
        return "EnterpriseApplyResponse{" +
                "id=" + id +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", partnerId='" + partnerId + '\'' +
                ", partnerMemberId='" + partnerMemberId + '\'' +
                ", isAgree='" + isAgree + '\'' +
                ", merchantId='" + merchantId + '\'' +
                '}';
    }
}
