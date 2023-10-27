import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseDBManagerTest_STUDENT {
    private CourseDBManagerInterface courseManager = new CourseDBManager();

    @Before
    public void setUp() throws Exception {
        courseManager = new CourseDBManager();
    }

    @After
    public void tearDown() throws Exception {
        courseManager = null;
    }

    @Test
    public void testAddToDB() {
        try {
            courseManager.add("CMSC203", 30504, 4, "SC450", "Joey Bag-O-Donuts");
            assertEquals(1, courseManager.showAll().size());
        } catch (Exception e) {
            fail("This should not have caused an Exception");
        }
    }

    @Test
    public void testRead() {
        try {
            File input = new File("Test1.txt");
            PrintWriter inFile = new PrintWriter(input);
            inFile.println("CMSC203 30504 4 SC450 Joey Bag-O-Donuts");
            inFile.close();

            assertEquals(0, courseManager.showAll().size());
            courseManager.readFile(input);
            assertEquals(1, courseManager.showAll().size());
        } catch (Exception e) {
            fail("Should not have thrown an exception");
        }
    }

    @Test
    public void testShowAll() {
        courseManager.add("CMSC224", 31504, 4, "SC445", "Joe");
        courseManager.add("CMSC204", 30503, 4, "SC450", "Matty");
        courseManager.add("CMSC207", 30559, 4, "SC453", "Edward");
        ArrayList<String> list = courseManager.showAll();

        assertEquals(list.get(2),
                "\nCourse:CMSC204 CRN:30503 Credits:4 Instructor:Matty Room:SC450");
        assertEquals(list.get(0),
                "\nCourse:CMSC207 CRN:30559 Credits:4 Instructor:Edward Room:SC453");
        assertEquals(list.get(1),
                "\nCourse:CMSC224 CRN:31504 Credits:4 Instructor:Joe Room:SC445");
    }

    @Test
    public void testGet() {
        courseManager.add("CMSC224", 31504, 4, "SC445", "Joe");
        courseManager.add("CMSC204", 30503, 4, "SC450", "Matty");
        courseManager.add("CMSC207", 30559, 4, "SC453", "Edward");

        try {
            assertEquals("CMSC224", courseManager.get(31504).getID());
            assertEquals("CMSC204", courseManager.get(30503).getID());
            assertEquals("SC453", courseManager.get(30559).getRoomNum());
        } catch (Exception e) {
            fail("Should not have thrown an exception");
        }
    }

}