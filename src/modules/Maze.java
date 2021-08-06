/**
 * 
 */
package modules;

import java.util.LinkedList;

/** Class representation of the maze module
 * @author Eliza Thornton
 *
 */
public class Maze {

	/** Enumeration used for the previous direction
		 * @author Eliza Thornton
		 *
		 */
	private enum PrevDirection {
	   /** Represents the start */
       START,
       /** Represents the up direction */
       UP,
       /** Represents the down direction */
       DOWN,
       /** Represents the left direction */
       LEFT,
       /** Represents the right direction */
       RIGHT
	}

	/** The first maze with circles at 1,5 and 6,4 */
	private static final String[][] MAZE_1 = {{"rd", "lr", "ld", "rd", "lr", "l"},
			{"ud", "rd", "ul", "ur", "lr", "ld"},
			{"ud", "ur", "ld", "rd", "lr", "uld"},
			{"ud", "r", "ulr", "ul", "r", "uld"},
			{"urd", "lr", "ld", "rd", "l", "ud"},
			{"ur", "l", "ur", "ul", "r", "ul"}};
	
	/** The second maze with circles at 2,3 and 5,5 */
	private static final String[][] MAZE_2 = {{"r", "lrd", "l", "rd", "lrd", "l"},
			{"rd", "ul", "rd", "ul", "ur", "ld"},
			{"ud", "rd", "ul", "rd", "lr", "uld"},
			{"urd", "ul", "rd", "ul", "d", "ud"},
			{"ud", "d", "ud", "rd", "ul", "ud"},
			{"u", "ur", "ul", "ur", "lr", "ul"}};

	/** The third maze with circles at 4,3 and 6,3 */
	private static final String[][] MAZE_3 = {{"rd", "lr", "ld", "d", "rd", "ld"},
			{"u", "d", "ud", "ur", "ul", "ud"},
			{"rd", "uld", "ud", "rd", "ld", "ud"},
			{"ud", "ud", "ud", "ud", "ud", "ud"},
			{"ud", "ur", "ul", "ud", "ud", "ud"},
			{"ur", "lr", "lr", "ul", "ur", "ul"}};
	
	/** The fourth maze with circles at 1,3 and 1,6 */
	private static final String[][] MAZE_4 = {{"rd", "ld", "r", "lr", "lr", "ld"},
			{"ud", "ud", "rd", "lr", "lr", "uld"},
			{"ud", "ur", "ul", "rd", "l", "ud"},
			{"ud", "r", "lr", "ulr", "lr", "uld"},
			{"urd", "lr", "lr", "lr", "ld", "ud"},
			{"ur", "lr", "l", "r", "ul", "u"}};
	
	/** The fifth maze with circles at 4,1 and 5,4 */
	private static final String[][] MAZE_5 = {{"r", "lr", "lr", "lr", "lrd", "ld"},
			{"rd", "lr", "lr", "lrd", "ul", "u"},
			{"urd", "ld", "r", "ul", "rd", "ld"},
			{"ud", "ur", "lr", "ld", "u", "ud"},
			{"ud", "rd", "lr", "ulr", "l", "ud"},
			{"u", "ur", "lr", "lr", "lr", "ul"}};
	
	/** The sixth maze with circles at 3,2 and 5,6 */
	private static final String[][] MAZE_6 = {{"d", "rd", "ld", "r", "lrd", "ld"},
			{"ud", "ud", "ud", "rd", "ul", "ud"},
			{"urd", "ul", "u", "ud", "rd", "ul"},
			{"ur", "ld", "rd", "uld", "ud", "d"},
			{"rd", "ul", "u", "ud", "ur", "uld"},
			{"ur", "lr", "lr", "ul", "r", "ul"}};
	
	/** The seventh maze with circles at 2,1 and 2,6 */
	private static final String[][] MAZE_7 = {{"rd", "lr", "lr", "ld", "rd", "ld"},
			{"ud", "rd", "l", "ur", "ul", "ud"},
			{"ur", "ul", "rd", "l", "rd", "ul"},
			{"rd", "ld", "urd", "lr", "ul", "d"},
			{"ud", "u", "ur", "lr", "ld", "ud"},
			{"ur", "lr", "lr", "lr", "ulr", "ul"}};
	
	/** The eighth maze with circles at 3,3 and 4,6 */
	private static final String[][] MAZE_8 = {{"d", "rd", "lr", "ld", "rd", "ld"},
			{"urd", "ulr", "l", "ur", "ul", "ud"},
			{"ud", "rd", "lr", "lr", "ld", "ud"},
			{"ud", "ur", "ld", "r", "ulr", "ul"},
			{"ud", "d", "ur", "lr", "lr", "l"},
			{"ur", "ulr", "lr", "lr", "lr", "l"}};
	
