package com.bank_application.dao;

import com.bank_application.UserProfile;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProfileDao {
	public UserProfile getUserProfile(String user_name) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/BankApplication", "root", "root");
			String query = "SELECT t1.user_name, t1.full_name, t1.address, t1.debit_card, t1.credit_card, t1.mobile_number, t1.email_id, t2.password, t2.is_admin FROM UserData t1 INNER JOIN LogInCredentials t2 ON t1.user_name = t2.user_name WHERE t1.user_name = \"" + user_name + "\"";
			System.out.println(query);
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				boolean is_admin = false;
				if(rs.getString(9).equals("Y")) {
					is_admin = true;
				}
				return new UserProfile(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), is_admin);
			}
		}
		catch(ClassNotFoundException | SQLException exc) {
			System.out.println(exc);
		}
		
		return null;
	}
}
