package nuisance;

import java.util.*;

/**
 * Class that instantiates an Insect as a Butterfly and gives the following 
 * functionality:
 * 		getColors
 * 		toString
 * 
 * @author Chad Z
 */
public final class Butterfly extends Insect {
	private final List<String> colors;

	/**
	 * Creates instance of Butterfly object with the following params.
	 * 
	 * @param species		Species of Butterfly
	 */
	public Butterfly(String species, List<String> colors) {
		super(species);
		List<String> temp = new ArrayList<String>(colors);
		this.colors = temp;
	}

	/**
	 * Creates instance of Butterfly object with an existing Butterfly object.
	 * 
	 * @param butterfly		Butterfly object
	 */
	public Butterfly(Butterfly butterfly) {
		this(butterfly.getSpecies(), new ArrayList<String>(butterfly.getColors()));
		
	}

	/**
	 * Returns a copy of the Butterfly's List<> of Colors
	 * 
	 * @return the colors
	 */
	public List<String> getColors() {
		List<String> temp = new ArrayList<String>(colors);
		return temp;
	}

	@Override
	public String toString() {
		return getSpecies() + " " + colors;
	}
	
	
}
