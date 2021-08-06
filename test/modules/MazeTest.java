/**
 * 
 */
package modules;

import static org.junit.Assert.*;

import org.junit.Test;


/** Test class for the Maze module
 * @author Eliza Thornton
 *
 */
public class MazeTest {
	/** Value of one */
	private static final byte ONE = 1;
	
	/** Value of two */
	private static final byte TWO = 2;
	
	/** Value of three */
	private static final byte THREE = 3;
	
	/** Value of four */
	private static final byte FOUR = 4;
	
	/** Value of five */
	private static final byte FIVE = 5;
	
	/** Value of six */
	private static final byte SIX = 6;
	/**
	 * Test method for finding a specific maze
	 */
	@Test
	public void testMazeFinder() {
		String[][] maze1a = Maze.mazeFinder(ONE, FIVE, SIX, FOUR);
		assertEquals("rd", maze1a[0][0]);
		assertEquals("lr", maze1a[0][1]);
		assertEquals("ld", maze1a[0][2]);
		assertEquals("rd", maze1a[0][3]);
		assertEquals("lr", maze1a[0][4]);
		assertEquals("l", maze1a[0][5]);
		String[][] maze1b = Maze.mazeFinder(SIX, FOUR, ONE, FIVE);
		assertEquals("rd", maze1b[0][0]);
		assertEquals("lr", maze1b[0][1]);
		assertEquals("ld", maze1b[0][2]);
		assertEquals("rd", maze1b[0][3]);
		assertEquals("lr", maze1b[0][4]);
		assertEquals("l", maze1b[0][5]);
		
		String[][] maze2a = Maze.mazeFinder(TWO, THREE, FIVE, FIVE);
		assertEquals("r", maze2a[0][0]);
		assertEquals("lrd", maze2a[0][1]);
		assertEquals("l", maze2a[0][2]);
		assertEquals("rd", maze2a[0][3]);
		assertEquals("lrd", maze2a[0][4]);
		assertEquals("l", maze2a[0][5]);
		String[][] maze2b = Maze.mazeFinder(FIVE, FIVE, TWO, THREE);
		assertEquals("r", maze2b[0][0]);
		assertEquals("lrd", maze2b[0][1]);
		assertEquals("l", maze2b[0][2]);
		assertEquals("rd", maze2b[0][3]);
		assertEquals("lrd", maze2b[0][4]);
		assertEquals("l", maze2b[0][5]);
		
		String[][] maze3a = Maze.mazeFinder(FOUR, THREE, SIX, THREE);
		assertEquals("rd", maze3a[0][0]);
		assertEquals("lr", maze3a[0][1]);
		assertEquals("ld", maze3a[0][2]);
		assertEquals("d", maze3a[0][3]);
		assertEquals("rd", maze3a[0][4]);
		assertEquals("ld", maze3a[0][5]);
		String[][] maze3b = Maze.mazeFinder(SIX, THREE, FOUR, THREE);
		assertEquals("rd", maze3b[0][0]);
		assertEquals("lr", maze3b[0][1]);
		assertEquals("ld", maze3b[0][2]);
		assertEquals("d", maze3b[0][3]);
		assertEquals("rd", maze3b[0][4]);
		assertEquals("ld", maze3b[0][5]);
		
		String[][] maze4a = Maze.mazeFinder(ONE, THREE, ONE, SIX);
		assertEquals("rd", maze4a[0][0]);
		assertEquals("ld", maze4a[0][1]);
		assertEquals("r", maze4a[0][2]);
		assertEquals("lr", maze4a[0][3]);
		assertEquals("lr", maze4a[0][4]);
		assertEquals("ld", maze4a[0][5]);
		String[][] maze4b = Maze.mazeFinder(ONE, SIX, ONE, THREE);
		assertEquals("rd", maze4b[0][0]);
		assertEquals("ld", maze4b[0][1]);
		assertEquals("r", maze4b[0][2]);
		assertEquals("lr", maze4b[0][3]);
		assertEquals("lr", maze4b[0][4]);
		assertEquals("ld", maze4b[0][5]);
		
		String[][] maze5a = Maze.mazeFinder(FOUR, ONE, FIVE, FOUR);
		assertEquals("r", maze5a[0][0]);
		assertEquals("lr", maze5a[0][1]);
		assertEquals("lr", maze5a[0][2]);
		assertEquals("lr", maze5a[0][3]);
		assertEquals("lrd", maze5a[0][4]);
		assertEquals("ld", maze5a[0][5]);
		String[][] maze5b = Maze.mazeFinder(FIVE, FOUR, FOUR, ONE);
		assertEquals("r", maze5b[0][0]);
		assertEquals("lr", maze5b[0][1]);
		assertEquals("lr", maze5b[0][2]);
		assertEquals("lr", maze5b[0][3]);
		assertEquals("lrd", maze5b[0][4]);
		assertEquals("ld", maze5b[0][5]);
		
		String[][] maze6a = Maze.mazeFinder(THREE, TWO, FIVE, SIX);
		assertEquals("d", maze6a[0][0]);
		assertEquals("rd", maze6a[0][1]);
		assertEquals("ld", maze6a[0][2]);
		assertEquals("r", maze6a[0][3]);
		assertEquals("lrd", maze6a[0][4]);
		assertEquals("ld", maze6a[0][5]);
		String[][] maze6b = Maze.mazeFinder(FIVE, SIX, THREE, TWO);
		assertEquals("d", maze6b[0][0]);
		assertEquals("rd", maze6b[0][1]);
		assertEquals("ld", maze6b[0][2]);
		assertEquals("r", maze6b[0][3]);
		assertEquals("lrd", maze6b[0][4]);
		assertEquals("ld", maze6b[0][5]);
		
		String[][] maze7a = Maze.mazeFinder(TWO, ONE, TWO, SIX);
		assertEquals("rd", maze7a[0][0]);
		assertEquals("lr", maze7a[0][1]);
		assertEquals("lr", maze7a[0][2]);
		assertEquals("ld", maze7a[0][3]);
		assertEquals("rd", maze7a[0][4]);
		assertEquals("ld", maze7a[0][5]);
		String[][] maze7b = Maze.mazeFinder(TWO, SIX, TWO, ONE);
		assertEquals("rd", maze7b[0][0]);
		assertEquals("lr", maze7b[0][1]);
		assertEquals("lr", maze7b[0][2]);
		assertEquals("ld", maze7b[0][3]);
		assertEquals("rd", maze7b[0][4]);
		assertEquals("ld", maze7b[0][5]);
		
		String[][] maze8a = Maze.mazeFinder(THREE, THREE, FOUR, SIX);
		assertEquals("d", maze8a[0][0]);
		assertEquals("rd", maze8a[0][1]);
		assertEquals("lr", maze8a[0][2]);
		assertEquals("ld", maze8a[0][3]);
		assertEquals("rd", maze8a[0][4]);
		assertEquals("ld", maze8a[0][5]);
		String[][] maze8b = Maze.mazeFinder(FOUR, SIX, THREE, THREE);
		assertEquals("d", maze8b[0][0]);
		assertEquals("rd", maze8b[0][1]);
		assertEquals("lr", maze8b[0][2]);
		assertEquals("ld", maze8b[0][3]);
		assertEquals("rd", maze8b[0][4]);
		assertEquals("ld", maze8b[0][5]);
		
		String[][] maze9a = Maze.mazeFinder(ONE, TWO, THREE, FIVE);
		assertEquals("d", maze9a[0][0]);
		assertEquals("rd", maze9a[0][1]);
		assertEquals("lr", maze9a[0][2]);
		assertEquals("lr", maze9a[0][3]);
		assertEquals("lrd", maze9a[0][4]);
		assertEquals("ld", maze9a[0][5]);
		String[][] maze9b = Maze.mazeFinder(THREE, FIVE, ONE, TWO);
		assertEquals("d", maze9b[0][0]);
		assertEquals("rd", maze9b[0][1]);
		assertEquals("lr", maze9b[0][2]);
		assertEquals("lr", maze9b[0][3]);
		assertEquals("lrd", maze9b[0][4]);
		assertEquals("ld", maze9b[0][5]);
		
		try {
			Maze.mazeFinder(ONE, ONE, ONE, ONE);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid circle positions", e.getMessage());
		}
	}

