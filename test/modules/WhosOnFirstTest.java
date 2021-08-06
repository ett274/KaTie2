/**
 * 
 */
package modules;

import static org.junit.Assert.*;

import org.junit.Test;

/** Test class for Who's On First
 * @author Eliza Thornton
 *
 */
public class WhosOnFirstTest {

	/**
	 * Test method for finding the button to read
	 */
	@Test
	public void testFindRead() {
		WhosOnFirst whos = new WhosOnFirst();
		String[] buttons = new String[6];
		buttons[0] = "top left";
		buttons[1] = "top right";
		buttons[2] = "middle left";
		buttons[3] = "middle right";
		buttons[4] = "bottom left";
		buttons[5] = "bottom right";
		assertEquals("middle left", whos.findRead("YES", buttons));
		assertEquals("top right", whos.findRead("FIRST", buttons));
		assertEquals("bottom right", whos.findRead("DISPLAY", buttons));
		assertEquals("top right", whos.findRead("OKAY", buttons));
		assertEquals("bottom right", whos.findRead("SAYS", buttons));
		assertEquals("middle left", whos.findRead("NOTHING", buttons));
		assertEquals("bottom left", whos.findRead("  ", buttons));
		assertEquals("middle right", whos.findRead("BLANK", buttons));
		assertEquals("bottom right", whos.findRead("NO", buttons));
		assertEquals("middle left", whos.findRead("LED", buttons));
		assertEquals("bottom right", whos.findRead("LEAD", buttons));
		assertEquals("middle right", whos.findRead("READ", buttons));
		assertEquals("middle right", whos.findRead("RED", buttons));
		assertEquals("bottom left", whos.findRead("REED", buttons));
		assertEquals("bottom left", whos.findRead("LEED", buttons));
		assertEquals("bottom right", whos.findRead("HOLD ON", buttons));
		assertEquals("middle right", whos.findRead("YOU", buttons));
		assertEquals("bottom right", whos.findRead("YOU ARE", buttons));
		assertEquals("middle right", whos.findRead("YOUR", buttons));
		assertEquals("middle right", whos.findRead("YOU'RE", buttons));
		assertEquals("top left", whos.findRead("UR", buttons));
		assertEquals("bottom right", whos.findRead("THERE", buttons));
		assertEquals("bottom left", whos.findRead("THEY'RE", buttons));
		assertEquals("middle right", whos.findRead("THEIR", buttons));
		assertEquals("middle left", whos.findRead("THEY ARE", buttons));
		assertEquals("bottom right", whos.findRead("SEE", buttons));
		assertEquals("top right", whos.findRead("C", buttons));
		assertEquals("bottom right", whos.findRead("CEE", buttons));
		
		assertEquals("middle left", whos.findRead("yes", buttons));
	}
	
	/** Tests throwing exceptions in the read method
	 * 
	 */
	@Test
	public void testInvalidRead() {
		WhosOnFirst whos = new WhosOnFirst();
		String[] buttons = new String[6];
		buttons[0] = "top left";
		buttons[1] = "top right";
		buttons[2] = "middle left";
		buttons[3] = "middle right";
		buttons[4] = "bottom left";
		buttons[5] = "bottom right";
		try {
			whos.findRead(null, buttons);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Display cannot be null", e.getMessage());
		}
		String[] shortButtons = new String[3];
		
		try {
			whos.findRead("BLANK", shortButtons);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Must have six button inputs", e.getMessage());
		}
		try {
			whos.findRead("BAD", buttons);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid display", e.getMessage());
		}
	}

