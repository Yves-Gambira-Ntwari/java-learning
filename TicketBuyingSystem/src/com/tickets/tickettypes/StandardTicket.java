//Student 1
//Full Name: Gambira Ntwari Yves
//Regno: 24rp05514
//Class:B

//Student 2
//Full Name: Umurerwa Marie
//Regno: 24rp12881
//Class:B

package com.tickets.tickettypes;

public class StandardTicket extends Ticket{
	String block;
	public StandardTicket(String block){
		super(10);
		basePrice = 10;
		this.block = block; 
	}
	
	public double claculateFinaPrice() {
		return basePrice;
	}
	
	public void buyTicket(double basePrice) {
		System.out.println("Standard ticket of: , price:" + claculateFinaPrice() + "$"+ " seat " + block);
		System.out.println(" seat " + block);
		System.out.println(claculateFinaPrice() + "$"+ " seat " + block);
	}
	

	public void buyTicket(double basePrice, String extra) {
		
	}
	public void cancel() {
		System.out.println("Standard ticket of: " + claculateFinaPrice() + "$" + "Have been cancaled");
		System.out.println(claculateFinaPrice() + "$" + "Have been cancaled");
	}
	public void showInfo() {
		System.out.println("Standard ticket of: " + basePrice + "$");
	}
}
