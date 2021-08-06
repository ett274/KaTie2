/**
 * 
 */
package modules;

/** Class representing the Button module
 * @author Eliza Thornton
 *
 */
public class Button {
	
	/** The values of the solutions of solve()
		 * @author Eliza Thornton
		 *
		 */
	public enum Solution {
		/** Press and release the button */
		PRESS,
		
		/** Hold the button and refer to hold() */
		HOLD

	}
	
	/** The number of batteries on the bomb */
	private final byte batteries;
	
	/** If there is a lit indicator labeled FRK on the bomb */
	private final boolean frk;
	
	/** If there is a lit indicator labeled CAR on the bomb */
	private final boolean car;
	
	
	
	/** Constructor for a button
	 * 
	 * @param batteries the number of batteries on the bomb
	 * @param frk if there is a lit indicator labeled FRK on the bomb
	 * @param car if there is a lit indicator labeled CAR on the bomb
	 */
	public Button(byte batteries, boolean frk, boolean car) {
		if (batteries < 0) {
			throw new IllegalArgumentException("Batteries must be a positive number");
		}
		this.batteries = batteries;
		this.frk = frk;
		this.car = car;
	}

	/** Gives instructions on how to defuse the button module
	 * 
	 * 	@param color the color of the button
	 *  @param text the text on the button
	 *  @return either "Hold" or "Press and Release"
	 */
	public Solution solve(Colors color, String text) {
		if (text == null) {
			throw new IllegalArgumentException("Text cannot be null");
		} else if (text.isBlank()) {
			throw new IllegalArgumentException("Text cannot be blank");
		}
		if (color == null) {
			throw new IllegalArgumentException("Color cannot be null");
		}
		if (Colors.BLUE.equals(color) && "abort".equalsIgnoreCase(text)) {
			return Solution.HOLD;
		} else if (batteries > 1 && "detonate".equalsIgnoreCase(text)) {
			return Solution.PRESS;
		} else if (car && Colors.WHITE.equals(color)) {
			return Solution.HOLD;
		} else if (frk && batteries > 2) {
			return Solution.PRESS;
		} else if (Colors.YELLOW.equals(color)) {
			return Solution.HOLD;
		} else if (Colors.RED.equals(color) && "hold".equalsIgnoreCase(text)) {
			return Solution.PRESS;
		} else {
			return Solution.HOLD;
		}
	}
	
	/** Gives instructions on when to release a held button
	 * 
	 * @param colorStrip the color of the light next to the button
	 * @return the number on the timer that should be present to release the button
	 */
	public static char hold(Colors colorStrip) {
		switch(colorStrip) {
			case BLUE:
				return '4';
			case YELLOW:
				return '5';
			default:
				return '1';
		}
	}

}
