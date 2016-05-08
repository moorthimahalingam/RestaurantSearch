package com.genie.restaurent.searchengine.exception;

public class RestaurantSearchException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1172050602124187951L;

	public RestaurantSearchException() {
		super();
	}
	
	public RestaurantSearchException(String message) {
		super(message);
	}
	
	public RestaurantSearchException(Exception exception) {
		super(exception);
	}
	
	public RestaurantSearchException(Throwable throwable) {
		super(throwable);
	}
	
	public RestaurantSearchException(Exception exception, String methodName) {
		super(exception);
	}
	
	public RestaurantSearchException(Throwable throwable, String methodName) {
		super(throwable);
	}
	
}

