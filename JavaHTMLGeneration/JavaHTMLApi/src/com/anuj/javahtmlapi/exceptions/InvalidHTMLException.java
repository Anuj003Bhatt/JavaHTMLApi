package com.anuj.javahtmlapi.exceptions;

public class InvalidHTMLException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidHTMLException() {
		super("Attempt to generate invalid HTML");
	}

	public InvalidHTMLException(String message) {
		super("Attempt to generate invalid HTML: " + message);
	}
	
}
