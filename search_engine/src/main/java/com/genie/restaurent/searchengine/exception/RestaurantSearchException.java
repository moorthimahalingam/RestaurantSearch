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

	public RestaurantSearchException(Exception exception, String errMessge) {
		super(errMessge, exception);
	}

	public RestaurantSearchException(Throwable throwable, String errMessage) {
		super(errMessage, throwable);
	}

	private String errorCode;
	private String errorDesc;
	public RestaurantSearchException(Throwable throwable, String errorDtl, String errCode,
			String errDec) {
		super(errorDtl, throwable);
		this.errorCode = errCode;
		this.errorDesc = errDec;
	}
	
	public RestaurantSearchException(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorDesc = errorMessage;
	}
	
	public RestaurantSearchException(Exception exception, String errorDtl, String errCode,
			String errDec) {
		super(errorDtl, exception);
		this.errorCode = errCode;
		this.errorDesc = errDec;
	}

}
