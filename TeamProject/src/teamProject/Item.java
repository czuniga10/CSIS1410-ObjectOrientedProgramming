package teamProject;

/**
 * Item Class is used to store lists of static menu items, as well as
 * the items in the users cart using ArrayLists. This class also provides
 * the following functionality:
 *         -getName()
 *         -getPrice()
 *         -getDescription()
 *         -toString()
 * 
 * @author Thomas Olvera and Chad Zuniga
 */
public class Item {
    private String name;
    private double price;
    private String description;
    
    public Item(String name, double price, String description) {
        this.name = name;
        if (price < 1) {
            throw new IllegalArgumentException("Variable price can not be less than 0...");
        }
        this.price = price;
        this.description = description;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("%s : %.2f", name, price);
    }
}