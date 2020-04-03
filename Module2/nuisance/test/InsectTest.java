package nuisance;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests the constructor and the public methods from class Insect.
 * This test class should not be modified.
 */
class InsectTest {

	Insect insect = new Insect("wasp");

	@Test
	void insect_InitializesSpecies() {
		Insect insect1 = new Insect("bee");
		assertEquals("bee", insect1.getSpecies());
	}

	@Test
	void getSpecies_returnsSpecies() {
		assertEquals("wasp", insect.getSpecies());
	}

	@Test
	void toString_returnsClassNameColonAndSpecies() {
		assertEquals("Insect: wasp", insect.toString());
	}

}
