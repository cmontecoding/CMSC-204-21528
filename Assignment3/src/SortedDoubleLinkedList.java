
import java.util.Comparator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {

    private Comparator<T> comparator;

    /**
     * Creates an empty list that is associated with the specified comparator.
     * 
     * @param compareableObject Comparator to compare data elements
     */
    SortedDoubleLinkedList(java.util.Comparator<T> compareableObject) {
        this.comparator = compareableObject;
    }

    /**
     * Inserts the specified element at the correct position in the sorted list.
     * Notice we can insert the same element several times.
     * Your implementation must traverse the list only once in order to perform the
     * insertion.
     * 
     * @param data the data to be added to the list
     */
    public void add(T data) {
        // Do not implement this method using iterators. Notice that you don't need to
        // call any of the super class methods in order to implement this method.
        Node newNode = new Node(data);
        Node current = head;
        Node previous = null;
        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
        } else if (comparator.compare(head.data, data) >= 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
        } else if (comparator.compare(tail.data, data) <= 0) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size++;
        } else {
            while (current != null && comparator.compare(current.data, data) < 0) {
                previous = current;
                current = current.next;
            }
            previous.next = newNode;
            newNode.prev = previous;
            newNode.next = current;
            current.prev = newNode;
            size++;
        }
    }

    /**
     * This operation is invalid for a sorted list. An UnsupportedOperationException
     * will be generated using the message "Invalid operation for sorted list."
     * 
     * @param data data to be added to the list
     * @throws java.lang.UnsupportedOperationException if method is called
     */
    @Override
    public void addToEnd(T data) throws java.lang.UnsupportedOperationException {
        throw new java.lang.UnsupportedOperationException("Invalid operation for sorted list");
    }

    /**
     * This operation is invalid for a sorted list. An UnsupportedOperationException
     * will be generated using the message "Invalid operation for sorted list."
     * 
     * @param data data to be added to the list
     * @throws java.lang.UnsupportedOperationException if method is called
     */
    @Override
    public void addToFront(T data) throws java.lang.UnsupportedOperationException {
        throw new java.lang.UnsupportedOperationException("Invalid operation for sorted list");
    }

    /**
     * Implements the iterator by calling the super class iterator method.
     * 
     * @return an iterator positioned at the head of the list
     */
    @Override
    public java.util.ListIterator<T> iterator() {
        return super.iterator();
    }

    /**
     * Implements the remove operation by calling the super class remove method.
     * 
     * @param data       the data element to be removed
     * @param comparator the comparator to determine equality of data elements
     * @return data element or null
     */
    @Override
    public BasicDoubleLinkedList<T>.Node remove(T data, java.util.Comparator<T> comparator) {
        return super.remove(data, comparator);
    }

}
