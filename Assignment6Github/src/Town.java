/**
 * The Town class represents a town in a graph
 * 
 * @author Andrew Chiaramonte
 * @date 11/19/2023
 */
public class Town implements Comparable<Town> {

    private String name;

    /**
     * Constructor
     * 
     * @param name The name of the town
     */
    public Town(String name) {
        this.name = name;
    }

    /**
     * Copy constructor
     * 
     * @param templateTown The town to copy
     */
    public Town(Town templateTown) {
        this.name = templateTown.getName();
    }

    /**
     * Compares two towns
     * 
     * @param o The town to compare to
     * @return 0 if equal, 1 if not equal
     */
    public int compareTo(Town o) {
        if (this == o) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * Gets the name of the town
     * 
     * @return The name of the town
     */
    public String getName() {
        return name;
    }

    /**
     * Checks if two town names are equal
     * 
     * @param obj The town
     * @return if the town names are equal
     */
    public boolean equals(Object obj) {
        if (obj instanceof Town) {
            Town t = (Town) obj;
            return name.equals(t.getName());
        }
        return false;
    }

    /**
     * Gets the hash code of the town name
     * 
     * @return The hash code of the town name
     */
    public int hashCode() {
        return name.hashCode();
    }

    /**
     * Gets the name of the town
     * 
     * @return The name of the town
     */
    public String toString() {
        return name;
    }

}
