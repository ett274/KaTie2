/**
 * 
 */
package modules;

import static org.junit.Assert.*;

import org.junit.Test;

import modules.Simon.SimonColors;
import modules.Simon.Strikes;

/** Test class for the Simon module.
 * @author Eliza Thornton
 *
 */
public class SimonTest {

	/**
	 * Tests solving Simon Says
	 */
	@Test
	public void testSolve() {
		Simon trueSimon = new Simon(true);
		Simon falseSimon = new Simon(false);
		assertEquals(SimonColors.BLUE, trueSimon.solve(SimonColors.RED, Strikes.ZERO));
		assertEquals(SimonColors.YELLOW, trueSimon.solve(SimonColors.RED, Strikes.ONE));
		assertEquals(SimonColors.GREEN, trueSimon.solve(SimonColors.RED, Strikes.TWO));
		
		assertEquals(SimonColors.RED, trueSimon.solve(SimonColors.BLUE, Strikes.ZERO));
		assertEquals(SimonColors.GREEN, trueSimon.solve(SimonColors.BLUE, Strikes.ONE));
		assertEquals(SimonColors.RED, trueSimon.solve(SimonColors.BLUE, Strikes.TWO));
		
		assertEquals(SimonColors.YELLOW, trueSimon.solve(SimonColors.GREEN, Strikes.ZERO));
		assertEquals(SimonColors.BLUE, trueSimon.solve(SimonColors.GREEN, Strikes.ONE));
		assertEquals(SimonColors.YELLOW, trueSimon.solve(SimonColors.GREEN, Strikes.TWO));
		
		assertEquals(SimonColors.GREEN, trueSimon.solve(SimonColors.YELLOW, Strikes.ZERO));
		assertEquals(SimonColors.RED, trueSimon.solve(SimonColors.YELLOW, Strikes.ONE));
		assertEquals(SimonColors.BLUE, trueSimon.solve(SimonColors.YELLOW, Strikes.TWO));
		
		assertEquals(SimonColors.BLUE, falseSimon.solve(SimonColors.RED, Strikes.ZERO));
		assertEquals(SimonColors.RED, falseSimon.solve(SimonColors.RED, Strikes.ONE));
		assertEquals(SimonColors.YELLOW, falseSimon.solve(SimonColors.RED, Strikes.TWO));
		
		assertEquals(SimonColors.YELLOW, falseSimon.solve(SimonColors.BLUE, Strikes.ZERO));
		assertEquals(SimonColors.BLUE, falseSimon.solve(SimonColors.BLUE, Strikes.ONE));
		assertEquals(SimonColors.GREEN, falseSimon.solve(SimonColors.BLUE, Strikes.TWO));
		
		assertEquals(SimonColors.GREEN, falseSimon.solve(SimonColors.GREEN, Strikes.ZERO));
		assertEquals(SimonColors.YELLOW, falseSimon.solve(SimonColors.GREEN, Strikes.ONE));
		assertEquals(SimonColors.BLUE, falseSimon.solve(SimonColors.GREEN, Strikes.TWO));
		
		assertEquals(SimonColors.RED, falseSimon.solve(SimonColors.YELLOW, Strikes.ZERO));
		assertEquals(SimonColors.GREEN, falseSimon.solve(SimonColors.YELLOW, Strikes.ONE));
		assertEquals(SimonColors.RED, falseSimon.solve(SimonColors.YELLOW, Strikes.TWO));
	}
	
	/** Tests invalid inputs for solve()
	 * 
	 */
	@Test
	public void testInvalid() {
		Simon simon = new Simon(true);
		Simon simon2 = new Simon(false);
	    try {
			simon.solve(SimonColors.RED, null);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Strikes cannot be null", e.getMessage());
		}
	    try {
			simon.solve(SimonColors.BLUE, null);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Strikes cannot be null", e.getMessage());
		}
	    try {
			simon.solve(SimonColors.GREEN, null);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Strikes cannot be null", e.getMessage());
		}
	    try {
			simon.solve(SimonColors.YELLOW, null);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Strikes cannot be null", e.getMessage());
		}
	    try {
			simon.solve(null, null);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Flash cannot be null", e.getMessage());
		}
	    try {
			simon.solve(null, Strikes.ZERO);
		} catch (IllegalArgumentException e) {
			assertEquals("Flash cannot be null", e.getMessage());
		}
	    try {
			simon.solve(null, Strikes.ONE);
		} catch (IllegalArgumentException e) {
			assertEquals("Flash cannot be null", e.getMessage());
		}
	    try {
			simon.solve(null, Strikes.TWO);
		} catch (IllegalArgumentException e) {
			assertEquals("Flash cannot be null", e.getMessage());
		}
	    try {
			simon2.solve(SimonColors.RED, null);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Strikes cannot be null", e.getMessage());
		}
	    try {
			simon2.solve(SimonColors.BLUE, null);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Strikes cannot be null", e.getMessage());
		}
	    try {
			simon2.solve(SimonColors.GREEN, null);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Strikes cannot be null", e.getMessage());
		}
	    try {
			simon2.solve(SimonColors.YELLOW, null);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Strikes cannot be null", e.getMessage());
		}
	    try {
			simon2.solve(null, null);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Flash cannot be null", e.getMessage());
		}
	    try {
			simon2.solve(null, Strikes.ZERO);
		} catch (IllegalArgumentException e) {
			assertEquals("Flash cannot be null", e.getMessage());
		}
	    try {
			simon2.solve(null, Strikes.ONE);
		} catch (IllegalArgumentException e) {
			assertEquals("Flash cannot be null", e.getMessage());
		}
	    try {
			simon2.solve(null, Strikes.TWO);
		} catch (IllegalArgumentException e) {
			assertEquals("Flash cannot be null", e.getMessage());
		}
	}

}
