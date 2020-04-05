package docComments;

public class TravelApp {

	public static void main(String[] args) {
		//Trip 1
		Car car1 = new Car("BMW", "M4", 25);
		TripPlanner trip1 = new TripPlanner("SF", "LA", 382, car1);
		
		//Trip 2
		Car car2 = new Car("Honda", "Civic", 42);
		TripPlanner trip2 = new TripPlanner("Tampa", "Miami", 280, car2);

		System.out.println("Cars:");
		displayCar(car1);
		displayCar(car2);
		System.out.println();
		
		System.out.println("California Trip:");
		displayTripInfo(trip1);
		System.out.println();
		
		System.out.println("Florida Trip:");
		displayTripInfo(trip2);
	}
	
	private static void displayCar(Car car) {
		System.out.printf("%s %s %d mpg %n", car.getMake(), car.getModel(), car.getMpg());
	}
	
	private static void displayTripInfo(TripPlanner trip) {
		System.out.println(trip.toString());
		System.out.printf("fuel consumption: %.1f gallons%n", trip.fuelConsumption());
	}
}
