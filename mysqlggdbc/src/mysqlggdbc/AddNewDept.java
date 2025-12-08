//package mysqlggdbc;
//import java.sql.*;
//import java.util.Scanner;
//
//public class AddNewDept {
//
//	public static void main(String[] args) throws SQLException {
//		String db_url = "jdbc:mysql://localhost:3306/javaconnect";
//		Connection con = DriverManager.getConnection(db_url, "root", "");
//		prepareStatement pstm = con.prepareStatement("INSERT INTO dept VALUES(?,?)");
//		Scanner sc = new Scanner(System.in);
//		System.out.print("Enter your Department number: ");
//		int dno = sc.nextInt();
//		System.out.print("Enter your Department name: ");
//		String dname = sc.next();
//		pstm.setInt()
//	}
//
//}
