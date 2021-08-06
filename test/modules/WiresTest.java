/**
 * 
 */
package modules;

import static org.junit.Assert.*;

import org.junit.Test;

/** Test class for the wires module
 * @author Eliza Thornton
 *
 */
public class WiresTest {

	/**
	 * Tests constructing a wires object and throwing invalid length exceptions
	 */
	@Test
	public void testWires() {
		Wires wire1 = null;
		try {
			wire1 = new Wires(true);
		} catch (IllegalArgumentException e){
			fail("Unexpected IllegalArgumentException");
		}

		Colors[] badColors = {Colors.RED};
		Colors[] longColors = {Colors.RED, Colors.RED, Colors.RED, Colors.RED, Colors.RED, Colors.RED, Colors.RED};
		try  {
			wire1.getInstructions(badColors);
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid number of wires", e.getMessage());
		}
		try  {
			wire1.getInstructions(longColors);
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid number of wires", e.getMessage());
		}
	}

	/**
	 * Tests counting items in an array
	 */
	@Test
	public void testCountItems() {
		Wires wires = new Wires(true);
		Colors[] test1 = new Colors[4];
		test1[0] = Colors.RED;
		test1[1] = Colors.BLUE;
		test1[2] = Colors.RED;
		test1[3] = Colors.YELLOW;
		assertEquals(2, wires.countItems(test1, Colors.RED));
		assertEquals(1, wires.countItems(test1, Colors.BLUE));
		assertEquals(1, wires.countItems(test1, Colors.YELLOW));
		assertEquals(0, wires.countItems(test1, Colors.WHITE));
		
	}

	/**
	 * Tests solving for instructions with three wires
	 */
	@Test
	public void testGetInstructions3() {
		Wires wires1 = new Wires(false);
		Colors[] testthree1 = new Colors[3];
		testthree1[0] = Colors.WHITE;
		testthree1[1] = Colors.BLUE;
		testthree1[2] = Colors.YELLOW;
		assertEquals("second", wires1.getInstructions(testthree1));
		Colors[] testthree2 = new Colors[3];
		testthree2[0] = Colors.RED;
		testthree2[1] = Colors.BLUE;
		testthree2[2] = Colors.WHITE;
		assertEquals("last", wires1.getInstructions(testthree2));
		Colors[] testthree3 = new Colors[3];
		testthree3[0] = Colors.RED;
		testthree3[1] = Colors.BLUE;
		testthree3[2] = Colors.BLUE;
		assertEquals("last blue", wires1.getInstructions(testthree3));
		Colors[] testthree4 = new Colors[3];
		testthree4[0] = Colors.RED;
		testthree4[1] = Colors.BLUE;
		testthree4[2] = Colors.YELLOW;
		assertEquals("last", wires1.getInstructions(testthree4));
	}
	
	/**
	 * Tests solving for instructions with four wires
	 */
	@Test
	public void testGetInstructions4() {
		Wires wirest = new Wires(true);
		Wires wiresf = new Wires(false);
		Colors[] testfour1 = new Colors[4];
		testfour1[0] = Colors.RED;
		testfour1[1] = Colors.RED;
		testfour1[2] = Colors.YELLOW;
		testfour1[3] = Colors.WHITE;
		assertEquals("last red", wirest.getInstructions(testfour1));
		assertEquals("second", wiresf.getInstructions(testfour1));
		Colors[] testfour2 = new Colors[4];
		testfour2[0] = Colors.BLUE;
		testfour2[1] = Colors.BLUE;
		testfour2[2] = Colors.YELLOW;
		testfour2[3] = Colors.YELLOW;
		assertEquals("first", wirest.getInstructions(testfour2));
		assertEquals("first", wiresf.getInstructions(testfour2));
		Colors[] testfour3 = new Colors[4];
		testfour3[0] = Colors.BLUE;
		testfour3[1] = Colors.RED;
		testfour3[2] = Colors.YELLOW;
		testfour3[3] = Colors.WHITE;
		assertEquals("first", wirest.getInstructions(testfour3));
		assertEquals("first", wiresf.getInstructions(testfour3));
		Colors[] testfour4 = new Colors[4];
		testfour4[0] = Colors.YELLOW;
		testfour4[1] = Colors.RED;
		testfour4[2] = Colors.YELLOW;
		testfour4[3] = Colors.WHITE;
		assertEquals("last", wirest.getInstructions(testfour4));
		assertEquals("last", wiresf.getInstructions(testfour4));
		Colors[] testfour5 = new Colors[4];
		testfour5[0] = Colors.BLACK;
		testfour5[1] = Colors.RED;
		testfour5[2] = Colors.YELLOW;
		testfour5[3] = Colors.WHITE;
		assertEquals("second", wirest.getInstructions(testfour5));
		assertEquals("second", wiresf.getInstructions(testfour5));

	}
	
