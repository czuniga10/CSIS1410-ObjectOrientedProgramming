/**
 * 
 */
package abstractClass;

/**
 * Printer Test Client 
 * 
 * @author Chad Z
 *
 */
public class PrinterApp {

	public static void main(String[] args) {
		Printer[] arr = {new InkjetPrinter("Canon TS202"), 
				new LaserPrinter("Samsung Xpress")};
	
		for(Printer el:arr) {
			System.out.println(el);
			for(int i = 1; i <= 11; i++) {
				el.print();
				System.out.println();
			}
		}
		
		for(Printer el:arr) {
			if(el instanceof LaserPrinter) {
				((LaserPrinter) el).refillToner();
			} else {
				((InkjetPrinter) el).refillCartridge();
			}
			System.out.printf("Remaining %s after refilling: %d%%%n", 
					(el instanceof LaserPrinter) ? "toner" : "cartridge", 
					(el instanceof LaserPrinter) ? ((LaserPrinter) el)
					.getRemainingToner() : ((InkjetPrinter) el)
					.getRemainingCartridge());
		}	
	}
}
