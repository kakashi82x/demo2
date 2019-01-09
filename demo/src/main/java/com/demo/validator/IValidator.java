/*
 * All right reserved
 */
package com.demo.validator;

import javax.servlet.http.HttpServletRequest;

// TODO: Auto-generated Javadoc
/**
 * The Interface IValidator.
 */
public interface IValidator {
	
	/**
	 * Validate.
	 *
	 * @param request the request
	 * @return true, if successful
	 */
	boolean validate (final HttpServletRequest request);
}
