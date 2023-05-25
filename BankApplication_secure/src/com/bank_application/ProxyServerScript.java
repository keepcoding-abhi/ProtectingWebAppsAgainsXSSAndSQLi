package com.bank_application;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.Enumeration;
import javax.servlet.http.HttpSession;

public class ProxyServerScript extends HttpServlet {
	@Override
	public void service(ServletRequest request, ServletResponse response) {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		boolean sanitized = check_script_based_query(req);
		HttpSession session = req.getSession();
		session.setAttribute("xss", sanitized);
	}
	
	public boolean check_script_based_query(HttpServletRequest req) {
		Enumeration<String> parameterNames = req.getParameterNames();
		boolean sanitized = false;
		while(parameterNames.hasMoreElements()) {
			String currentParameter = parameterNames.nextElement();
			String currentValues[] = req.getParameterValues(currentParameter);
			
			for(int i = 0, n = currentValues.length ; i < n ; i++) {
				String current = currentValues[i];
				int length = current.length();
				current = current.replaceAll("<!--|-->", "");
				current = current.replaceAll("<[^>]*>", "");
				req.setAttribute(currentParameter, current);
				if(current.length() != length) {
					sanitized = true;
				}
			}
		}
		return sanitized;
	}
}
