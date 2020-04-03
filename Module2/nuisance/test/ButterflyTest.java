package nuisance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Tests the constructor and the public methods from class Butterfly.
 * This test class should not be modified.
 */
class ButterflyTest {

	private Butterfly b = new Butterfly("Clouded sulphur", List.of("yellow", "brown"));
	
	@Test
	void butterfly_fieldParameters_oneColor() {
		List<String> colors = new LinkedList<>();
		colors.add("yellow");
		Butterfly b1 = new Butterfly("Yellow Phoebis", colors);
		
		assertEquals("Yellow Phoebis", b1.getSpecies());		
		assertTrue(sameColors(colors, b1.getColors()));
		
	}
	
	@Test
	void butterfly_fieldParameters_multipleColors() {
		List<String> colors = new ArrayList<>();
		Collections.addAll(colors, "yellow", "black", "green");
		Butterfly b1 = new Butterfly("Common Green Bridwing", 
				List.of("yellow", "black", "green"));
		
		assertEquals("Common Green Bridwing", b1.getSpecies());
		assertTrue(sameColors(colors, b1.getColors()));		
	}

	@Test
	void butterfly_copyConstructor() {
		List<String> colors = List.of("orange", "black", "white");
		Butterfly b1 = new Butterfly("Monarch", colors);
		Butterfly b2 = new Butterfly(b1);

		assertEquals("Monarch", b2.getSpecies());
		assertTrue(sameColors(colors, b2.getColors()));		
	}
	
	@Test
	void butterfly_immutable() {
		List<String> colors = new ArrayList<>();
		Collections.addAll(colors, "orange", "black", "white");
		
		Butterfly b1 = new Butterfly("Monarch", colors);
		Butterfly b2 = new Butterfly(b1);
		
		// Modifying the original color list should not affect b1 or b2.
		colors.set(0, "pink");
		
		// Modifying the colors returned by the getters should not affect b1 or b2
		List<String> b1Colors = b1.getColors();
		b1Colors.set(1, "lime");
		List<String> b2Colors = b2.getColors();
		b2Colors.set(1, "cyan");
		
		assertTrue(sameColors(List.of("orange", "black", "white"), b1.getColors()));	
		assertTrue(sameColors(List.of("orange", "black", "white"), b2.getColors()));	
	}	
	
	/**
	 * Determines whether the lists <code>list1</code> and <code>list2</code>
	 * are the same. In this context, two lists are considered the same 
	 * if they include the same elements in the same order.
	 * 
	 * @param list1
	 * @param list2
	 * @return true if the lists are considered the same; otherwise false.
	 */
	private boolean sameColors(List<String> list1, List<String> list2) {
		if(list1.size() != list2.size())
			return false;
		
		for(int i = 0; i < list1.size(); i++) {
			if (!list1.get(i).equals(list2.get(i)))
				return false;
		}
		
		return true;
	}

	@Test
	void toString_returnsSpeciesAndColorsInBrackets() {
		assertEquals("Clouded sulphur [yellow, brown]", b.toString());
	}


	@Test
	void testGetColors() {
		assertTrue(sameColors(List.of("yellow", "brown"), b.getColors()));		
	}

}
