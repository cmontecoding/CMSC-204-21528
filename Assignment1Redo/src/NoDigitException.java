public class NoDigitException extends Exception {
	/**
	 * NoDigitException constructor throws an exception
	 */
	public NoDigitException() {
		super("The password must contain at least one digit");
	}

	/**
	 * NoDigitException throws a custom exception
	 * 
	 * @param message the exception message
	 */
	public NoDigitException(String message) {
		super(message);
	}
}
