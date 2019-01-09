/*
 * All right reserved
 */
package com.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.demo.util.LogWrapper;
import com.demo.validator.IValidator;

// TODO: Auto-generated Javadoc
/**
 * The Class HeaderFilter.
 */
@Component ("RequestHeaderValidationFilter")
public class RequestHeaderValidationFilter implements Filter {
	
	/** The Constant LOG. */
	private static final LogWrapper LOG = new LogWrapper(Logger.getLogger(RequestHeaderValidationFilter.class));
	
	@Autowired
	private IValidator headerValidator;
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		final HttpServletRequest req = (HttpServletRequest) request;
		final HttpServletResponse resp = (HttpServletResponse) response;
		LOG.debugger(req.getContextPath());
		if(headerValidator.validate(req)) {
			chain.doFilter(request, response);
		} else {
			resp.sendRedirect(req.getContextPath() + "/error/unauthoraized");
		}
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
