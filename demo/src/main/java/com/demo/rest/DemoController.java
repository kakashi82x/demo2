/*
 * All right reserved
 */
package com.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bean.Response;

/**
 * The Class DemoController.
 */
@RestController
@RequestMapping("/api")
public class DemoController {

	/**
	 * Gets the request.
	 *
	 * @param input the input
	 * @return the request
	 */
	@RequestMapping( value = "/test")
	public ResponseEntity<Response> getRequest(final @RequestParam String input) {
		return new ResponseEntity<Response>(new Response(), HttpStatus.OK);
	}
	
}
