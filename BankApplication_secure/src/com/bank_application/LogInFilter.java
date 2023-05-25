package com.bank_application;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.text.StringEscapeUtils;
/**
 * Servlet Filter implementation class LogInFilter
 */

@WebFilter("/VerifyCredentials")
public class LogInFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LogInFilter() {
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
		//System.out.println("In log-in filter.");
		HttpServletRequest req = (HttpServletRequest)request;
		
		RequestDispatcher rd = req.getRequestDispatcher("ProxyServerQuery");
		rd.include(req, response);
		//System.out.println("Back in login filter");
		// pass the request along the filter chain
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("sqli");
		if(obj == null) {
			chain.doFilter(request, response);
		}
		else {
			session.removeAttribute("sqli");
			String display_alert = StringEscapeUtils.escapeHtml4("SQL based Query!!! The input >>>" + (String)obj + "<<< may lead to SQL Injection attack. Please give safe input.");
			session.setAttribute("printError", display_alert);
			((HttpServletResponse)response).sendRedirect("login.jsp");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
