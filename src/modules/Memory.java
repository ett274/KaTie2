/**
 * 
 */
package modules;

/** Class representing the Memory module
 * @author Eliza Thornton
 *
 */
public class Memory {
	
	/** Represents the display of the module
		 * @author Eliza Thornton
		 *
		 */
	public enum Display {
		/** Represents the number 1 on the display */
		ONE,
		/** Represents the number 2 on the display */
		TWO,
		/** Represents the number 3 on the display */
		THREE,
		/** Represents the number 4 on the display */
		FOUR
	}

	/** Stores the label from stage one */
	private char stageOneLabel;
	
	/** Stores the position from stage one */
	private byte stageOnePosition;
	
	/** Stores the label from stage two */
	private char stageTwoLabel;
	
	/** Stores the position from stage two */
	private byte stageTwoPosition;
	
	/** Stores the label from stage three */
	private char stageThreeLabel;
	
	/** Stores the label from stage four */
	private char stageFourLabel;
	
	/** Constructs a Memory module
	 * 
	 */
	public Memory() {
		reset();
	}
	
	/** Returns which button to press for the first four stages
	 * 
	 * @param stage which stage we are in
	 * @param display which number is on display as a character
	 * @param buttons a String representing the buttons in order
	 * @return the button label to press as a character
	 */
	public char stageOneThroughFour(byte stage, Display display, String buttons) {
		if (buttons == null || buttons.length() != 4) {
			throw new IllegalArgumentException("Buttons must be a String of length 4");
		}
		if (buttons.indexOf('1') == -1 || buttons.indexOf('2') == -1 || buttons.indexOf('3') == -1 || buttons.indexOf('4') == -1) {
			throw new IllegalArgumentException("Invalid button input");
		}
		if (display == null) {
			throw new IllegalArgumentException("Invalid display");
		}
		switch (stage) {
			case 1:
				switch (display) {
					case ONE:
						stageOneLabel = buttons.charAt(1);
						stageOnePosition = 1;
						break;
					case TWO:
						stageOneLabel = buttons.charAt(1);
						stageOnePosition = 1;
						break;
					case THREE:
						stageOneLabel = buttons.charAt(2);
						stageOnePosition = 2;
						break;
					case FOUR:
						stageOneLabel = buttons.charAt(3);
						stageOnePosition = 3;
						break;
					default:
						throw new IllegalArgumentException("Invalid display");
				}
				return stageOneLabel;
			case 2:
				switch (display) {
				  case ONE:
					stageTwoLabel = '4';
					stageTwoPosition = (byte)buttons.indexOf('4');
					break;
				  case TWO:
					stageTwoLabel = buttons.charAt(stageOnePosition);
					stageTwoPosition = stageOnePosition;
					break;
				  case THREE:
					stageTwoLabel = buttons.charAt(0);
					stageTwoPosition = 0;
					break;
				  case FOUR:
					stageTwoLabel = buttons.charAt(stageOnePosition);
					stageTwoPosition = stageOnePosition;
					break;
				  default:
					throw new IllegalArgumentException("Invalid display");
				}
				return stageTwoLabel;
			case 3:
				switch (display) {
				  case ONE:
					stageThreeLabel = stageTwoLabel;
					break;
				  case TWO:
					stageThreeLabel = stageOneLabel;
					break;
				  case THREE:
					stageThreeLabel = buttons.charAt(2);
					break;
				case FOUR:
					stageThreeLabel = '4';
					break;
				default:
					throw new IllegalArgumentException("Invalid display");
				}
				return stageThreeLabel;
			case 4:
				switch (display) {
				  case ONE:
					stageFourLabel = buttons.charAt(stageOnePosition);
					break;
				  case TWO:
					stageFourLabel = buttons.charAt(0);
					break;
				  case THREE:
					stageFourLabel = buttons.charAt(stageTwoPosition);
					break;
				  case FOUR:
					stageFourLabel = buttons.charAt(stageTwoPosition);
					break;
				  default:
					throw new IllegalArgumentException("Invalid display");
			    }
				return stageFourLabel;
			default:
				throw new IllegalArgumentException("Invalid stage");
				
		}
	}
	
	/** Returns which button to push in stage 5
	 * 
	 * @param display the number on the display
	 * @return a character representing which button to press
	 */
	public char stageFive(Display display) {
		if (stageOneLabel == ' ' || stageTwoLabel == ' ' || stageThreeLabel == ' ' || stageFourLabel == ' ') {
			throw new IllegalArgumentException("Stage five not reached");
		}
		if (display == null) {
			throw new IllegalArgumentException("Invalid display");
		}
		switch (display) {
			case ONE:
				return stageOneLabel;
			case TWO:
				return stageTwoLabel;
			case THREE:
				return stageFourLabel;
			case FOUR:
				return stageThreeLabel;
			default:
				throw new IllegalArgumentException("Invalid display");
		}
	}
	
	/** Resets the module
	 * 
	 */
	public void reset() {
		this.stageOneLabel = ' ';
		this.stageOnePosition = -1;
		this.stageTwoLabel = ' ';
		this.stageTwoPosition = -1;
		this.stageThreeLabel = ' ';
		this.stageFourLabel = ' ';
	}
}
