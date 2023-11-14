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

public class SortedDoubleLinkedListTest_STUDENT {
    SortedDoubleLinkedList<String> sortedLinkedString;
    SortedDoubleLinkedList<Double> sortedLinkedDouble;
    StringComparator comparator;
    DoubleComparator comparatorD;

    @Before
    public void setUp() throws Exception {
        comparator = new StringComparator();
        sortedLinkedString = new SortedDoubleLinkedList<String>(comparator);
        comparatorD = new DoubleComparator();
        sortedLinkedDouble = new SortedDoubleLinkedList<Double>(comparatorD);
    }

    @After
    public void tearDown() throws Exception {
        sortedLinkedString = null;
        sortedLinkedDouble = null;
    }

    @Test
    public void testAdd() {
        sortedLinkedString.add("Hello");
        sortedLinkedString.add("Bye");
        sortedLinkedDouble.add(1.0);
        sortedLinkedDouble.add(2.0);
        assertEquals("Bye", sortedLinkedString.getFirst());
        assertEquals(2.0, sortedLinkedDouble.getFirst(), 2.0);
    }

    @Test
    public void testIteratorSuccessfulStringNext() {
        sortedLinkedString.add("Hello");
        sortedLinkedString.add("Bye");
        sortedLinkedString.add("Zoo");
        sortedLinkedString.add("Apple");
        sortedLinkedString.add("Cat");
        Iterator<String> iterator = sortedLinkedString.iterator();
        assertEquals(true, iterator.hasNext());
        assertEquals("Apple", iterator.next());
        assertEquals("Bye", iterator.next());
        assertEquals("Cat", iterator.next());
        assertEquals("Hello", iterator.next());
        assertEquals("Zoo", iterator.next());
        assertEquals(false, iterator.hasNext());
    }

    @Test
    public void testAddMixed() {
        sortedLinkedString.add("Hello");
        sortedLinkedString.add("Bye");
        sortedLinkedString.add("Zoo");
        sortedLinkedString.add("Apple");
        sortedLinkedString.add("Cat");
        sortedLinkedDouble.add(1.0);
        sortedLinkedDouble.add(2.0);
        sortedLinkedDouble.add(3.0);
        sortedLinkedDouble.add(4.0);
        sortedLinkedDouble.add(5.0);
        assertEquals("Apple", sortedLinkedString.getFirst());
        assertEquals(1.0, sortedLinkedDouble.getFirst(), 1.0);
    }

    @Test
    public void testRemoveEnd() {
        sortedLinkedString.add("Hello");
        sortedLinkedString.add("Bye");
        sortedLinkedString.add("Zoo");
        sortedLinkedString.add("Apple");
        sortedLinkedString.add("Cat");
        sortedLinkedString.remove("Zoo", comparator);
        assertEquals("Hello", sortedLinkedString.getLast());
    }

    private class StringComparator implements Comparator<String> {

        @Override
        public int compare(String arg0, String arg1) {
            // TODO Auto-generated method stub
            return arg0.compareTo(arg1);
        }

    }

    private class DoubleComparator implements Comparator<Double> {

        @Override
        public int compare(Double arg0, Double arg1) {
            // TODO Auto-generated method stub
            return arg0.compareTo(arg1);
        }

    }

}