	/**
	 * Tests solving for instructions with five wires
	 */
	@Test
	public void testGetInstructions5() {
		Wires wirest = new Wires(true);
		Wires wiresf = new Wires(false);
		Colors[] testfive1 = new Colors[5];
		testfive1[0] = Colors.RED;
		testfive1[1] = Colors.WHITE;
		testfive1[2] = Colors.BLUE;
		testfive1[3] = Colors.YELLOW;
		testfive1[4] = Colors.BLACK;
		assertEquals("fourth", wirest.getInstructions(testfive1));
		assertEquals("first", wiresf.getInstructions(testfive1));
		Colors[] testfive2 = new Colors[5];
		testfive2[0] = Colors.RED;
		testfive2[1] = Colors.WHITE;
		testfive2[2] = Colors.BLUE;
		testfive2[3] = Colors.YELLOW;
		testfive2[4] = Colors.YELLOW;
		assertEquals("first", wirest.getInstructions(testfive2));
		assertEquals("first", wiresf.getInstructions(testfive2));
		Colors[] testfive3 = new Colors[5];
		testfive3[0] = Colors.RED;
		testfive3[1] = Colors.RED;
		testfive3[2] = Colors.BLUE;
		testfive3[3] = Colors.YELLOW;
		testfive3[4] = Colors.BLUE;
		assertEquals("second", wirest.getInstructions(testfive3));
		assertEquals("second", wiresf.getInstructions(testfive3));
		Colors[] testfive4 = new Colors[5];
		testfive4[0] = Colors.RED;
		testfive4[1] = Colors.RED;
		testfive4[2] = Colors.BLACK;
		testfive4[3] = Colors.YELLOW;
		testfive4[4] = Colors.BLUE;
		assertEquals("first", wirest.getInstructions(testfive4));
		assertEquals("first", wiresf.getInstructions(testfive4));

	}
	
	/**
	 * Tests solving for instructions with five wires
	 */
	@Test
	public void testGetInstructions6() {
		Wires wirest = new Wires(true);
		Wires wiresf = new Wires(false);
		Colors[] testsix1 = new Colors[6];
		testsix1[0] = Colors.RED;
		testsix1[1] = Colors.BLACK;
		testsix1[2] = Colors.WHITE;
		testsix1[3] = Colors.BLUE;
		testsix1[4] = Colors.BLACK;
		testsix1[5] = Colors.BLUE;
		assertEquals("third", wirest.getInstructions(testsix1));
		assertEquals("fourth", wiresf.getInstructions(testsix1));
		Colors[] testsix2 = new Colors[6];
		testsix2[0] = Colors.RED;
		testsix2[1] = Colors.BLACK;
		testsix2[2] = Colors.WHITE;
		testsix2[3] = Colors.WHITE;
		testsix2[4] = Colors.BLACK;
		testsix2[5] = Colors.YELLOW;
		assertEquals("fourth", wirest.getInstructions(testsix2));
		assertEquals("fourth", wiresf.getInstructions(testsix2));
		Colors[] testsix3 = new Colors[6];
		testsix3[0] = Colors.BLUE;
		testsix3[1] = Colors.BLACK;
		testsix3[2] = Colors.WHITE;
		testsix3[3] = Colors.BLACK;
		testsix3[4] = Colors.BLACK;
		testsix3[5] = Colors.YELLOW;
		assertEquals("last", wirest.getInstructions(testsix3));
		assertEquals("last", wiresf.getInstructions(testsix3));
		Colors[] testsix4 = new Colors[6];
		testsix4[0] = Colors.BLUE;
		testsix4[1] = Colors.BLACK;
		testsix4[2] = Colors.WHITE;
		testsix4[3] = Colors.RED;
		testsix4[4] = Colors.BLACK;
		testsix4[5] = Colors.YELLOW;
		assertEquals("fourth", wirest.getInstructions(testsix4));
		assertEquals("fourth", wiresf.getInstructions(testsix4));


	}

}
