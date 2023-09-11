public class NoUpperAlphaException extends Exception {
	/**
	 * NoUpperAlphaException constructor throws an exception
	 */
	public NoUpperAlphaException() {
		super("The password must contain at least one uppercase alphabetic character");
	}

	/**
	 * NoUpperAlphaException throws a custom exception
	 * 
	 * @param message the exception message
	 */
	public NoUpperAlphaException(String message) {
		super(message);
	}
}
