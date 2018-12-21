package com.glgw.pay.response;

import java.util.List;

public class IssuerListResponse {

    private List<IssuerResonseItem> lists ; //发卡机构列表

    public List<IssuerResonseItem> getLists() {
        return lists;
    }

    public void setLists(List<IssuerResonseItem> lists) {
        this.lists = lists;
    }

    @Override
    public String toString() {
        return "IssuerListResponse{" +
                "lists=" + lists +
                '}';
    }
}
