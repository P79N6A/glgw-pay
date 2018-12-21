package com.glgw.pay.response;

import java.util.Map;

public class EnterRealNameApplyRejectQueryResponse {

    private String auditStatus;
    private String subAuditStatus;
    private Map<String, String> rejectMap;

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getSubAuditStatus() {
        return subAuditStatus;
    }

    public void setSubAuditStatus(String subAuditStatus) {
        this.subAuditStatus = subAuditStatus;
    }

    public Map<String, String> getRejectMap() {
        return rejectMap;
    }

    public void setRejectMap(Map<String, String> rejectMap) {
        this.rejectMap = rejectMap;
    }

    @Override
    public String toString() {
        return "EnterRealNameApplyRejectQueryResponse{" +
                "auditStatus='" + auditStatus + '\'' +
                ", subAuditStatus='" + subAuditStatus + '\'' +
                ", rejectMap=" + rejectMap +
                '}';
    }
}
