public class StackUnderflowException extends Exception {
    
    public StackUnderflowException() {
        super("Stack Underflow");
    }
    
    public StackUnderflowException(String message) {
        super(message);
    }

}
