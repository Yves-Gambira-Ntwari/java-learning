package com.bank.account;

import com.bank.interfaces.Transactable;

public class SavingsAccount extends BankAccount implements Transactable{
	public SavingsAccount(int accountNumber) {
		super(accountNumber);
	}
	
	public void deposit(double amount) {
		balance += amount;
		System.out.println("You've deposited " + amount);
	}
	public void deposit(double amount, String note) {
		balance += amount;
		System.out.println("You've deposited " + amount + " for"+"(" + note + ")");
	}
	public void withdraw(double amount) {
		if(balance > amount) {			
		balance -= amount;
		System.out.println("You've withdraw "+ amount + " You're new balance is " + balance);
		} else {
			System.out.println("Your balance is insaffcient to "+ balance );
		}
	}
	
}
