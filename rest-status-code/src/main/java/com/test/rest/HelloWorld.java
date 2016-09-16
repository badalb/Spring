package com.test.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.bean.APIResponse;

@RestController
public class HelloWorld {

	@RequestMapping("/hi")
	public ResponseEntity<String> sayHello() {
		return new ResponseEntity<String>("Hi There!!!", HttpStatus.OK);
	}

	@RequestMapping("/hi/error")
	public ResponseEntity<String> exceptionTest() {
		try {
			throw new Exception("Testing error scenario!!!!");
		} catch (Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/hi/error_code")
	public ResponseEntity<APIResponse> exceptionTestWithBean() {
		try {
			throw new Exception("Testing error scenario!!!!");
		} catch (Exception ex) {
			APIResponse response = new APIResponse();
			response.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			response.setResponseMessage(ex.getMessage());
			return new ResponseEntity<APIResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/hi/error_bean_resp")
	public APIResponse apiResponseWithBean() {
		try {
			throw new Exception("Testing error scenario!!!!");
		} catch (Exception ex) {
			APIResponse response = new APIResponse();
			response.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			response.setResponseMessage(ex.getMessage());
			return response;
		}
	}
}
