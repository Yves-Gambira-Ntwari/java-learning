package services;

import model.Students;
import java.util.List;


public interface StudentService {
    
    
    boolean addStudent(Students student);
    
        List<Students> getAllStudents();
    
        boolean updateStudent(Students student);
    
        boolean deleteStudent(int studentId);
    
        Students getStudentById(int studentId);
}