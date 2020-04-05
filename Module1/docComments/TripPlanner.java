package docComments;

/**
 * Trip planner class to store departure and arrival cities, distance, the instance 
 * of the car, and can calculate fuel consumption
 * 
 * @author Chad Z
 *
 */
public class TripPlanner {
	private String departure;
	private String arrival;
	private int distance;
	private Car car;
	
	/**
	 * @param departure		departure city
	 * @param arrival		arrival city
	 * @param distance		distance to travel
	 * @param car			instance of car being used
	 */
	public TripPlanner(String departure, String arrival, int distance, Car car) {
		this.departure = departure;
		this.arrival = arrival;
		this.distance = distance;
		this.car = car;
	}

	/**
	 * calculates fuel consumption based off distance and car mpg
	 * 
	 * @return fuelConsumption 	
	 */
	public double fuelConsumption() {
		return distance / (double)car.getMpg();
	}

	@Override
	public String toString() {
		return "TripPlanner [departure=" + departure + ", arrival=" + arrival + 
				", distance=" + distance + ", car=" + car.getModel() + "]";
	}
}
