/**
 * 
 */
package modules;

import static org.junit.Assert.*;

import org.junit.Test;

import modules.Sequence.Letters;

/** Test class for the sequence module
 * @author Eliza Thornton
 *
 */
public class SequenceTest {

	/**
	 * Test method for solving a sequence
	 */
	@Test
	public void testSolve1() {
		Sequence sequence = new Sequence();
		assertTrue(sequence.solve(Colors.RED, Letters.C));
		assertTrue(sequence.solve(Colors.RED, Letters.B));
		assertTrue(sequence.solve(Colors.RED, Letters.A));
		assertFalse(sequence.solve(Colors.RED, Letters.B));
		assertTrue(sequence.solve(Colors.RED, Letters.B));
		assertFalse(sequence.solve(Colors.RED, Letters.B));
		assertTrue(sequence.solve(Colors.RED, Letters.C));
		assertFalse(sequence.solve(Colors.RED, Letters.C));
		assertTrue(sequence.solve(Colors.RED, Letters.B));
		
		assertTrue(sequence.solve(Colors.BLUE, Letters.B));
		assertFalse(sequence.solve(Colors.BLUE, Letters.B));
		assertTrue(sequence.solve(Colors.BLUE, Letters.B));
		assertTrue(sequence.solve(Colors.BLUE, Letters.A));
		assertTrue(sequence.solve(Colors.BLUE, Letters.B));
		assertFalse(sequence.solve(Colors.BLUE, Letters.A));
		assertTrue(sequence.solve(Colors.BLUE, Letters.C));
		assertFalse(sequence.solve(Colors.BLUE, Letters.B));
		assertTrue(sequence.solve(Colors.BLUE, Letters.A));
		
		assertTrue(sequence.solve(Colors.BLACK, Letters.C));
		assertFalse(sequence.solve(Colors.BLACK, Letters.B));
		assertTrue(sequence.solve(Colors.BLACK, Letters.B));
		assertFalse(sequence.solve(Colors.BLACK, Letters.B));
		assertTrue(sequence.solve(Colors.BLACK, Letters.B));
		assertFalse(sequence.solve(Colors.BLACK, Letters.A));
		assertFalse(sequence.solve(Colors.BLACK, Letters.C));
		assertTrue(sequence.solve(Colors.BLACK, Letters.C));
		assertTrue(sequence.solve(Colors.BLACK, Letters.C));
		
		sequence.reset();
		assertTrue(sequence.solve(Colors.RED, Letters.C));
		assertTrue(sequence.solve(Colors.BLUE, Letters.B));
		assertTrue(sequence.solve(Colors.BLACK, Letters.B));
	}
	
	/**
	 * Test method for solving a sequence using different paths
	 */
	@Test
	public void testSolve2() {
		Sequence sequence = new Sequence();
		assertFalse(sequence.solve(Colors.RED, Letters.A));
		assertFalse(sequence.solve(Colors.RED, Letters.C));
		assertFalse(sequence.solve(Colors.RED, Letters.B));
		assertTrue(sequence.solve(Colors.RED, Letters.A));
		assertFalse(sequence.solve(Colors.RED, Letters.C));
		assertTrue(sequence.solve(Colors.RED, Letters.A));
		assertTrue(sequence.solve(Colors.RED, Letters.B));
		assertTrue(sequence.solve(Colors.RED, Letters.A));
		assertFalse(sequence.solve(Colors.RED, Letters.A));
		try {
			sequence.solve(Colors.RED, Letters.A);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid number of red occurences", e.getMessage());
		}
		
		assertFalse(sequence.solve(Colors.BLUE, Letters.A));
		assertTrue(sequence.solve(Colors.BLUE, Letters.C));
		assertFalse(sequence.solve(Colors.BLUE, Letters.A));
		assertFalse(sequence.solve(Colors.BLUE, Letters.B));
		assertFalse(sequence.solve(Colors.BLUE, Letters.C));
		assertTrue(sequence.solve(Colors.BLUE, Letters.B));
		assertFalse(sequence.solve(Colors.BLUE, Letters.A));
		assertTrue(sequence.solve(Colors.BLUE, Letters.C));
		assertFalse(sequence.solve(Colors.BLUE, Letters.B));
		try {
			sequence.solve(Colors.BLUE, Letters.A);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid number of blue occurences", e.getMessage());
		}
		
		assertTrue(sequence.solve(Colors.BLACK, Letters.A));
		assertTrue(sequence.solve(Colors.BLACK, Letters.A));
		assertFalse(sequence.solve(Colors.BLACK, Letters.C));
		assertTrue(sequence.solve(Colors.BLACK, Letters.C));
		assertFalse(sequence.solve(Colors.BLACK, Letters.A));
		assertTrue(sequence.solve(Colors.BLACK, Letters.B));
		assertTrue(sequence.solve(Colors.BLACK, Letters.B));
		assertFalse(sequence.solve(Colors.BLACK, Letters.A));
		assertFalse(sequence.solve(Colors.BLACK, Letters.B));
		try {
			sequence.solve(Colors.BLACK, Letters.A);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid number of black occurences", e.getMessage());
		}
		
		sequence.reset();
		assertFalse(sequence.solve(Colors.RED, Letters.A));
		assertFalse(sequence.solve(Colors.BLUE, Letters.C));
		assertTrue(sequence.solve(Colors.BLACK, Letters.B));
	}
	
	/** Tests throwing exceptions with the solve method
	 * 
	 */
	@Test
	public void testInvalidSolve() {
		Sequence sequence = new Sequence();
		try {
			sequence.solve(Colors.YELLOW, Letters.A);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid color", e.getMessage());
		}
		try {
			sequence.solve(Colors.BLACK, null);
		} catch (IllegalArgumentException e1) {
			assertEquals("Invalid letter", e1.getMessage());
		}
		try {
			sequence.solve(null, Letters.A);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid color", e.getMessage());
		}
	}

}
