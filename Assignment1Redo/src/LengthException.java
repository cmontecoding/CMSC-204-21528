public class LengthException extends Exception {

	/**
	 * LengthException constructor throws an exception
	 */
	public LengthException() {
		super("The password must be at least 6 characters long");
	}

	/**
	 * LengthException throws a custom exception
	 * 
	 * @param message the exception message
	 */
	public LengthException(String message) {
		super(message);
	}

}
