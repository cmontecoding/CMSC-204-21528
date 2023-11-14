public class WeakPasswordException extends Exception {
	/**
	 * WeakPasswordException constructor throws an exception
	 */
	public WeakPasswordException() {
		super("The password is OK but weak - it contains fewer than 10 characters");
	}

	/**
	 * WeakPasswordException throws a custom exception
	 * 
	 * @param message the exception message
	 */
	public WeakPasswordException(String message) {
		super(message);
	}
}
