package modules;

/** Functions for the Wires module
* @author Eliza Thornton
*/
public class Wires {
    
    /** If the last digit of the serial number is odd */
    private final boolean odd;
    
    /** Constructs a Wires object
    * @param oddNumber if the last digit of the serial number is odd
    */
    public Wires(boolean oddNumber) {
        this.odd = oddNumber;
    }
    
    /** Counts how many of each item there are in an array
    * @param array the array of strings
    * @param item the item to count
    * @return the number of the given item there are in the given array
    */
    protected byte countItems(Colors[] array, Colors item) {
        byte count = 0;
        for (int n = 0; n < array.length; n++) {
            if (array[n].equals(item)) {
                count++;
            }
        }
        return count;
        
    }
    /** Tells which wire to cut with the module
    * @param wires an array of strings with the colors of the wires in order
    * @return the word of the order of the wire to cut
    */
    public String getInstructions(Colors[] wires) {
    	byte redWires = countItems(wires, Colors.RED);
    	byte blueWires = countItems(wires, Colors.BLUE);
    	byte yellowWires = countItems(wires, Colors.YELLOW);
    	byte whiteWires = countItems(wires, Colors.WHITE);
    	byte blackWires = countItems(wires, Colors.BLACK);
    	switch (wires.length) {
    		case 3:
    			if (redWires == 0) {
                    return "second";
                } else if (wires[2].equals(Colors.WHITE) || blueWires <= 1) {
                    return "last";
                } else {
                    return "last blue";
                }
    		case 4:
    			if (odd && redWires > 1) {
                    return "last red";
                } else if (wires[3].equals(Colors.YELLOW) && redWires == 0 || blueWires == 1) {
                    return "first";
                } else if (yellowWires > 1) {
                    return "last";
                } else {
                    return "second";
                }
    		case 5:
    			if (odd && wires[4].equals(Colors.BLACK)) {
                    return "fourth";
                } else if (redWires == 1 && yellowWires > 1 || blackWires != 0) {
                    return "first";
                } else {
                	return "second";
                }
    		case 6:
    			if (odd && yellowWires == 0) {
                    return "third";
                } else if (yellowWires == 1 && whiteWires > 1 || redWires != 0) {
                    return "fourth";
                } else {
                	return "last";
                }
    		default:
    			throw new IllegalArgumentException("Invalid number of wires");
    	}
    }
}