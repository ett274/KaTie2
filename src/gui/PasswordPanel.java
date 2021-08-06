package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * GUI for the password module
 * @author Eliza Thornton
 *
 */
public class PasswordPanel extends JPanel implements ActionListener {

	/** ID number used for object serialization
	 * 
	 */
	private static final long serialVersionUID = 444749394607913171L;

	/** Provides information about inputting each section of the password */
	private JLabel title;
	
	/** Place to input each letter */
	private JTextField input;
	
	/** Place to submit the letters */
	private JButton submit;
	
	/** The current index of the password */
	private byte index;
	
	PasswordPanel() {
		super(new GridLayout(3, 1));
		index = 1;
		title = new JLabel("Enter each letter in position " + index + ". (Ex. abcefg)");
		add(title);
		input = new JTextField(6);
		add(input);
		submit = new JButton("Submit");
		submit.addActionListener(this);
		add(submit);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit) {
			String text = input.getText().toLowerCase();
			Character[] letters = new Character[text.length()];
			for (byte i = 0; i < letters.length; i++) {
				letters[i] = text.charAt(i);
			}
			String password = null;
			try {
				password = BombGUI.bomb.solvePassword(letters, (byte)(index - 1), index == 1);
				if (password == null) {
					index++;
					title.setText("Enter each letter in position " + index + ". (Ex. abcefg)");
					input.setText("");
				} else {
					JOptionPane.showMessageDialog(this, "The password is " + password + ".", "Solution", JOptionPane.INFORMATION_MESSAGE);
					finish();
				}
			} catch (IllegalArgumentException i) {
				JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				if (i.getMessage().equals("Error finding password")) {
					finish();
				}
			} catch (IndexOutOfBoundsException o) {
				JOptionPane.showMessageDialog(this, "Error finding password", "Error", JOptionPane.ERROR_MESSAGE);
				finish();
			}
		}
		
	}
	
	private void finish() {
		index = 1;
		title.setText("Enter each letter in position " + index + ". (Ex. abcefg)");
		input.setText("");
		BombGUI.returnToMenu();
	}

}
