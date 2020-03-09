package labInterface;

/**
 * Hangglider class that gives object functionality of a hangglider
 * 
 * @author CSIS + Chad Z
 */
public class Hangglider implements Flyable{
	private final boolean isRigidWing ;

	/**
	 * Instantiates Hangglider object with the given param
	 * 
	 * @param rigidWing		Bool of if plane has a rigid wing, or not
	 */
	public Hangglider(boolean rigidWing)
	{
		isRigidWing = rigidWing;
	}

	@Override
	public String toString()
	{
		return String.format(isRigidWing ? "Rigid-wing" : "Flex-wing");
	}

	@Override
	public void launch() {
		System.out.println("Running until take-off");
		
	}

	@Override
	public void land() {
		System.out.println("Gliding to a land");
		
	}
}
