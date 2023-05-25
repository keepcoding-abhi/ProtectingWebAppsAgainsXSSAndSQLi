package com.bank_application;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;
import org.apache.commons.text.StringEscapeUtils;

/**
 * Servlet Filter implementation class AddUserFilter
 */
@WebFilter(servletNames = { "AddUser" })
public class AddUserFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AddUserFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		RequestDispatcher rd = req.getRequestDispatcher("ProxyServerScript");
		HttpSession session = req.getSession();
		
		String uname, password, error = "\0";
		uname = req.getParameter("user_name");
		password = req.getParameter("password");
		
		if(ProxyServerQuery.check_scripted_value(uname)) {
			error = "Invalid username >>>" + uname + "<<<. It may cause SQL Injection. Please specify different username.\n";
		}
		
		if(ProxyServerQuery.check_scripted_value(password)) {
			error += "Invalid password >>>" + password  + "<<<. It may cause SQL Injection. Please specify different password.\n";
		}
	
		rd.include(req, res);
		
		boolean sanitized = (boolean)session.getAttribute("xss");
		if(sanitized) {
			error += "The specified input fields may cause Cross Site Scripting. Please avoid any special characters in the input fields.\n";
		}
		
		if(error.length() != 0) {
			error = StringEscapeUtils.escapeHtml4(error);
			session.setAttribute("printError", error);
			res.sendRedirect("add_user.jsp");
		}
		else {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
