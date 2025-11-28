//Student 1
//Full Name: Gambira Ntwari Yves
//Regno: 24rp05514
//Class:B

//Student 2
//Full Name: Umurerwa Marie
//Regno: 24rp12881
//Class:B

package com.tickets.interfaces;

public interface IBookable {
	public void buyTicket(double basePrice);
	public void buyTicket(double basePrice, String extra);
	public void cancel();
	public void showInfo();
}
