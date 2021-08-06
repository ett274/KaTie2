/**
 * 
 */
package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/** GUI for the morse code panel
 * @author Eliza Thornton
 *
 */
public class MorsePanel extends JPanel implements ActionListener {

	/** ID used for serialization
	 * 
	 */
	private static final long serialVersionUID = 5751942439623935196L;

	/** Gives instructions to input the morse code */
	private JLabel title;
	
	/** Place for the buttons */
	private JPanel buttons;
	
	/** Button to submit the input */
	private JButton submit;
	
	/** Button to finish and find the frequency */
	private JButton finish;
	
	/** Button representing a dot in Morse */
	private JButton dot;
	
	/** Button representing a dash in Morse */
	private JButton dash;
	
	/** Stores the inputs */
	private StringBuilder inputs;
	
	/** Displays the given inputs */
	private JLabel submittedInputs;
	
	/** Represents the input for a single letter */
	private StringBuilder input;
	
	/** String that stores the given inputs */
	private StringBuilder givenInputs;
	
	/** Represents the current letter */
	private JLabel letterDisplay;
	
	/** Panel to keep the text field and the submitted inputs text */
	private JPanel textStuff;
	
	/** Clears the current letter */
	private JButton clear;
	
	MorsePanel() {
		super(new GridLayout(4, 1));
		title = new JLabel("Wait until a very long gap between inputs, then input each Morse letter as it comes in. " + "\n" + " Use - for long flashes and . for short flashes. Press Finish when every letter has been inputted before the long gap.");
		title.setHorizontalAlignment(JLabel.CENTER);
		add(title);
		letterDisplay = new JLabel("Current Letter: ");
		letterDisplay.setHorizontalAlignment(JLabel.CENTER);
		add(letterDisplay);
		textStuff = new JPanel(new GridLayout(2, 2));
		dot = new JButton("Short flash (.)");
		dot.addActionListener(this);
		textStuff.add(dot);
		dash = new JButton("Long flash (-)");
		dash.addActionListener(this);
		textStuff.add(dash);
		givenInputs = new StringBuilder("Given Inputs: ");
		submittedInputs = new JLabel(givenInputs.toString());
		submittedInputs.setHorizontalAlignment(JLabel.CENTER);
		textStuff.add(submittedInputs);
		add(textStuff);
		buttons = new JPanel(new GridLayout(1, 3));
		submit = new JButton("Submit");
		submit.addActionListener(this);
		buttons.add(submit);
		clear = new JButton("Clear");
		clear.addActionListener(this);
		buttons.add(clear);
		finish = new JButton("Finish");
		finish.addActionListener(this);
		buttons.add(finish);
		add(buttons);
		inputs = new StringBuilder(6);
		input = new StringBuilder(4);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == dot) {
			input.append('.');
			letterDisplay.setText("Current Letter: " + input.toString());
		} else if (e.getSource() == dash) {
			input.append('-');
			letterDisplay.setText("Current Letter: " + input.toString());
		} else if (e.getSource() == submit) {
			try {
				inputs.append(BombGUI.bomb.getMorseLetter(input.toString()));
				givenInputs.append(input.toString());
				givenInputs.append(' ');
				submittedInputs.setText(givenInputs.toString());
				input.delete(0, input.length());
				letterDisplay.setText("Current Letter: " + input.toString());
			} catch (IllegalArgumentException i) {
				JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			} catch (NullPointerException j) {
				JOptionPane.showMessageDialog(this, "Invalid letter", "Error", JOptionPane.ERROR_MESSAGE);
				input.delete(0, input.length());
				letterDisplay.setText("Current Letter: " + input.toString());
			}
		} else if (e.getSource() == clear ) {
			input.delete(0, input.length());
			letterDisplay.setText("Current Letter: " + input.toString());
		} else if (e.getSource() == finish) {
			char[] letters = inputs.toString().toCharArray();
			String solution = null;
			try {
				solution = BombGUI.bomb.solveMorse(letters);
				JOptionPane.showMessageDialog(this, "Set it to " + solution + " MHz, then press TX.", "Error", JOptionPane.INFORMATION_MESSAGE);
				inputs.delete(0, inputs.length());
				givenInputs.replace(0, givenInputs.length(), "Given Inputs: ");
				submittedInputs.setText(givenInputs.toString());
				BombGUI.returnToMenu();
			} catch (IllegalArgumentException i) {
				JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				inputs.delete(0, inputs.length());
				givenInputs.replace(0, givenInputs.length(), "Given Inputs: ");
				submittedInputs.setText(givenInputs.toString());
			}
		}
		
	}

}
