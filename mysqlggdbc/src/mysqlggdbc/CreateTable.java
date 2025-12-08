package mysqlggdbc;
import java.sql.*;

public class CreateTable {
	public static void main(String arg[]) throws SQLException {		
		String db_url = "jdbc:mysql://localhost:3306/javaconnect";
		Connection con = DriverManager.getConnection(db_url, "root", "");
		Statement stm = con.createStatement();
		stm.execute("CREATE TABLE dept(dno int primary key auto_increment, dname varchar(100))");
	}
}

//package MySqlconnection;
//import java.sql.*;
//import java.util.Scanner;
//public class DeleteDept {
//	public static void main(String[] args) throws SQLException {
//		String db="jdbc:mysql://localhost:3306/tumbacollege";
//		Connection con = DriverManager.getConnection(db, "root", "");
//		PreparedStatement stm = con.prepareStatement("DELETE FROM dept WHERE dno >=?");
//		Scanner sc =new Scanner(System.in);
//		System.out.print("Enter Department Number: ");
//		int dno=sc.nextInt();
//		stm.setInt(1, dno);
//		stm.executeUpdate();
//		sc.close();
//		stm.close();
//		con.close();
//		
//	}
//package MySqlconnection;
//import java.sql.*;
//import java.util.Scanner;
//public class UpdateDept {
//	public static void main(String[] args) throws SQLException {
//		String db="jdbc:mysql://localhost:3306/tumbacollege";
//		Connection con = DriverManager.getConnection(db, "root", "");
//		PreparedStatement stm = con.prepareStatement("UPDATE dept SET dname= ? WHERE dno =?");
//		Scanner sc =new Scanner(System.in);
//		System.out.print("Which new Name of Department?: ");
//		String dname=sc.next();
//		System.out.print("Of which Department Number?: ");
//		int  dno=sc.nextInt();
//		stm.setString(1, dname);
//		stm.setInt(2, dno);
//		stm.executeUpdate();
//		sc.close();
//		stm.close();
//		con.close();
//		
//	}
//}


//package mYSQLConnect;
//import java.sql.*;
//public class Sqlconnect {
//
//	public static void main(String[] args) throws SQLException {
//		// TODO Auto-generated method stub
//		String db_url = "jdbc:mysql://localhost:3306/javadb";
//		Connection con = DriverManager.getConnection(db_url, "root", "");
//		
//		Statement stm = con.createStatement();
//		stm.execute("CREATE TABLE dept(dno int primary key auto_increment, dname varchar(100))");
//        stm.executeUpdate("insert into dept values(10,'IT')");
//		
//	}
//
//}