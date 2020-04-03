package nuisance;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests the public method from class Telemarketer.
 * This test class should not be modified.
 */
class TelemarketerTest {

	@Test
	void giveSalesPitch_returnsNamePlusMessage() {
		Telemarketer t = new Telemarketer("Fritz", 27);
		assertTrue(t.giveSalesPitch().matches("Fritz pressures others to buy stuff.?"));
	}
	@Test
	void annoy_returnsNamePlusMessage() {
		Telemarketer t = new Telemarketer("Fritz", 27);
		assertTrue(t.annoy().matches("Fritz annoys by giving a sales pitch.?"));
	}
}
