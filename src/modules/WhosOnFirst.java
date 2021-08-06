/**
 * 
 */
package modules;

import java.util.HashMap;

/** Class representing the Who's On First module
 * @author Eliza Thornton
 *
 */
public class WhosOnFirst {
	
	/** Creates the Read Map
	 * 
	 */
	public WhosOnFirst() {
		super();
		READ.put("UR", (byte)0);
		
		READ.put("FIRST", (byte)1);
		READ.put("OKAY", (byte)1);
		READ.put("C", (byte)1);
		
		READ.put("NOTHING", (byte)2);
		READ.put("LED", (byte)2);
		READ.put("THEY ARE", (byte)2);
		READ.put("YES", (byte)2);
		
		READ.put("RED", (byte)3);
		READ.put("READ", (byte)3);
		READ.put("YOU", (byte)3);
		READ.put("THEIR", (byte)3);
		READ.put("YOU'RE", (byte)3);
		READ.put("YOUR", (byte)3);
		READ.put("BLANK", (byte)3);
		
		READ.put("THEY'RE", (byte)4);
		READ.put("REED", (byte)4);
		READ.put("LEED", (byte)4);
		
		READ.put("SEE", (byte)5);
		READ.put("CEE", (byte)5);
		READ.put("DISPLAY", (byte)5);
		READ.put("SAYS", (byte)5);
		READ.put("NO", (byte)5);
		READ.put("HOLD ON", (byte)5);
		READ.put("YOU ARE", (byte)5);
		READ.put("THERE", (byte)5);
		READ.put("LEAD", (byte)5);

	}
	
	/** Solution list for the word READY */
	private static final String[] READY_LIST = {"YES", "OKAY", "WHAT", "MIDDLE", "LEFT", "PRESS", "RIGHT", "BLANK", "READY"};
	
	/** Solution list for the word FIRST */
	private static final String[] FIRST_LIST = {"LEFT", "OKAY", "YES", "MIDDLE", "NO", "RIGHT", "NOTHING", "UHHH", "WAIT", "READY", "BLANK", "WHAT", "PRESS", "FIRST"};
	
	/** Solution list for the word NO */
	private static final String[] NO_LIST = {"BLANK", "UHHH", "WAIT", "FIRST", "WHAT", "READY", "RIGHT", "YES", "NOTHING", "LEFT", "PRESS", "OKAY", "NO"};
	
	/** Solution list for the word BLANK */
	private static final String[] BLANK_LIST = {"WAIT", "RIGHT", "OKAY", "MIDDLE", "BLANK"};
	
	/** Solution list for the word NOTHING */
	private static final String[] NOTHING_LIST = {"UHHH", "RIGHT", "OKAY", "MIDDLE", "YES", "BLANK", "NO", "PRESS", "LEFT", "WHAT", "WAIT", "FIRST", "NOTHING"};
	
	/** Solution list for the word YES */
	private static final String[] YES_LIST = {"OKAY", "RIGHT", "UHHH", "MIDDLE", "FIRST", "WHAT", "PRESS", "READY", "NOTHING", "YES"};
	
	/** Solution list for the word WHAT */
	private static final String[] WHAT_LIST = {"UHHH", "WHAT"};
	
	/** Solution list for the word UHHH */
	private static final String[] UHHH_LIST = {"READY", "NOTHING", "LEFT", "WHAT", "OKAY", "YES", "RIGHT", "NO", "PRESS", "BLANK", "UHHH"};
	
	/** Solution list for the word LEFT */
	private static final String[] LEFT_LIST = {"RIGHT", "LEFT"};
	
	/** Solution list for the word RIGHT */
	private static final String[] RIGHT_LIST = {"YES", "NOTHING", "READY", "PRESS", "NO", "WAIT", "WHAT", "RIGHT"};
	
	/** Solution list for the word MIDDLE */
	private static final String[] MIDDLE_LIST = {"BLANK", "READY", "OKAY", "WHAT", "NOTHING", "PRESS", "NO", "WAIT", "LEFT", "MIDDLE"};
	
	/** Solution list for the word OKAY */
	private static final String[] OKAY_LIST = {"MIDDLE", "NO", "FIRST", "YES", "UHHH", "NOTHING", "WAIT", "OKAY"};
	
	/** Solution list for the word WAIT */
	private static final String[] WAIT_LIST = {"UHHH", "NO", "BLANK", "OKAY", "YES", "LEFT", "FIRST", "PRESS", "WHAT", "WAIT"};
	
	/** Solution list for the word PRESS */
	private static final String[] PRESS_LIST = {"RIGHT", "MIDDLE", "YES", "READY", "PRESS"};
	
	/** Solution list for the word YOU */
	private static final String[] YOU_LIST = {"SURE", "YOU ARE", "YOUR", "YOU'RE", "NEXT", "UH HUH", "UR", "HOLD", "WHAT?", "YOU"};
	
	/** Solution list for the word YOU ARE */
	private static final String[] YOU_ARE_LIST = {"YOUR", "NEXT", "LIKE", "UH HUH", "WHAT?", "DONE", "UH UH", "HOLD", "YOU", "U", "YOU'RE", "SURE", "UR", "YOU ARE"};
	
	/** Solution list for the word YOUR */
	private static final String[] YOUR_LIST = {"UH UH", "YOU ARE", "UH HUH", "YOUR"};
	
	/** Solution list for the word YOU'RE */
	private static final String[] YOURE_LIST = {"YOU", "YOU'RE"};
	
	/** Solution list for the word UR */
	private static final String[] UR_LIST = {"DONE", "U", "UR"};
	
