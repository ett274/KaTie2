/**
 * 
 */
package modules;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/** Class representing the keypad / symbols module
 * @author Eliza Thornton
 *
 */
public class Keypads {

	/**
	 *  Creates the sets of the symbols
	 */
	public Keypads() {
		super();
		COLUMN_1.add(Symbols.Q);
		COLUMN_1.add(Symbols.AT);
		COLUMN_1.add(Symbols.LAMBDA);
		COLUMN_1.add(Symbols.LIGHTNING);
		COLUMN_1.add(Symbols.ALIEN);
		COLUMN_1.add(Symbols.GE);
		COLUMN_1.add(Symbols.BACK_C);
		
		COLUMN_2.add(Symbols.E);
		COLUMN_2.add(Symbols.Q);
		COLUMN_2.add(Symbols.BACK_C);
		COLUMN_2.add(Symbols.SWIRL);
		COLUMN_2.add(Symbols.WHITE_STAR);
		COLUMN_2.add(Symbols.GE);
		COLUMN_2.add(Symbols.QUESTION);
		
		COLUMN_3.add(Symbols.COPYRIGHT);
		COLUMN_3.add(Symbols.W);
		COLUMN_3.add(Symbols.SWIRL);
		COLUMN_3.add(Symbols.XI);
		COLUMN_3.add(Symbols.DROOP_R);
		COLUMN_3.add(Symbols.LAMBDA);
		COLUMN_3.add(Symbols.WHITE_STAR);
		
		COLUMN_4.add(Symbols.SIX);
		COLUMN_4.add(Symbols.PARAGRAPH);
		COLUMN_4.add(Symbols.TB);
		COLUMN_4.add(Symbols.ALIEN);
		COLUMN_4.add(Symbols.XI);
		COLUMN_4.add(Symbols.QUESTION);
		COLUMN_4.add(Symbols.FACE);
		
		COLUMN_5.add(Symbols.PSI);
		COLUMN_5.add(Symbols.FACE);
		COLUMN_5.add(Symbols.TB);
		COLUMN_5.add(Symbols.C);
		COLUMN_5.add(Symbols.PARAGRAPH);
		COLUMN_5.add(Symbols.BUNNY);
		COLUMN_5.add(Symbols.BLACK_STAR);
		
		COLUMN_6.add(Symbols.SIX);
		COLUMN_6.add(Symbols.E);
		COLUMN_6.add(Symbols.NOT_EQUAL);
		COLUMN_6.add(Symbols.AE);
		COLUMN_6.add(Symbols.PSI);
		COLUMN_6.add(Symbols.N);
		COLUMN_6.add(Symbols.OHM);
	}


   
	/** Represents the different symbols of the keypads
		 * @author Eliza Thornton
		 *
		 */
	public enum Symbols {
		/** Looks like a Q with the tail on the bottom */
		Q,
		/** Looks like a T inside a capital A */
		AT,
		/** Looks like a lambda with a slash on the top */
		LAMBDA,
		/** Looks like a curly lightning bolt */
		LIGHTNING,
		/** Looks like an alien spaceship or a triangular jellyfish */
		ALIEN,
		/** Looks like the symbol for General Electric */
		GE,
		/** Looks like a backwards C with a dot in the center */
		BACK_C,
		/** Looks like a curvy backwards E with two dots above */ 
		E,
		/** A swirl */
		SWIRL,
		/** A white star */
		WHITE_STAR,
		/** An upside down question mark */
		QUESTION,
		/** The copyright symbol */
		COPYRIGHT,
		/** Looks like a wide, rounded W with a comma and a line above it */
		W,
		/** Looks like an I with a curvy X interposed on it */
		XI,
		/** Looks like half an R with a droopy end */
		DROOP_R,
		/** Looks like the number 6 */
		SIX,
		/** The paragraph symbol */
		PARAGRAPH,
		/** Looks like a lowercase B and an uppercase T fused together */
		TB,
		/** Looks like the greek letter psi, or a candleabra or a trident */
		PSI,
		/** Looks like a smiley face with its tongue sticking out */
		FACE,
		/** Looks like a 3 with bunny ears and a tail */
		BUNNY,
		/** A black star */
		BLACK_STAR,
		/** Looks like the != symbol (= with a slash through it) tilted slightly */
		NOT_EQUAL,
		/** The dipthong ae */
		AE,
		/** Looks like a backwards capital N */
		N,
		/** The greek letter Omega */
		OHM,
		/** Looks like a capital C with a dot in the center */
		C

	}
	

