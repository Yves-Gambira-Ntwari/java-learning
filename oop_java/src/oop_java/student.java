package oop_java;

public class student {
	private double side1;
	private double side2;
	private double side3;
	public student(double s1, double s2, double s3) {
		side1= s1;
		side2 = s2;
		side3 = s3;
	}
	
	
	// Getters
    public double getSide1() { return side1; }
    public double getSide2() { return side2; }
    public double getSide3() { return side3; }

    // Setters
    public void setSide1(double s1) { side1 = s1; }
    public void setSide2(double s2) { side2 = s2; }
    public void setSide3(double s3) { side3 = s3; }
	
    public double getPerimeter() {
        return side1 + side2 + side3; 
    }
    public double getArea() {
    	return (side1 + side2 +side3) / 2;
    }




	
	public static void main(String[] args) {
		student triangle = new student(2,5,6);
		System.out.println(triangle.getPerimeter());
		System.out.print(triangle.getArea());
		

	}

}

