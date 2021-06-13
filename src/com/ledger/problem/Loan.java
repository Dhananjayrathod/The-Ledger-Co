package com.ledger.problem;

public class Loan {

    private String user;
    private String bank;
    private int principal;
    private int term;
    private int rate;
    private double amount;
    private double emi;

    public Loan(String user, String bank, int principal, int term, int rate) {
        this.user = user;
        this.bank = bank;
        this.principal = principal;
        this.term = term;
        this.rate = rate;
        this.amount = this.getTotalAmount(principal, term, rate);
        this.emi = this.calculateEmi(amount, term);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public int getPrincipal() {
        return principal;
    }

    public void setPrincipal(int principal) {
        this.principal = principal;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getEmi() {
        return emi;
    }

    public void setEmi(double emi) {
        this.emi = emi;
    }

    private double getTotalAmount (int principal, int term, double rate) {
        return  principal + Math.ceil(principal * term * (rate / 100));
    }

    private double calculateEmi(double amount, int term) {
        return Math.ceil(amount / (term * 12));
    }
}
