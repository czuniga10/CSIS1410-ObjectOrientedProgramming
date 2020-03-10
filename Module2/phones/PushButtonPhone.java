package phones;

/**
 *  PushButtonPhone class that gives DeskPhone the functionality of a Push
 *  Button Phone
 * 
 * @author Chad Z
 */
public class PushButtonPhone extends DeskPhone {

	/**
	 * Initializes Push Button phone with the attributes it needs
	 * 
	 * @param model			Model of the Phone
	 * @param dimension		Dimensions of the Phone
	 * @param voltage		Voltage of the Phone
	 */
	public PushButtonPhone(String model, Dimension dimension, Voltage voltage) {
		super(model, dimension, voltage);
	}

	@Override
	public String call(long number) {
		return String.format("Pushing buttons to call %d", number);
	}

}
