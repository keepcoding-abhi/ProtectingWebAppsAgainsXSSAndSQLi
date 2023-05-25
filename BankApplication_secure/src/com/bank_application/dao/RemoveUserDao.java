package com.bank_application.dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class RemoveUserDao {
	public void remove(String user_name) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankApplication", "root", "root");
			Statement stmt = con.createStatement();
			
			String query = "DELETE FROM LogInCredentials WHERE user_name = \"" + user_name + "\"";
			stmt.execute(query);
		}
		catch(ClassNotFoundException | SQLException exc) {
			System.out.println(exc);
		}
	}
}
