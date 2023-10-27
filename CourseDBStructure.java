import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * This class implements the CourseDBStructureInterface and creates a
 * CourseDBStructure that can add CourseDBElements to a hashTable, get
 * CourseDBElements from a hashTable, and return an ArrayList of each element in
 * the hashTable
 * 
 */
public class CourseDBStructure implements CourseDBStructureInterface {

    public LinkedList<CourseDBElement>[] hashTable;

    /**
     * Constructor for CourseDBStructure
     * 
     * @param size - the size of the hash table
     */
    public CourseDBStructure(int size) {
        // Find the next prime number that is of the form 4k+3 and greater than or equal
        // to the given size.
        // 1.5 is the load factor
        int sizeWithLoadFactor = (int) (size / 1.5) + 1;
        // Create 4k+3 integer
        int currentNum = sizeWithLoadFactor + (3 - (sizeWithLoadFactor % 4));

        boolean prime = false;
        while (!prime) {
            // Check if prime
            prime = true;
            for (int i = 2; i <= currentNum / 2; i++) {
                if (currentNum % i == 0) {
                    prime = false;
                    break;
                }
            }
            if (!prime)
                currentNum += 4;
        }

        hashTable = new LinkedList[currentNum];
    }

    /**
     * Constructor for CourseDBStructure
     * 
     * @param testing
     * @param size
     */
    public CourseDBStructure(String testing, int size) {
        hashTable = new LinkedList[size];
    }

    /**
     * add adds a CourseDBElement to the hashTable
     * 
     * @param element - the element to add
     */
    @Override
    public void add(CourseDBElement element) {
        int index = getHashIndex(element);
        if (hashTable[index] == null) {
            hashTable[index] = new LinkedList<>();
            hashTable[index].add(element);
        } else {
            CourseDBElement current = hashTable[index].getFirst();
            while (current != null) {
                if (current.crn == element.crn) {
                    current.id = element.id;
                    current.credits = element.credits;
                    current.roomNum = element.roomNum;
                    current.instructor = element.instructor;
                    return;
                }
                current = current.next;
            }
            hashTable[index].add(element);
        }
    }

    /**
     * get returns a CourseDBElement with the given crn
     * 
     * @param crn - the crn of the element to get
     * @return the element with the given crn
     * @throws IOException if the element is not found
     */
    @Override
    public CourseDBElement get(int crn) throws IOException {
        CourseDBElement tempElement = new CourseDBElement();
        tempElement.setCRN(crn);
        int index = getHashIndex(tempElement);
        LinkedList<CourseDBElement> list = hashTable[index];

        if (list == null) {
            throw new IOException();
        }
        return list.stream().filter(c -> c.getCRN() == crn).findAny().orElseThrow(IOException::new);
    }

    /**
     * showAll returns an ArrayList of all the elements in the hashTable
     * 
     * @return an ArrayList of all the elements in the hashTable
     */
    @Override
    public ArrayList<String> showAll() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null) {
                for (CourseDBElement element : hashTable[i]) {
                    list.add(element.toString());
                }
            }
        }
        return list;
    }

    /**
     * getTableSize returns the size of the hashTable
     * 
     * @return the size of the hashTable
     */
    @Override
    public int getTableSize() {
        return hashTable.length;
    }

    /**
     * getHashIndex finds the index position in the array where the element is
     * The index
     * is computed using the element´s hashcode
     * 
     * @param element - the element to compute
     * @return the element index
     */
    private int getHashIndex(CourseDBElement element) {
        int hashIndex = element.hashCode() % hashTable.length;
        if (hashIndex < 0) {
            hashIndex += hashTable.length;
        }
        return hashIndex;
    }

}
