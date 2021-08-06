/**
 * 
 */
package gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import modules.Memory.Display;

/** GUI for the memory module
 * @author Eliza Thornton
 *
 */
public class MemoryPanel extends JPanel implements ActionListener  {

	/** ID number used for object serialization
	 * 
	 */
	private static final long serialVersionUID = -7955763575201644990L;

	/** Gives instructions on what is on the display */
	private JLabel displayTitle;
	
	/** A group of Radio Buttons for selecting the display */
	private ButtonGroup displayButtons;
	
	/** Button for display 1 */
	private JRadioButton oneButton;
	
	/** Button for display 2 */
	private JRadioButton twoButton;
	
	/** Button for display 3 */
	private JRadioButton threeButton;
	
	/** Button for display 4 */
	private JRadioButton fourButton;
	
	/** Gives instructions on typing the buttons input */
	private JLabel buttonsTitle;
	
	/** Place to input the buttons */
	private JTextField buttonsInput;
	
	/** Button to submit */
	private JButton submit;
	
	/** Panel to keep the display button group */
	private JPanel display;
	
	/** Panel to keep the buttons input */
	private JPanel buttons;
	
	/** Keeps track of the current stage */
	private JLabel stageIndicator;
	
	/** The current stage of the memory module */
	private byte stage;
	
	/** The stored value of the display */
	private Display displayChar;
	
	MemoryPanel() {
		super(new GridLayout(4, 1));
		stage = 1;
		stageIndicator = new JLabel("Stage " + stage + ":");
		stageIndicator.setHorizontalAlignment(JLabel.CENTER);
		add(stageIndicator);
		
		display = new JPanel(new FlowLayout());
		displayTitle = new JLabel("What number is on the big display?");
		displayTitle.setHorizontalAlignment(JLabel.CENTER);
		display.add(displayTitle);
		oneButton = new JRadioButton("1");
		twoButton = new JRadioButton("2");
		threeButton = new JRadioButton("3");
		fourButton = new JRadioButton("4");
		displayButtons = new ButtonGroup();
		displayButtons.add(oneButton);
		displayButtons.add(twoButton);
		displayButtons.add(threeButton);
		displayButtons.add(fourButton);
		oneButton.addActionListener(this);
		twoButton.addActionListener(this);
		threeButton.addActionListener(this);
		fourButton.addActionListener(this);
		display.add(oneButton);
		display.add(twoButton);
		display.add(threeButton);
		display.add(fourButton);
		add(display);
		
		buttons = new JPanel(new FlowLayout());
		buttonsTitle = new JLabel("Input the button labels in order (ex. 1234): ");
		buttonsTitle.setHorizontalAlignment(JLabel.CENTER);
		buttons.add(buttonsTitle);
		buttonsInput = new JTextField(4);
		buttons.add(buttonsInput);
		add(buttons);
		
		submit = new JButton("Submit");
		submit.addActionListener(this);
		add(submit);
		
		stage = 1;
		displayChar = null;
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == oneButton) {
			displayChar = Display.ONE;
		} else if (e.getSource() == twoButton) {
			displayChar = Display.TWO;
		} else if (e.getSource() == threeButton) {
			displayChar = Display.THREE;
		} else if (e.getSource() == fourButton) {
			displayChar = Display.FOUR;
		} else if (e.getSource() == submit) {
			try {
				char solution = BombGUI.bomb.solveMemory(stage, displayChar, buttonsInput.getText());
				JOptionPane.showMessageDialog(this, "Press " + solution + ".", "Solution", JOptionPane.INFORMATION_MESSAGE);
				nextStage();
			} catch (IllegalArgumentException i) {
				if (i.getMessage().equals("Buttons must be a String of length 4")) {
					JOptionPane.showMessageDialog(this, "Input four numbers with no spaces", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (i.getMessage().equals("Invalid display")){
					JOptionPane.showMessageDialog(this, "Select a display number", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
		
	}
	
	private void nextStage() {
		if (stage == 5) {
			stage = 1;
			BombGUI.returnToMenu();
		} else {
			stage++;
		}
		displayButtons.clearSelection();
		displayChar = null;
		buttonsInput.setText("");
		if (stage == 5) {
			stageIndicator.setText("Stage 5: (You don't have to input the buttons for this one)");
		} else {
			stageIndicator.setText("Stage " + stage + ":");
		}
		
	}

}
