import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

/**
 * This class implements the CourseDBManagerInterface and creates a
 * CourseDBManager
 * that can add CourseDBElements to a hashTable, get CourseDBElements from a
 * hashTable,
 * read a file and add each element to a hashTable, and return an ArrayList of
 * each element
 * in the hashTable
 * 
 */
public class CourseDBManager implements CourseDBManagerInterface {

    CourseDBStructure cds;

    /**
     * This constructor creates a CourseDBManager with a default size of 100
     */
    public CourseDBManager() {
        cds = new CourseDBStructure(100);
    }

    /**
     * This constructor creates a CourseDBManager with a given size
     * 
     * @param size
     */
    public CourseDBManager(int size) {
        cds = new CourseDBStructure(size);
    }

    /**
     * This method adds a CourseDBElement to the hashTable
     * 
     * @param id         the id of the CourseDBElement to be added
     * @param crn        the crn of the CourseDBElement to be added
     * @param credits    the credits of the CourseDBElement to be added
     * @param roomNum    the roomNum of the CourseDBElement to be added
     * @param instructor the instructor of the CourseDBElement to be added
     */
    @Override
    public void add(String id, int crn, int credits, String roomNum, String instructor) {
        CourseDBElement cde = new CourseDBElement(id, crn, credits, roomNum, instructor);
        cds.add(cde);
    }

    /**
     * This method returns a CourseDBElement with the given crn
     * 
     * @param crn the crn of the CourseDBElement to be returned
     * @return the CourseDBElement with the given crn
     */
    @Override
    public CourseDBElement get(int crn) {
        try {
            return cds.get(crn);
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * This method reads a file and adds each element to the hashTable
     * 
     * @param input the file to be read
     */
    @Override
    public void readFile(File input) throws FileNotFoundException {
        try {
            Scanner sc = new Scanner(input);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] tokens = line.split(" ");
                String id = tokens[0];
                int crn = Integer.parseInt(tokens[1]);
                int credits = Integer.parseInt(tokens[2]);
                String roomNum = tokens[3];
                String instructor = tokens[4];
                add(id, crn, credits, roomNum, instructor);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
    }

    /**
     * This method returns an ArrayList of each element in the hashTable
     * 
     * @return an ArrayList of each element in the hashTable
     */
    @Override
    public ArrayList<String> showAll() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < cds.hashTable.length; i++) {
            if (cds.hashTable[i] != null) {
                for (CourseDBElement element : cds.hashTable[i]) {
                    list.add(element.toString());
                }
            }
        }
        return list;
    }

}
