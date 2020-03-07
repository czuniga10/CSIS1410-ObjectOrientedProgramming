package polymorphism;

/**
 * Instantiates cutter as Prunning Shears
 * 
 * @author czuniga10
 *
 */
public class PruningShears extends Cutter {
	
	/**
	 * Initializes cutter as Pruning Shears
	 * 
	 * @param size		
	 */
	public PruningShears(int size) {
		super(size);
	}

	/**
	 * Returns String "prunning" to indicate the Prune Shears are cutting
	 * 
	 * @return 		String "prunning" 
	 */
	@Override
	public String cut() {
		return "prunning";
	}
	
	

}