	/** Comparator for the first column
		 * @author Eliza Thornton
		 *
		 */
	private class Column1Comparator implements Comparator<Symbols> {

		@Override
		public int compare(Symbols o1, Symbols o2) {
			byte symbol1 = 0;
			byte symbol2 = 0;
			switch(o1) {
			   case Q:
				 symbol1 = 1;
				 break;
			   case AT:
				 symbol1 = 2;
				 break;
		   	   case LAMBDA:
				 symbol1 = 3;
				 break;
			   case LIGHTNING:
				 symbol1 = 4;
				 break;
			   case ALIEN:
				 symbol1 = 5;
				 break;
			   case GE:
				 symbol1 = 6;
				 break;
			   case BACK_C:
				 symbol1 = 7;
				 break;
		       default:
		    	 throw new IllegalArgumentException("Invalid comparing symbol"); 
			}
			switch(o2) {
			   case Q:
				 symbol2 = 1;
				 break;
			   case AT:
				 symbol2 = 2;
				 break;
		   	   case LAMBDA:
				 symbol2 = 3;
				 break;
			   case LIGHTNING:
				 symbol2 = 4;
				 break;
			   case ALIEN:
				 symbol2 = 5;
				 break;
			   case GE:
				 symbol2 = 6;
				 break;
			   case BACK_C:
				 symbol2 = 7;
				 break;
		       default:
		    	 throw new IllegalArgumentException("Invalid comparing symbol"); 
			}
			return Byte.compare(symbol1, symbol2);
		}
       
	}
	
	/** Comparator for the second column
	 * @author Eliza Thornton
	 *
	 */
   private class Column2Comparator implements Comparator<Symbols> {

	@Override
	public int compare(Symbols o1, Symbols o2) {
		byte symbol1 = 0;
		byte symbol2 = 0;
		switch(o1) {
		   case E:
			 symbol1 = 1;
			 break;
		   case Q:
			 symbol1 = 2;
			 break;
	   	   case BACK_C:
			 symbol1 = 3;
			 break;
		   case SWIRL:
			 symbol1 = 4;
			 break;
		   case WHITE_STAR:
			 symbol1 = 5;
			 break;
		   case GE:
			 symbol1 = 6;
			 break;
		   case QUESTION:
			 symbol1 = 7;
			 break;
	       default:
	    	 throw new IllegalArgumentException("Invalid comparing symbol"); 
		}
		switch(o2) {
		   case E:
			 symbol2 = 1;
			 break;
		   case Q:
			 symbol2 = 2;
			 break;
	   	   case BACK_C:
			 symbol2 = 3;
			 break;
		   case SWIRL:
			 symbol2 = 4;
			 break;
		   case WHITE_STAR:
			 symbol2 = 5;
			 break;
		   case GE:
			 symbol2 = 6;
			 break;
		   case QUESTION:
			 symbol2 = 7;
			 break;
	       default:
	    	 throw new IllegalArgumentException("Invalid comparing symbol"); 
		}
		return Byte.compare(symbol1, symbol2);
	}
}
   
   /** Comparator for the third column
	 * @author Eliza Thornton
	 *
	 */
  private class Column3Comparator implements Comparator<Symbols> {

