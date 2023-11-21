
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TownGraphManager_STUDENT_Test {

    private TownGraphManager townGraphManager;

    @Before
	public void setUp() throws Exception {
        townGraphManager = new TownGraphManager();
	}

	@After
	public void tearDown() throws Exception {
        townGraphManager = null;
	}

    /**
     * Testing for correct implementation of addRoad
     */
    @Test
    public void testAddRoad() {
        try {
            assertTrue(townGraphManager.addRoad("Town1", "Town2", 2, "Road1"));
        } catch (Exception e) {
            fail("addRoad threw an exception");
        }
    }

    /**
     * Testing for correct implementation of getRoad
     */
    @Test
    public void testGetRoad() {
        try {
            townGraphManager.addRoad("Town1", "Town2", 2, "Road1");
            assertEquals("Road1", townGraphManager.getRoad("Town1", "Town2"));
        } catch (Exception e) {
            fail("getRoad threw an exception");
        }
    }

    /**
     * Testing for correct implementation of addTown
     */
    @Test
    public void testAddTown() {
        try {
            assertTrue(townGraphManager.addTown("Town1"));
        } catch (Exception e) {
            fail("addTown threw an exception");
        }
        try {
            assertFalse(townGraphManager.addTown("Town1"));
        } catch (Exception e) {
            fail("addTown threw an exception");
        }
    }

    /**
     * Testing for correct implementation of getTown
     */
    @Test
    public void testGetTown() {
        try {
            townGraphManager.addTown("Town1");
            assertEquals("Town1", townGraphManager.getTown("Town1").getName());
        } catch (Exception e) {
            fail("getTown threw an exception");
        }
    }

    /**
     * Testing for correct implementation of containsTown
     */
    @Test
    public void testContainsTown() {
        try {
            townGraphManager.addTown("Town1");
            assertTrue(townGraphManager.containsTown("Town1"));
        } catch (Exception e) {
            fail("containsTown threw an exception");
        }
    }

    /**
     * Testing for correct implementation of containsRoadConnection
     */
    @Test
    public void testContainsRoadConnection() {
        try {
            townGraphManager.addTown("Town1");
            townGraphManager.addTown("Town2");
            townGraphManager.addRoad("Town1", "Town2", 2, "Road1");
            assertTrue(townGraphManager.containsRoadConnection("Town1", "Town2"));
        } catch (Exception e) {
            fail("containsRoadConnection threw an exception");
        }
    }

    /**
     * Testing for correct implementation of deleteRoadConnection
     */
    @Test
    public void testDeleteRoadConnection() {
        try {
            townGraphManager.addTown("Town1");
            townGraphManager.addTown("Town2");
            townGraphManager.addRoad("Town1", "Town2", 2, "Road1");
            assertTrue(townGraphManager.deleteRoadConnection("Town1", "Town2", "Road1"));
        } catch (Exception e) {
            fail("deleteRoadConnection threw an exception");
        }
    }

    /**
     * Testing for correct implementation of deleteTown
     */
    @Test
    public void testDeleteTown() {
        try {
            townGraphManager.addTown("Town1");
            assertTrue(townGraphManager.deleteTown("Town1"));
        } catch (Exception e) {
            fail("deleteTown threw an exception");
        }
    }

    /**
     * Testing for correct implementation of allTowns
     */
    @Test
    public void testAllTowns() {
        try {
            townGraphManager.addTown("Town1");
            townGraphManager.addTown("Town2");
            townGraphManager.addTown("Town3");
            townGraphManager.addTown("Town4");
            townGraphManager.addTown("Town5");
            townGraphManager.addTown("Town6");
            townGraphManager.addTown("Town7");
            townGraphManager.addTown("Town8");
            townGraphManager.addTown("Town9");
            townGraphManager.addTown("Town10");
            assertEquals(10, townGraphManager.allTowns().size());
        } catch (Exception e) {
            fail("allTowns threw an exception");
        }
    }

    /**
     * Testing for correct implementation of allRoads
     */
    @Test
    public void testAllRoads() {
        try {
            townGraphManager.addTown("Town1");
            townGraphManager.addTown("Town2");
            townGraphManager.addTown("Town3");
            townGraphManager.addTown("Town4");
            townGraphManager.addTown("Town5");
            townGraphManager.addTown("Town6");
            townGraphManager.addTown("Town7");
            townGraphManager.addTown("Town8");
            townGraphManager.addTown("Town9");
            townGraphManager.addTown("Town10");
            townGraphManager.addRoad("Town1", "Town2", 2, "Road1");
            townGraphManager.addRoad("Town1", "Town3", 2, "Road2");
            townGraphManager.addRoad("Town1", "Town4", 2, "Road3");
            townGraphManager.addRoad("Town1", "Town5", 2, "Road4");
            townGraphManager.addRoad("Town1", "Town6", 2, "Road5");
            townGraphManager.addRoad("Town1", "Town7", 2, "Road6");
            townGraphManager.addRoad("Town1", "Town8", 2, "Road7");
            townGraphManager.addRoad("Town1", "Town9", 2, "Road8");
            townGraphManager.addRoad("Town1", "Town10", 2, "Road9");
            assertEquals(9, townGraphManager.allRoads().size());
        } catch (Exception e) {
            fail("allRoads threw an exception");
        }
    }

    /**
     * Testing for correct implementation of getPath
     */
    @Test
    public void testGetPath() {
        try {
            townGraphManager.addTown("Town1");
            townGraphManager.addTown("Town2");
            townGraphManager.addTown("Town3");
            townGraphManager.addTown("Town4");
            townGraphManager.addTown("Town5");
            townGraphManager.addTown("Town6");
            townGraphManager.addTown("Town7");
            townGraphManager.addTown("Town8");
            townGraphManager.addTown("Town9");
            townGraphManager.addTown("Town10");
            townGraphManager.addRoad("Town1", "Town2", 2, "Road1");
            townGraphManager.addRoad("Town1", "Town3", 2, "Road2");
            townGraphManager.addRoad("Town1", "Town4", 2, "Road3");
            townGraphManager.addRoad("Town1", "Town5", 2, "Road4");
            townGraphManager.addRoad("Town1", "Town6", 2, "Road5");
            townGraphManager.addRoad("Town1", "Town7", 2, "Road6");
            townGraphManager.addRoad("Town1", "Town8", 2, "Road7");
            townGraphManager.addRoad("Town1", "Town9", 2, "Road8");
            townGraphManager.addRoad("Town1", "Town10", 2, "Road9");
            assertEquals("Town1 via Road9 to Town10 2 mi", townGraphManager.getPath("Town1", "Town10").get(0).trim());
        } catch (Exception e) {
            fail("getPath threw an exception");
        }
    }

}
