/**
 * 
 */
package modules;

import static org.junit.Assert.*;

import org.junit.Test;

/** Test class for the Password module
 * @author Eliza Thornton
 *
 */
public class PasswordTest {

	/**
	 * Test method for solving for a password
	 */
	@Test
	public void testSolve() {
		Password password = new Password();
		Character[] about0 = new Character[6];
		about0[0] = 'z';
		about0[1] = 'v';
		about0[2] = 'a';
		about0[3] = 'b';
		about0[4] = 'q';
		about0[5] = 's';
		assertNull(password.solve(about0, (byte)0));
		Character[] about1 = new Character[6];
		about1[0] = 'r';
		about1[1] = 'v';
		about1[2] = 'n';
		about1[3] = 'b';
		about1[4] = 'q';
		about1[5] = 's';
		assertEquals("about", password.solve(about1, (byte)1));
		
		password.reset();
		Character[] small0 = new Character[6];
		small0[0] = 'g';
		small0[1] = 't';
		small0[2] = 'p';
		small0[3] = 'l';
		small0[4] = 'r';
		small0[5] = 'q';
		assertNull(password.solve(small0, (byte)4));
		Character[] small1 = new Character[6];
		small1[0] = 'g';
		small1[1] = 'x';
		small1[2] = 'p';
		small1[3] = 'l';
		small1[4] = 'r';
		small1[5] = 'z';
		assertNull(password.solve(small1, (byte)3));
		Character[] small2 = new Character[6];
		small2[0] = 'a';
		small2[1] = 'x';
		small2[2] = 'p';
		small2[3] = 'l';
		small2[4] = 'r';
		small2[5] = 'z';
		assertEquals("small", password.solve(small2, (byte)2));
		
	}
	
	/** Tests throwing exceptions with the solve method
	 * 
	 */
	@Test
	public void testInvalid() {
		Password password = new Password();
		Character[] shortChars = new Character[4];
		try {
			password.solve(shortChars, (byte)2);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("There should be exactly 6 unique characters in a section", e.getMessage());
		}
		Character[] duplicates = new Character[6];
		duplicates[0] = 'a';
		duplicates[1] = 'b';
		duplicates[2] = 'c';
		duplicates[3] = 'b';
		duplicates[4] = 'd';
		duplicates[5] = 'e';
		try {
			password.solve(duplicates, (byte)1);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("There should be exactly 6 unique characters in a section", e.getMessage());
		}
		Character[] nonLetters = new Character[6];
		nonLetters[0] = 'a';
		nonLetters[1] = 'b';
		nonLetters[2] = 'c';
		nonLetters[3] = '1';
		nonLetters[4] = 'd';
		nonLetters[5] = 'e';
		try {
			password.solve(nonLetters, (byte)4);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Inputs must all be letters", e.getMessage());
		}
		Character[] valid = new Character[6];
		valid[0] = 'a';
		valid[1] = 'b';
		valid[2] = 'c';
		valid[3] = 'd';
		valid[4] = 'e';
		valid[5] = 'f';
		try {
			password.solve(valid, (byte)-1);
			fail("Exception not thrown");
		} catch (IndexOutOfBoundsException e) {
			//can't really assert anything here lmao
		}
		try {
			password.solve(valid, (byte)5);
			fail("Exception not thrown");
		} catch (IndexOutOfBoundsException e) {
			//can't really assert anything here lmao
		}
		Character[] unsolvable = new Character[6];
		unsolvable[0] = 'z';
		unsolvable[1] = 'x';
		unsolvable[2] = 'q';
		unsolvable[3] = 'y';
		unsolvable[4] = 'j';
		unsolvable[5] = 'v';
		try {
			password.solve(unsolvable, (byte)0);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Error finding password", e.getMessage());
		}
	}

}
