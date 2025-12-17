package champion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class Login_form {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Login Form");
		JLabel firstname =  new JLabel("First name: ");
		JTextField fnameField = new JTextField(20);
		JLabel teamName = new JLabel("Team name: ");
		JTextField teamField = new JTextField(20);
		JLabel playerOne = new JLabel("Player with one Goal");
		JTextField playerOneField = new JTextField(20);
		JLabel playerTwo = new JLabel("Player with one Goal");
		JTextField playerTwoField = new JTextField(20);
		JLabel playerThree = new JLabel("Player with one Goal");
		JTextField playerThreeField = new JTextField(20);
		JButton updateRecord =  new JButton("Update Record");
		JButton deleteRecord = new JButton("Delete Record");
		
		JButton add = new JButton("Add");
		JButton exit = new JButton("Exit");

        // Table data
		
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Fun name");
        model.addColumn("Team Name");
        model.addColumn("Average Goals");
        model.addRow(new Object[]{ "Alice", 21, 0.2});
        model.addRow(new Object[]{ "Bob", 23,03});
        
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        
		JPanel panel = new JPanel();
		panel.add(firstname);
		panel.add(fnameField);
		panel.add(teamName);
		panel.add(teamField);
		panel.add(playerOne);
		panel.add(playerOneField);
		panel.add(playerTwo);
		panel.add(playerTwoField);
		panel.add(playerThree);
		panel.add(playerThreeField);
		panel.add(add);
		panel.add(exit);
//		panel.add(display);
		panel.add(scrollPane);
		panel.add(updateRecord);
		panel.add(deleteRecord);
		
		frame.add(panel);
		frame.setSize(1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		

	}

}
