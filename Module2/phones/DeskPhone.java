package phones;

/**
 * DeskPhone class that gives subclass DeskPhones the initial functionality of a 
 * DeskPhone
 * 
 * @author Chad Z
 *
 */
public abstract class DeskPhone extends Phone {
	private boolean connected;
	private Voltage voltage;

	/**
	 * Initializes DeskPhone with the given attributes
	 * 
	 * @param model			Model of the Phone
	 * @param dimension		Dimensions of the Phone
	 */
	public DeskPhone(String model, Dimension dimension, Voltage voltage) {
		super(model, dimension);
		this.voltage = voltage;
	}
	
	/**
	 * Plugs in connection if connection is false
	 */
	public void plugIn() {
		if(connected) {
			System.out.println("Already plugged in...");
		} else {
			connected = !connected;
		}
	}
	
	/**
	 * Unplugs connection if connection is true
	 */
	public void unplug() {
		if(!connected) {
			System.out.println("Already unplugged...");
		} else {
			connected = !connected;
		}
	}

	/**
	 * Returns the connection status
	 * 
	 * @return the connected
	 */
	public boolean isConnected() {
		return connected;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s",super.toString(),voltage,(connected) 
				? "connected" : "not connected");
	}
	
	

}
