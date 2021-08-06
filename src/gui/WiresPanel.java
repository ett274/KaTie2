package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modules.Colors;

/** GUI for the wires module
 * 
 * @author Eliza Thornton
 *
 */
public class WiresPanel extends JPanel implements ActionListener {

	/** ID number used for object serialization
	 * 
	 */
	private static final long serialVersionUID = 3807211216879529695L;

	/** Tells to input the wires from top to button */
	private JLabel instructions;
	
	/** Shows the wires inputted */
	private JLabel inputs;
	
	/** Button representing a red wire */
	private JButton red;
	
	/** Button representing a blue wire */
	private JButton blue;
	
	/** Button representing a yellow wire */
	private JButton yellow;
	
	/** Button representing a white wire */
	private JButton white;
	
	/** Button representing a black wire */
	private JButton black;
	
	/** Button to finish the wire input */
	private JButton submit;
	
	/** Place to but the buttons */
	private JPanel buttons;
	
	/** The colors inputted */
	private ArrayList<Colors> colors;
	
	/** Stores the inputs */
	private StringBuilder inputString;
	
	WiresPanel() {
		super(new GridLayout(4, 1));
		instructions = new JLabel("Input the colors of the wires from top to bottom. Ignore gaps.");
		instructions.setHorizontalAlignment(JLabel.CENTER);
		add(instructions);
		
		buttons = new JPanel(new FlowLayout());
		red = new JButton("Red");
		red.setBackground(Color.RED);
		red.addActionListener(this);
		buttons.add(red);
		blue = new JButton("Blue");
		blue.setBackground(Color.BLUE);
		blue.addActionListener(this);
		buttons.add(blue);
		yellow = new JButton("Yellow");
		yellow.setBackground(Color.YELLOW);
		yellow.addActionListener(this);
		buttons.add(yellow);
		white = new JButton("White");
		white.setBackground(Color.WHITE);
		white.addActionListener(this);
		buttons.add(white);
		black = new JButton("Black");
		black.setBackground(Color.GRAY);
		black.addActionListener(this);
		buttons.add(black);
		add(buttons);
		
		inputs = new JLabel("Inputs: ");
		add(inputs);
		
		submit = new JButton("Submit");
		submit.addActionListener(this);
		add(submit);
		
		colors = new ArrayList<Colors>(6);
		inputString = new StringBuilder();
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == red) {
			colors.add(Colors.RED);
			inputString.append("Red, ");
		} else if (e.getSource() == blue) {
			colors.add(Colors.BLUE);
			inputString.append("Blue, ");
		} else if (e.getSource() == yellow) {
			colors.add(Colors.YELLOW);
			inputString.append("Yellow, ");
		} else if (e.getSource() == white) {
			colors.add(Colors.WHITE);
			inputString.append("White, ");
		} else if (e.getSource() == black) {
			colors.add(Colors.BLACK);
			inputString.append("Black, ");
		} else if (e.getSource() == submit) {
			finish();
			return;
		}
		if (colors.size() == 6) {
			finish();
		} else {
			updateInputs();
		}
		
	}
	
	private void updateInputs() {
		if (inputString.length() == 0) {
			inputs.setText("Inputs: ");
		} else {
			inputs.setText("Inputs: " + inputString.substring(0, inputString.length() - 2));
		}
	}
	
	private void finish() {
		Colors[] colorArray = new Colors[colors.size()];
		colorArray = colors.toArray(colorArray);
		String solution = null;
		try {
			solution = BombGUI.bomb.solveWires(colorArray);
		} catch (IllegalArgumentException i) {
			JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		inputString.delete(0, inputString.length());
		colors.clear();
		updateInputs();
		if (solution != null) {
			JOptionPane.showMessageDialog(this, "Cut the " + solution + " wire from the top.", "Solution", JOptionPane.INFORMATION_MESSAGE);
			BombGUI.returnToMenu();
		}
	}

}
