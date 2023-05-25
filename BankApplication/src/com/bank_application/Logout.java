package com.bank_application;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Logout extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
		try {
			HttpSession session = req.getSession();
			session.removeAttribute("username");
			session.removeAttribute("admin_logged");
			session.invalidate();
			res.sendRedirect("login.jsp");
		}
		catch(IOException ioe) {
			System.out.println(ioe);
		}
	}
}
