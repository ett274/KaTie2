/**
 * 
 */
package manager;

import modules.Button;
import modules.Button.Solution;
import modules.Colors;
import modules.Complicated;
import modules.Keypads;
import modules.Maze;
import modules.Keypads.Symbols;
import modules.Knob;
import modules.Knob.Directions;
import modules.Memory;
import modules.Memory.Display;
import modules.MorseCode;
import modules.Password;
import modules.Sequence;
import modules.Sequence.Letters;
import modules.Simon;
import modules.Simon.SimonColors;
import modules.Simon.Strikes;
import modules.WhosOnFirst;
import modules.Wires;

/** Manages the bomb and various modules of the bomb
 * @author Eliza Thornton
 *
 */
public class Bomb {
	
	/** Keeps track of the memory stages */
	private static final Memory MEMORY = new Memory();
	
	/** Keeps track of the sequence occurrences */
	private static final Sequence SEQUENCE = new Sequence();
	
	/** Keeps track of the password stages */
	private static final Password PASSWORD = new Password();
	
	/** Represents the MorseCode module */
	private static final MorseCode MORSE = new MorseCode();
	
	/** Represents the Complicated module */
	private final Complicated comp;
	
	/** Represents the Simon module */
	private final Simon simon;
	
	/** Represents the Wires module */
	private final Wires wires;
	
	/** Represents the Button module */
	private final Button button;
	
	/** Represents the Who's On First module */
	private static final WhosOnFirst WHOS = new WhosOnFirst();
	
	/** Represents the Keypads module */
	private static final Keypads KEYPADS = new Keypads();
	
	
	/** Constructs a bomb with the specified preconditions
	 * 
	 * @param car if there is a lit indicator labeled CAR
	 * @param frk if there is a lit indicator labeled FRK
	 * @param batteries the number of batteries on the bomb
	 * @param digit the last digit of the serial number
	 * @param vowel if there is a vowel in the serial number
	 * @param parallel if the bomb has a long pink port (parallel port)
	 */
	public Bomb(boolean car, boolean frk, byte batteries, char digit, boolean vowel, boolean parallel) {
		if (!Character.isDigit(digit)) {
			throw new IllegalArgumentException("Invalid digit");
		}
		boolean even = Character.getNumericValue(digit) % 2 == 0;
		this.comp = new Complicated(even, parallel, batteries);
		this.simon = new Simon(vowel);
		this.wires = new Wires(!even);
		this.button = new Button(batteries, frk, car);
	}
	
	/** Calls when a button needs to be solved
	 * 
	 * @param color the color of the button
	 * @param text the text on the button
	 * @return a value stating if the button needs to be pressed or held
	 */
	public Solution solveButton(Colors color, String text) {
		return button.solve(color, text);
	}
	
	/** Calls when a button needs to be held
	 * 
	 * @param strip the color of the glowing strip next to the held button
	 * @return the number that needs to be on the display to release it
	 */
	public char solveHold(Colors strip) {
		return Button.hold(strip);
	}
	
	/** Calls to solve wires
	 * 
	 * @param colors an array containing the colors of the wires
	 * @return a String indicating which wire to cut
	 */
	public String solveWires(Colors[] colors) {
		return wires.getInstructions(colors);
	}
	
	/** Calls to solve the keypad module
	 * 
	 * @param keypad the four symbols present on the keypad
	 * @return the four symbols arranged in the order they should be pressed
	 */
	public Symbols[] solveKeypad(Symbols[] keypad) {
		return KEYPADS.solve(keypad);
	}
	
	/** Calls to solve the Simon Says module
	 * 
	 * @param color the color that flashed last
	 * @param strikes the number of strikes on the bomb
	 * @return the color to press
	 */
	public SimonColors solveSimon(SimonColors color, Strikes strikes) {
		return simon.solve(color, strikes);
	}
	
	/** Calls to solve the Who's On First module
	 * 
	 * @param display the word on the top of the display
	 * @param buttons the buttons on the module
	 * @return a String representing which button to press
	 */
	public String solveWhosOnFirst(String display, String[] buttons) {
		return WhosOnFirst.findButton(WHOS.findRead(display, buttons), buttons);
	}
	
