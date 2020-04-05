package docComments;

/**
 * Car class that initializes the attributes of the car
 * 
 * @author Chad Z
 *
 */
public class Car {
	private String make;
	private String model;
	private int mpg;
	
	/**
	 * @param make 		String of the maker of the car
	 * @param model 	String of the model of the car
	 * @param mpg		integer that displays the miles per gallon
	 */
	public Car(String make, String model, int mpg) {
		this.make = make;
		this.model = model;
		this.mpg = mpg;
	}

	/**
	 * returns make of the car
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * returns model of the car
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * returns miles per gallon
	 * @return the mpg
	 */
	public int getMpg() {
		return mpg;
	}
}
