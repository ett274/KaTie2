/**
 * 
 */
package modules;

/** Class representing the Simon Says module
 * @author Eliza Thornton
 *
 */
public class Simon {

	/** Represents the number of strikes on the bomb
		 * @author Eliza Thornton
		 *
		 */
	public enum Strikes {
		/** Represents zero strikes on the bomb */
       ZERO,
       /** Represents one strike on the bomb */
       ONE,
       /** Represents two strikes on the bomb */
       TWO
	}
	
	/** The four colors of Simon Says
	 * @author Eliza Thornton
	 *
	 */
    public enum SimonColors {
	   /** The color red for Simon Says*/
	   RED,
	   /** The color blue for Simon Says */
       BLUE,
	   /** The color green for Simon Says */
	   GREEN,
	   /** The color yellow for Simon Says */
	   YELLOW
    }
	
	/** If the serial number of the bomb contains a vowel
	 * 
	 */
	private final boolean vowel;
	
	/** Sets the value of the vowel
	 * 
	 * @param vowel true if the serial number of the bomb contains a vowel, false if not
	 */
	public Simon(boolean vowel) {
		this.vowel = vowel;
		
	}
	
	/** Returns what color button to press based on what color is flashing and how many strikes the bomb has
	 * 
	 * @param flash which color flashed
	 * @param strikes how many strikes the bomb has
	 * @return a SimonColor value representing which button to press
	 */
	public SimonColors solve(SimonColors flash, Strikes strikes) {
		if (flash == null) {
			throw new IllegalArgumentException("Flash cannot be null");
		}
		if (strikes == null) {
			throw new IllegalArgumentException("Strikes cannot be null");
		}
		if (vowel) {
			switch (strikes) {
			    case ZERO:
				    switch (flash) {
				        case RED:
				        	return SimonColors.BLUE;
				        case BLUE:
				        	return SimonColors.RED;
				        case GREEN:
				        	return SimonColors.YELLOW;
				        case YELLOW:
				        	return SimonColors.GREEN;
				        default:
				        	return null;	
				    }
			    case ONE:
			    	switch (flash) {
			            case RED:
			        	    return SimonColors.YELLOW;
			            case BLUE:
			        	    return SimonColors.GREEN;
			            case GREEN:
			        	    return SimonColors.BLUE;
			            case YELLOW:
			        	    return SimonColors.RED;
			            default:
			        	    return null;	
			        }
			    case TWO:
			    	switch (flash) {
		                case RED:
		        	        return SimonColors.GREEN;
		                case BLUE:
		        	        return SimonColors.RED;
		                case GREEN:
		        	        return SimonColors.YELLOW;
		                case YELLOW:
		        	        return SimonColors.BLUE;
		                default:
		        	        return null;	
		            }
			    default:
			    	return null;
			}
		} else {
			switch (strikes) {
		        case ZERO:
			        switch (flash) {
			            case RED:
			            	return SimonColors.BLUE;
			            case BLUE:
			            	return SimonColors.YELLOW;
			            case GREEN:
			            	return SimonColors.GREEN;
			            case YELLOW:
			            	return SimonColors.RED;
			            default:
			        	    return null;	
			        }
		        case ONE:
		    	    switch (flash) {
		                case RED:
		        	        return SimonColors.RED;
		                case BLUE:
		        	        return SimonColors.BLUE;
		                case GREEN:
		            	    return SimonColors.YELLOW;
		                case YELLOW:
		            	    return SimonColors.GREEN;
		                default:
		            	    return null;	
		            }
		        case TWO:
		        	switch (flash) {
	                    case RED:
	               	        return SimonColors.YELLOW;
	                    case BLUE:
	            	        return SimonColors.GREEN;
	                    case GREEN:
	        	            return SimonColors.BLUE;
	                    case YELLOW:
	            	        return SimonColors.RED;
	                    default:
	            	        return null;	
	                }
		        default:
		        	return null;
			}
	    }
	}
}
	
