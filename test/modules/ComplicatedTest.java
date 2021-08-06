/**
 * 
 */
package modules;

import static org.junit.Assert.*;

import org.junit.Test;

/** Test for the Complicated class
 * @author Eliza Thornton
 *
 */
public class ComplicatedTest {

	/**
	 * Tests solving for a complicated wire
	 */
	@Test
	public void testComplicated() {
		Complicated invalid = null;
		try {
			invalid = new Complicated(false, false, (byte)-1);
		} catch (IllegalArgumentException e) {
			assertEquals("Batteries must be a positive number", e.getMessage());
		}
		assertNull(invalid);
		Complicated allFalse = new Complicated(false, false, (byte)1);
		Complicated even = new Complicated(true, false, (byte)1);
		Complicated parallel = new Complicated(false, true, (byte)1);
		Complicated batteries = new Complicated(false, false, (byte)2);
		
		assertTrue(allFalse.solveWire(false, false, false, false));
		assertFalse(allFalse.solveWire(true, false, false, false));
		assertTrue(even.solveWire(true, false, false, false));
		assertFalse(allFalse.solveWire(false, true, false, false));
		assertTrue(even.solveWire(false, true, false, false));
		assertTrue(allFalse.solveWire(false, false, true, false));
		assertFalse(allFalse.solveWire(false, false, false, true));
		
		assertFalse(allFalse.solveWire(true, true, false, false));
		assertTrue(even.solveWire(true, true, false, false));
		assertTrue(allFalse.solveWire(true, false, true, false));
		assertFalse(allFalse.solveWire(true, false, false, true));
		assertTrue(batteries.solveWire(true, false, false, true));
		assertFalse(allFalse.solveWire(false, true, true, false));
		assertFalse(allFalse.solveWire(false, true, false, true));
		assertTrue(parallel.solveWire(false, true, false, true));
		assertFalse(allFalse.solveWire(false, false, true, true));
		assertTrue(batteries.solveWire(false, false, true, true));
		
		assertFalse(allFalse.solveWire(false, true, true, true));
		assertTrue(parallel.solveWire(false, true, true, true));
		assertFalse(allFalse.solveWire(true, false, true, true));
		assertTrue(batteries.solveWire(true, false, true, true));
		assertFalse(allFalse.solveWire(true, true, false, true));
		assertTrue(even.solveWire(true, true, false, true));
		assertFalse(allFalse.solveWire(true, true, true, false));
		assertTrue(parallel.solveWire(true, true, true, false));
		
		assertFalse(allFalse.solveWire(true, true, true, true));
	}

}
