package phones;

/**
 * RotaryPhone class that gives DeskPhone the functionality of a Rotary Phone
 * 
 * @author Chad Z
 */
public class RotaryPhone extends DeskPhone {

	/**
	 * Initializes Rotary phone with the attributes it needs
	 * 
	 * @param model			Model of the phone
	 * @param dimension		Dimensions of the phone
	 * @param voltage		Voltage of the phone
	 */		
	public RotaryPhone(String model, Dimension dimension, Voltage voltage) {
		super(model, dimension, voltage);
	}

	@Override
	public String call(long number) {
		return String.format("Rotating the dial to call %d", number);
	}

}
