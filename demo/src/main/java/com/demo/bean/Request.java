/*
 * All right reserved
 */
package com.demo.bean;

import org.springframework.stereotype.Component;

/**
 * The Class Request.
 * prueba de cambios
 */
@Component("request")
public class Request {
	
	/** The code. */
	private String code;
	
	/** The description. */
	private String description;
	
	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
}
