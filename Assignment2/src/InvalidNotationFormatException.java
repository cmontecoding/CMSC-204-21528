public class InvalidNotationFormatException extends Exception {
    
    public InvalidNotationFormatException() {
        super("Invalid Notation Format");
    }
    
    public InvalidNotationFormatException(String message) {
        super(message);
    }

}
