public class InvalidSequenceException extends Exception {
	/**
     * InvalidSequenceException constructor throws an exception
     */
    public InvalidSequenceException() {
        super("The password cannot contain more than two of the same character in sequence");
    }
    /**
     * InvalidSequenceException throws a custom exception
     * @param message the exception message
     */    
    public InvalidSequenceException(String message) {
        super(message);
    }
}
