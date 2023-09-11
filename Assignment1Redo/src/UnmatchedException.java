public class UnmatchedException extends Exception {
	/**
	 * UnmatchedException constructor throws an exception
	 */
	public UnmatchedException() {
		super("The passwords do not match");
	}

	/**
	 * UnmatchedException throws a custom exception
	 * 
	 * @param message the exception message
	 */
	public UnmatchedException(String message) {
		super(message);
	}
}
