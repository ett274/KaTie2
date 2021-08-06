/**
 * 
 */
package modules;

import java.util.HashMap;

/** Class representation of the needy Knob module
 * @author Eliza Thornton
 *
 */
public class Knob {
	
	/** Adjusts the direction of the knob based on where the UP label is
	 * 
	 */
	private final HashMap<Directions, Directions> directions;

	/** Represents the directions of the knob
		 * @author Eliza Thornton
		 *
		 */
	public enum Directions {
		/** Represents up */
		UP,
		/** Represents down */
		DOWN,
		/** Represents right */
		RIGHT,
		/** Represents left */
		LEFT
	}
	
	/** Constructs a new Knob
	 * 
	 * @param upLabel where the up label is on the knob
	 */
	public Knob(Directions upLabel) {
		this.directions = new HashMap<Directions, Directions>(4);
		switch(upLabel) {
			case UP:
				directions.put(Directions.UP, Directions.UP);
				directions.put(Directions.DOWN, Directions.DOWN);
				directions.put(Directions.LEFT, Directions.LEFT);
				directions.put(Directions.RIGHT, Directions.RIGHT);
				break;
			case DOWN:
				directions.put(Directions.UP, Directions.DOWN);
				directions.put(Directions.DOWN, Directions.UP);
				directions.put(Directions.LEFT, Directions.RIGHT);
				directions.put(Directions.RIGHT, Directions.LEFT);
				break;
			case RIGHT:
				directions.put(Directions.UP, Directions.RIGHT);
				directions.put(Directions.DOWN, Directions.LEFT);
				directions.put(Directions.LEFT, Directions.UP);
				directions.put(Directions.RIGHT, Directions.DOWN);
				break;
			case LEFT:
				directions.put(Directions.UP, Directions.LEFT);
				directions.put(Directions.DOWN, Directions.RIGHT);
				directions.put(Directions.LEFT, Directions.DOWN);
				directions.put(Directions.RIGHT, Directions.UP);
				break;
			default:
				throw new IllegalArgumentException("Invalid up label");
		}
	}
	
	/** Returns which direction to turn the knob based on which lights are on
	 * 
	 * **ONLY APPLIES TO THE LIGHTS ON THE LEFT SIDE**
	 * 
	 * @param topLeft if the light on the top left side is on
	 * @param bottomLeft if the light on the bottom left side is on
	 * @param bottomRight if the light on the bottom right is on
	 * @param middleBottom if the light on the middle bottom is on
	 * @param middleTop if the light on the middle top is on
	 * @return the direction to turn the knob; don't need to pay attention to the UP label
	 */
	public Directions solve(boolean topLeft, boolean bottomLeft, boolean bottomRight, boolean middleBottom, boolean middleTop) {
		if (topLeft) {
			if (bottomLeft) {
				return directions.get(Directions.RIGHT);
			} else {
				if (bottomRight) {
					return directions.get(Directions.UP);
				} else {
					return directions.get(Directions.DOWN);
				}
			}
		} else {
			if (middleBottom) {
				if (middleTop) {
					return directions.get(Directions.DOWN);
				} else {
					return directions.get(Directions.UP);
				}
			} else {
				return directions.get(Directions.LEFT);
			}
		}
	}
	

	
}
