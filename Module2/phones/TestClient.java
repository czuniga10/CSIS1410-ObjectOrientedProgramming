package phones;

import java.util.Random;
/**
 * Test Client for the InheritancePolymorphism Assignment
 * 
 * @author Chad Z
 */
public class TestClient {

	public static void main(String[] args) {
		RotaryPhone rotaryPhone = new RotaryPhone("Model 500", 
				new Dimension(143, 208, 119), Voltage.V110);
		PushButtonPhone pushButtonPhone = new PushButtonPhone("Cortelco 2500", 
				new Dimension(178, 228, 127), Voltage.DUAL);
		SmartPhone smartPhone1 = new SmartPhone("Pixel3", 
				new Dimension(145.6, 68.2, 7.9), 128);
		SmartPhone smartPhone2 = new SmartPhone("iPhone8", 
				new Dimension(138.4, 67.3, 7.3), 64);
		
		Phone[] phoneArr = {rotaryPhone, pushButtonPhone, smartPhone1, 
				smartPhone2};
		
		System.out.println("Various Phones: ");
		printPhones(phoneArr);
		System.out.println();
		
		rotaryPhone.plugIn();
		pushButtonPhone.plugIn();
		unplugRandomDeskPhone(rotaryPhone, pushButtonPhone);
		
		System.out.println("Array Elements: ");
		printPhonesWithMetaData(phoneArr);

	}
	
	private static void printPhones(Phone[] arr) {
		for(Phone el:arr) {
			System.out.println(el);
		}
	}
	
	private static void printPhonesWithMetaData(Phone[] arr) {
		for(Phone el:arr) {
			System.out.println(el);
			System.out.println(el.call(8019574111L));
			if(el instanceof SmartPhone) {
				System.out.println(((SmartPhone) el).browse());
				System.out.println(((SmartPhone) el).takePicture());
			}
			System.out.println();
		}
	}
	
	private static void unplugRandomDeskPhone(DeskPhone phone1, DeskPhone phone2) {
		Random rand = new Random();
		if(rand.nextDouble() < 0.5) {
			phone1.unplug();
		} else {
			phone2.unplug();
		}
	}

}
