package it.solvingteam.componentipcrestspringmvc.exception;

public class NonExistentElementException extends Exception {

	private static final long serialVersionUID = 212358229831465390L;

	public NonExistentElementException() {}

	public NonExistentElementException(String message) {
		super(message);
	}

	public NonExistentElementException(String message, Throwable cause) {
		super(message, cause);
	}

	public NonExistentElementException(Throwable cause) {
		super(cause);
	}

	public NonExistentElementException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
}
