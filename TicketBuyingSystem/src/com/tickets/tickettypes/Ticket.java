//Student 1
//Full Name: Gambira Ntwari Yves
//Regno: 24rp05514
//Class:B

//Student 2
//Full Name: Umurerwa Marie
//Regno: 24rp12881
//Class:B



package com.tickets.tickettypes;
import com.tickets.interfaces.*;
public abstract class Ticket implements IBookable {
	
	double basePrice;
	Ticket(double basePrice){
		this.basePrice = basePrice;
	}
}
