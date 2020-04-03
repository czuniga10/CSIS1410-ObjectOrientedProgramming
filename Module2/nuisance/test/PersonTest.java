package nuisance;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests the constructor and all public methods from class Person.
 * This test class should not be modified.
 */
class PersonTest {
	private Person p = new Person("Joey", 42);
	
	@Test
	void person_PersonAssignedValidAgeBetween1And150() {
		assertEquals(21, new Person("Laura", 21).getAge());
	}
	
	@Test
	void person_PersonAssignedAgeLessThan1_ThrowsIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {new Person("Joey", 0);});
	}
	
	@Test
	void person_PersonAssignedAgeGreaterThan150_ThrowsIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {new Person("Joey", 151);});
	}
	
	@Test
	void getName_returnsName() {
		assertEquals("Joey", p.getName());
	}
	
	@Test
	void getAge_returnsAge() {
		assertEquals(42, p.getAge());
	}
	
	@Test
	void toString_PersonWithNameAndAge_NameFollowedByAgeInParentheses() {
		assertEquals("Joey(42)", p.toString());
	}

	@Test
	void equalsObject_SameNameSameAge_ReturnTrue() {
		Person newPerson = new Person("Joey", 42);
		assertEquals(true, p.equals(newPerson));
	}
	
	@Test
	void equalsObject_SameNameDifferentAge_ReturnFalse() {
		Person newPerson = new Person("Joey", 41);
		assertEquals(false, p.equals(newPerson));
	}
	
	@Test
	void equalsObject_SameAgeDifferentName_ReturnFalse() {
		Person newPerson = new Person("Joel", 42);
		assertEquals(false, p.equals(newPerson));
	}

	@Test
	void equalsObject_DifferentTypesOfObjects_ReturnFalse() {
		Mosquito m = new Mosquito("Culiseta melanura");
		assertEquals(false, p.equals(m));
	}
	
	@Test
	void equalsObject_NullValue_ReturnFalse() {
		assertEquals(false, p.equals(null));
	}
}
