/*
 * All right reserved
 */
package com.demo.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class Log4jInit.
 */
public class Log4jInit extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2579404518496580978L;

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init()
	 */
	@SuppressWarnings("unused")
	public void init() {
		final String envType = null;
		if(envType == null) {
			System.setProperty("log.prioridad", "error");
		} else {
			System.setProperty("log.prioridad", "debug");
		}
		
	}
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		
	}
}
