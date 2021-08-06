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
import javax.swing.JTextField;

/** GUI for the Who's On First panel
 * @author Eliza Thornton
 *
 */
public class WhosOnFirstPanel extends JPanel implements ActionListener {

	/** ID number used for object serialization
	 * 
	 */
	private static final long serialVersionUID = 6637369967005747571L;

	/** Asks what's on the display */
	private JLabel displayQuestion;
	
	/** Place to input the display */
	private JTextField displayInput;
	
	/** Asks what's on the button */
	private JLabel buttonsQuestion;
	
	/** Text field for the top left button */
	private JTextField topLeftButton;
	
	/** Text field for the top right button */
	private JTextField topRightButton;
	
	/** Text field for the middle left button */
	private JTextField middleLeftButton;
	
	/** Text field for the middle right button */
	private JTextField middleRightButton;
	
	/** Text field for the bottom left button */
	private JTextField bottomLeftButton;
	
	/** Text field for the top right button */
	private JTextField bottomRightButton;
	
	/** Place for the buttons */
	private JPanel buttons;
	
	/** Place to submit the input */
	private JButton submit;
	
	/** The current stage of the module */
	private byte stage;
	
	WhosOnFirstPanel() {
		super(new GridLayout(5, 1));
		displayQuestion = new JLabel("What is written on the display? (Leave blank if the display is blank)");
		add(displayQuestion);
		displayInput = new JTextField(8);
		add(displayInput);
		
		buttonsQuestion = new JLabel("Input the lower buttons exactly as they appear on the module.");
		add(buttonsQuestion);
		buttons = new JPanel(new GridLayout(3, 2));
		topLeftButton = new JTextField(7);
		buttons.add(topLeftButton);
		topRightButton = new JTextField(7);
		buttons.add(topRightButton);
		middleLeftButton = new JTextField(7);
		buttons.add(middleLeftButton);
		middleRightButton = new JTextField(7);
		buttons.add(middleRightButton);
		bottomLeftButton = new JTextField(7);
		buttons.add(bottomLeftButton);
		bottomRightButton = new JTextField(7);
		buttons.add(bottomRightButton);
		add(buttons);
		
		submit = new JButton("Submit");
		submit.addActionListener(this);
		add(submit);
		
		stage = 1;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit) {
			String solution = null;
			String[] buttonInputs = {topLeftButton.getText(), topRightButton.getText(), middleLeftButton.getText(), 
					middleRightButton.getText(), bottomLeftButton.getText(), bottomRightButton.getText()};
			try {
				solution = BombGUI.bomb.solveWhosOnFirst(displayInput.getText(), buttonInputs);
			} catch (IllegalArgumentException i) {
				if (i.getMessage().equals("Invalid found button")) {
					JOptionPane.showMessageDialog(this, "One or more of the buttons was incorrectly inputted", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			if (solution != null) {
				JOptionPane.showMessageDialog(this, "Press " + solution + ".", "Solution", JOptionPane.INFORMATION_MESSAGE);
				displayInput.setText("");
				topLeftButton.setText("");
				topRightButton.setText("");
				middleLeftButton.setText("");
				middleRightButton.setText("");
				bottomLeftButton.setText("");
				bottomRightButton.setText("");
				if (stage == 3) {
					BombGUI.returnToMenu();
					stage = 1;
				} else {
					stage++;
				}
			}
		}
	}

}
