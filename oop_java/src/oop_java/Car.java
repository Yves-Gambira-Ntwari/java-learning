package oop_java;

public class Car {
	public static void main(String args[]) {
		Student student = new Student();
		student.name= "Alice";
		student.age = 15;
		student.studentId = "S123";
		
		student.displayInfo();
		student.showDetails();
		
		
		Rectangle rectangle = new Rectangle();
		Circle circle = new Circle();
		
		rectangle.draw();
		circle.draw();
		circle.description();
		
		Transport[] transport = {new Bus(),new Car2(),new Bicycle()};
		
		for(Transport trans: transport) {
			trans.move();
		}
	}
}

class Person {
	String name;
	int age;
	
	void displayInfo() {
		System.out.println("Name: "+ this.name);
		System.out.println("Age: "+ this.age);
	}
}

class Student extends Person{
	String studentId;
	void showDetails() {
		
		System.out.println("StudentId: "+ this.studentId);
		
	}
}

abstract class Shape{
	abstract void draw();
	void description() {
		System.out.println("This is a geometric shape");
	}
}
class Rectangle extends Shape{
	void draw() {
		System.out.println("Rectangle Drawn");
	}
}

class Circle extends Shape{
	void draw(){
		System.out.println("Circle drawn");
	}
}

interface Transport{
	void move();
	
}

class Car2 implements Transport{
	public void move() {
		System.out.println("Car moves");
	}
	
}
class Bus implements Transport{
	public void move() {
		System.out.println("Bus moves");
		
	}
}
class Bicycle implements Transport{
	public void move() {
		System.out.println("Bicycle moves");
		
	}
}
