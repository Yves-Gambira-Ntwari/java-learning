package champion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import premier_league.Database;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login_form {
	public static void main(String[] args) throws SQLException {
		String db_url = "jdbc:mysql://localhost:3306/premier_league";
		Connection con = DriverManager.getConnection(db_url, "root", "");
		Statement stm = con.createStatement();
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
        String displaySql = "SELECT *FROM fan";
        PreparedStatement ps = con.prepareStatement(displaySql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
        	String fanName = rs.getString("fanName");
        	String teamNames = rs.getString("team");
        	int goalOnes = Integer.parseInt(rs.getString("goalone"));
        	int goalTwos = Integer.parseInt(rs.getString("goaltwo"));
        	int goalThrees = Integer.parseInt(rs.getString("goalthree"));
        	int average = (goalOnes + goalTwos + goalThrees)/3;
        	
        	
        	
        	model.addRow(new Object[]{ fanName, teamNames, average});
        }
        
        
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.add(firstname);
        formPanel.add(fnameField);

        formPanel.add(teamName);
        formPanel.add(teamField);

        formPanel.add(playerOne);
        formPanel.add(playerOneField);

        formPanel.add(playerTwo);
        formPanel.add(playerTwoField);

        formPanel.add(playerThree);
        formPanel.add(playerThreeField);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(add);
        buttonPanel.add(updateRecord);
        buttonPanel.add(deleteRecord);
        buttonPanel.add(exit);
        
        frame.setLayout(new BorderLayout(10, 10));
        frame.add(formPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
		
		frame.setSize(1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		add.addActionListener(e ->{
			String firstnameValue = fnameField.getText();
			String teamValue = teamField.getText();
			String playerOneValue = playerOneField.getText();
			String playerTwoValue =  playerTwoField.getText();
			String playerThreeValue =  playerThreeField.getText();

			if(firstnameValue.isEmpty() || teamValue.isEmpty() || playerOneValue.isEmpty() || playerTwoValue.isEmpty() || playerThreeValue.isEmpty()) {
		        JOptionPane.showMessageDialog(
		                frame,
		                "Please fill all required fields"
		            );
			
			} else {
				int newPlayerOne = Integer.parseInt(playerOneValue);
				int newPlayerTwo = Integer.parseInt(playerTwoValue);
				int newPlayerThree = Integer.parseInt(playerThreeValue);
				
				if(newPlayerOne < 0 || newPlayerTwo <0 || newPlayerThree < 0) {
			        JOptionPane.showMessageDialog(
			                frame,
			                "The Goals must be positive number"
			            );
				}else{					
					try {
						new Database().Database(firstnameValue, teamValue, playerOneValue, playerTwoValue, playerThreeValue);
						
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
			}
			
			
		});
		
		

	}

}