	@Override
	public int compare(Symbols o1, Symbols o2) {
		byte symbol1 = 0;
		byte symbol2 = 0;
		switch(o1) {
		   case COPYRIGHT:
			 symbol1 = 1;
			 break;
		   case W:
			 symbol1 = 2;
			 break;
	   	   case SWIRL:
			 symbol1 = 3;
			 break;
		   case XI:
			 symbol1 = 4;
			 break;
		   case DROOP_R:
			 symbol1 = 5;
			 break;
		   case LAMBDA:
			 symbol1 = 6;
			 break;
		   case WHITE_STAR:
			 symbol1 = 7;
			 break;
	       default:
	    	 throw new IllegalArgumentException("Invalid comparing symbol"); 
		}
		switch(o2) {
		   case COPYRIGHT:
			 symbol2 = 1;
			 break;
		   case W:
			 symbol2 = 2;
			 break;
	   	   case SWIRL:
			 symbol2 = 3;
			 break;
		   case XI:
			 symbol2 = 4;
			 break;
		   case DROOP_R:
			 symbol2 = 5;
			 break;
		   case LAMBDA:
			 symbol2 = 6;
			 break;
		   case WHITE_STAR:
			 symbol2 = 7;
			 break;
	       default:
	    	 throw new IllegalArgumentException("Invalid comparing symbol"); 
		}
		return Byte.compare(symbol1, symbol2);
	}
  }
  
  /** Comparator for the third column
	 * @author Eliza Thornton
	 *
	 */
private class Column4Comparator implements Comparator<Symbols> {

	@Override
	public int compare(Symbols o1, Symbols o2) {
		byte symbol1 = 0;
		byte symbol2 = 0;
		switch(o1) {
		   case SIX:
			 symbol1 = 1;
			 break;
		   case PARAGRAPH:
			 symbol1 = 2;
			 break;
	   	   case TB:
			 symbol1 = 3;
			 break;
		   case ALIEN:
			 symbol1 = 4;
			 break;
		   case XI:
			 symbol1 = 5;
			 break;
		   case QUESTION:
			 symbol1 = 6;
			 break;
		   case FACE:
			 symbol1 = 7;
			 break;
	       default:
	    	 throw new IllegalArgumentException("Invalid comparing symbol"); 
		}
		switch(o2) {
		   case SIX:
			 symbol2 = 1;
			 break;
		   case PARAGRAPH:
			 symbol2 = 2;
			 break;
	   	   case TB:
			 symbol2 = 3;
			 break;
		   case ALIEN:
			 symbol2 = 4;
			 break;
		   case XI:
			 symbol2 = 5;
			 break;
		   case QUESTION:
			 symbol2 = 6;
			 break;
		   case FACE:
			 symbol2 = 7;
			 break;
	       default:
	    	 throw new IllegalArgumentException("Invalid comparing symbol"); 
		}
		return Byte.compare(symbol1, symbol2);
	}
}

/** Comparator for the fifth column
 * @author Eliza Thornton
 *
 */
private class Column5Comparator implements Comparator<Symbols> {

@Override
public int compare(Symbols o1, Symbols o2) {
	byte symbol1 = 0;
	byte symbol2 = 0;
	switch(o1) {
	   case PSI:
		 symbol1 = 1;
		 break;
	   case FACE:
		 symbol1 = 2;
		 break;
   	   case TB:
		 symbol1 = 3;
		 break;
	   case C:
		 symbol1 = 4;
		 break;
	   case PARAGRAPH:
		 symbol1 = 5;
		 break;
	   case BUNNY:
		 symbol1 = 6;
		 break;
	   case BLACK_STAR:
		 symbol1 = 7;
		 break;
       default:
    	 throw new IllegalArgumentException("Invalid comparing symbol"); 
	}
	switch(o2) {
	   case PSI:
		 symbol2 = 1;
		 break;
	   case FACE:
		 symbol2 = 2;
		 break;
   	   case TB:
		 symbol2 = 3;
		 break;
	   case C:
		 symbol2 = 4;
		 break;
	   case PARAGRAPH:
		 symbol2 = 5;
		 break;
	   case BUNNY:
		 symbol2 = 6;
		 break;
	   case BLACK_STAR:
		 symbol2 = 7;
		 break;
       default:
    	 throw new IllegalArgumentException("Invalid comparing symbol"); 
	}
	return Byte.compare(symbol1, symbol2);
  }
}

/** Comparator for the third column
 * @author Eliza Thornton
 *
 */
private class Column6Comparator implements Comparator<Symbols> {

@Override
public int compare(Symbols o1, Symbols o2) {
	byte symbol1 = 0;
	byte symbol2 = 0;
	switch(o1) {
	   case SIX:
		 symbol1 = 1;
		 break;
	   case E:
		 symbol1 = 2;
		 break;
   	   case NOT_EQUAL:
		 symbol1 = 3;
		 break;
	   case AE:
		 symbol1 = 4;
		 break;
	   case PSI:
		 symbol1 = 5;
		 break;
	   case N:
		 symbol1 = 6;
		 break;
	   case OHM:
		 symbol1 = 7;
		 break;
       default:
    	 throw new IllegalArgumentException("Invalid comparing symbol"); 
	}
	switch(o2) {
	   case SIX:
		 symbol2 = 1;
		 break;
	   case E:
		 symbol2 = 2;
		 break;
   	   case NOT_EQUAL:
		 symbol2 = 3;
		 break;
	   case AE:
		 symbol2 = 4;
		 break;
	   case PSI:
		 symbol2 = 5;
		 break;
	   case N:
		 symbol2 = 6;
		 break;
	   case OHM:
		 symbol2 = 7;
		 break;
       default:
    	 throw new IllegalArgumentException("Invalid comparing symbol"); 
	}
	return Byte.compare(symbol1, symbol2);
  }
}
	/** The first solution column of symbols */
	private static final HashSet<Symbols> COLUMN_1 = new HashSet<Symbols>(7);
	
