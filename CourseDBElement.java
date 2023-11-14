
/**
 * CourseDBElement implements Comparable interface and consists of five
 * attributes: the Course ID (a String),
 * the CRN (an int), the number of credits (an int), the room number (a String),
 * and the instructor name (a String).
 * Normally the CourseDBElement will be an object consisting of these five
 * attributes and is referred to as a CDE.
 */
public class CourseDBElement implements Comparable {

    public String id;
    public int crn;
    public int credits;
    public String roomNum;
    public String instructor;
    public CourseDBElement next;

    /**
     * Constructor for CourseDBElement
     * 
     * @param id
     * @param crn
     * @param credits
     * @param roomNum
     * @param instructor
     */
    public CourseDBElement(String id, int crn, int credits, String roomNum, String instructor) {
        this.id = id;
        this.crn = crn;
        this.credits = credits;
        this.roomNum = roomNum;
        this.instructor = instructor;
    }

    /**
     * Constructor for CourseDBElement
     */
    public CourseDBElement() {
        this.id = "";
        this.crn = 0;
        this.credits = 0;
        this.roomNum = "";
        this.instructor = "";
    }

    /**
     * This method turns it to a string
     * 
     * @return the string
     */
    @Override
    public String toString() {
        return "\nCourse:" + id + " CRN:" + crn + " Credits:" + credits + " Instructor:" + instructor + " Room:"
                + roomNum;
    }

    /**
     * This method returns the hashcode of the CourseDBElement
     * 
     * @return the hashcode
     */
    public int hashCode() {
        return String.valueOf(crn).hashCode();
    }

    /**
     * This method returns the Course ID
     * 
     * @return the Course ID
     */
    public String getID() {
        return id;
    }

    /**
     * This method returns the CRN
     * 
     * @return the CRN
     */
    public int getCRN() {
        return crn;
    }

    /**
     * This method sets the CRN
     * 
     * @param crn
     */
    public void setCRN(int crn) {
        this.crn = crn;
    }

    /**
     * This method returns the number of credits
     * 
     * @return the number of credits
     */
    public int getCredits() {
        return credits;
    }

    /**
     * This method returns the room number
     * 
     * @return the room number
     */
    public String getRoomNum() {
        return roomNum;
    }

    /**
     * This method returns the instructor name
     * 
     * @return the instructor name
     */
    public String getInstructor() {
        return instructor;
    }

    /**
     * This method returns the next CourseDBElement
     * 
     * @return the next CourseDBElement
     */
    public CourseDBElement getNext() {
        return next;
    }

    /**
     * This method sets the next CourseDBElement
     * 
     * @param element
     */
    public void setNext(CourseDBElement element) {
        next = element;
    }

    /**
     * This method compares two CourseDBElements
     * 
     * @param o
     * @return the comparison
     */
    @Override
    public int compareTo(Object o) {
        CourseDBElement cde = (CourseDBElement) o;
        return (this.crn - cde.crn);
    }

    /**
     * This method checks if two CourseDBElements are equal
     * 
     * @param o
     * @return the comparison
     */
    @Override
    public boolean equals(Object o) {
        CourseDBElement cde = (CourseDBElement) o;
        return (this.crn == cde.crn);
    }

}
