package src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * BasicDoubleLinkedList class that implements java's Iterable interface
 * 
 * @param <T> generic type
 */
public class BasicDoubleLinkedList<T> implements java.lang.Iterable<T> {

    protected Node head;
    protected Node tail;
    protected int size;

    /**
     * Constructor to set to initialize head, tail and size to null, null and 0
     */
    public BasicDoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Returns the number of nodes in the list.
     * 
     * @return the size of the linked list
     */
    public int getSize() {
        // Notice: Do not traverse the list to compute the size. This method just
        // returns the value of the instance variable you use to keep track of size.
        return size;
    }

    /**
     * Adds an element to the end of the list and updated the size of the list
     * 
     * @param data data to be added to the list
     */
    public void addToEnd(T data) {
        // DO NOT use iterators to implement this method.
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size += 1;
    }

    /**
     * Adds element to the front of the list and updated the size of the list
     * 
     * @param data data to be added to the list
     */
    public void addToFront(T data) {
        // Do not use iterators to implement this method.
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size += 1;
    }

    /**
     * Returns but does not remove the first element from the list.
     * If there are no elements the method returns null.
     * 
     * @return the data element or null
     */
    public T getFirst() {
        // Do not implement this method using iterators.
        if (size == 0) {
            return null;
        } else {
            return head.data;
        }
    }

    /**
     * Returns but does not remove the last element from the list.
     * If there are no elements the method returns null.
     * 
     * @return the data element or null
     */
    public T getLast() {
        // Do not implement this method using iterators.
        if (size == 0) {
            return null;
        } else {
            return tail.data;
        }
    }

    /**
     * This method returns an object of the DoubleLinkedListIterator. (the inner
     * class that implements java's ListIterator interface)
     * 
     * @return a ListIterator object
     */
    public java.util.ListIterator<T> iterator() {
        return new DoubleLinkedListIterator();
    }

    /**
     * Removes the first instance of the targetData from the list. Notice that you
     * must remove the
     * elements by performing a single traversal over the list. You may not use any
     * of the other
     * retrieval methods associated with the class in order to complete the removal
     * process.
     * You must use the provided comparator (do not use equals) to find those
     * elements that match
     * the target.
     * 
     * @param targetData data element to be removed
     * @param comparator comparator to determine equality of data elements
     * @return a node containing the targetData or null
     */
    public BasicDoubleLinkedList<T>.Node remove(T targetData, java.util.Comparator<T> comparator) {
        // Do not implement this method using iterators.
        Node current = head;
        while (current != null) {
            if (comparator.compare(current.data, targetData) == 0) {
                if (current == head) {
                    head = head.next;
                } else if (current == tail) {
                    tail = tail.prev;
                } else {
                    current.prev.next = current.next;
                }
                size -= 1;
                return current;
            }
            current = current.next;
        }
        return current;
    }

    /**
     * Removes and returns the first element from the list. If there are no elements
     * the method
     * returns null.
     * 
     * @return data element or null
     */
    public T retrieveFirstElement() {
        // Do not implement this method using iterators.
        if (size == 0) {
            return null;
        }
        T data = head.data;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size -= 1;
        return data;
    }

    /**
     * Removes and returns the last element from the list. If there are no elements
     * the method returns null.
     * 
     * @return
     */
    public T retrieveLastElement() {
        // Do not implement this method using iterators.
        if (size == 0) {
            return null;
        } else {
            T data = tail.data;
            tail = tail.prev;
            tail.next = null;
            size -= 1;
            return data;
        }
    }

    /**
     * Returns an arraylist of all the items in the Double Linked list
     * 
     * @return an arraylist of the items in the list
     */
    public java.util.ArrayList<T> toArrayList() {
        ArrayList<T> list = new ArrayList<T>();
        Node current = head;
        while (current != null) {
            list.add(current.data);
            current = current.next;
        }
        return list;
    }

    /**
     * Node class that implements java's Iterable interface
     */
    public class Node {
        protected T data;
        protected Node next;
        protected Node prev;

        /**
         * Constructor to create a Node
         * 
         * @param data data to be stored in the node
         */
        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    /**
     * DoubleLinkedListIterator class that implements java's ListIterator interface
     */
    public class DoubleLinkedListIterator implements java.util.ListIterator<T> {

        protected Node current = head;
        protected Node last;

        /**
         * Constructor to initialize the current pointer to the head of the
         * BasicDoubleLinkedList
         */
        public DoubleLinkedListIterator() {
            // The other attributes defined for this class can be initialized as well.
        }

        /**
         * This method returns an object of the DoubleLinkedListIterator. (the inner
         * class that implements java's ListIterator interface)
         * 
         * @return a ListIterator object
         */
        public java.util.ListIterator<T> iterator() {
            return null;
        }

        /**
         * Returns true if the iteration has more elements.
         * 
         * @return true if the iteration has more elements
         */
        public boolean hasNext() {
            // Returns true if the iteration has more elements.
            return current != null;
        }

        /**
         * Returns the next element in the iteration.
         * 
         * @return the next element in the iteration
         * @throws java.util.NoSuchElementException if the iteration has no more
         *                                          elements
         */
        public T next() throws java.util.NoSuchElementException {
            // Returns the next element in the iteration.
            if (current == null) {
                throw new NoSuchElementException();
            } else {
                last = current;
                current = current.next;
                return last.data;
            }
        }

        /**
         * Returns true if this list iterator has more elements when traversing the list
         * in the reverse direction.
         * 
         * @return true if this list iterator has more elements when traversing the list
         *         in the reverse direction
         */
        public boolean hasPrevious() {
            // Returns true if this list iterator has more elements when traversing the list
            // in the reverse direction.
            return last != null;
        }

        /**
         * Returns the previous element in the list and moves the cursor position
         * backwards.
         * 
         * @return the previous element in the list
         * @throws java.util.NoSuchElementException if the iteration has no more
         *                                          elements
         */
        public T previous() throws java.util.NoSuchElementException {
            // Returns the previous element in the list and moves the cursor position
            // backwards.
            if (last == null) {
                throw new NoSuchElementException();
            } else {
                current = last;
                last = last.prev;
                return current.data;
            }
        }

        /**
         * remove elements
         * 
         * @throws java.lang.UnsupportedOperationException
         */
        public void remove() throws java.lang.UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        /**
         * add elements
         * 
         * @param arg0
         * @throws java.lang.UnsupportedOperationException
         */
        public void add(T arg0) throws java.lang.UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        /**
         * Returns the index of the element that would be returned by a subsequent call
         * to next().
         * 
         * @return the index of the element that would be returned by a subsequent call
         *         to next
         */
        public int nextIndex() throws java.lang.UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        /**
         * Returns the index of the element that would be returned by a subsequent call
         * to previous().
         * 
         * @return the index of the element that would be returned by a subsequent call
         *         to previous
         */
        public int previousIndex() throws java.lang.UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        /**
         * Replaces the last element returned by next() or previous() with the specified
         * element.
         * 
         * @param arg0
         * @throws java.lang.UnsupportedOperationException
         */
        public void set(T arg0) throws java.lang.UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

    }

}