	/** Solution list for the word U */
	private static final String[] U_LIST = {"UH HUH", "SURE", "NEXT", "WHAT?", "YOU'RE", "UR", "UH UH", "DONE", "U"};
	
	/** Solution list for the word UH UH */
	private static final String[] UH_UH_LIST = {"UR", "U", "YOU ARE", "YOU'RE", "NEXT", "UH UH"};
	
	/** Solution list for the word WHAT? */
	private static final String[] WHATQ_LIST = {"YOU", "HOLD", "YOU'RE", "YOUR", "U", "DONE", "UH UH", "LIKE", "YOU ARE", "UH HUH", "UR", "NEXT", "WHAT?"};
	
	/** Solution list for the word DONE */
	private static final String[] DONE_LIST = {"SURE", "UH HUH", "NEXT", "WHAT?", "YOUR", "UR", "YOU'RE", "HOLD", "LIKE", "YOU", "U", "YOU ARE", "UH UH", "DONE"};
	
	/** Solution list for the word NEXT */
	private static final String[] NEXT_LIST = {"WHAT?", "UH HUH", "UH UH", "YOUR", "HOLD", "SURE", "NEXT"};
	
	/** Solution list for the word HOLD */
	private static final String[] HOLD_LIST = {"YOU ARE", "U", "DONE", "UH UH", "YOU", "UR", "SURE", "WHAT?", "YOU'RE", "NEXT", "HOLD"};
	
	/** Solution list for the word SURE */
	private static final String[] SURE_LIST = {"YOU ARE", "DONE", "LIKE", "YOU'RE", "YOU", "HOLD", "UH HUH", "UR", "SURE"};
	
	/** Solution list for the word LIKE */
	private static final String[] LIKE_LIST = {"YOU'RE", "NEXT", "U", "UR", "HOLD", "DONE", "UH UH", "WHAT?", "UH HUH", "YOU", "LIKE"};
	
	/** Map that indicates what button to return for the findRead function
	 * 
	 */
	private static final HashMap<String, Byte> READ = new HashMap<String, Byte>(27);

	/** Takes the buttons and the given display and finds the button to read into step 2
	 * 
	 * @param display the word (or lack of word) on the top display of the module
	 * @param buttons the buttons on the bottom, read left to right and top to bottom
	 * @return the word that will be read into step 2
	 */
	public String findRead(String display, String[] buttons) {
		if (display == null) {
			throw new IllegalArgumentException("Display cannot be null");
		}
		if (buttons.length != 6) {
			throw new IllegalArgumentException("Must have six button inputs");
		}
		if (display.isBlank()) {
			return buttons[4];
		}
		Byte index = READ.get(display.toUpperCase());
		if (index == null) {
			throw new IllegalArgumentException("Invalid display");
		}
		return buttons[index];

	}
	
	/** Finds what button to press from the found button from step 1
	 * 
	 * @param foundButton the found button from step 1
	 * @param buttons the buttons on the module
	 * @return the button to press
	 */
	public static String findButton(String foundButton, String[] buttons) {
		if (foundButton == null) {
			throw new IllegalArgumentException("The found button cannot be null");
		}
		if (buttons.length != 6) {
			throw new IllegalArgumentException("Must have six button inputs");
		}
		String uppercase = foundButton.toUpperCase();
		if ("UH HUH".equals(uppercase)) {
			return "UH HUH";
		}
		String[] solution = null;
		switch (uppercase) {
			case "READY":
				solution = READY_LIST;
				break;
			case "FIRST":
				solution = FIRST_LIST;
				break;
			case "NO":
				solution = NO_LIST;
				break;
			case "BLANK":
				solution = BLANK_LIST;
				break;
			case "NOTHING":
				solution = NOTHING_LIST;
				break;
			case "YES":
				solution = YES_LIST;
				break;
			case "WHAT":
				solution = WHAT_LIST;
				break;
			case "UHHH":
				solution = UHHH_LIST;
				break;
			case "LEFT":
				solution = LEFT_LIST;
				break;
			case "RIGHT":
				solution = RIGHT_LIST;
				break;
			case "MIDDLE":
				solution = MIDDLE_LIST;
				break;
			case "OKAY":
				solution = OKAY_LIST;
				break;
			case "WAIT":
				solution = WAIT_LIST;
				break;
			case "PRESS":
				solution = PRESS_LIST;
				break;
			case "YOU":
				solution = YOU_LIST;
				break;
			case "YOU ARE":
				solution = YOU_ARE_LIST;
				break;
			case "YOUR":
				solution = YOUR_LIST;
				break;
			case "YOU'RE":
				solution = YOURE_LIST;
				break;
			case "UR":
				solution = UR_LIST;
				break;
			case "U":
				solution = U_LIST;
				break;
			case "UH UH":
				solution = UH_UH_LIST;
				break;
			case "WHAT?":
				solution = WHATQ_LIST;
				break;
			case "DONE":
				solution = DONE_LIST;
				break;
			case "NEXT":
				solution = NEXT_LIST;
				break;
			case "HOLD":
				solution = HOLD_LIST;
				break;
			case "SURE":
				solution = SURE_LIST;
				break;
			case "LIKE":
				solution = LIKE_LIST;
				break;
			default:
				throw new IllegalArgumentException("Invalid found button");
		}
		for (String s : solution) {
			for (byte i = 0; i < buttons.length; i++) {
				if (buttons[i].equalsIgnoreCase(s)) {
					return s;
				}
			}
		}
		throw new IllegalArgumentException("Error finding correct button");
	}
}
