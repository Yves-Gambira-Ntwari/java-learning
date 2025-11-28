//Student 1
//Full Name: Gambira Ntwari Yves
//Regno: 24rp05514
//Class:B

//Student 2
//Full Name: Umurerwa Marie
//Regno: 24rp12881
//Class:B

package com.tickets.tickettypes;
import com.tickets.app.*;


public class VIPTicket extends Ticket {
	double VIPFee = 5;
	String snacks = "";
	String block = "";
	public VIPTicket(String block) {
		super(10);
		this.block = block; 
	}
	public double claculateFinaPrice() {
		return basePrice + VIPFee;
	}
	
	public void buyTicket(double basePrice) {
		System.out.println("VIP ticket of: " + basePrice + "$");
	}
	public void buyTicket(double basePrice, String extra) {
		System.out.println("VIP ticket of: " + basePrice + "$" + "+" + VIPFee);
		System.out.println(" Total Price= " + claculateFinaPrice() + " seat " + block + " plus snack: " + extra);
		System.out.println(" seat " + block + " plus snack: " + extra);
	}
	public void cancel() {
		System.out.println("Standard ticket of: " + basePrice + "$" + "Have been cancaled");
	}
	public void showInfo() {}
}
