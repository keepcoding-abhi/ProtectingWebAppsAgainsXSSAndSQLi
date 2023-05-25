package com.bank_application.dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

public class FeedbackDao {
	public void add(String name, String message) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankApplication", "root", "root");
			String query = "INSERT INTO Feedback(name, message) VALUES (?, ?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2,  message);
			ps.execute();
			ps.close();
		}
		catch(ClassNotFoundException | SQLException exc) {
			System.out.println(exc);
		}
	}
	
	public ArrayList<String[]> getPreviousFeedbacks() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankApplication", "root", "root");
			String query = "SELECT * FROM Feedback ORDER BY time_posted DESC";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			String entry[];
			ArrayList<String[]> all_entries = new ArrayList<String[]>();
			while(rs.next()) {
				entry = new String[3];
				entry[0] = (rs.getTimestamp(1)).toString().replace(".0", "");
				entry[1] = rs.getString(2);
				entry[2] = rs.getString(3);
				all_entries.add(entry);
			}
			return all_entries;
		}
		catch(ClassNotFoundException | SQLException exc) {
			System.out.println(exc);
		}
		return null;
	}
}
