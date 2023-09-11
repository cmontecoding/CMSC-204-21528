public class NoSpecialCharacterException extends Exception {
	/**
	 * NoSpecialCharacterException constructor throws an exception
	 */
	public NoSpecialCharacterException() {
		super("The password must contain at least one special character");
	}

	/**
	 * NoSpecialCharacterException throws a custom exception
	 * 
	 * @param message the exception message
	 */
	public NoSpecialCharacterException(String message) {
		super(message);
	}
}
