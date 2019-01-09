/*
 * All right reserved
 */
package com.demo.validator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

/**
 * The Class HeaderValidatorImpl.
 *
 * @author rodri
 */
@Component("headerValidator")
public class HeaderValidatorImpl implements IValidator {

	/* (non-Javadoc)
	 * @see com.demo.validator.IValidator#validate(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public boolean validate(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return false;
	}

}
