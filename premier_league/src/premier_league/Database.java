package premier_league;
import java.sql.*;
public class Database {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String db_url = "jdbc:mysql://localhost:3306/premier_league";
		Connection con = DriverManager.getConnection(db_url, "root", "");
		Statement stm = con.createStatement();
		stm.execute("CREATE TABLE fan (id int PRIMARY key auto_increment, team varchar(10), goal int)");
		System.out.print("Yes");

	}

}
