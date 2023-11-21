
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Road_STUDENT_Test {

    private Road road;

    @Before
	public void setUp() throws Exception {
        road = new Road(new Town("Town1"), new Town("Town2"), 2, "Road1");
	}

	@After
	public void tearDown() throws Exception {
        road = null;
	}

    /**
     * Testing for correct implementation of compareTo
     */
    @Test
    public void testCompareTo() {
        try {
            assertEquals(0, road.compareTo(road));
        } catch (Exception e) {
            fail("compareTo threw an exception");
        }
        try {
            assertEquals(1, road.compareTo(null));
        } catch (Exception e) {
            fail("compareTo threw an exception");
        }
    }

    /**
     * Testing for correct implementation of contains
     */
    @Test
    public void testContains() {
        try {
            assertTrue(road.contains(new Town("Town1")));
        } catch (Exception e) {
            fail("contains threw an exception");
        }
        try {
            assertTrue(road.contains(new Town("Town2")));
        } catch (Exception e) {
            fail("contains threw an exception");
        }
        try {
            assertFalse(road.contains(new Town("Town3")));
        } catch (Exception e) {
            fail("contains threw an exception");
        }
    }

    /**
     * Testing for correct implementation of getDestination
     */
    @Test
    public void testGetDestination() {
        try {
            assertEquals(new Town("Town2"), road.getDestination());
        } catch (Exception e) {
            fail("getDestination threw an exception");
        }
    }

    /**
     * Testing for correct implementation of getName
     */
    @Test
    public void testGetName() {
        try {
            assertEquals("Road1", road.getName());
        } catch (Exception e) {
            fail("getName threw an exception");
        }
    }

    /**
     * Testing for correct implementation of getSource
     */
    @Test
    public void testGetSource() {
        try {
            assertEquals(new Town("Town1"), road.getSource());
        } catch (Exception e) {
            fail("getSource threw an exception");
        }
    }

    /**
     * Testing for correct implementation of getWeight
     */
    @Test
    public void testGetWeight() {
        try {
            assertEquals(2, road.getWeight());
        } catch (Exception e) {
            fail("getWeight threw an exception");
        }
    }

    /**
     * Testing for correct implementation of equals
     */
    @Test
    public void testEquals() {
        try {
            assertTrue(road.equals(new Road(new Town("Town1"), new Town("Town2"), 2, "Road1")));
        } catch (Exception e) {
            fail("equals threw an exception");
        }
        try {
            assertTrue(road.equals(new Road(new Town("Town2"), new Town("Town1"), 2, "Road1")));
        } catch (Exception e) {
            fail("equals threw an exception");
        }
        try {
            assertFalse(road.equals(new Road(new Town("Town1"), new Town("Town3"), 2, "Road1")));
        } catch (Exception e) {
            fail("equals threw an exception");
        }
        try {
            assertFalse(road.equals(new Road(new Town("Town3"), new Town("Town1"), 2, "Road1")));
        } catch (Exception e) {
            fail("equals threw an exception");
        }
        try {
            assertFalse(road.equals(new Town("Town1")));
        } catch (Exception e) {
            fail("equals threw an exception");
        }
        try {
            assertFalse(road.equals(null));
        } catch (Exception e) {
            fail("equals threw an exception");
        }
    }

    /**
     * Testing for correct implementation of toString
     */
    @Test
    public void testToString() {
        try {
            assertEquals("Town1 via Road1 to Town2 2 mi", road.toString());
        } catch (Exception e) {
            fail("toString threw an exception");
        }
    }

}
