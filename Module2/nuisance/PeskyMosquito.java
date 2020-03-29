/**
 * 
 */
package nuisance;

/**
 * Class that instantiates an Insect as a PeskyMosquito and gives the following 
 * functionality:
 * 		bite
 * 
 * @author Chad Z
 */
public class PeskyMosquito extends Mosquito {

	/**
	 * Creates instance of PeskyMosquito object with the following params.
	 * 
	 * @param species		Species of PeskyMosquito
	 */
	public PeskyMosquito(String species) {
		super(species);
	}

	/**
	 * Returns String saying the PeskyMosquito is sucking blood.
	 * 
	 * @return String
	 */
	public String bite() {
		return "sucking blood";
	}
}
