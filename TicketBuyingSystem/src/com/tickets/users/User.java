//Student 1
//Full Name: Gambira Ntwari Yves
//Regno: 24rp05514
//Class:B

//Student 2
//Full Name: Umurerwa Marie
//Regno: 24rp12881
//Class:B

package com.tickets.users;

public abstract class User{
	 String name;
	 String regNumber;
	 String className;
	 public User(String name, String regNumber, String className) {
		 this.name = name;
		 this.className = className;
		 this.regNumber = regNumber;
	 }
	public void getUserInfo() {
		System.out.println(this.name);
		System.out.println(this.regNumber);
		System.out.println(this.className);
	}
	
}
