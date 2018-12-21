package com.glgw.pay.response;

import java.util.List;

public class ProvinceListResponse {

    private List<ProvinceResponseItem> lists;   //省份列表


    public List<ProvinceResponseItem> getLists() {
        return lists;
    }

    public void setLists(List<ProvinceResponseItem> lists) {
        this.lists = lists;
    }

    @Override
    public String toString() {
        return "ProvinceListResponse{" +
                "lists=" + lists +
                '}';
    }
}
