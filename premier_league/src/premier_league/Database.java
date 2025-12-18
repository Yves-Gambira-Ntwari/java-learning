package premier_league;
import java.sql.*;
public class Database {
	
	String db_url = "jdbc:mysql://localhost:3306/premier_league";
	public void Database(String fname, String teamName, String goalOne, String goalTwo, String goalThree) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection(db_url, "root", "");
		Statement stm = con.createStatement();
//		stm.execute("CREATE TABLE fan (id int PRIMARY key auto_increment, team varchar(10), goal int)");
		String insert = "INSERT INTO fan( `fanName`, `team`, `goalone`, `goaltwo`, `goalthree`) VALUES (?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(insert);
		ps.setString(1, fname);
		ps.setString(2, teamName);
		ps.setString(3, goalOne);
		ps.setString(4, goalTwo);
		ps.setString(5, goalThree);
		ps.executeUpdate();
		System.out.print("Inserted successful");
		

	}

}
