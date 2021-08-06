/**
 * 
 */
package manager;

import static org.junit.Assert.*;

import org.junit.Test;

import modules.Button.Solution;
import modules.Keypads.Symbols;
import modules.Knob.Directions;
import modules.Memory.Display;
import modules.Sequence.Letters;
import modules.Simon.SimonColors;
import modules.Simon.Strikes;
import modules.Colors;

/** Tests the Bomb class
 * @author Eliza Thornton
 *
 */
public class BombTest {
	
	/** Default bomb to use during testing
	 * 
	 */
	private static final Bomb DEFAULT_BOMB = new Bomb(false, false, (byte)0, '1', false, false);

	/**
	 * Tests constructing a bomb
	 */
	@Test
	public void testBomb() {
		Bomb bomb1 = new Bomb(false, false, (byte)2, '1', false, false);
		assertNotNull(bomb1);
		Bomb bomb2 = null;
		try {
			bomb2 = new Bomb(true, false, (byte)-1, '0', false, false);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Batteries must be a positive number", e.getMessage());
		}
		assertNull(bomb2);
		try {
			bomb2 = new Bomb(true, false, (byte)1, 'b', false, false);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid digit", e.getMessage());
		}
		assertNull(bomb2);
		bomb2 = new Bomb(true, true, (byte)3, '2', true, true);
		assertNotNull(bomb2);
	}

	/**
	 * Test method for solving a button
	 */
	@Test
	public void testSolveButton() {
		Bomb bomb = new Bomb(true, true, (byte)4, '2', false, false);
		assertEquals(Solution.HOLD, bomb.solveButton(Colors.BLUE, "Abort"));
		assertEquals(Solution.PRESS, bomb.solveButton(Colors.RED, "Abort"));
	}

	/**
	 * Test method for solving a held button
	 */
	@Test
	public void testSolveHold() {
		assertEquals('4', DEFAULT_BOMB.solveHold(Colors.BLUE));
		assertEquals('1', DEFAULT_BOMB.solveHold(Colors.WHITE));
		assertEquals('5', DEFAULT_BOMB.solveHold(Colors.YELLOW));
		assertEquals('1', DEFAULT_BOMB.solveHold(Colors.RED));
	}

	/**
	 * Test method for solving wires
	 */
	@Test
	public void testSolveWires() {
		Bomb bomb = new Bomb(true, true, (byte)4, '1', false, false);
		Colors[] wires = {Colors.WHITE, Colors.BLUE, Colors.WHITE};
		assertEquals("second", bomb.solveWires(wires));
		Colors[] wires2 = {Colors.BLUE, Colors.BLUE, Colors.WHITE, Colors.YELLOW, Colors.BLACK};
		assertEquals("fourth", bomb.solveWires(wires2));
		Colors[] wires3 = {Colors.RED};
		try {
			bomb.solveWires(wires3);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid number of wires", e.getMessage());
		}
	}

	/**
	 * Test method for solving keypads
	 */
	@Test
	public void testSolveKeypad() {
		Symbols[] symbols = {Symbols.XI, Symbols.TB, Symbols.FACE, Symbols.SIX};
		Symbols[] solution = DEFAULT_BOMB.solveKeypad(symbols);
		assertEquals(Symbols.SIX, solution[0]);
		assertEquals(Symbols.TB, solution[1]);
		assertEquals(Symbols.XI, solution[2]);
		assertEquals(Symbols.FACE, solution[3]);
	}

	/**
	 * Test method for Simon Says
	 */
	@Test
	public void testSolveSimon() {
		Bomb bombV = new Bomb(false, false, (byte)0, '0', true, false);
		assertEquals(SimonColors.RED, bombV.solveSimon(SimonColors.BLUE, Strikes.ZERO));
		assertEquals(SimonColors.YELLOW, DEFAULT_BOMB.solveSimon(SimonColors.BLUE, Strikes.ZERO));
	}

	/**
	 * Test method for solving Who's On First
	 */
	@Test
	public void testSolveWhosOnFirst() {
		String[] buttons = {"UH UH", "YOU ARE", "RIGHT", "DONE", "YOU", "UHHH"};
		assertEquals("DONE", DEFAULT_BOMB.solveWhosOnFirst("FIRST", buttons));
	}

