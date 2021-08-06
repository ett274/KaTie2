/**
 * 
 */
package modules;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/** Class representing the Morse Code module
 * @author Eliza Thornton
 *
 */
public class MorseCode {
	
	/** Stores the values of the morse code inputs to characters */
	private static final HashMap<String, Character> MORSE_MAP = new HashMap<String, Character>(19);
	
	/** Stores the value of the given word and the frequency responses */
	private static final HashMap<String, String> CODE_MAP = new HashMap<String, String>(16);
	
	/** Stores the possible words of the transmission */
	private static final String[] POSSIBLE_WORDS = {"shell", "halls", "slick", "trick", "boxes", "leaks", "strobe", "bistro", "flick", "bombs",
	                                                "break", "brick", "steak", "sting", "vector", "beats"};
	
	/** Constructs the hash maps of the morse code and the solution codes
	 * 
	 */
	public MorseCode() {
		MORSE_MAP.put(".-", 'a');
		MORSE_MAP.put("-...", 'b');
		MORSE_MAP.put("-.-.", 'c');
		MORSE_MAP.put("-..", 'd');
		MORSE_MAP.put(".", 'e');
		MORSE_MAP.put("..-.", 'f');
		MORSE_MAP.put("--.", 'g');
		MORSE_MAP.put("....", 'h');
		MORSE_MAP.put("..", 'i');
		MORSE_MAP.put("-.-", 'k');
		MORSE_MAP.put(".-..", 'l');
		MORSE_MAP.put("--", 'm');
		MORSE_MAP.put("-.", 'n');
		MORSE_MAP.put("---", 'o');
		MORSE_MAP.put(".-.", 'r');
		MORSE_MAP.put("...", 's');
		MORSE_MAP.put("-", 't');
		MORSE_MAP.put("...-", 'v');
		MORSE_MAP.put("-..-", 'x');

		CODE_MAP.put("shell", "3.505");
		CODE_MAP.put("halls", "3.515");
		CODE_MAP.put("slick", "3.522");
		CODE_MAP.put("trick", "3.532");
		CODE_MAP.put("boxes", "3.535");
		CODE_MAP.put("leaks", "3.542");
		CODE_MAP.put("strobe", "3.545");
		CODE_MAP.put("bistro", "3.552");
		CODE_MAP.put("flick", "3.555");
		CODE_MAP.put("bombs", "3.565");
		CODE_MAP.put("break", "3.572");
		CODE_MAP.put("brick", "3.575");
		CODE_MAP.put("steak", "3.582");
		CODE_MAP.put("sting", "3.592");
		CODE_MAP.put("vector", "3.595");
		CODE_MAP.put("beats", "3.600");
	}
	
	/** Returns the letter corresponding to the morse input
	 * 
	 * @param morse an input in morse code
	 * @return the letter corresponding to it
	 */
	public char getLetter(String morse) {
		return MORSE_MAP.get(morse);
	}
	
	/** Finds the frequency to respond at 
	 * 
	 * @param characters the characters inputed from the morse code
	 * @return the frequency to respond at
	 */
	public String solve(char[] characters) {
		if (characters.length < 4 || characters.length > 6) {
			throw new IllegalArgumentException("Invalid length of characters");
		}
		LinkedList<String> wordsLeft = new LinkedList<String>();
		wordsLeft.addAll(Arrays.asList(POSSIBLE_WORDS));
		for (char c : characters) {
			wordsLeft.removeIf(word -> word.indexOf(c) == -1);
			if (wordsLeft.isEmpty()) {
				throw new IllegalArgumentException("Error finding correct word");
			}
			if (wordsLeft.size() == 1) {
				return CODE_MAP.get(wordsLeft.getFirst());
			}
		}
		throw new IllegalArgumentException("Error finding correct word");
	}
	
}
