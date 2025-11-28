//Student 1
//Full Name: Gambira Ntwari Yves
//Regno: 24rp05514
//Class:B

//Student 2
//Full Name: Umurerwa Marie
//Regno: 24rp12881
//Class:B

package com.tickets.app;
import com.tickets.users.*;
import com.tickets.tickettypes.*;

public class DemoApp {

	public static void main(String[] args) {
		RegularUser nina = new RegularUser("Umurerwa Marie", "24rp12881", "B");
		RegularUser lucas = new RegularUser("Gambira Ntwari Yves", "24rp05514", "B");
//		nina.getUserInfo();
//		lucas.getUserInfo();
		StandardTicket ninaStandard = new StandardTicket("A1");
		VIPTicket lucasVIP = new VIPTicket("A1");
		ninaStandard.buyTicket(10);
		lucasVIP.buyTicket(10, "Popcone");
		
	}

}