	/**
	 * Test method for solving memory
	 */
	@Test
	public void testSolveMemory() {
		assertEquals('2', DEFAULT_BOMB.solveMemory((byte)1, Display.TWO, "1234"));
		assertEquals('4', DEFAULT_BOMB.solveMemory((byte)2, Display.ONE, "1234"));
		assertEquals('2', DEFAULT_BOMB.solveMemory((byte)3, Display.TWO, "1234"));
		assertEquals('1', DEFAULT_BOMB.solveMemory((byte)4, Display.TWO, "1234"));
		assertEquals('4', DEFAULT_BOMB.solveMemory((byte)5, Display.TWO, "1234"));
		assertEquals('4', DEFAULT_BOMB.solveMemory((byte)1, Display.FOUR, "1234"));
	}

	/**
	 * Test method for getting a character from a morse code input
	 */
	@Test
	public void testGetMorseLetter() {
		assertEquals('a', DEFAULT_BOMB.getMorseLetter(".-"));
	}

	/**
	 * Test method for solving the morse code password
	 */
	@Test
	public void testSolveMorse() {
		char[] bistro = {'b', 'i', 's', 't', 'r', 'o'};
		assertEquals("3.552", DEFAULT_BOMB.solveMorse(bistro));
	}

	/**
	 * Test method for solving complicated wires
	 */
	@Test
	public void testSolveComplicated() {
		Bomb even = new Bomb(false, false, (byte)0, '2', false, false);
		Bomb parallel = new Bomb(false, false, (byte)0, '1', false, true);
		Bomb batteries = new Bomb(false, false, (byte)2, '1', false, false);
		
		assertFalse(DEFAULT_BOMB.solveComplicated(false, true, false, false));
		assertTrue(even.solveComplicated(false, true, false, false));
		
		assertFalse(DEFAULT_BOMB.solveComplicated(false, true, false, true));
		assertTrue(parallel.solveComplicated(false, true, false, true));
		
		assertFalse(DEFAULT_BOMB.solveComplicated(false, false, true, true));
		assertTrue(batteries.solveComplicated(false, false, true, true));
	}

	/**
	 * Test method for solving sequences
	 */
	@Test
	public void testSolveSequence() {
		assertTrue(DEFAULT_BOMB.solveSequence(Colors.RED, Letters.C, false));
		assertFalse(DEFAULT_BOMB.solveSequence(Colors.RED, Letters.C, false));
		assertTrue(DEFAULT_BOMB.solveSequence(Colors.RED, Letters.C, true));
		
		assertTrue(DEFAULT_BOMB.solveSequence(Colors.BLUE, Letters.B, false));
		assertFalse(DEFAULT_BOMB.solveSequence(Colors.BLUE, Letters.B, false));
		assertTrue(DEFAULT_BOMB.solveSequence(Colors.BLUE, Letters.B, true));
		
		assertTrue(DEFAULT_BOMB.solveSequence(Colors.BLACK, Letters.B, false));
		assertFalse(DEFAULT_BOMB.solveSequence(Colors.BLACK, Letters.B, false));
		assertTrue(DEFAULT_BOMB.solveSequence(Colors.BLACK, Letters.B, true));
	}

	/**
	 * Test method for solving a maze
	 */
	@Test
	public void testSolveMaze() {
		assertEquals("left, down, left, up", DEFAULT_BOMB.solveMaze((byte)1, (byte)5, (byte)6, (byte)4, (byte)5, (byte)2, (byte)3, (byte)2));
	}

	/**
	 * Test method for solving a password
	 */
	@Test
	public void testSolvePassword() {
		Character[] characters1 = {'a', 'b', 'c', 'd', 'e', 'f'};
		Character[] characters2 = {'f', 'z', 'x', 'y', 'h', 'k'};
		assertNull(DEFAULT_BOMB.solvePassword(characters1, (byte)0, true));
		assertEquals("after", DEFAULT_BOMB.solvePassword(characters2, (byte)1, false));
		assertNull(DEFAULT_BOMB.solvePassword(characters2, (byte)1, true));
	}

	/**
	 * Test method for solving a knob
	 */
	@Test
	public void testSolveKnob() {
		assertEquals(Directions.UP, DEFAULT_BOMB.solveKnob(Directions.UP, false, true, true, true, false));
		assertEquals(Directions.DOWN, DEFAULT_BOMB.solveKnob(Directions.DOWN, false, true, true, true, false));
		assertEquals(Directions.LEFT, DEFAULT_BOMB.solveKnob(Directions.LEFT, false, true, true, true, false));
		assertEquals(Directions.RIGHT, DEFAULT_BOMB.solveKnob(Directions.RIGHT, false, true, true, true, false));
	}

}
