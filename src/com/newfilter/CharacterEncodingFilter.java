package com.newfilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

public class CharacterEncodingFilter implements Filter {
	private static Logger logger = Logger.getLogger(CharacterEncodingFilter.class);
	private String charset = null;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filter) throws IOException, ServletException {
		if(charset != null) {
			request.setCharacterEncoding(charset);
			response.setContentType("text/html;charset=" + charset);
		}
		filter.doFilter(request, response);
		// TODO Auto-generated method stub
	}

	@Override
	public void init(FilterConfig filter) throws ServletException {
		String initParam = filter.getInitParameter("charset");
		if(initParam != null && initParam.trim().length() != 0) {
			charset = initParam;
		}else {
			logger.info("charsetÎª¿Õ");
		}
		// TODO Auto-generated method stub
		
	}

}
