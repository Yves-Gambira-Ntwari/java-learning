package oop_java;

// Parent class
public class Persons {
    public static void main(String[] args) {
        class Parent{
        	String name;
        	public Parent(String name) {
        		this.name = name;
        	}
        	
        }
        class Child extends Parent{
        	String childName;
        	public Child(String name, String childName) {
        		super(name);
        		this.childName = childName;
        	}
        	public void info() {
        		System.out.println("My name is " + childName);
        		System.out.print("My parent's name is " + name);
        	}
        }
        Child child1 = new Child("Gambira", "Ntwari Yves");
        child1.info();

    }
}
