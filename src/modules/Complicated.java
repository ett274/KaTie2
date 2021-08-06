/**
 * 
 */
package modules;

/** Class representing the complicated wires module
 * @author Eliza Thornton
 *
 */
public class Complicated {
	
	/** If the last digit of the serial number is even */
	private final boolean even;
	
	/** If there is a parallel port */
	private final boolean parallel;
	
	/** If the bomb has two or more batteries */
	private final boolean twoBatteries;
	
	/** Constructs a Complicated object
	 * 
	 * @param even if the last digit of the serial number is even
	 * @param parallel if there is a parallel port
	 * @param batteries the number of batteries on the bomb
	 */
	public Complicated(boolean even, boolean parallel, byte batteries) {
		this.even = even;
		this.parallel = parallel;
		if (batteries < 0) {
			throw new IllegalArgumentException("Batteries must be a positive number");
		}
		this.twoBatteries = batteries >= 2;
	}
	
	/** Takes in the traits of a wire and returns if it should be cut
	 * 
	 * @param red if the wire has red coloring
	 * @param blue if the wire has blue coloring
	 * @param star if there is a star symbol underneath the wire
	 * @param led if the LED above the wire is on
	 * @return true if the wire should be cut, false if it should not be cut
	 */
	public boolean solveWire(boolean red, boolean blue, boolean star, boolean led) {
		if (red) {
			if (blue) {
				if (star) {
					if (led) {
						return false;
					} else {
						return parallel;
					}
				} else {
					return even;
				}
			} else {
				if (star) {
					if (led) {
						return twoBatteries;
					} else {
						return true;
					}
				} else {
					if (led) {
						return twoBatteries;
					} else {
						return even;
					}
				}
			}
		} else {
			if (blue) {
				if (star) {
					if (led) {
						return parallel;
					} else {
						return false;
					}
				} else {
					if (led) {
						return parallel;
					} else {
						return even;
					}
				}
			} else {
				if (star) {
					if (led) {
						return twoBatteries;
					} else {
						return true;
					}
				} else {
					return !led;
				}
			}
		}
	}
}
