package mainapp;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {
	public void addUser(RegisterPojo registerPojo) throws ClassNotFoundException, SQLException {
		String firstname = registerPojo.getFirstName();
		String lastname = registerPojo.getLastName();
		String username = registerPojo.getUsername();
		String password = registerPojo.getPassword();
		String email = registerPojo.getEmail();

		ConnectionManager cm = new ConnectionManager();
		// Insert all the details in the database

		String sql = "Insert into USERDETAILS(FIRSTNAME,LASTNAME,USERNAME,PASSWORD,EMAIL)VALUES(?,?,?,?,?)";
		// Create Statement Object
		PreparedStatement st = cm.getConnection().prepareStatement(sql);
		st.setString(1, firstname);
		st.setString(2, lastname);
		st.setString(3, username);
		st.setString(4, password);
		st.setString(5, email);
		st.executeUpdate();
		cm.getConnection().close();
	}
}
