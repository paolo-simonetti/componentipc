package it.solvingteam.componentipcrestspringmvc.exception;

public class ElementNotFoundException extends Exception {
	 
	private static final long serialVersionUID = 4853199797999860523L;

	public ElementNotFoundException() {}

	public ElementNotFoundException(String message) {
		super(message);
	}

	public ElementNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ElementNotFoundException(Throwable cause) {
		super(cause);
	}

	public ElementNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
