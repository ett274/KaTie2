/**
 * 
 */
package modules;

import static org.junit.Assert.*;

import org.junit.Test;

import modules.Keypads.Symbols;

/** Test for the Keypads class
 * @author Eliza Thornton
 *
 */
public class KeypadsTest {

	/**
	 * Tests solving for the keypads
	 */
	@Test
	public void testSolve() {
		Keypads keypads = new Keypads();
		Symbols[] test1 = new Symbols[4];
		test1[0] = Symbols.GE;
		test1[1] = Symbols.LIGHTNING;
		test1[2] = Symbols.AT;
		test1[3] = Symbols.LAMBDA;
		Symbols[] solution1 = keypads.solve(test1);
		assertEquals(Symbols.AT, solution1[0]);
		assertEquals(Symbols.LAMBDA, solution1[1]);
		assertEquals(Symbols.LIGHTNING, solution1[2]);
		assertEquals(Symbols.GE, solution1[3]);
		
		Symbols[] test2 = new Symbols[4];
		test2[0] = Symbols.SWIRL;
		test2[1] = Symbols.WHITE_STAR;
		test2[2] = Symbols.Q;
		test2[3] = Symbols.BACK_C;
		Symbols[] solution2 = keypads.solve(test2);
		assertEquals(Symbols.Q, solution2[0]);
		assertEquals(Symbols.BACK_C, solution2[1]);
		assertEquals(Symbols.SWIRL, solution2[2]);
		assertEquals(Symbols.WHITE_STAR, solution2[3]);
		
		Symbols[] test3 = new Symbols[4];
		test3[0] = Symbols.DROOP_R;
		test3[1] = Symbols.WHITE_STAR;
		test3[2] = Symbols.XI;
		test3[3] = Symbols.SWIRL;
		Symbols[] solution3 = keypads.solve(test3);
		assertEquals(Symbols.SWIRL, solution3[0]);
		assertEquals(Symbols.XI, solution3[1]);
		assertEquals(Symbols.DROOP_R, solution3[2]);
		assertEquals(Symbols.WHITE_STAR, solution3[3]);
		
		Symbols[] test4 = new Symbols[4];
		test4[0] = Symbols.TB;
		test4[1] = Symbols.PARAGRAPH;
		test4[2] = Symbols.FACE;
		test4[3] = Symbols.ALIEN;
		Symbols[] solution4 = keypads.solve(test4);
		assertEquals(Symbols.PARAGRAPH, solution4[0]);
		assertEquals(Symbols.TB, solution4[1]);
		assertEquals(Symbols.ALIEN, solution4[2]);
		assertEquals(Symbols.FACE, solution4[3]);
		
		Symbols[] test5 = new Symbols[4];
		test5[0] = Symbols.FACE;
		test5[1] = Symbols.BUNNY;
		test5[2] = Symbols.BLACK_STAR;
		test5[3] = Symbols.C;
		Symbols[] solution5 = keypads.solve(test5);
		assertEquals(Symbols.FACE, solution5[0]);
		assertEquals(Symbols.C, solution5[1]);
		assertEquals(Symbols.BUNNY, solution5[2]);
		assertEquals(Symbols.BLACK_STAR, solution5[3]);
		
		Symbols[] test6 = new Symbols[4];
		test6[0] = Symbols.N;
		test6[1] = Symbols.OHM;
		test6[2] = Symbols.AE;
		test6[3] = Symbols.SIX;
		Symbols[] solution6 = keypads.solve(test6);
		assertEquals(Symbols.SIX, solution6[0]);
		assertEquals(Symbols.AE, solution6[1]);
		assertEquals(Symbols.N, solution6[2]);
		assertEquals(Symbols.OHM, solution6[3]);
	}
	
	/** Tests throwing exceptions for invalid keypad inputs
	 * 
	 */
	@Test
	public void testInvalidKeypad() {
		Keypads keypads = new Keypads();
		Symbols[] invalid1 = new Symbols[3];
		invalid1[0] = Symbols.N;
		invalid1[1] = Symbols.OHM;
		invalid1[2] = Symbols.AE;
		try {
			keypads.solve(invalid1);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e){
			assertEquals("Invalid keypad length", e.getMessage());
		}
		
		Symbols[] invalid2 = new Symbols[4];
		invalid2[0] = Symbols.DROOP_R;
		invalid2[1] = Symbols.DROOP_R;
		invalid2[2] = Symbols.SWIRL;
		invalid2[3] = Symbols.W;
		try {
			keypads.solve(invalid2);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e){
			assertEquals("Keypad symbols must all be different", e.getMessage());
		}
		
		Symbols[] invalid3 = new Symbols[4];
		invalid3[0] = Symbols.SIX;
		invalid3[1] = Symbols.Q;
		invalid3[2] = Symbols.WHITE_STAR;
		invalid3[3] = Symbols.PSI;
		try {
			keypads.solve(invalid3);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e){
			assertEquals("Error finding solution column", e.getMessage());
		}
	}

}
