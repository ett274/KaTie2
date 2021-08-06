/**
 * 
 */
package modules;

import static org.junit.Assert.*;

import org.junit.Test;

import modules.Memory.Display;

/** Test class for the Memory module
 * @author Eliza Thornton
 *
 */
public class MemoryTest {

	/**
	 * Tests the method for solving stage one through four
	 */
	@Test
	public void testStageOneThroughFour() {
		Memory memory = new Memory();
		assertEquals('2', memory.stageOneThroughFour((byte)1, Display.ONE, "1234"));
		assertEquals('2', memory.stageOneThroughFour((byte)1, Display.TWO, "1234"));
		assertEquals('3', memory.stageOneThroughFour((byte)1, Display.THREE, "1234"));
		assertEquals('4', memory.stageOneThroughFour((byte)1, Display.FOUR, "1234"));
		
		assertEquals('4', memory.stageOneThroughFour((byte)2, Display.ONE, "1234"));
		assertEquals('4', memory.stageOneThroughFour((byte)2, Display.TWO, "1234"));
		assertEquals('1', memory.stageOneThroughFour((byte)2, Display.THREE, "1234"));
		assertEquals('4', memory.stageOneThroughFour((byte)2, Display.FOUR, "1234"));
		
		assertEquals('4', memory.stageOneThroughFour((byte)3, Display.ONE, "1234"));
		assertEquals('4', memory.stageOneThroughFour((byte)3, Display.TWO, "1234"));
		assertEquals('3', memory.stageOneThroughFour((byte)3, Display.THREE, "1234"));
		assertEquals('4', memory.stageOneThroughFour((byte)3, Display.FOUR, "1234"));
		
		assertEquals('4', memory.stageOneThroughFour((byte)4, Display.ONE, "1234"));
		assertEquals('1', memory.stageOneThroughFour((byte)4, Display.TWO, "1234"));
		assertEquals('4', memory.stageOneThroughFour((byte)4, Display.THREE, "1234"));
		assertEquals('4', memory.stageOneThroughFour((byte)4, Display.FOUR, "1234"));
	}

	/**
	 * Test method for solving stage five
	 */
	@Test
	public void testStageFive() {
		Memory memory = new Memory();
		assertEquals('2', memory.stageOneThroughFour((byte)1, Display.ONE, "1234"));
		assertEquals('4', memory.stageOneThroughFour((byte)2, Display.ONE, "1234"));
		assertEquals('4', memory.stageOneThroughFour((byte)3, Display.ONE, "1234"));
		assertEquals('2', memory.stageOneThroughFour((byte)4, Display.ONE, "1234"));
		
		assertEquals('2', memory.stageFive(Display.ONE));
		assertEquals('4', memory.stageFive(Display.TWO));
		assertEquals('2', memory.stageFive(Display.THREE));
		assertEquals('4', memory.stageFive(Display.FOUR));
	}
	
	/** Tests throwing exceptions with stages one through four
	 * 
	 */
	@Test
	public void testInvalidStageOneThroughFour() {
		Memory memory = new Memory();
		String buttons = "1234";
		try {
			memory.stageOneThroughFour((byte)-1, Display.ONE, buttons);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid stage", e.getMessage());
		}
		try {
			memory.stageOneThroughFour((byte)1, null, buttons);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid display", e.getMessage());
		}
		try {
			memory.stageOneThroughFour((byte)2, null, buttons);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid display", e.getMessage());
		}
		try {
			memory.stageOneThroughFour((byte)3, null, buttons);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid display", e.getMessage());
		}
		try {
			memory.stageOneThroughFour((byte)4, null, buttons);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid display", e.getMessage());
		}
		String invalidButtons = "12345";
		try {
			memory.stageOneThroughFour((byte)1, Display.ONE, invalidButtons);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Buttons must be a String of length 4", e.getMessage());
		}
		String invalidButtons2 = "abcd";
		try {
			memory.stageOneThroughFour((byte)1, Display.ONE, invalidButtons2);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid button input", e.getMessage());
		}
		String invalidButtons3 = "1235";
		try {
			memory.stageOneThroughFour((byte)1, Display.ONE, invalidButtons3);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid button input", e.getMessage());
		}
		String invalidButtons4 = "1223";
		try {
			memory.stageOneThroughFour((byte)1, Display.ONE, invalidButtons4);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid button input", e.getMessage());
		}
	}
	
	/** Tests throwing an exception with stage five
	 * 
	 */
	@Test
	public void testInvalidStageFive() {
		Memory memory = new Memory();
		try {
			memory.stageFive(Display.ONE);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Stage five not reached", e.getMessage());
		}
		
		assertEquals('2', memory.stageOneThroughFour((byte)1, Display.ONE, "1234"));
		assertEquals('4', memory.stageOneThroughFour((byte)2, Display.ONE, "1234"));
		assertEquals('4', memory.stageOneThroughFour((byte)3, Display.ONE, "1234"));
		assertEquals('2', memory.stageOneThroughFour((byte)4, Display.ONE, "1234"));
		
		try {
			memory.stageFive(null);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid display", e.getMessage());
		}
	}

}
