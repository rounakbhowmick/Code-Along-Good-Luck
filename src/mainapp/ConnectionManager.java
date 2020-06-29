package mainapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		// Register the driver class //Loading Driver
		Class.forName("oracle.jdbc.OracleDriver");

		// Create the conncection object
		// DriverManager.getConnection(url,user,password)
		Connection con = null;
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "rounak");
		if (con != null) {
			System.out.println("Established");
		} else {
			System.out.println("Error");
		}
		return con;
	}
}
