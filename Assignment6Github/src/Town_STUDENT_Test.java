
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Town_STUDENT_Test {

    private Town town;

    @Before
	public void setUp() throws Exception {
        town = new Town("Town1");
	}

	@After
	public void tearDown() throws Exception {
        town = null;
	}

    /**
     * Test the constructor
     */
    @Test
    public void testTownString() {
        assertEquals("Town1", town.getName());
    }
    
    /**
     * Test the copy constructor
     */
    @Test
    public void testTownTown() {
        Town t = new Town(town);
        assertEquals("Town1", t.getName());
    }

    /**
     * Test the compareTo method
     */
    @Test
    public void testCompareTo() {
        Town t = new Town("Town2");
        assertEquals(1, town.compareTo(t));
        assertEquals(0, town.compareTo(town));
    }

    /**
     * Test the getName method
     */
    @Test
    public void testGetName() {
        assertEquals("Town1", town.getName());
    }

    /**
     * Test the equals method
     */
    @Test
    public void testEqualsObject() {
        Town t = new Town("Town1");
        assertTrue(town.equals(t));
        assertFalse(town.equals(new File("Town1")));
    }

    /**
     * Test the toString method
     */
    @Test
    public void testToString() {
        assertEquals("Town1", town.toString());
    }

    /**
     * Test the hashCode method
     */
    @Test
    public void testHashCode() {
        assertEquals("Town1".hashCode(), town.hashCode());
    }

}