	/**
	 * Tests finding the button to push with Who's On First
	 */
	@Test
	public void testFindButton() {
		String[] buttons = new String[6];
		buttons[0] = "BLANK";
		buttons[1] = "READY";
		buttons[2] = "MIDDLE";
		buttons[3] = "wait";
		buttons[4] = "UHHH";
		buttons[5] = "FIRST";
		assertEquals("MIDDLE", WhosOnFirst.findButton("READY", buttons));
		assertEquals("MIDDLE", WhosOnFirst.findButton("FIRST", buttons));
		buttons[1] = "NO";
		assertEquals("BLANK", WhosOnFirst.findButton("NO", buttons));
		assertEquals("WAIT", WhosOnFirst.findButton("BLANK", buttons));
		buttons[1] = "NOTHING";
		assertEquals("UHHH", WhosOnFirst.findButton("NOTHING", buttons));
		buttons[1] = "YES";
		assertEquals("UHHH", WhosOnFirst.findButton("YES", buttons));
		buttons[1] = "WHAT";
		assertEquals("UHHH", WhosOnFirst.findButton("WHAT", buttons));
		assertEquals("WHAT", WhosOnFirst.findButton("UHHH", buttons));
		buttons[1] = "LEFT";
		assertEquals("LEFT", WhosOnFirst.findButton("LEFT", buttons));
		buttons[1] = "RIGHT";
		assertEquals("WAIT", WhosOnFirst.findButton("RIGHT", buttons));
		assertEquals("BLANK", WhosOnFirst.findButton("MIDDLE", buttons));
		buttons[1] = "OKAY";
		assertEquals("MIDDLE", WhosOnFirst.findButton("OKAY", buttons));
		assertEquals("UHHH", WhosOnFirst.findButton("WAIT", buttons));
		buttons[1] = "PRESS";
		assertEquals("MIDDLE", WhosOnFirst.findButton("PRESS", buttons));
		buttons[1] = "YOU";
		assertEquals("YOU", WhosOnFirst.findButton("YOU", buttons));
		buttons[1] = "YOU ARE";
		assertEquals("YOU ARE", WhosOnFirst.findButton("YOU ARE", buttons));
		buttons[1] = "YOUR";
		assertEquals("YOUR", WhosOnFirst.findButton("YOUR", buttons));
		buttons[1] = "YOU'RE";
		assertEquals("YOU'RE", WhosOnFirst.findButton("YOU'RE", buttons));
		buttons[1] = "UR";
		assertEquals("UR", WhosOnFirst.findButton("UR", buttons));
		buttons[1] = "U";
		assertEquals("U", WhosOnFirst.findButton("U", buttons));
		assertEquals("UH HUH", WhosOnFirst.findButton("UH HUH", buttons));
		buttons[1] = "UH UH";
		assertEquals("UH UH", WhosOnFirst.findButton("UH UH", buttons));
		buttons[1] = "WHAT?";
		assertEquals("WHAT?", WhosOnFirst.findButton("WHAT?", buttons));
		buttons[1] = "DONE";
		assertEquals("DONE", WhosOnFirst.findButton("DONE", buttons));
		buttons[1] = "NEXT";
		assertEquals("NEXT", WhosOnFirst.findButton("NEXT", buttons));
		buttons[1] = "HOLD";
		assertEquals("HOLD", WhosOnFirst.findButton("HOLD", buttons));
		buttons[1] = "SURE";
		assertEquals("SURE", WhosOnFirst.findButton("SURE", buttons));
		buttons[1] = "SURE";
		assertEquals("SURE", WhosOnFirst.findButton("SURE", buttons));
		
	}
	
	/** Tests throwing exceptions with the findButton method
	 * 
	 */
	@Test
	public void testInvalidButton() {
		String[] buttons = new String[6];
		buttons[0] = "BLANK";
		buttons[1] = "READY";
		buttons[2] = "MIDDLE";
		buttons[3] = "WAIT";
		buttons[4] = "UHHH";
		buttons[5] = "FIRST";
		try {
			WhosOnFirst.findButton(null, buttons);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("The found button cannot be null", e.getMessage());
		}
		String[] shortButtons = new String[4];
		try {
			WhosOnFirst.findButton("YOU", shortButtons);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Must have six button inputs", e.getMessage());
		}
		try {
			WhosOnFirst.findButton("BAD", buttons);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid found button", e.getMessage());
		}
		try {
			WhosOnFirst.findButton("LIKE", buttons);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Error finding correct button", e.getMessage());
		}
		
	}

}
