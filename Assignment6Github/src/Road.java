/**
 * Road class that represents edges in a graph of towns
 */
public class Road
        implements Comparable<Road> {

    private Town source;
    private Town destination;
    private int degrees;
    private String name;

    /**
     * Constructor
     * 
     * @param source      The source town
     * @param destination The destination town
     * @param degrees     The degrees between the towns
     * @param name        The name of the road
     */
    public Road(Town source, Town destination, int degrees, String name) {
        this.source = source;
        this.destination = destination;
        this.degrees = degrees;
        this.name = name;
    }

    /**
     * Constructor with weight preset at 1
     * 
     * @param source      The source town
     * @param destination The destination town
     * @param name        The name of the road
     */
    public Road(Town source, Town destination, String name) {
        this.source = source;
        this.destination = destination;
        this.degrees = 1;
        this.name = name;
    }

    /**
     * Compares two roads
     * 
     * @param o The road to compare to
     * @return 0 if equal, 1 if not equal
     */
    public int compareTo(Road o) {
        if (this == o) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * returns true if edge contains given town
     * 
     * @param town
     * @return true if edge contains given town
     */
    public boolean contains(Town town) {
        return source.equals(town) || destination.equals(town);
    }

    /**
     * Checks if two roads are equal. Direction does not matter
     * 
     * @param obj The road to compare to
     * @return if the roads are equal
     */
    public boolean equals(Object obj) {
        if (obj instanceof Road) {
            Road r = (Road) obj;
            return (source.equals(r.getSource()) && destination.equals(r.getDestination()))
                    || (source.equals(r.getDestination()) && destination.equals(r.getSource()));
        }
        return false;
    }

    /**
     * Gets the destination town
     * 
     * @return The destination town
     */
    public Town getDestination() {
        return destination;
    }

    /**
     * Gets the road name
     * 
     * @return The road name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the source town
     * 
     * @return The source town
     */
    public Town getSource() {
        return source;
    }

    /**
     * Gets the weight of the road
     * 
     * @return The weight of the road
     */
    public int getWeight() {
        return degrees;
    }

    // /**
    //  * toString method
    //  */
    // public String toString() {
    //     return name;
    // }

    /**
   * To string method. Output: "Town_2 via Road_12 to Town_11 6 mi"
   * 
   * @return all varibles
   */
  @Override
  public String toString() {
    return source.getName() + " via " + name + " to " + destination.getName() + " " + degrees
        + " mi";
  }

}
