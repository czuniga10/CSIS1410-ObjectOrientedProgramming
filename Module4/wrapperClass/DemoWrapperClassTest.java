package wrapperClass;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

/**
 * JUnit tests to test the static methods in class DemoWrapperClass.
 * This test class should not be changed.
 */
class DemoWrapperClassTest {

	@Test
	void testMinMax() {
		String expected = 
				"Byte   : [-128 , 127]\n" + 
				"Short  : [-32768 , 32767]\n" + 
				"Integer: [-2147483648 , 2147483647]\n" + 
				"Long   : [-9223372036854775808 , 9223372036854775807]\n" + 
				"Float  : [1.4E-45 , 3.4028235E38]\n" + 
				"Double : [4.9E-324 , 1.7976931348623157E308]";
		
		assertEquals(expected, DemoWrapperClass.minMax());
	}

	@Test
	void numberRepresentations_zero() {
		String expected = "0        0        0        0";
		assertEquals(expected, DemoWrapperClass.numberRepresentations(0));
	}
	
	@Test
	void numberRepresentations_threeDigitNumber() {
		String expected = "798      31e      1436     1100011110";
		assertEquals(expected, DemoWrapperClass.numberRepresentations(798));
	}
	
	@Test
	void numberRepresentations_fourDigitNumber() {
		String expected = "7231     1c3f     16077    1110000111111";
		assertEquals(expected, DemoWrapperClass.numberRepresentations(7231));
	}

	@Test
	void charProperties_lowercase_markedLowercase() {
		assertEquals("h lowercase letter", DemoWrapperClass.charProperties('h'));
	}

	@Test
	void charProperties_uppercase_markedUppercase() {
		assertEquals("F uppercase letter", DemoWrapperClass.charProperties('F'));
	}
	
	@Test
	void charProperties_percent_noDescription() {
		assertEquals("%", DemoWrapperClass.charProperties('%'));
	}
	
	@Test
	void charProperties_space_markedWhiteSpace() {
		assertEquals("  white space", DemoWrapperClass.charProperties(' '));
	}
	
	@Test
	void charProperties_two_markedNumber() {
		assertEquals("2 number", DemoWrapperClass.charProperties('2'));
	}
	
	@Test
	void testParseSum_multipleElements_ReturnSum() {
		String[] array = {"12.1", "23.2", "34.3", "9.87"};
		assertEquals(79.47, DemoWrapperClass.parseSum(array));
	}
	
	@Test
	void testParseSum_oneElement_ReturnElement() {
		String[] array = {"1.135"};
		assertEquals(1.135, DemoWrapperClass.parseSum(array));
	}
	
	@Test
	void testParseSum_emptyArray_Return0() {
		String[] array = { };
		assertEquals(0, DemoWrapperClass.parseSum(array));
	}
	
	@Test
	void testParseSum_null_Return0() {
		assertEquals(0, DemoWrapperClass.parseSum(null));
	}

	@Test
	void testGetRandomLetter() {
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(int i = 0; i < 100_000; i++) {
			char c = DemoWrapperClass.getRandomLetter();
			if (! Character.isLetter(c))
				fail("Only letters a-z or A-Z should be returned.");
			// count how often the letters occurred
			map.compute(c, (k, v) -> (v == null) ? 1 : v + 1);
		}
		
		// confirm that no boundary values were missed
		assertTrue(map.get('a') > 0 && map.get('z') > 0 
				&& map.get('A') > 0 && map.get('Z') > 0);
	}

	@Test
	void testGetRandomThreeDigitNumber() {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < 100_000; i++) {
			int n = DemoWrapperClass.getRandomThreeDigitNumber();
			if (n < 100 || n > 999)
				fail("Only three-digit numbers should be returned.");
			map.compute(n, (k, v) -> (v == null) ? 1 : v + 1);
		}
		
		assertTrue(map.get(100) > 0 && map.get(999) > 0);
	}


}
