package gui;

import model.Student;
import dao.StudentDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class StudentManagementGUI extends JFrame {
    private JTextField nameField, rollField, mathField, javaField, phpField;
    private JButton addButton, exitButton, refreshButton, topStudentButton;
    private JTable studentTable;
    private DefaultTableModel tableModel;

    public StudentManagementGUI() {
        setTitle("Student Management System");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Form Panel
        JPanel formPanel = new JPanel(new GridLayout(7, 2));
        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Reg Number:"));
        rollField = new JTextField();
        formPanel.add(rollField);

        formPanel.add(new JLabel("Math Marks:"));
        mathField = new JTextField();
        formPanel.add(mathField);

        formPanel.add(new JLabel("Java Marks:"));
        javaField = new JTextField();
        formPanel.add(javaField);

        formPanel.add(new JLabel("PHP Marks:"));
        phpField = new JTextField();
        formPanel.add(phpField);

        addButton = new JButton("Add Student");
        exitButton = new JButton("Exit");

        formPanel.add(addButton);
        formPanel.add(exitButton);

        add(formPanel, BorderLayout.NORTH);

        // Table
        tableModel = new DefaultTableModel(new String[]{"Name", "Reg Number", "Average Marks"}, 0);
        studentTable = new JTable(tableModel);
        add(new JScrollPane(studentTable), BorderLayout.CENTER);

        // Inside addButton ActionListener
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                String roll = rollField.getText().trim();

                try {
                    int math = Integer.parseInt(mathField.getText().trim());
                    int java = Integer.parseInt(javaField.getText().trim());
                    int php = Integer.parseInt(phpField.getText().trim());

                    if (!isValidMark(math) || !isValidMark(java) || !isValidMark(php)) {
                        JOptionPane.showMessageDialog(null, "Marks should be between 0 and 100.");
                        return;
                    }

                    // Create student object
                    Student s = new Student(name, roll, math, java, php);

                    // Save to DB
                    dao.StudentDAO dao = new dao.StudentDAO();
                    dao.addStudent(s);

                    // Add to table
                    tableModel.addRow(new Object[]{name, roll, s.calculateAverage()});

                    // Clear fields
                    nameField.setText("");
                    rollField.setText("");
                    mathField.setText("");
                    javaField.setText("");
                    phpField.setText("");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numeric values for marks.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error saving student: " + ex.getMessage());
                }
            }
        });

        exitButton.addActionListener(e -> System.exit(0));
        refreshButton.addActionListener(e -> loadStudents());
//        topStudentButton.addActionListener(e -> showTopStudent());

        // Load existing students at startup
        loadStudents();
    }

    private void loadStudents() {
        try {
            StudentDAO dao = new StudentDAO();
            java.util.List<Student> students = dao.getAllStudents();

            tableModel.setRowCount(0); // clear table
            for (Student s : students) {
                tableModel.addRow(new Object[]{s.getName(), s.getRollNumber(), s.calculateAverage()});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error loading students: " + ex.getMessage());
        }
    }

//    private void showTopStudent() {
//        try {
//            StudentDAO dao = new StudentDAO();
//            Student top = dao.getTopStudent();
//            if (top != null) {
//                JOptionPane.showMessageDialog(this,
//                        "Top Student:\nName: " + top.getName() +
//                        "\nReg Number: " + top.getRollNumber() +
//                        "\nAverage Marks: " + top.calculateAverage());
//            } else {
//                JOptionPane.showMessageDialog(this, "No students found.");
//            }
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(this, "Error fetching top student: " + ex.getMessage());
//        }
//    }

    private boolean isValidMark(int mark) {
        return mark >= 0 && mark <= 100;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentManagementGUI().setVisible(true));
    }
}