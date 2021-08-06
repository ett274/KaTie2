package modules;

import static org.junit.Assert.*;

import org.junit.Test;

import modules.Button.Solution;

/** Tests for the Button class
 * 
 * @author Eliza Thornton
 *
 */
public class ButtonTest {

	/** Tests constructing a Button and throwing exceptions
	 * 
	 */
	@Test
	public void testButton() {
		Button button1 = null;
		try {
			button1 = new Button((byte)2, false, false);
		} catch (IllegalArgumentException e) {
			fail("Unexpected IllegalArgumentException");
		}
		try {
			button1.solve(Colors.BLUE, null);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Text cannot be null", e.getMessage());
		}
		try {
			button1.solve(Colors.BLUE, " ");
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Text cannot be blank", e.getMessage());
		}
		try {
			button1.solve(null, "hold");
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Color cannot be null", e.getMessage());
		}
		Button button2 = null;
		try {
			button2 = new Button((byte)-1, false, false);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Batteries must be a positive number", e.getMessage());
		}
		assertNull(button2);
	}

	/** Tests solving a Button
	 * 
	 */
	@Test
	public void testSolve() {
		Button button1 = new Button((byte)1, false, false);
		assertEquals(Solution.HOLD, button1.solve(Colors.BLUE, "Abort"));
		Button button2 = new Button((byte)2, false, false);
		assertEquals(Solution.PRESS, button2.solve(Colors.RED, "Detonate"));
		Button button3 = new Button((byte)2, false, true);
		assertEquals(Solution.HOLD, button3.solve(Colors.WHITE, "Abort"));
		Button button4 = new Button((byte)4, true, false);
		assertEquals(Solution.PRESS, button4.solve(Colors.RED, "Abort"));
		Button button5 = new Button((byte)0, false, false);
		assertEquals(Solution.HOLD, button5.solve(Colors.YELLOW, "Abort"));
		Button button6 = new Button((byte)0, false, false);
		assertEquals(Solution.PRESS, button6.solve(Colors.RED, "Hold"));
		Button button7 = new Button((byte)0, false, false);
		assertEquals(Solution.HOLD, button7.solve(Colors.BLUE, "Hold"));
	}

	/** Tests solving a held Button
	 * 
	 */
	@Test
	public void testHold() {
		assertEquals('4', Button.hold(Colors.BLUE));
		assertEquals('5', Button.hold(Colors.YELLOW));
		assertEquals('1', Button.hold(Colors.WHITE));
		assertEquals('1', Button.hold(Colors.RED));
	}

}
