package labInterface;

import java.util.ArrayList;

/**
 * Test Client for lab Interface
 * 
 * @author Chad Z
 */
public class App
{
	public static void main(String[] args)
	{
		//part1
		Plane myPlane = new Plane(4, "Boing 747");
		System.out.printf("myPlane: %s%n", myPlane);

		Hangglider myHangglider = new Hangglider(true);
		System.out.printf("myHangglider: %s%n", myHangglider);

		Bird myBird = new Bird("Swallow");
		System.out.printf("myBird: %s%n", myBird);
		System.out.println();
		
		//part2
		ArrayList<Flyable> flyingThings = new ArrayList<Flyable>();
		flyingThings.add(myPlane);
		flyingThings.add(myHangglider);
		flyingThings.add(myBird);
		
		for(Flyable el:flyingThings) {
			System.out.println(el.toString());
			el.launch();
			el.land();
			System.out.println();
		}
	}
}
