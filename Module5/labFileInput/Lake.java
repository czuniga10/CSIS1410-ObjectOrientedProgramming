package labFileInput;

/**
 * A lake defined by its name, depth, and its support for boating.
 * 
 * @author Starter Code
 *
 */
public class Lake {
    private final String name;
    private final int depth;
    private final boolean hasMarina;

    /**
     * Initializes a newly created Lake with the information provided by the user.
     * 
     * @param name  name of the lake.
     * @param depth  depth of the lake in meters.
     * @param hasMarina  true if the lake has a marina.
     */
    public Lake(String name, int depth, boolean hasMarina)
    {
        this.name = name;
        this.depth = depth;
        this.hasMarina = hasMarina;
    }

    public String getName() {
        return name;
    }

    public int getDepth() {
        return depth;
    }

    public boolean hasMarina() {
        return hasMarina;
    }

    @Override
    public String toString() {
        return name + " (" + depth + ") " + (hasMarina ? "*" : "");
    }
}