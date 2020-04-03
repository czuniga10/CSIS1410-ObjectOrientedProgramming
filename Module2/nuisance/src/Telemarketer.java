package nuisance;

/**
 * Class that instantiates a Person as a Telemarketer and gives the following 
 * functionality:
 * 		giveSalesPitch
 * 		annoy
 * 
 * @author Chad Z
 */
public class Telemarketer extends Person implements Nuisance{

	/**
	 * Creates instance of Telemarketer object with the following params.
	 * 
	 * @param name		Name of Telemarketer
	 * @param age		Age of Telemarketer
	 */
	public Telemarketer(String name, int age) {
		super(name, age);
	}
	
	/**
	 * Returns String of the name of the Telemarketer and how they are 
	 * pressuring others to buy stuff.
	 * 
	 * @return		Returns String
	 */
	public String giveSalesPitch() {
		return String.format("%s pressures others to buy stuff.", super.getName());
	}

	@Override
	public String annoy() {
		return String.format("%s annoys by giving a sales pitch.", super.getName());
	}

}
