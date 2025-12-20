package service;

import dao.StudentDAO;
import model.Student;
import java.util.List;

public class StudentService {
    private StudentDAO studentDAO;

    public StudentService() {
        this.studentDAO = new StudentDAO();
    }

    // Add a student (delegates to DAO)
    public void addStudent(Student student) throws Exception {
        studentDAO.addStudent(student);
    }

    // Get all students
    public List<Student> getAllStudents() throws Exception {
        return studentDAO.getAllStudents();
    }

    // Calculate class average (average of all students' averages)
    public double calculateClassAverage() throws Exception {
        List<Student> students = studentDAO.getAllStudents();
        if (students.isEmpty()) return 0.0;

        double total = 0;
        for (Student s : students) {
            total += s.calculateAverage();
        }
        return total / students.size();
    }
}

    // Get top student (highest average)
//    public Student getTopStudent() throws Exception {
//        return studentDAO.getTopStudent();
//    }
