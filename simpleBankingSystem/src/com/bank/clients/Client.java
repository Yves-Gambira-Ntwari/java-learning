package com.bank.clients;

public abstract class Client {
	protected String name;
	protected double withdrawLimit;
	public Client(String name, double withdrawLimit) {
		this.name = name;
		this.withdrawLimit = withdrawLimit;
	}
	
	public String getName() {
		return name;
	}
	public double getWithdraw() {
		return withdrawLimit;
	}
	
}
