public class NoLowerAlphaException extends Exception {
	/**
     * NoLowerAlphaException constructor throws an exception
     */
    public NoLowerAlphaException() {
        super("The password must contain at least one lowercase alphabetic character");
    }
    /**
     * NoLowerAlphaException throws a custom exception
     * @param message the exception message
     */ 
    public NoLowerAlphaException(String message) {
        super(message);
    }
}
