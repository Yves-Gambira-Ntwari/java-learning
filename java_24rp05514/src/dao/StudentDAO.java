package dao;

import model.Student;
import java.sql.*;
import java.util.*;

public class StudentDAO {

    // Add student to database
    public void addStudent(Student s) throws Exception {
        Connection conn = DatabaseConnection.getConnection();
        String sql = "INSERT INTO students(name, roll_number, math_marks, java_marks, php_marks) VALUES(?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, s.getName());
        ps.setString(2, s.getRollNumber());
        ps.setInt(3, s.getMathMarks());
        ps.setInt(4, s.getJavaMarks());
        ps.setInt(5, s.getPhpMarks());
        ps.executeUpdate();
        conn.close();
    }
    

    // Get all students
    public List<Student> getAllStudents() throws Exception {
        Connection conn = DatabaseConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM students");
        List<Student> list = new ArrayList<>();
        while(rs.next()) {
            Student s = new Student(
                rs.getString("name"),
                rs.getString("roll_number"),
                rs.getInt("math_marks"),
                rs.getInt("java_marks"),
                rs.getInt("php_marks")
            );
            list.add(s);
        }
        conn.close();
        return list;
    }

    // Get student with highest average
    public Student getTopStudent() throws Exception {
        Connection conn = DatabaseConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(
            "SELECT *, (math_marks+java_marks+php_marks)/3 AS avg_marks " +
            "FROM students ORDER BY avg_marks DESC LIMIT 1"
        );
        Student top = null;
        if(rs.next()) {
            top = new Student(
                rs.getString("name"),
                rs.getString("roll_number"),
                rs.getInt("math_marks"),
                rs.getInt("java_marks"),
                rs.getInt("php_marks")
            );
        }
        conn.close();
        return top;
    }
}