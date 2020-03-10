package phones;
import java.util.Random;

/**
 * Smartphone class that gives a Phone object smartphone capabilities
 * 
 * @author Chad Z
 */
public class SmartPhone extends Phone {
	private int storage;

	/**
	 * Initializes instance of a SmartPhone phone with the added param
	 * of storage
	 * 
	 * @param model
	 * @param dimension
	 */
	public SmartPhone(String model, Dimension dimension, int storage) {
		super(model, dimension);
		if(storage <= 0) {
			throw new IllegalArgumentException("Storage needs to be assigned a positive value.");
		} else {
			this.storage = storage;
		}
		
	}

	@Override
	public String call(long number) {
		return String.format("Calling %d by selecting the number", number);
	}
	
	/**
	 * Returns the String "Browsing the web"
	 * 
	 * @return	returns a String
	 */
	public String browse() {
		return "Browsing the web";
	}
	
	/**
	 * Returns a random String of either "Taking a horizontal picture" or
	 * "taking a vertical picture"
	 * 
	 * @return 	Random String direction phone is taking a picture
	 */
	public String takePicture() {
		Random rand = new Random();
		return String.format("Taking a %s picture",(rand.nextDouble() < 0.5 
				? "vertical" : "horizontal"));
	}

	@Override
	public String toString() {
		return super.toString() + " " + storage + "GB";
	}
	
	

}
