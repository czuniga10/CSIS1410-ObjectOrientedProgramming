package phones;

/**
 * Phone class that gives subclass Phones the initial functionality of a Phone
 * 
 * @author Chad Z
 */
public abstract class Phone {
	private String model;
	private Dimension dimension;
	
	/**
	 * Initializes Phone with the given attributes
	 * 
	 * @param model			Model of the Phone
	 * @param dimension		Dimensions of the Phone
	 */	
	public Phone(String model, Dimension dimension) {
		this.model = model;
		this.dimension = dimension;
	}
	
	/**
	 * Gives call functionality to the Phone based on the Phones subclass
	 * 
	 * @param number	Phone number parameter
	 * @return			returns String of the Phone calling the given number
	 */
	public abstract String call(long number);

	@Override
	public String toString() {
		return model + " " + dimension;
	}
}
