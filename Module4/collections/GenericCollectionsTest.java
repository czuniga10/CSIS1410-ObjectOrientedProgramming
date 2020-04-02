package collections;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * Unit Test Class to house tests for GerenicCollections Class
 * 
 * @author Chad Z
 */
class GenericCollectionsTest {
	
	//lettersAndNumber method tests
	
	@Test
	void lettersAndNumbers_GivenLetters_ReturnsLettersWithUpperLowerRepresentation() {
		List<String> expected = new ArrayList<String>(Arrays
				.asList("L(a)","U(b)","L(c)","U(d)"));
		assertEquals(expected,GenericCollections.lettersAndNumbers(
				new ArrayList<Character>(Arrays.asList('a','B','c','D'))));
	}
	
	@Test
	void lettersAndNumbers_GivenNumbers_ReturnsLettersWithNumberRepresentation() {
		List<String> expected = new ArrayList<String>(Arrays
				.asList("N(1)","N(2)","N(3)","N(4)"));
		assertEquals(expected,GenericCollections.lettersAndNumbers(
				new ArrayList<Character>(Arrays.asList('1','2','3','4'))));
	}
	
	@Test
	void lettersAndNumbers_GivenNumbersAndLetters_ReturnsLettersWithUpperLowerAndNumberRepresentation() {
		List<String> expected = new ArrayList<String>(Arrays
				.asList("L(a)","N(1)","L(b)","N(2)"));
		assertEquals(expected,GenericCollections.lettersAndNumbers(
				new ArrayList<Character>(Arrays.asList('a','1','b','2'))));
	}
	
	@Test
	void lettersAndNumbers_GivenUpperCaseOnly_ReturnsLettersWithUpperRepresentation() {
		List<String> expected = new ArrayList<String>(Arrays
				.asList("U(a)","U(b)","U(c)","U(d)"));
		assertEquals(expected,GenericCollections.lettersAndNumbers(
				new ArrayList<Character>(Arrays.asList('A','B','C','D'))));
	}
	
	@Test
	void lettersAndNumbers_GivenLowerCaseOnly_ReturnsLettersWithLowerRepresentation() {
		List<String> expected = new ArrayList<String>(Arrays
				.asList("L(a)","L(b)","L(c)","L(d)"));
		assertEquals(expected,GenericCollections.lettersAndNumbers(
				new ArrayList<Character>(Arrays.asList('a','b','c','d'))));
	}
	
	@Test
	void lettersAndNumbers_GivenMixedNumbersAndLettersWithSymbols_ReturnsOnlyUpperLowerAndNumberRepresentation() {
		List<String> expected = new ArrayList<String>(Arrays
				.asList("L(a)","N(1)","U(b)"));
		assertEquals(expected,GenericCollections.lettersAndNumbers(
				new ArrayList<Character>(Arrays.asList('a','1','B','$'))));
	}
	
	@Test
	void lettersAndNumbers_GivenSymbolsOnly_ReturnsEmptyList() {
		List<String> expected = new ArrayList<String>();
		assertEquals(expected,GenericCollections.lettersAndNumbers(
				new ArrayList<Character>(Arrays.asList('!','@','#','$'))));
	}
	
	@Test
	void lettersAndNumbers_GivenEmptyList_ReturnsEmptyList() {
		List<String> expected = new ArrayList<String>();
		assertEquals(expected,GenericCollections.lettersAndNumbers(
				new ArrayList<Character>()));
	}
	
	@Test
	void lettersAndNumbers_GivenNull_ReturnsNull() {
		List<String> expected = null;
		assertEquals(expected,GenericCollections.lettersAndNumbers(
				null));
	}
	
	//modify method tests
	
	@Test
	void modify_GivenEmptyList_ReturnsAllMultiplesOf456UniquelyCounted() {
		int expected = 13;
		assertEquals(expected,GenericCollections.modify(
				new ArrayList<Integer>()));
	}
	
	@Test
	void modify_GivenOnlyMultiplesof3_ReturnsAllMultiplesOf456UniquelyCounted() {
		int expected = 13;
		assertEquals(expected,GenericCollections.modify(
				new ArrayList<Integer>(Arrays
						.asList(3, -6, 3, -9, -3, 0, 12, 3))));
	}
	
