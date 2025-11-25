package com.bank.app;

import com.bank.clients.*;
import com.bank.account.*;

public class DemoApp {

	public static void main(String[] args) {
        Client john = new RegularClient("John");
        Client alice = new RegularClient("Alice");
    

        SavingsAccount johnAcc = new SavingsAccount(11);
        SavingsAccount aliceAcc = new SavingsAccount(100);

        // Scenario
        johnAcc.deposit(200, "Birthday gift");
        System.out.println(johnAcc.getBalance());
       
//        aliceAcc.withdraw(200);
	}

}
