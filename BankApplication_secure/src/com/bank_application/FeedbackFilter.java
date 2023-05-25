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
 * Servlet Filter implementation class FeedbackFilter
 */
@WebFilter("/Feedback")
public class FeedbackFilter implements Filter {

    /**
     * Default constructor. 
     */
    public FeedbackFilter() {
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

		// pass the request along the filter chain
		HttpServletResponse res = (HttpServletResponse)response;
		HttpServletRequest req = (HttpServletRequest) request;
		
		RequestDispatcher rd = req.getRequestDispatcher("ProxyServerScript");
		rd.include(req, res);
		
		HttpSession session = req.getSession();
		boolean sanitized = (boolean)session.getAttribute("xss");
		session.removeAttribute("xss");
		if(sanitized) {
			String warning = "Script-based Request. The input provided by you may lead to an XSS attack. It was sanitized before processing.";
			warning = StringEscapeUtils.escapeHtml4(warning);
			session.setAttribute("printWarning", warning);
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
