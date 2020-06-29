package mainapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args)
			throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("1.Register Here");
		System.out.println("2.Login");
		int x;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		x = Integer.parseInt(br.readLine());

		// objects
		RegisterPojo registerpojo = new RegisterPojo();
		RegisterDAO registerdao = new RegisterDAO();
		LoginPOJO loginpojo = new LoginPOJO();
		LoginDAO logindao = new LoginDAO();
		switch (x) {
		case 1:
			System.out.println("Enter the first name");
			String firstname = br.readLine();
			System.out.println("Enter the last name");
			String lastname = br.readLine();
			System.out.println("Enter the user name");
			String username = br.readLine();
			System.out.println("Enter the password");
			String password = br.readLine();
			System.out.println("Enter the user email");
			String email = br.readLine();

			registerpojo.setFirstName(firstname);
			registerpojo.setLastName(lastname);
			registerpojo.setUsername(username);
			registerpojo.setPassword(password);
			registerpojo.setEmail(email);

			registerdao.addUser(registerpojo);
			break;

		case 2:
			System.out.println("Enter the user name");
			String name = br.readLine();
			System.out.println("Enter the password");
			String pass = br.readLine();
			loginpojo.setUsername(name);
			loginpojo.setPassword(pass);
			if (logindao.validate(loginpojo) == true) {
				Luck luck = new Luck();
				luck.display();
			} else {
				System.out.println("Incorrect email or password");
			}
			break;
		}
	}

}
