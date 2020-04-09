package keyValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Test Client for KeyValuePair Class. Also used to show more functionality of
 * Collections and type Erasure.
 * 
 * @author Chad Z
 */
public class TestClient {

	public static void main(String[] args) {
		//Part1
		System.out.println("Part1: \n-------");
		KeyValuePair<String,Integer> p1 = new KeyValuePair<>("SLC",189899);
		KeyValuePair<String,Integer> p2 = new KeyValuePair<>("NY",8244910);
		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);
		System.out.printf("p1.equals(p2): %b%n%n",p1.equals(p2));
		
		KeyValuePair<String,Integer> p3 = p2;
		System.out.println("p3: " + p3);
		System.out.printf("p2.equals(p3): %b%n",p2.equals(p3));
		System.out.println();
		
		//Part 2
		System.out.println("Part2: \n-------");
		KeyValuePair<String,Integer> p4 = new KeyValuePair<>("LA",3819702);
		KeyValuePair<String,Integer> p5 = new KeyValuePair<>("SF",812826);
		List<KeyValuePair<String,Integer>> cities = new ArrayList<>(Arrays.asList(
				p1,p2,p3,p4,p5));
		System.out.println("Original List:");
		printList(cities);
		System.out.println();
		
		System.out.println("Sorted List:");
		Collections.sort(cities);;
		printList(cities);
		System.out.println();
		
		//Part 3
		System.out.println("Part3: \n-------");
		System.out.println("Cities with margin 5:");
		printWithMargin(cities,5);
		System.out.println();
		
		Set<KeyValuePair<Integer,String>> countryCodes = new HashSet<>(Arrays.asList(
				new KeyValuePair<Integer,String>(30,"Greece"),
				new KeyValuePair<Integer,String>(33,"France"),
				new KeyValuePair<Integer,String>(43,"Austria")));
		System.out.println("Country codes with margin 3:");
		printWithMargin(countryCodes,3);
	}
	
	private static void printList(List<KeyValuePair<String, Integer>> cities) {
		cities.forEach(el -> {
			System.out.println(el);
		});
	}
	
	private static <T> void printWithMargin(Collection<T> collection,int indentation) {
		collection.forEach(el -> {
			System.out.printf("%s%s%n",addSpaces(indentation),el.toString());
		});
	}
	
	private static String addSpaces(int indentation) {
		String spaces = "";
		for(int i = 0; i < indentation; i++) {
			spaces += " ";
		}
		return spaces;
	}

}