	@Test
	void modify_Given1Through7_ReturnsAllNumbersExceptMultplesOf3AndReturnsMultiplesOf456UniquelyCounted() {
		int expected = 16;
		assertEquals(expected,GenericCollections.modify(
				new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7))));
	}
	
	@Test
	void modify_GivenNull_ReturnsNullPointerException() {
		assertThrows(NullPointerException.class, () -> GenericCollections
				.modify(null), "List should not be null...");
	}
	
	@Test
	void modify_GivenOnlyNegativeNumbers_ReturnsAllNumbersExceptMultiplesOf3AndReturnsMultiplesOf456UniquelyCounted() {
		int expected = 18;
		assertEquals(expected,GenericCollections.modify(
				new ArrayList<Integer>(Arrays.asList(-1, -2, -3, -4, -5, -6, -7))));
	}
	
	@Test
	void modify_Given0Only_ReturnsMultiplesOf456UniquelyCountedAndDoesntCount0() {
		int expected = 16;
		assertEquals(expected,GenericCollections.modify(
				new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7))));
	}
	
	@Test
	void modify_Given456_ReturnsMultiplesOf456CountedOnlyOnce() {
		int expected = 13;
		assertEquals(expected,GenericCollections.modify(new ArrayList<Integer>(Arrays
				.asList(4, 5, 6))));
	}
	
	@Test
	void modify_Given5OfTheSameNumber_ReturnsMultiplesOf456PlusGivenNumbersUniquelyCounted() {
		int expected = 14;
		assertEquals(expected,GenericCollections.modify(new ArrayList<Integer>(Arrays
				.asList(1, 1, 1, 1, 1))));
	}
	
	//removeEveryNthElement
	
	@Test
	void removeEveryNthElement_GivenListOfTypeDoubleWhereNIs2_ListAfterShouldRemoveEveryOtherElement() {
		List<Double> expected = new ArrayList<Double>(Arrays
				.asList(1.1, 3.3, 5.5, 7.7, 9.9));
		List<Double> result = new ArrayList<Double>(Arrays
				.asList(1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9));
		GenericCollections.removeEveryNthElement(result,2);
		assertEquals(expected,result);
	}
	
	@Test
	void removeEveryNthElement_GivenListOfTypeIntegerWhereNIs3_ListAfterShouldRemoveEvery3rdElement() {
		List<Integer> expected = new ArrayList<Integer>(Arrays
				.asList(1, 2, 4, 5, 7, 8));
		List<Integer> result = new ArrayList<Integer>(Arrays
				.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		GenericCollections.removeEveryNthElement(result,3);
		assertEquals(expected,result);
	}
	
	@Test
	void removeEveryNthElement_GivenListOfTypeStringWhereNIs4_ListAfterShouldRemoveEvery4thElement() {
		List<String> expected = new ArrayList<String>(Arrays
				.asList("AA", "BB", "CC", "EE", "FF"));
		List<String> result = new ArrayList<String>(Arrays
				.asList("AA", "BB", "CC", "DD", "EE", "FF"));
		GenericCollections.removeEveryNthElement(result,4);
		assertEquals(expected,result);
	}
	
	@Test
	void removeEveryNthElement_GivenListOfTypeCharacterWhereNIs5_ListAfterShouldRemoveEvery5thElement() {
		List<Character> expected = new ArrayList<Character>(Arrays
				.asList('z', 'y', 'x', 'w', 'u', 't', 'x', 'r'));
		List<Character> result = new ArrayList<Character>(Arrays
				.asList('z', 'y', 'x', 'w', 'v', 'u', 't', 'x', 'r', 'q'));
		GenericCollections.removeEveryNthElement(result,5);
		assertEquals(expected,result);
	}
	
	@Test
	void removeEveryNthElement_GivenListOfTypeStringWhereNIsLargerThanListSize_ListAfterShouldRemainTheSame() {
		List<String> expected = new ArrayList<String>(Arrays
				.asList("AA", "BB", "CC", "DD", "EE", "FF"));
		List<String> result = new ArrayList<String>(Arrays
				.asList("AA", "BB", "CC", "DD", "EE", "FF"));
		GenericCollections.removeEveryNthElement(result,12);
		assertEquals(expected,result);
	}
	
	@Test
	void removeEveryNthElement_GivenListOfTypeStringWhereNIs1_ListAfterShouldBeEmpty() {
		List<String> expected = new ArrayList<String>();
		List<String> result = new ArrayList<String>(Arrays
				.asList("AA", "BB", "CC", "DD", "EE", "FF"));
		GenericCollections.removeEveryNthElement(result,1);
		assertEquals(expected,result);
	}
	
	@Test
	void removeEveryNthElement_GivenListOfTypeStringWhereNIs0_ReturnsIllegalArgumentException() {
		List<String> result = new ArrayList<String>(Arrays
				.asList("AA", "BB", "CC", "DD", "EE", "FF"));
		assertThrows(IllegalArgumentException.class, () -> GenericCollections
				.removeEveryNthElement(result,0), "N must be positive...");
	}
	
	@Test
	void removeEveryNthElement_GivenANullListOfTypeStringWhereNIs1_ReturnsNullPointerException() {
		List<String> result = null;
		assertThrows(NullPointerException.class, () -> GenericCollections
				.removeEveryNthElement(result,1), "List must not be null...");
	}

}
