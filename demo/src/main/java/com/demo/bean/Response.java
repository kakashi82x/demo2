/*
 * All right reserved
 */
package com.demo.bean;

import org.springframework.stereotype.Component;

/**
 * The Class Response.
 */
@Component("response")
public class Response {
	
	/** The codes. */
	private String codes;
	
	/** The description. */
	private String description;
	
	/**
	 * Gets the codes.
	 *
	 * @return the codes
	 */
	public String getCodes() {
		return codes;
	}
	
	/**
	 * Sets the codes.
	 *
	 * @param codes the new codes
	 */
	public void setCodes(String codes) {
		System.err.print("conflicto 2");
		this.codes = codes;
		System.err.print("conflicto 1");
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
