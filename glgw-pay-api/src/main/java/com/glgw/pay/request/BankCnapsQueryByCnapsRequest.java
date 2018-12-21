package com.glgw.pay.request;

public class BankCnapsQueryByCnapsRequest {

    private String cnaps;   //联行号

    public String getCnaps() {
        return cnaps;
    }

    public void setCnaps(String cnaps) {
        this.cnaps = cnaps;
    }

    @Override
    public String toString() {
        return "BankCnapsQueryByCnapsRequest{" +
                "cnaps='" + cnaps + '\'' +
                '}';
    }
}
