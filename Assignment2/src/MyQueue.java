import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface<T> {

    private T[] queue;
    private int front;
    private int back;
    private int size;

    public MyQueue() {
        this(10);
    }

    public MyQueue(int size) {
        queue = (T[]) new Object[size];
        front = 0;
        back = 0;
    }

    public boolean enqueue(T item) throws QueueOverflowException {
        if (isFull()) {
            throw new QueueOverflowException();
        }
        queue[back] = item;
        if (back == size - 1) {

        } else {
            back++;
        }
        size++;
        return true;
    }

    public T dequeue() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }
        T temp = queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;
        size--;
        return temp;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    public int size() {
        return size;
    }

    public String toString() {
        if (isEmpty()) {
            return "";
        }

        String result = "";

        for (int i = front; i < back; i++) {
            result += queue[i];
        }

        return result;
    }

    public String toString(String delimiter) {
        if (isEmpty()) {
            return "";
        }

        String result = queue[front].toString();

        for (int i = front + 1; i < back; i++) {
            result += delimiter + queue[i];
        }

        return result;
    }

    public void fill(ArrayList<T> list) {
        for (int i = 0; i < list.size(); i++) {
            try {
                enqueue(list.get(i));
            } catch (QueueOverflowException e) {
                e.printStackTrace();
            }
        }
    }

}