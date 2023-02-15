package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	 public static Connection DBCon() throws ClassNotFoundException, SQLException {
			
		 	Connection con;
			String url="jdbc:mysql://localhost:3306/e_ticketformonorail";
			String uname = "root";
			String pass = "hrushi";
			
			Class.forName("com.mysql.cj.jdbc.Driver");						//Load SQL Drivers
			con = DriverManager.getConnection(url, uname, pass);			//Connect to MySQL Database
			
			return con;
			
		}
}
