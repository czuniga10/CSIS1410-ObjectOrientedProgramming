package nuisance;

/**
 * Class that instantiates an Insect with the following functionality:
 * 		getSpecies
 * 		toString
 * 
 * @author Chad Z
 */
public class Insect {
	private String species;

	/**
	 * Creates instance of Insect object with the following params.
	 * 
	 * @param species		Species of Insect
	 */
	public Insect(String species) {
		this.species = species;
	}

	/**
	 * Returns the species of the Insec
	 * 
	 * @return the species
	 */
	public String getSpecies() {
		return species;
	}

	@Override
	public String toString() {
		return super.getClass().getSimpleName() + ": " + species;
	}
}
