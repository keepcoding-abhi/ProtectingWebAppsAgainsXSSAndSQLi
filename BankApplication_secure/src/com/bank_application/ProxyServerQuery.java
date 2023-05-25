package com.bank_application;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import sun.awt.datatransfer.DataTransferer.ReencodingInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;
import java.util.Enumeration;

public class ProxyServerQuery extends HttpServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		String result = check_scripted_request(request);
		
		if(result != null) {
			HttpSession session = request.getSession();
			session.setAttribute("sqli", result);
		}
	}
	
	public String check_scripted_request(HttpServletRequest req) {
		Enumeration<String> parameterNames = req.getParameterNames();
		String currentParameter, currentValues[], currentValue;
		
		while(parameterNames.hasMoreElements()) {
			currentParameter = parameterNames.nextElement();
			currentValues = req.getParameterValues(currentParameter);
			
			for(int i = 0, n = currentValues.length ; i < n ; i++) {
				currentValue = currentValues[i];
				if(check_scripted_value(currentValue) == true) {
					return currentValue;
				}
			}
		}
		
		return null;
	}
	
	public static boolean check_scripted_value(String value) {
		value = value.toUpperCase();
		String restricted[] = {"#", "--", "/*", ";", "=", " OR ", " AND ", "\'", "\"", " DROP ", " SELECT ", " UNION ", " DELETE ", " CONCAT", " GROUP_CONCAT"};
		for(int i = 0 , n = restricted.length ; i < n ; i++) {
			if(value.contains(restricted[i])) {
				return true;
			}
		}
		return false;
	}
}
