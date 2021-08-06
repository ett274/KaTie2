/**
 * 
 */
package modules;

import static org.junit.Assert.*;

import org.junit.Test;

/** Test method for the morse code class
 * @author Eliza Thornton
 *
 */
public class MorseCodeTest {

	/**
	 * Test method for constructing the morse code object
	 */
	@Test
	public void testMorseCode() {
		MorseCode morse = new MorseCode();
		assertEquals('a', morse.getLetter(".-"));
		assertEquals('b', morse.getLetter("-..."));
		assertEquals('c', morse.getLetter("-.-."));
		assertEquals('d', morse.getLetter("-.."));
		assertEquals('e', morse.getLetter("."));
		assertEquals('f', morse.getLetter("..-."));
		assertEquals('g', morse.getLetter("--."));
		assertEquals('h', morse.getLetter("...."));
		assertEquals('i', morse.getLetter(".."));
		assertEquals('k', morse.getLetter("-.-"));
		assertEquals('l', morse.getLetter(".-.."));
		assertEquals('m', morse.getLetter("--"));
		assertEquals('n', morse.getLetter("-."));
		assertEquals('o', morse.getLetter("---"));
		assertEquals('r', morse.getLetter(".-."));
		assertEquals('s', morse.getLetter("..."));
		assertEquals('t', morse.getLetter("-"));
		assertEquals('v', morse.getLetter("...-"));
		assertEquals('x', morse.getLetter("-..-"));
	}

	/**
	 * Test method for solving a password
	 */
	@Test
	public void testSolve() {
		MorseCode morse = new MorseCode();
		char[] shell = new char[5];
		shell[0] = 's';
		shell[1] = 'h';
		shell[2] = 'e';
		shell[3] = 'l';
		shell[4] = 'l';
		assertEquals("3.505", morse.solve(shell));
		
		char[] halls = new char[5];
		halls[0] = 'h';
		halls[1] = 'a';
		halls[2] = 'l';
		halls[3] = 'l';
		halls[4] = 's';
		assertEquals("3.515", morse.solve(halls));
		
		char[] slick = new char[5];
		slick[0] = 's';
		slick[1] = 'l';
		slick[2] = 'i';
		slick[3] = 'c';
		slick[4] = 'k';
		assertEquals("3.522", morse.solve(slick));
		
		char[] trick = new char[5];
		trick[0] = 't';
		trick[1] = 'r';
		trick[2] = 'i';
		trick[3] = 'c';
		trick[4] = 'k';
		assertEquals("3.532", morse.solve(trick));
		
		char[] boxes = new char[5];
		boxes[0] = 'b';
		boxes[1] = 'o';
		boxes[2] = 'x';
		boxes[3] = 'e';
		boxes[4] = 's';
		assertEquals("3.535", morse.solve(boxes));
		
		char[] leaks = new char[5];
		leaks[0] = 'l';
		leaks[1] = 'e';
		leaks[2] = 'a';
		leaks[3] = 'k';
		leaks[4] = 's';
		assertEquals("3.542", morse.solve(leaks));
		
		char[] strobe = new char[6];
		strobe[0] = 's';
		strobe[1] = 't';
		strobe[2] = 'r';
		strobe[3] = 'o';
		strobe[4] = 'b';
		strobe[5] = 'e';
		assertEquals("3.545", morse.solve(strobe));
		
		char[] bistro = new char[6];
		bistro[0] = 'b';
		bistro[1] = 'i';
		bistro[2] = 's';
		bistro[3] = 't';
		bistro[4] = 'r';
		bistro[5] = 'o';
		assertEquals("3.552", morse.solve(bistro));
		
		char[] flick = new char[5];
		flick[0] = 'f';
		flick[1] = 'l';
		flick[2] = 'i';
		flick[3] = 'c';
		flick[4] = 'k';
		assertEquals("3.555", morse.solve(flick));
		
		char[] bombs = new char[5];
		bombs[0] = 'b';
		bombs[1] = 'o';
		bombs[2] = 'm';
		bombs[3] = 'b';
		bombs[4] = 's';
		assertEquals("3.565", morse.solve(bombs));
		
		char[] breakk = new char[5];
		breakk[0] = 'b';
		breakk[1] = 'r';
		breakk[2] = 'e';
		breakk[3] = 'a';
		breakk[4] = 'k';
		assertEquals("3.572", morse.solve(breakk));
		
		char[] brick = new char[5];
		brick[0] = 'b';
		brick[1] = 'r';
		brick[2] = 'i';
		brick[3] = 'c';
		brick[4] = 'k';
		assertEquals("3.575", morse.solve(brick));
		
		char[] steak = new char[5];
		steak[0] = 's';
		steak[1] = 't';
		steak[2] = 'e';
		steak[3] = 'a';
		steak[4] = 'k';
		assertEquals("3.582", morse.solve(steak));
		
		char[] sting = new char[5];
		sting[0] = 's';
		sting[1] = 't';
		sting[2] = 'i';
		sting[3] = 'n';
		sting[4] = 'g';
		assertEquals("3.592", morse.solve(sting));
		
		char[] vector = new char[6];
		vector[0] = 'v';
		vector[1] = 'e';
		vector[2] = 'c';
		vector[3] = 't';
		vector[4] = 'o';
		vector[5] = 'r';
		assertEquals("3.595", morse.solve(vector));
		
		char[] beats = new char[5];
		beats[0] = 'b';
		beats[1] = 'e';
		beats[2] = 'a';
		beats[3] = 't';
		beats[4] = 's';
		assertEquals("3.600", morse.solve(beats));
		
		char[] llehs = new char[5]; //testing letters in the wrong order
		llehs[0] = 'l';
		llehs[1] = 'l';
		llehs[2] = 'e';
		llehs[3] = 'h';
		llehs[4] = 's';
		assertEquals("3.505", morse.solve(llehs));
		
		char[] slehl = new char[5]; //testing letters in the wrong order
		slehl[0] = 's';
		slehl[1] = 'l';
		slehl[2] = 'e';
		slehl[3] = 'h';
		slehl[4] = 'l';
		assertEquals("3.505", morse.solve(slehl));
	}
	
	/** Tests throwing exceptions with the solve method
	 * 
	 */
	@Test
	public void invalidSolve() {
		MorseCode morse = new MorseCode();
		char[] shortChars = new char[3];
		try {
			morse.solve(shortChars);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid length of characters", e.getMessage());
		}
		
		char[] chars = new char[5];
		chars[0] = 'z';
		chars[1] = 'i';
		chars[2] = 'p';
		chars[3] = 'p';
		chars[4] = 'y';
		try {
			morse.solve(chars);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Error finding correct word", e.getMessage());
		}
		
	}

}
