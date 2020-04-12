package prep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Module04Prep {

	public static void main(String[] args) {
		transform(10);

	}

	public static void transform(double multiplier) {
		List<Double> list = new ArrayList<>();

		// initialize the list with 11 numbers from -10 to 10 each multiplied
		// with the multiplier
		for (int n = -5; n <= 5; n++) {
			list.add(n * multiplier);
		}
		System.out.println("original              : " + list);

		// remove all elements greater than 5
		list.removeIf(el -> el > 5);
		System.out.println("removed greater than 5: " + list);

		// for each of the elements in the list, add an element that is 10 times
		// as big
		int size = list.size();
		for (int i = 0; i < size; i++) {
			list.add(list.get(i) * 10);
		}
		System.out.println("add 10 times bigger el: " + list);

		// change all elements to positive elements
		for (int i = 0; i < list.size(); i++) {
			Double currentElement = list.get(i);
			if (currentElement < 0) {
				list.set(i, currentElement * -1);
			}
		}
		list.sort(null); // TODO remove after testing in main
		System.out.println("change all to positive:	" + list);

		// remove all duplicates in the list
		Set<Double> set = new HashSet<>(list);
		list = new ArrayList<>(set);
		list.sort(null); // TODO remove after testing in main
		System.out.println("remove duplicates     : " + list);

		// rotate all elemtents one to the left, and the first element to the
		// last position
		// E.g. 2 4 6 8 . . . 4 6 8 2
		Collections.rotate(list, -1);
		System.out.println("rotated 1 to the left : " + list);
		System.out.println();
	}
}