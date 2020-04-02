package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class assignment with 3 static methods (lettersAndNumbers, modify, 
 * removeEveryNthElement) to work on skills with Generic Collections.
 * 
 * @author Chad Z
 */
public class GenericCollections {

	/**
	 * This method creates a new list based on the following rules:
	 * -Characters that are neither letters nor numbers are ignored.
	 * -The new list includes a string representation of each character that is
	 * either a letter or a number in reverse order.
	 * -Each lowercase letter is represented as  L({letter})
	 * -Each uppercase letter is represented as U({letter})
	 * -Each number is represented as N({number})
	 * -An empty list should return an empty string.
	 * -If the argument passed to the method is null, the method should return null.
	 * 
	 * @param list	List of Characters.
	 * @return		Returns List of Strings.
	 */
	public static List<String> lettersAndNumbers(List<Character> list) {
		List<String> result = new ArrayList<>();
		if(list == null) {
			return null;
		}
		list.forEach(el -> {
			if(Character.isDigit(el)) {
				result.add(String.format("N(%s)", el.toString()));
			}
			else if(Character.isUpperCase(el)) {
				result.add(String.format("U(%c)", Character.toLowerCase(el)));
			}
			else if(Character.isLowerCase(el)) {
				result.add(String.format("L(%s)", el.toString()));
			}
		});
		return result;
	}
	
	/**
	 * This method changes the list by applying a number of changes based on the following rules:
	 * -If the list is null, a NullPointerException should be thrown. 
  	 * -Delete all multiples of 3.  
	 * -Add the first 5 multiples of 4, 5, and 6.
	 * -Sort the list in ascending order.
	 * 
	 * @param list	List of Integers.
	 * @return		Return the number of unique elements in the modified list.
	 */
	public static int modify(List<Integer> list) {
		if(list == null) {
			throw new NullPointerException("List should not be null...");
		}
		Set<Integer> set = new HashSet<Integer>(list);
		set.removeIf(el -> el % 3 == 0);
		set.addAll(Arrays.asList(4, 5, 6, 8, 10, 12, 12, 15, 16, 18, 20, 20, 24, 25, 30));
		return set.size();
	}
	
	/**
	 * This method modifies the list by removing every n-th element.
	 * If n is zero or negative, an IllegalArgumentException should be thrown.
	 * If the list is null, a NullPointerException should be thrown. 
	 * 
	 * @param list	List of any Type.
	 * @param n		Index at which the element will be removed.
	 */
	public static void removeEveryNthElement(List<?> list, int n) {
		if(n <= 0) {
			throw new IllegalArgumentException("N must be positive...");
		}
		if(list == null) {
			throw new NullPointerException("List must not be null...");
		}
		if(n == 1) {
			list.clear();
			return;
		}
		if(list.isEmpty()) {
			return;
		}
		for(int i = 1; i < list.size()+1; i++) {
			if(i % n == 0) {
				list.set(i-1, null);
			}
		}
		list.removeIf(el -> el == null);
	}
}
