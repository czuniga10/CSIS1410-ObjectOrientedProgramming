package abstractClass;

/**
 * Printer class that initializes a Printer as an Inkjet printer and
 * gives print functionality
 * 
 * @author Chad Z
 *
 */
public class InkjetPrinter extends Printer {
	private int remainingCartridge;

	/**
	 * Initializes instance of an Injet Printer 
	 * 
	 * @param model				Printers model
	 * @param serialNumber		Printers serial number
	 */
	public InkjetPrinter(String model) {
		super(model);
		remainingCartridge = 100;
	}

	@Override
	public void print() {
		if(remainingCartridge < 10) {
			System.out.println("The toner is empty.");
		} else {
			remainingCartridge -= 10;
			System.out.printf("%s is printing. Remaining cartridge: %d%%", 
					getModel(), getRemainingCartridge());
		}
	}

	/**
	 * Returns Printers remaining cartridge
	 * 
	 * @return the remainingCartridge
	 */
	public int getRemainingCartridge() {
		return remainingCartridge;
	}
	
	/**
	 * Refills Printer cartridge to 100%
	 */
	public void refillCartridge() {
		remainingCartridge = 100;
	}
	

}
