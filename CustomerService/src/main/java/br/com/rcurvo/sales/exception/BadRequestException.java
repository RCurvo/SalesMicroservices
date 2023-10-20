package br.com.rcurvo.sales.exception;

public class BadRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1142913528650169257L;
	
	public BadRequestException(String message) {
		super(message);
	}

}
