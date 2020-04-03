package nuisance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Tests the constructor and public method from class PeskyMosquito.
 * This test class should not be modified.
 */
class PeskyMosquitoTest {

	@Test
	void testPeskyMosquito() {
		PeskyMosquito mosquito = new PeskyMosquito("Anopheles freeborni");
		assertEquals("Anopheles freeborni", mosquito.getSpecies());
	}

	@Test
	void testBite() {
		String message = new PeskyMosquito("Culex pipiens").bite();
		assertTrue(message.matches("[s|S]ucking [b|B]lood"));
	}

}
