package abstractClass;

/**
 * Printer represents an Object that prints. Can either be an inkjet or 
 * laser printer
 * 
 * @author Chad Z
 */
public abstract class Printer {
	private String model;
	private static int count;
	private int serialNumber;
	
	/**
	 * Initializes Printer with a Model and Serial Number
	 * 
	 * @param model			Model of the Printer
	 * @param serialNumber	Serial number of the Printer
	 */
	public Printer(String model) {
		this.model = model;
		count++;
		serialNumber = 12345 + count;
	}
	
	/**
	 * Returns the Model of the Printer
	 * 
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	
	/**
	 * Returns the Serial Number of the Printer
	 * 
	 * @return the serialNumber
	 */
	public int getSerialNumber() {
		return serialNumber;
	}
	
	/**
	 * Returns a message saying the Printer is printing and 
	 * decrements the printer toner/cartridge volume 10%
	 */
	public abstract void print();

	@Override
	public String toString() {
		return this.getClass().getSimpleName() +": " + model + " #"+ serialNumber;
	}
	
	
}