	/**
	 * Test method for traversing a maze
	 */
	@Test
	public void testTraverse() {
		String[][] maze1 = Maze.mazeFinder(ONE, FIVE, SIX, FOUR);
        assertEquals("left, down, right, down, left", Maze.solve(maze1, TWO, ONE, ONE, THREE));
		
		String[][] maze2 = Maze.mazeFinder(TWO, THREE, FIVE, FIVE);
		assertEquals("up, right, up, right, up", Maze.solve(maze2, ONE, THREE, THREE, (byte)0));
		
		String[][] maze3 = Maze.mazeFinder(FOUR, THREE, SIX, THREE);
		assertEquals("down, down, down, left", Maze.solve(maze3, THREE, TWO, TWO, FIVE));
		
		String[][] maze4 = Maze.mazeFinder(ONE, THREE, ONE, SIX);
		assertEquals("right, up, left, left, left", Maze.solve(maze4, THREE, FIVE, ONE, FOUR));
		
		String[][] maze5 = Maze.mazeFinder(FOUR, ONE, FIVE, FOUR);
		assertEquals("up, right, down, down, down", Maze.solve(maze5, FOUR, THREE, FIVE, FIVE));
		
		String[][] maze6 = Maze.mazeFinder(THREE, TWO, FIVE, SIX);
		assertEquals("up, right, up, up, right", Maze.solve(maze6, TWO, FOUR, FOUR, ONE));
		
		String[][] maze7 = Maze.mazeFinder(TWO, ONE, TWO, SIX);
		assertEquals("left, down, left, up", Maze.solve(maze7, TWO, ONE, (byte)0, ONE));
		
		String[][] maze8 = Maze.mazeFinder(THREE, THREE, FOUR, SIX);
		assertEquals("right, up, left, left", Maze.solve(maze8, THREE, THREE, TWO, TWO));
		
		String[][] maze9 = Maze.mazeFinder(ONE, TWO, THREE, FIVE);
		assertEquals("left, up, left, down", Maze.solve(maze9, FIVE, FIVE, THREE, FIVE));
	}

}
