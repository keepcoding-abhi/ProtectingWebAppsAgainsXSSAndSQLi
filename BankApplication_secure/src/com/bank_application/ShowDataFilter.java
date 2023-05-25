package com.bank_application;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import org.apache.commons.text.StringEscapeUtils;

/**
 * Servlet Filter implementation class ShowDataFilter
 */
@WebFilter("/showData.jsp")
public class ShowDataFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ShowDataFilter() {
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
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		RequestDispatcher rd = req.getRequestDispatcher("ProxyServerQuery");

		rd.include(req, res);
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("sqli");
		if(obj == null) {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
		else {
			session.removeAttribute("sqli");
			String display_alert = StringEscapeUtils.escapeHtml4("SQL based Query!!! The input >>>" + (String)obj + "<<< may lead to SQL Injection attack. Please give safe input.");
			session.setAttribute("printError", display_alert);
			if(session.getAttribute("admin_logged") == null)
				res.sendRedirect("welcome.jsp");
			else
				res.sendRedirect("welcome_admin.jsp");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
