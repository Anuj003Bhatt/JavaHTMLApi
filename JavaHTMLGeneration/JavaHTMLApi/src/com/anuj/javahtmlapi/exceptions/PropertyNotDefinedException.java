package com.anuj.javahtmlapi.exceptions;

public class PropertyNotDefinedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PropertyNotDefinedException() {
		super();
	}
	
	public PropertyNotDefinedException(String element, String property) {
		super("Property " + property + " for element " + element + " is not defined");
	}

	public PropertyNotDefinedException(String message) {
		super(message);
	}
	
}
