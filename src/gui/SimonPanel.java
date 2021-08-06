/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import modules.Simon.SimonColors;
import modules.Simon.Strikes;

/** GUI for the Simon Says module
 * @author Eliza Thornton
 *
 */
public class SimonPanel extends JPanel implements ActionListener {

	/** ID number used for object serialization
	 * 
	 */
	private static final long serialVersionUID = -6503860229974048986L;

	/**Asks how many strikes the bomb has */
	private JLabel strikesQuestion;
	
	/** Group of radio buttons representing the number of strikes */
	private ButtonGroup strikes;
	
	/** Button representing zero strikes */
	private JRadioButton zeroStrikes;
	
	/** Button representing one strike */
	private JRadioButton oneStrike;
	
	/** Button representing two strikes */
	private JRadioButton twoStrikes;
	
	/** Tells to press the last flashing light */
	private JLabel buttonInstructions;
	
	/** Button representing a red flash*/
	private JButton red;
	
	/** Button representing a blue flash*/
	private JButton blue;
	
	/** Button representing a green flash*/
	private JButton green;
	
	/** Button representing a yellow flash*/
	private JButton yellow;
	
	/** Label containing the instructions */
	private JLabel instructionsLabel;
	
	/** Button to finish the module */
	private JButton done;
	
	/** Panel for the strikes question / buttons */
	private JPanel strikesPanel;
	
	/** Panel for the color buttons */
	private JPanel colorButtons;
	
	/** The number of strikes */
	private Strikes strikeNumber;
	
	/** Tells which buttons to press in what order */
	private StringBuilder instructions;
	
	/** Keeps track of the inputs */
	private ArrayList<SimonColors> inputs;
	
	/** Map that translates colors to strings
	 * 
	 */
	private static final HashMap<SimonColors, String> COLOR_TO_STRING = new HashMap<SimonColors, String>(4);
	
	SimonPanel() {
		super(new GridLayout(5, 1));
		strikesPanel = new JPanel(new FlowLayout());
		strikesQuestion = new JLabel("How many strikes does the bomb have?");
		strikesPanel.add(strikesQuestion);
		strikes = new ButtonGroup();
		zeroStrikes = new JRadioButton("0", true);
		strikes.add(zeroStrikes);
		oneStrike = new JRadioButton("1");
		strikes.add(oneStrike);
		twoStrikes = new JRadioButton("2");
		strikes.add(twoStrikes);
		zeroStrikes.addActionListener(this);
		oneStrike.addActionListener(this);
		twoStrikes.addActionListener(this);
		strikesPanel.add(zeroStrikes);
		strikesPanel.add(oneStrike);
		strikesPanel.add(twoStrikes);
		add(strikesPanel);
		
		buttonInstructions = new JLabel("Press the last color that flashed.");
		buttonInstructions.setHorizontalAlignment(JLabel.CENTER);
		add(buttonInstructions);
		
		colorButtons = new JPanel(new FlowLayout());
		red = new JButton("Red");
		red.setBackground(Color.RED);
		red.addActionListener(this);
		colorButtons.add(red);
		blue = new JButton("Blue");
		blue.setBackground(Color.BLUE);
		blue.addActionListener(this);
		colorButtons.add(blue);
		green = new JButton("Green");
		green.setBackground(Color.GREEN);
		green.addActionListener(this);
		colorButtons.add(green);
		yellow = new JButton("Yellow");
		yellow.setBackground(Color.YELLOW);
		yellow.addActionListener(this);
		colorButtons.add(yellow);
		add(colorButtons);
		
		instructionsLabel = new JLabel();
		add(instructionsLabel);
		
		done = new JButton("Finished");
		done.addActionListener(this);
		add(done);
		
		strikeNumber = Strikes.ZERO;
		instructions = new StringBuilder();
		updateInstructions();
		inputs = new ArrayList<SimonColors>(6);
		COLOR_TO_STRING.put(SimonColors.RED, "Red, ");
		COLOR_TO_STRING.put(SimonColors.BLUE, "Blue, ");
		COLOR_TO_STRING.put(SimonColors.GREEN, "Green, ");
		COLOR_TO_STRING.put(SimonColors.YELLOW, "Yellow, ");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == zeroStrikes) {
			strikeNumber = Strikes.ZERO;
			strikeChange();
		} else if (e.getSource() == oneStrike) {
			strikeNumber = Strikes.ONE;
			strikeChange();
		} else if (e.getSource() == twoStrikes) {
			strikeNumber = Strikes.TWO;
			strikeChange();
		} else if (e.getSource() == red) {
			inputs.add(SimonColors.RED);
			instructions.append(COLOR_TO_STRING.get(BombGUI.bomb.solveSimon(SimonColors.RED, strikeNumber)));
			updateInstructions();
		} else if (e.getSource() == blue) {
			inputs.add(SimonColors.BLUE);
			instructions.append(COLOR_TO_STRING.get(BombGUI.bomb.solveSimon(SimonColors.BLUE, strikeNumber)));
			updateInstructions();
		} else if (e.getSource() == green) {
			inputs.add(SimonColors.GREEN);
			instructions.append(COLOR_TO_STRING.get(BombGUI.bomb.solveSimon(SimonColors.GREEN, strikeNumber)));
			updateInstructions();
		} else if (e.getSource() == yellow) {
			inputs.add(SimonColors.YELLOW);
			instructions.append(COLOR_TO_STRING.get(BombGUI.bomb.solveSimon(SimonColors.YELLOW, strikeNumber)));
			updateInstructions();
		} else if (e.getSource() == done) {
			inputs.clear();
			instructions.delete(0, instructions.length());
			updateInstructions();
			BombGUI.returnToMenu();
		}
		
	}
	
	private void updateInstructions() {
		if (instructions.length() == 0) {
			instructionsLabel.setText("Press: ");
		} else {
			instructionsLabel.setText("Press: " + instructions.substring(0, instructions.length() - 2));
		}
		
	}
	
	private void strikeChange() {
		instructions.delete(0, instructions.length());
		for (SimonColors s : inputs) {
			instructions.append(COLOR_TO_STRING.get(BombGUI.bomb.solveSimon(s, strikeNumber)));
		}
		updateInstructions();
	}

}
