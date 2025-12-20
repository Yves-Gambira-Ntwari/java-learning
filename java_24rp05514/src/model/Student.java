package model;

public class Student {
    private String name;
    private String rollNumber;
    private int mathMarks;
    private int javaMarks;
    private int phpMarks;

    // Constructor
    public Student(String name, String rollNumber, int mathMarks, int javaMarks, int phpMarks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.mathMarks = mathMarks;
        this.javaMarks = javaMarks;
        this.phpMarks = phpMarks;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRollNumber() { return rollNumber; }
    public void setRollNumber(String rollNumber) { this.rollNumber = rollNumber; }

    public int getMathMarks() { return mathMarks; }
    public void setMathMarks(int mathMarks) { this.mathMarks = mathMarks; }

    public int getJavaMarks() { return javaMarks; }
    public void setJavaMarks(int javaMarks) { this.javaMarks = javaMarks; }

    public int getPhpMarks() { return phpMarks; }
    public void setPhpMarks(int phpMarks) { this.phpMarks = phpMarks; }

    // Calculate average
    public double calculateAverage() {
        return (mathMarks + javaMarks + phpMarks) / 3.0;
    }
}