	/** The ninth maze with circles at 1,2 and 3,5 */
	private static final String[][] MAZE_9 = {{"d", "rd", "lr", "lr", "lrd", "ld"},
			{"ud", "ud", "rd", "l", "ud", "ud"},
			{"urd", "ulr", "ul", "rd", "ul", "ud"},
			{"ud", "d", "rd", "ul", "r", "uld"},
			{"ud", "ud", "ud", "rd", "ld", "u"},
			{"ur", "ul", "ur", "ul", "ur", "l"}};
	 
	
	/** Finds the assigned maze based on the coordinates of the green circles
	 * 
	 * @param x1 x coordinate of the first circle
	 * @param y1 y coordinate of the first circle
	 * @param x2 x coordinate of the second circle
	 * @param y2 y coordinate of the second circle
	 * @return a 2D string array representing the maze
	 */
	public static String[][] mazeFinder(byte x1, byte y1, byte x2, byte y2) {
		if (x1 == 1 && y1 == 5 && x2 == 6 && y2 == 4 || x1 == 6 && y1 == 4 && x2 == 1 && y2 == 5) {
			return MAZE_1;
		} else if (x1 == 2 && y1 == 3 && x2 == 5 && y2 == 5 || x1 == 5 && y1 == 5 && x2 == 2 && y2 == 3) {
			return MAZE_2;
		} else if (x1 == 4 && y1 == 3 && x2 == 6 && y2 == 3 || x1 == 6 && y1 == 3 && x2 == 4 && y2 == 3) {
			return MAZE_3;
		} else if (x1 == 1 && y1 == 3 && x2 == 1 && y2 == 6 || x1 == 1 && y1 == 6 && x2 == 1 && y2 == 3) {
			return MAZE_4;
		} else if (x1 == 4 && y1 == 1 && x2 == 5 && y2 == 4 || x1 == 5 && y1 == 4 && x2 == 4 && y2 == 1) {
			return MAZE_5;
		} else if (x1 == 3 && y1 == 2 && x2 == 5 && y2 == 6 || x1 == 5 && y1 == 6 && x2 == 3 && y2 == 2) {
			return MAZE_6;
		} else if (x1 == 2 && y1 == 1 && x2 == 2 && y2 == 6 || x1 == 2 && y1 == 6 && x2 == 2 && y2 == 1) {
			return MAZE_7;
		} else if (x1 == 3 && y1 == 3 && x2 == 4 && y2 == 6 || x1 == 4 && y1 == 6 && x2 == 3 && y2 == 3) {
			return MAZE_8;
		} else if (x1 == 1 && y1 == 2 && x2 == 3 && y2 == 5 || x1 == 3 && y1 == 5 && x2 == 1 && y2 == 2) {
			return MAZE_9;
		} else {
			throw new IllegalArgumentException("Invalid circle positions");
		}
	}
	
