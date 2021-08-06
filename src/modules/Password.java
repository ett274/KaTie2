/**
 * 
 */
package modules;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/** Class representation of the Password module
 * @author Eliza Thornton
 *
 */
public class Password {

	/** Array containing all the possible passwords
	 * 
	 */
	private static final String[] PASSWORD_LIST = {"about", "after", "again", "below", "could", "every", "first", "found", "great", "house",
            "large", "learn", "never", "other", "place", "plant", "point", "right", "small", "sound",
            "spell", "still", "study", "their", "there", "these", "thing", "think", "three", "water",
            "where", "which", "world", "would", "write"};
	
	/** ArrayList containing the remaining passwords
	 * 
	 */
	private static final LinkedList<String> PASSWORDS_LEFT = new LinkedList<String>();
	
	/** Constructs the password list
	 * 
	 */
	public Password() {
		PASSWORDS_LEFT.addAll(Arrays.asList(PASSWORD_LIST));
	}
	
	/** Narrows down the possible passwords based on the characters in a certain slot of the password
	 * 
	 * @param characters the characters present in a certain position
	 * @param index the index of the position
	 * @return true if the length of the possible passwords is 1, false if not
	 */
	public String solve(Character[] characters, byte index) {
		if (index < 0 || index > 4) {
			throw new IndexOutOfBoundsException();
		}
		HashSet<Character> chars = new HashSet<Character>(6);
		chars.addAll(Arrays.asList(characters));
		if (chars.size() != 6) {
			throw new IllegalArgumentException("There should be exactly 6 unique characters in a section");
		}
		if (chars.removeIf(cha -> !Character.isLetter(cha))) {
			throw new IllegalArgumentException("Inputs must all be letters");
		}
		PASSWORDS_LEFT.removeIf(word -> !chars.contains(word.charAt(index)));
		if (PASSWORDS_LEFT.size() == 1) {
			return PASSWORDS_LEFT.getFirst();
		}
		if (PASSWORDS_LEFT.isEmpty()) {
			throw new IllegalArgumentException("Error finding password");
		}
		return null;
		
	}
	
	/** Resets the module
	 * 
	 */
	public void reset() {
		PASSWORDS_LEFT.clear();
		PASSWORDS_LEFT.addAll(Arrays.asList(PASSWORD_LIST));
	}
}
