package com.bank.interfaces;

public interface Transactable {
    void deposit(double amount);
    void deposit(double amount, String note); // overloading
    void withdraw(double amount);
}
