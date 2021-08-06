/**
 * 
 */
package modules;

/** Class repesenting the wire sequences module
 * @author Eliza Thornton
 *
 */
public class Sequence {

	/** The letters that are on the module
		 * @author Eliza Thornton
		 *
		 */
	public enum Letters {
		/** The letter A */
		A,
		/** The letter B */
		B,
		/** The letter C */
		C
	}

	/** The number of times a red wire appears
	 * 
	 */
	private byte redOccurences;
	
	/** The number of times a blue wire appears
	 * 
	 */
	private byte blueOccurences;
	
	/** The number of times a black wire appears
	 * 
	 */
	private byte blackOccurences;
	
	/** Constructs a new sequence
	 * 
	 */
	public Sequence() {
		reset();
	}
	
	/** Tells if a single wire should be cut or not
	 * 
	 * @param color the color of the wire
	 * @param letter the letter the wire is connected to
	 * @return true if the wire should be cut, false if not
	 */
	public boolean solve(Colors color, Letters letter) {
		if (color == null) {
			throw new IllegalArgumentException("Invalid color");
		}
		if (letter == null) {
			throw new IllegalArgumentException("Invalid letter");
		}
		boolean solution;
		switch (color) {
			case RED:
				switch(redOccurences) {
					case 1:
						solution = letter == Letters.C;
						break;
					case 2:
						solution = letter == Letters.B;
						break;
					case 3:
						solution = letter == Letters.A;
						break;
					case 4:
						solution = letter != Letters.B;
						break;
					case 5:
						solution = letter == Letters.B;
						break;
					case 6:
						solution = letter != Letters.B;
						break;
					case 7:
						solution = true;
						break;
					case 8:
						solution = letter != Letters.C;
						break;
					case 9:
						solution = letter == Letters.B;
						break;
					default:
						throw new IllegalArgumentException("Invalid number of red occurences");
				}
				redOccurences++;
				break;
			case BLUE:
				switch(blueOccurences) {
					case 1:
						solution = letter == Letters.B;
						break;
					case 2:
						solution = letter != Letters.B;
						break;
					case 3:
						solution = letter == Letters.B;
						break;
					case 4:
						solution = letter == Letters.A;
						break;
					case 5:
						solution = letter == Letters.B;
						break;
					case 6:
						solution = letter != Letters.A;
						break;
					case 7:
						solution = letter == Letters.C;
						break;
					case 8:
						solution = letter != Letters.B;
						break;
					case 9:
						solution = letter == Letters.A;
						break;
					default:
						throw new IllegalArgumentException("Invalid number of blue occurences");
				}
				blueOccurences++;
				break;
			case BLACK:
				switch(blackOccurences) {
					case 1:
						solution = true;
						break;
					case 2:
						solution = letter != Letters.B;
						break;
					case 3:
						solution = letter == Letters.B;
						break;
					case 4:
						solution = letter != Letters.B;
						break;
					case 5:
						solution = letter == Letters.B;
						break;
					case 6:
						solution = letter != Letters.A;
						break;
					case 7:
						solution = letter != Letters.C;
						break;
					case 8:
						solution = letter == Letters.C;
						break;
					case 9:
						solution = letter == Letters.C;
						break;
					default:
						throw new IllegalArgumentException("Invalid number of black occurences");
				}
				blackOccurences++;
				break;
			default:
				throw new IllegalArgumentException("Invalid color");
		}
		return solution;
	}

	/** Resets the module
	 * 
	 */
	public void reset() {
		this.redOccurences = 1;
		this.blueOccurences = 1;
		this.blackOccurences = 1;
	}
}

