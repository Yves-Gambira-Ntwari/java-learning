package com.bank.account;


public abstract class BankAccount {
    protected int accountNumber;
    protected double balance;
    
    public BankAccount(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
