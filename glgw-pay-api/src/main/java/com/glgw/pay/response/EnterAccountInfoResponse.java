package com.glgw.pay.response;

public class EnterAccountInfoResponse {

    private long amount;
    private long frozenAmount;
    private String status;
    private String settleBanance;

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getFrozenAmount() {
        return frozenAmount;
    }

    public void setFrozenAmount(long frozenAmount) {
        this.frozenAmount = frozenAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSettleBanance() {
        return settleBanance;
    }

    public void setSettleBanance(String settleBanance) {
        this.settleBanance = settleBanance;
    }

    @Override
    public String toString() {
        return "EnterAccountInfoResponse{" +
                "amount=" + amount +
                ", frozenAmount=" + frozenAmount +
                ", status='" + status + '\'' +
                ", settleBanance='" + settleBanance + '\'' +
                '}';
    }
}
