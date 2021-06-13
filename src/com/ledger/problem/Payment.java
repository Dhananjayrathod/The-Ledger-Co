package com.ledger.problem;

public class Payment {

    private String loanId;
    private int lumpSumAmount;
    private int emiNo;

    public Payment(String bank, String user, int lumpSumAmount, int emiNo) {
        this.loanId = bank + "_" + user;
        this.lumpSumAmount = lumpSumAmount;
        this.emiNo = emiNo;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public int getLumpSumAmount() {
        return lumpSumAmount;
    }

    public void setLumpSumAmount(int lumpSumAmount) {
        this.lumpSumAmount = lumpSumAmount;
    }

    public int getEmiNo() {
        return emiNo;
    }

    public void setEmiNo(int emiNo) {
        this.emiNo = emiNo;
    }
}
