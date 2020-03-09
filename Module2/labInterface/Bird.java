package labInterface;

/**
 * Bird class that gives object functionality of a Bird
 * 
 * @author CSIS + Chad Z
 */
public class Bird implements Flyable
{
	private final String type;

	/**
	 * Instantiates Bird object with the given param
	 * 
	 * @param t		Type of bird
	 */
	public Bird(String t)
	{
		type = t;
	}

	@Override
	public String toString()
	{
		return type;
	}

	@Override
	public void launch() {
		System.out.println("Flapping the wings to take off");
		
	}

	@Override
	public void land() {
		System.out.println("Flapping the wings until landing");
	}
}
