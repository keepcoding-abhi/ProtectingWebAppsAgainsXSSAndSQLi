package com.bank_application.dao;

import java.sql.DriverManager;
import com.bank_application.UserProfile;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.math.BigDecimal;

public class AddUserDao {
	public void create_entry(UserProfile new_user) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankApplication", "root", "root");
			String query = "INSERT INTO LogInCredentials VALUES (?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, new_user.getUser_name());
			ps.setString(2, new_user.getPassword());
			String is_admin = "N";
			if(new_user.getIs_admin()) {
				is_admin = "Y";
			};
			ps.setString(3,  is_admin);
			
			ps.execute();
			ps.close();
			
			query = "INSERT INTO UserData VALUES (?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(query);
			ps.setString(1, new_user.getUser_name());
			ps.setString(2, new_user.getFull_name());
			ps.setString(3, new_user.getAddress());
			ps.setBigDecimal(4, new BigDecimal(Long.parseLong(new_user.getDebit_card())));
			ps.setBigDecimal(5,  new BigDecimal(Long.parseLong(new_user.getCredit_card())));
			ps.setBigDecimal(6, new BigDecimal(Long.parseLong(new_user.getMobile_number())));
			ps.setString(7, new_user.getEmail_id());
			ps.execute();
			ps.close();
		}
		catch(ClassNotFoundException | SQLException exc) {
			System.out.println(exc);
		}
	}
}
