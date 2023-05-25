package com.bank_application;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bank_application.dao.FeedbackDao;
import java.io.IOException;

public class Feedback extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		try {
			FeedbackDao feedback = new FeedbackDao();
			feedback.add((String)req.getAttribute("client_name"), (String)req.getAttribute("message"));
			res.sendRedirect("feedback.jsp");
		}
		catch(IOException ioe) {
			System.out.println(ioe);
		}
	}
}
