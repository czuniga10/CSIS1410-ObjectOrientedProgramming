package teamProject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		
		return subTotal;
	}
	
	public double calculateTotal(List<Item> list) {
		return 0.0; // TODO
	}
	
	public List<Item> getItemList() {
		return itemList;
	}
}
