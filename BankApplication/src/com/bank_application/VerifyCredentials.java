package com.bank_application;

import com.bank_application.dao.LoginDao;
import com.bank_application.LoginCredentials;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;

public class VerifyCredentials extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		String uname = req.getParameter("user_name");
		String pass = req.getParameter("password");

		try {
			LoginDao login_database = new LoginDao();
			LoginCredentials login_data = login_database.check(uname,  pass);
			if(login_data != null) {
				HttpSession session = req.getSession();
				session.setAttribute("username", login_data.getUsername());
				if(login_data.getIs_admin()) {
					session.setAttribute("admin_logged", "yes");
					res.sendRedirect("welcome_admin.jsp");
				}
				else
					res.sendRedirect("welcome.jsp");
			}
			else {
				res.sendRedirect("login.jsp");
			}
		}
		catch(IOException ioe) {
			System.out.println(ioe);
		}
	}
}
