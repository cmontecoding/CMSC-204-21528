public class QueueOverflowException extends Exception {
    
    public QueueOverflowException() {
        super("Queue Overflow");
    }
    
    public QueueOverflowException(String message) {
        super(message);
    }
        
}