	/** The second solution column of symbols */
	private static final HashSet<Symbols> COLUMN_2 = new HashSet<Symbols>(7);
	
	/** The third solution column of symbols */
	private static final HashSet<Symbols> COLUMN_3 = new HashSet<Symbols>(7);
	
	/** The fourth solution column of symbols */
	private static final HashSet<Symbols> COLUMN_4 = new HashSet<Symbols>(7);
	
	/** The fifth solution column of symbols */
	private static final HashSet<Symbols> COLUMN_5 = new HashSet<Symbols>(7);
	
	/** The sixth solution column of symbols */
	private static final HashSet<Symbols> COLUMN_6 = new HashSet<Symbols>(7);
	
	
	/** Takes in four symbols on the keypad and returns them in the order that they should be pressed
	 * 
	 * @param keypad the unsorted four symbols on the keypad
	 * @return the same four symbols in the order they should be pressed
	 */
	public Symbols[] solve(Symbols[] keypad) {
		if (keypad.length != 4) {
			throw new IllegalArgumentException("Invalid keypad length");
		}
		Set<Symbols> symbols = new HashSet<Symbols>(4);
		symbols.addAll(Arrays.asList(keypad));
		if (symbols.size() != 4) {
			throw new IllegalArgumentException("Keypad symbols must all be different");
		}
		Comparator<Symbols> sorter = null;
		byte count = 0;
		if (COLUMN_1.containsAll(symbols)) {
			count++;
			sorter = new Column1Comparator();
		}
		if (COLUMN_2.containsAll(symbols)) {
			count++;
			sorter = new Column2Comparator();
		}
		if (COLUMN_3.containsAll(symbols)) {
			count++;
			sorter = new Column3Comparator();
		}
		if (COLUMN_4.containsAll(symbols)) {
			count++;
			sorter = new Column4Comparator();
		}
		if (COLUMN_5.containsAll(symbols)) {
			count++;
			sorter = new Column5Comparator();
		}
		if (COLUMN_6.containsAll(symbols)) {
			count++;
			sorter = new Column6Comparator();
		}
		if (count != 1) {
			throw new IllegalArgumentException("Error finding solution column");
		}
		Symbols[] solution = Arrays.copyOf(keypad, 4);
        Arrays.sort(solution, sorter);
		return solution;
	}
	

}
