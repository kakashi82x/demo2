/*
 * All right reserved
 */
package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.bean.Response;

// TODO: Auto-generated Javadoc
/**
 * The Class WelcomeController.
 */
@Controller
public class HandledErrorController {
	
	@Autowired
	private Response response;
	
	/**
	 * Welcome.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping( value = "/unauthoraized")
	public ResponseEntity<Response> unauthorized (){
		this.response.setCode("1");
		this.response.setDescription(HttpStatus.UNAUTHORIZED.getReasonPhrase());
		return new ResponseEntity<Response>(this.response, HttpStatus.UNAUTHORIZED);
	}
}
