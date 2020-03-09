package labInterface;

/**
 * Plan class that gives object functionality of a Plane
 * 
 * @author Chad Z
 */
public class Plane implements Flyable
{
	private final int numberOfEngines;
	private final String model;

	/**
	 * Instantiates Plane object with the given params
	 * 
	 * @param engines		amount of engines in the plane
	 * @param m				model of the plane
	 */
	public Plane(int engines, String m)
	{
		numberOfEngines = engines;
		model = m;
	}

	@Override
	public String toString()
	{
		return String.format("%s with %d engines", model, numberOfEngines);
	}

	@Override
	public void launch() {
		System.out.println("Rolling until take-off");
		
	}

	@Override
	public void land() {
		System.out.println("Rolling to a stop");
		
	}
	
	/**
	 * Returns the number of Engines on the Plane
	 * 
	 * @return the numberOfEngines
	 */
	public int getNumberOfEngines() {
		return numberOfEngines;
	}

	/**
	 * Returns the Model of the Plane
	 * 
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
}
