/**
 * 
 */
package modules;

import static org.junit.Assert.*;

import org.junit.Test;

import modules.Knob.Directions;

/** Test class for the Knob module
 * @author Eliza Thornton
 *
 */
public class KnobTest {

	/**
	 * Test method for finding which direction to turn the knob
	 */
	@Test
	public void testSolve() {
		// top left, bottom left, bottom right, middle bottom, middle top
		// on left side
		Knob up = new Knob(Directions.UP);
		Knob down = new Knob(Directions.DOWN);
		Knob left = new Knob(Directions.LEFT);
		Knob right = new Knob(Directions.RIGHT);
		
		assertEquals(Directions.UP, up.solve(false, true, true, true, false));
		assertEquals(Directions.UP, up.solve(true, false, true, true, false));
		
		assertEquals(Directions.DOWN, up.solve(false, true, true, true, true));
		assertEquals(Directions.DOWN, up.solve(false, false, false, true, true));
		assertEquals(Directions.DOWN, up.solve(true, false, false, false, false));
		
		assertEquals(Directions.LEFT, up.solve(false, true, false, false, false));
		assertEquals(Directions.LEFT, up.solve(false, false, false, false, false));
		
		assertEquals(Directions.RIGHT, up.solve(true, true, true, true, false));
		
		assertEquals(Directions.DOWN, down.solve(false, true, true, true, false));
		assertEquals(Directions.DOWN, down.solve(true, false, true, true, false));
		
		assertEquals(Directions.UP, down.solve(false, true, true, true, true));
		assertEquals(Directions.UP, down.solve(false, false, false, true, true));
		assertEquals(Directions.UP, down.solve(true, false, false, false, false));
		
		assertEquals(Directions.RIGHT, down.solve(false, true, false, false, false));
		assertEquals(Directions.RIGHT, down.solve(false, false, false, false, false));
		
		assertEquals(Directions.LEFT, down.solve(true, true, true, true, false));
		
		assertEquals(Directions.LEFT, left.solve(false, true, true, true, false));
		assertEquals(Directions.LEFT, left.solve(true, false, true, true, false));
		
		assertEquals(Directions.RIGHT, left.solve(false, true, true, true, true));
		assertEquals(Directions.RIGHT, left.solve(false, false, false, true, true));
		assertEquals(Directions.RIGHT, left.solve(true, false, false, false, false));
		
		assertEquals(Directions.DOWN, left.solve(false, true, false, false, false));
		assertEquals(Directions.DOWN, left.solve(false, false, false, false, false));
		
		assertEquals(Directions.UP, left.solve(true, true, true, true, false));
		
		assertEquals(Directions.RIGHT, right.solve(false, true, true, true, false));
		assertEquals(Directions.RIGHT, right.solve(true, false, true, true, false));
		
		assertEquals(Directions.LEFT, right.solve(false, true, true, true, true));
		assertEquals(Directions.LEFT, right.solve(false, false, false, true, true));
		assertEquals(Directions.LEFT, right.solve(true, false, false, false, false));
		
		assertEquals(Directions.UP, right.solve(false, true, false, false, false));
		assertEquals(Directions.UP, right.solve(false, false, false, false, false));
		
		assertEquals(Directions.DOWN, right.solve(true, true, true, true, false));
	}

}
