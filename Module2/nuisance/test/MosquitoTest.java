package nuisance;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests the public methods from class Mosquito.
 * This test class should not be modified.
 */
class MosquitoTest {

	Mosquito m = new Mosquito("Aedes vexans");

	@Test
	void buzz_returnsSpeciesPlusMessage() {
		assertTrue(m.buzz().matches("Aedes vexans buzzing around.?"));
	}

	@Test
	void annoy_returnsMessage() {
		assertEquals("buzz buzz buzz", m.annoy());
	}

}
