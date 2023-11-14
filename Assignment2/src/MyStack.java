import java.util.ArrayList;

public class MyStack<T> implements StackInterface<T> {
    
    private T[] stack;
    private int top;
    
    public MyStack() {
        this(10);
    }
    
    public MyStack(int size) {
        stack = (T[]) new Object[size];
        top = -1;
    }
    
    public boolean push(T item) throws StackOverflowException {
        if (isFull()) {
            throw new StackOverflowException();
        }
        stack[++top] = item;
        return true; 
    }
    
    public T pop() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException();
        }
        return stack[top--];
    }

    public T top() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException();
        }
        return stack[top];
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public boolean isFull() {
        return top == stack.length - 1;
    }
    
    public int size() {
        return top + 1;
    }
    
    public String toString() {
        String result = "";
        for (int i = 0; i <= top; i++) {
            result += stack[i];
        }
        return result;
    }

    public String toString(String delimiter) {
        String result = "";
        for (int i = 0; i <= top; i++) {
            result += stack[i] + delimiter;
        }
        return result.substring(0, result.length() - delimiter.length());
    }

    // public void fill(ArrayList<T> list) throws StackOverflowException {
    //     for (T item : list) {
    //         if (isFull()) {
    //             throw new StackOverflowException();
    //         }
    //         push(item);
    //     }
    // }

}
