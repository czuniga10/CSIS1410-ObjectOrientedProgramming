package abstractClass;

/**
 * Printer class that initializes a Printer as an Laser printer and
 * gives print functionality
 * 
 * @author Chad Z
 *
 */
public class LaserPrinter extends Printer {
	private int remainingToner;

	/**
	 * Initializes instance of a Laser Printer
	 * 
	 * @param model			Printer Model
	 * @param serialNumber	Printer Serial number
	 */
	public LaserPrinter(String model) {
		super(model);
		remainingToner = 100;
	}

	@Override
	public void print() {
		if(remainingToner < 10) {
			System.out.println("The toner is empty.");
		} else {
			remainingToner -= 10;
			System.out.printf("%s is printing. Remaining toner: %d%%", 
					getModel(), getRemainingToner());
		}
	}

	/**
	 * Returns the remaining toner for the Printer
	 * 
	 * @return the remainingToner
	 */
	public int getRemainingToner() {
		return remainingToner;
	}
	
	/**
	 * Refills Printers toner to 100%
	 */
	public void refillToner() {
		remainingToner = 100;
	}

}
