package com.bank_application;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bank_application.dao.AddUserDao;
import java.io.IOException;

public class AddUser extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		boolean is_admin = false;
		if(req.getParameter("user_type").equals("admin")) {
			is_admin = true;
		}
		
		UserProfile new_profile = new
		UserProfile(
				req.getParameter("user_name"),
				req.getParameter("full_name"),
				req.getParameter("address"),
				req.getParameter("debit_card"),
				req.getParameter("credit_card"),
				req.getParameter("mobile_number"),
				req.getParameter("email_id"),
				req.getParameter("password"),
				is_admin
			);
		
		AddUserDao add_to_database = new AddUserDao();
		add_to_database.create_entry(new_profile);
		try {
			res.sendRedirect("welcome_admin.jsp");
		}
		catch(IOException ioe) {
			System.out.println(ioe);
		}
	}
}
