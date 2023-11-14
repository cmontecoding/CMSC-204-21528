package src;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BasicDoubleLinkedListTest_STUDENT {
    BasicDoubleLinkedList<String> linkedString;
    BasicDoubleLinkedList<Double> linkedDouble;

    @Before
    public void setUp() throws Exception {
        linkedString = new BasicDoubleLinkedList<String>();
        linkedDouble = new BasicDoubleLinkedList<Double>();
    }

    @After
    public void tearDown() throws Exception {
        linkedString = null;
        linkedDouble = null;
    }

    @Test
    public void testGetFirstAddMultiple() {
        linkedString.addToFront("Hello");
        linkedString.addToFront("Bye");
        linkedDouble.addToFront(1.0);
        linkedDouble.addToFront(2.0);
        assertEquals("Bye", linkedString.getFirst());
        assertEquals(2.0, linkedDouble.getFirst(), 2.0);
    }

    @Test
    public void testGetLastAddMultiple() {
        linkedString.addToEnd("Hello");
        linkedString.addToEnd("Bye");
        linkedDouble.addToEnd(1.0);
        linkedDouble.addToEnd(2.0);
        assertEquals("Bye", linkedString.getLast());
        assertEquals(2.0, linkedDouble.getLast(), 2.0);
    }

    @Test
    public void testToArrayList() {
        linkedString.addToEnd("Hello");
        linkedString.addToEnd("Bye");
        linkedDouble.addToEnd(1.0);
        linkedDouble.addToEnd(2.0);
        ArrayList<String> stringList = linkedString.toArrayList();
        ArrayList<Double> doubleList = linkedDouble.toArrayList();
        assertEquals("Hello", stringList.get(0));
        assertEquals("Bye", stringList.get(1));
        assertEquals(1.0, doubleList.get(0), 1.0);
        assertEquals(2.0, doubleList.get(1), 2.0);
    }

    @Test
    public void testIteratorSuccessfulNext() {
        linkedString.addToEnd("Hello");
        linkedString.addToEnd("Bye");
        linkedDouble.addToEnd(1.0);
        linkedDouble.addToEnd(2.0);
        ListIterator<String> stringIterator = linkedString.iterator();
        ListIterator<Double> doubleIterator = linkedDouble.iterator();
        assertEquals(true, stringIterator.hasNext());
        assertEquals(true, doubleIterator.hasNext());
        assertEquals("Hello", stringIterator.next());
        assertEquals(1.0, doubleIterator.next(), 1.0);
        assertEquals("Bye", stringIterator.next());
        assertEquals(2.0, doubleIterator.next(), 2.0);
    }

    @Test
    public void testIteratorSuccessfulPrevious() {
        linkedString.addToEnd("Hello");
        linkedString.addToEnd("Bye");
        linkedDouble.addToEnd(1.0);
        linkedDouble.addToEnd(2.0);
        ListIterator<String> stringIterator = linkedString.iterator();
        ListIterator<Double> doubleIterator = linkedDouble.iterator();
        assertEquals(true, stringIterator.hasNext());
        assertEquals(true, doubleIterator.hasNext());
        assertEquals("Hello", stringIterator.next());
        assertEquals(1.0, doubleIterator.next(), 1.0);
        assertEquals("Bye", stringIterator.next());
        assertEquals(2.0, doubleIterator.next(), 2.0);
        assertEquals(true, stringIterator.hasPrevious());
        assertEquals(true, doubleIterator.hasPrevious());
        assertEquals("Bye", stringIterator.previous());
        assertEquals(2.0, doubleIterator.previous(), 2.0);
        assertEquals("Hello", stringIterator.previous());
        assertEquals(1.0, doubleIterator.previous(), 1.0);
    }

}
