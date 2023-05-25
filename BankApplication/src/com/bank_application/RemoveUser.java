package com.bank_application;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.bank_application.dao.RemoveUserDao;

public class RemoveUser extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
		String remove = req.getParameter("delete_user");
		new RemoveUserDao().remove(remove);
		
		try {
			res.sendRedirect("welcome_admin.jsp");
		}
		catch(IOException ioe) {
			System.out.println(ioe);
		}
	}
}
