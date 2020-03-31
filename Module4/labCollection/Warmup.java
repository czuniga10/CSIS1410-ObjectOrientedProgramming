package labCollection;

import java.util.ArrayList;

/**
 * In this class, we will create a list of numbers to review the method forEach
 * and lambda expressions. We also introduce the method removeIf and the Interface 
 * Predicate<T>.
 * 
 * @author Chad Z
 *
 */
public class Warmup {
	
	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<>();
		addNumbers(numbers);
		printNumbers(numbers);
		
		System.out.println("Removing multiples of three . . .");
		
		numbers.removeIf(x -> x % 3 == 0);
		printNumbers(numbers);
	}
	
	private static void addNumbers(ArrayList<Integer> numbers) {
		for(int i = 2; i <= 50; i+=2) {
			numbers.add(i);
		}
	}
	
	private static void printNumbers(ArrayList<Integer> numbers) {
		System.out.print("numbers: ");
		for(Integer el:numbers) {
			System.out.print(el+" ");
		}
		System.out.println();
	}

}
