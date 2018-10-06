package com.capgemini.customerapp.service.exceptions;

public class CustomerNotFoundException extends Exception {
	public CustomerNotFoundException(String message) {
		super(message);
	}
}
