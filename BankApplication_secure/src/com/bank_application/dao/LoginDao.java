package com.bank_application.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import com.bank_application.LoginCredentials;

public class LoginDao {
	public LoginCredentials check (String username, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankApplication", "root", "root");
			String query = "SELECT * FROM LogInCredentials where user_name = \"" + username + "\" and password = \"" + password + "\"";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if(rs.next()) {
				boolean is_admin = false;
				if(rs.getString(3).charAt(0) == 'Y') {
					is_admin = true;
				}
				LoginCredentials to_send = new LoginCredentials(rs.getString(1), is_admin);
				st.close();
				return to_send;
			}
			st.close();
		}
		catch(ClassNotFoundException | SQLException exc) {
			System.out.println(exc);
		}
		
		return null;
	}
}