	/** Returns the instructions of how to traverse the maze
	 * 
	 * @param maze the maze to traverse
	 * @param startX the starting x
	 * @param startY the starting y
	 * @param goalX the goal x
	 * @param goalY the goal y
	 * @return the intstructions stirng
	 */
	public static String solve(String[][] maze, byte startX, byte startY, byte goalX, byte goalY) {
		String solution = traverse(maze, startX, startY, goalX, goalY, new LinkedList<String>(), PrevDirection.START).toString();
		return solution.substring(1, solution.length() - 1);
	}
	/** Main method for traversing a maze; kind of uses recursion?
	 * 
	 * @param maze the maze being traversed
	 * @param currentX x coordinate of the current position
	 * @param currentY y coordinate of the current position
	 * @param goalX x coordinate of the goal
	 * @param goalY y coordinate of the goal
	 * @param pathList a list of the current paths taken
	 * @param previousDirection the previous direction traveled
	 * @return a list of Strings showing the shortest path to the goal
	 */
	private static LinkedList<String> traverse(String[][] maze, byte currentX, byte currentY, byte goalX, byte goalY, LinkedList<String> pathList, PrevDirection previousDirection) {
		if (currentX == goalX && currentY == goalY) {
			return pathList;
		}
		LinkedList<LinkedList<String>> directionList = new LinkedList<LinkedList<String>>();
		switch(previousDirection) {
			case START:
				try {
					directionList.add(moveRight(maze, currentX, currentY, goalX, goalY, pathList));
				} catch (NullPointerException e) {
					//skipping
				}
				try {
					directionList.add(moveLeft(maze, currentX, currentY, goalX, goalY, pathList));
				} catch (NullPointerException e) {
					//skipping
				}
				try {
					directionList.add(moveUp(maze, currentX, currentY, goalX, goalY, pathList));
				} catch (NullPointerException e) {
					//skipping
				}
				try {
					directionList.add(moveDown(maze, currentX, currentY, goalX, goalY, pathList));
				} catch (NullPointerException e) {
					//skipping
				}
				break;
			case LEFT:
				try {
					directionList.add(moveLeft(maze, currentX, currentY, goalX, goalY, pathList));
				} catch (NullPointerException e) {
					//skipping
				}
				try {
					directionList.add(moveUp(maze, currentX, currentY, goalX, goalY, pathList));
				} catch (NullPointerException e) {
					//skipping
				}
				try {
					directionList.add(moveDown(maze, currentX, currentY, goalX, goalY, pathList));
				} catch (NullPointerException e) {
					//skipping
				}
				break;
			case RIGHT:
				try {
					directionList.add(moveRight(maze, currentX, currentY, goalX, goalY, pathList));
				} catch (NullPointerException e) {
					//skipping
				}
				try {
					directionList.add(moveUp(maze, currentX, currentY, goalX, goalY, pathList));
				} catch (NullPointerException e) {
					//skipping
				}
				try {
					directionList.add(moveDown(maze, currentX, currentY, goalX, goalY, pathList));
				} catch (NullPointerException e) {
					//skipping
				}
				break;
			case UP:
				try {
					directionList.add(moveRight(maze, currentX, currentY, goalX, goalY, pathList));
				} catch (NullPointerException e) {
					//skipping
				}
				try {
					directionList.add(moveLeft(maze, currentX, currentY, goalX, goalY, pathList));
				} catch (NullPointerException e) {
					//skipping
				}
				try {
					directionList.add(moveUp(maze, currentX, currentY, goalX, goalY, pathList));
				} catch (NullPointerException e) {
					//skipping
				}
				break;
			case DOWN:
				try {
					directionList.add(moveRight(maze, currentX, currentY, goalX, goalY, pathList));
				} catch (NullPointerException e) {
					//skipping
				}
				try {
					directionList.add(moveLeft(maze, currentX, currentY, goalX, goalY, pathList));
				} catch (NullPointerException e) {
					//skipping
				}
				try {
					directionList.add(moveDown(maze, currentX, currentY, goalX, goalY, pathList));
				} catch (NullPointerException e) {
					//skipping
				}
				break;
			default:
				throw new IllegalArgumentException("Invalid previous direction");
		}
		LinkedList<String> shortestList = null;
		directionList.removeIf(list -> list == null || list.isEmpty());
		if (directionList.isEmpty()) {
			return null;
		} else {
			shortestList = directionList.getFirst();
		}
		for (LinkedList<String> list : directionList) {
			if (list.size() < shortestList.size()) {
				shortestList = list;
			}
		}
		return shortestList;
		
	}
	
	private static LinkedList<String> moveRight(String[][] maze, byte currentX, byte currentY, byte goalX, byte goalY, LinkedList<String> pathList) {
		if (currentX == 5 || !maze[currentY][currentX].contains("r")) {
			return null;
		}
		LinkedList<String> newList = new LinkedList<String>();
		newList.addAll(pathList);
		newList.add("right");
		return traverse(maze, (byte)(currentX + 1), currentY, goalX, goalY, newList, PrevDirection.RIGHT);
	}
	
	private static LinkedList<String> moveLeft(String[][] maze, byte currentX, byte currentY, byte goalX, byte goalY, LinkedList<String> pathList) {
		if (currentX == 0 || !maze[currentY][currentX].contains("l")) {
			return null;
		}
		LinkedList<String> newList = new LinkedList<String>();
		newList.addAll(pathList);
		newList.add("left");
		return traverse(maze, (byte)(currentX - 1), currentY, goalX, goalY, newList, PrevDirection.LEFT);
	}
	
	private static LinkedList<String> moveUp(String[][] maze, byte currentX, byte currentY, byte goalX, byte goalY, LinkedList<String> pathList) {
		if (currentY == 0 || !maze[currentY][currentX].contains("u")) {
			return null;
		}
		LinkedList<String> newList = new LinkedList<String>();
		newList.addAll(pathList);
		newList.add("up");
		return traverse(maze, currentX, (byte)(currentY - 1), goalX, goalY, newList, PrevDirection.UP);
	}
	
	private static LinkedList<String> moveDown(String[][] maze, byte currentX, byte currentY, byte goalX, byte goalY, LinkedList<String> pathList) {
		if (currentY == 5 || !maze[currentY][currentX].contains("d")) {
			return null;
		}
		LinkedList<String> newList = new LinkedList<String>();
		newList.addAll(pathList);
		newList.add("down");
		return traverse(maze, currentX, (byte)(currentY + 1), goalX, goalY, newList, PrevDirection.DOWN);
	}
	

	
	
}
