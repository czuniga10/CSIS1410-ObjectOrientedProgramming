package teamProject;

public class Item {
	private String name;
	private double price;
	
	public Item(String name, double price) {
		this.name = name;
		this.price = price; // needs validation
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return String.format("%s : %f", name, price);
	}
}