package javaConnect;
import java.util.Scanner;
import java.sql.*;

public class CreateTable {

	public static void main(String arg[]) throws SQLException {		
		String db_url = "jdbc:mysql://localhost:3306/javaconnect";
		Connection con = DriverManager.getConnection(db_url, "root", "");
		Statement stm = con.createStatement();
		Scanner sc = new Scanner(System.in);
		String names = sc.next();
//		stm.execute("CREATE TABLE dept(dno int primary key auto_increment, dname varchar(100))");
		stm.execute("INSERT INTO dept(dname) VALUES('"+names+"')");
	}
}
