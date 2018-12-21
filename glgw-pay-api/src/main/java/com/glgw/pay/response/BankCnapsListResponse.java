package com.glgw.pay.response;

import java.util.List;

public class BankCnapsListResponse {

    private List<BankCnapsItem> list;   //联行列表

    public List<BankCnapsItem> getList() {
        return list;
    }

    public void setList(List<BankCnapsItem> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "BankCnapsListResponse{" +
                "list=" + list +
                '}';
    }
}
