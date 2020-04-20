package teamProject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Creates a BillingSystem object that takes in the name of a text file to be
 * read from. The text file should be a list of menu items, with each item
 * separated with a line break. Each menu item has 2 attributes, a name
 * and a price. They should both be included on the same line and separated by
 * a comma. The attributes are then read in and used to create a new menu object,
 * which is then added to a list of menu objects. 
 * 
 * @author Tomas Olvera and Chad Zuniga
 */
public class BillingSystem {
	private List<Item> itemList;
	private double totalPrice;
	private double subTotal;
	private double gratuity;
	
	public BillingSystem(String readFile) {
		itemList = new ArrayList<>();
		
		try {
			FileReader reader = new FileReader(readFile);
			BufferedReader buffer = new BufferedReader(reader);
			String line = buffer.readLine();
			
			while (line != null) {
				String[] c = line.split(",");
				itemList.add(new Item(c[0], Double.parseDouble(c[1])));
				line = buffer.readLine();
			}
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public double calculateSubtotal() {
		for (Item el : itemList) {
			subTotal += el.getPrice();
		}
		
		totalPrice = subTotal;
		return subTotal;
	}
	
	public List<Item> getItemList() {
		return itemList;
	}
	
	/**
	 * Calculates the Total Price by adding the current Items subtotal with gratuity
	 */
	public void calculateTotal() {
		this.totalPrice = this.gratuity + this.subTotal;
	}
	
	/**
	 * @param gratuity the gratuity to set
	 */
	public void setGratuity(double gratuity) {
		this.gratuity = subTotal * gratuity;
		calculateTotal();
	}

	/**
	 * @return the gratuity
	 */
	public double getGratuity() {
		return gratuity;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getSubtotal() {
		return subTotal;
	}

	/**
	 * @return the totalPrice
	 */
	public double getTotalPrice() {
		return totalPrice;
	}
}
