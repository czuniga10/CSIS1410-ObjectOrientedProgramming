package labInterface;

/**
 * Flyable interface that creates a contract with a given class and provides 
 * 2 methods:
 * 		launch
 * 		land
 * 
 * @author Chad Z
 */
public interface Flyable {
	
	/**
	 * Outputs a console log of the instantiated object launching
	 */
	void launch();
	
	/**
	 * Outputs a console log of the instantiated object landing
	 */
	void land();
}