	/** Calls to solve the Memory module
	 * 
	 * @param stage the stage the memory module is at
	 * @param display the big display on the module
	 * @param buttons the four buttons in order
	 * @return a character representing which button to press
	 */
	public char solveMemory(byte stage, Display display, String buttons) {
		if (stage == 5) {
			char solution = MEMORY.stageFive(display);
			MEMORY.reset();
			return solution;
		}
		return MEMORY.stageOneThroughFour(stage, display, buttons);
	}
	
	/** Returns the character equivalent of a morse code input
	 * 
	 * @param morse a String of dots and dashes
	 * @return the equivalent letter to the morse code
	 */
	public char getMorseLetter(String morse) {
		return MORSE.getLetter(morse);
	}
	
	/** Calls to solve the Morse module
	 * 
	 * @param characters a group of characters representing the input
	 * @return the frequency to respond at
	 */
	public String solveMorse(char[] characters) {
		return MORSE.solve(characters);
	}
	
	/** Calls to solve the complicated module
	 * 
	 * @param red if the given wire has red coloring
	 * @param blue if the given wire has blue coloring
	 * @param star if the give wire has a star below it
	 * @param led if the light above the given star is on
	 * @return true if the wire should be cut, false if not
	 */
	public boolean solveComplicated(boolean red, boolean blue, boolean star, boolean led) {
		return comp.solveWire(red, blue, star, led);
	}
	
	/** Calls to solve the sequence module
	 * 
	 * @param color the color of the wire
	 * @param letter the letter of the wire
	 * @param newSequence if a new sequence has started
	 * @return true if the wire should be cut, false if not
	 */
	public boolean solveSequence(Colors color, Letters letter, boolean newSequence) {
		if (newSequence) {
			SEQUENCE.reset();
		}
		return SEQUENCE.solve(color, letter);
	}
	
	/** Calls to solve the maze module
	 * 
	 * @param circlex1 the x coordinate of one of the circles
	 * @param circley1 the y coordinate of one of the circles
	 * @param circlex2 the x coordinate of the other circle
	 * @param circley2 the y coordinate of the other circle
	 * @param whitex the x coordinate of the white square
	 * @param whitey the y coordinate of the white square
	 * @param redx the x coordinate of the red triangle
	 * @param redy the y coordinate of the red triangle
	 * @return a String representing the directions to take
	 */
	public String solveMaze(byte circlex1, byte circley1, byte circlex2, byte circley2, byte whitex, byte whitey, byte redx, byte redy) {
		return Maze.solve(Maze.mazeFinder(circlex1, circley1, circlex2, circley2), (byte)(whitex - 1), (byte)(6 - whitey), (byte)(redx - 1), (byte)(6 - redy));
	}
	
	/** Calls to solve the password module
	 * 
	 * @param characters a list of characters to comb through
	 * @param index the index of the password
	 * @param newPassword if there is a new password to solve
	 * @return either a String representing the password or null if the password hasn't been found yet
	 */
	public String solvePassword(Character[] characters, byte index, boolean newPassword) {
		if (newPassword) {
			PASSWORD.reset();
		}
		return PASSWORD.solve(characters, index);
	}
	
	/** Calls to solve the Knob module
	 * 
	 * @param upLabel where the UP label of the knob is
	 * @param topLeft if the top left light is on
	 * @param bottomLeft if the bottom left light is on
	 * @param bottomRight if the bottom right light is on (on the left side)
	 * @param middleBottom if the middle bottom light is on (on the left side)
	 * @param middleTop if the middle top light is on (on the left side)
	 * @return which direction to turn the knob
	 */
	public Directions solveKnob(Directions upLabel, boolean topLeft, boolean bottomLeft, boolean bottomRight, boolean middleBottom, boolean middleTop) {
		Knob knob = new Knob(upLabel);
		return knob.solve(topLeft, bottomLeft, bottomRight, middleBottom, middleTop);
	}
	
	
	
	
}
