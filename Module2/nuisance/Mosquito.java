package nuisance;

/**
 * Class that instantiates an Insect as a Mosquito and gives the following 
 * functionality:
 * 		buzz
 * 		annoy
 * 
 * @author Chad Z
 */
public class Mosquito extends Insect implements Nuisance {

	/**
	 * Creates instance of Mosquito object with the following params.
	 * 
	 * @param species		Species of Mosquito
	 */
	public Mosquito(String species) {
		super(species);
	}
	
	/**
	 * Returns the species of the Mosquito and states that it is buzzing 
	 * around.
	 * 
	 * @return
	 */
	public String buzz() {
		return String.format("%s buzzing around.", super.getSpecies());
	}

	@Override
	public String annoy() {
		return "buzz buzz buzz";
		
	}

}
