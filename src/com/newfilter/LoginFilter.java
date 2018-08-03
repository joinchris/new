package com.newfilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
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
	public void doFilter(ServletRequest requestCopy, ServletResponse responseCopy, FilterChain filter) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)requestCopy;
		HttpServletResponse response = (HttpServletResponse)responseCopy;
		HttpSession session = request.getSession();
		//用户为空
		if(session.getAttribute("user") == null) {
			//判断jsp为空
			String url = request.getParameter("jsp") + ".";
			if(request.getParameter("jsp") == null || url.indexOf(".") == -1) {
				response.sendRedirect("http://localhost:8080/new/NewServlet?jsp=newsindex");
			}else if(request.getParameter("jsp").equals("newsread") || url.indexOf(".") == -1) {
				filter.doFilter(requestCopy, responseCopy);
			}else {
				filter.doFilter(requestCopy, responseCopy);
			}
		}else {
			//不为空执行do
			filter.doFilter(requestCopy, responseCopy);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
