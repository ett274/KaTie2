package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import modules.Button.Solution;
import modules.Colors;

/**
 * GUI for the button module
 * @author Eliza Thornton
 *
 */
public class ButtonPanel extends JPanel {
	
	/** ID number used for object serialization
	 * 
	 */
	private static final long serialVersionUID = -5814014872419403221L;

	/** Card layout for the button panel */
	private CardLayout cardLayout;
	
	/** Panel for the holding option */
	private HoldPanel hold;
	
	/** Panel for the initial button */
	private ButtonQuestions button;

	/**	Panel for the optional holding down button solution
		 * @author Eliza Thornton
		 *
		 */
	private class HoldPanel extends JPanel implements ActionListener {

		/** ID number used for object serialization
		 * 
		 */
		private static final long serialVersionUID = 2317678980142246810L;

		/** Asks what color the strip is */
		private JLabel color;
		
		/** Selector for red */
		private JButton red;
		
		/** Selector for blue */
		private JButton blue;
		
		/** Selector for yellow */
		private JButton yellow;
		
		/** Button for white */
		private JButton white;
		
		/** The color of the strip */
		private Colors stripColor;
		
		HoldPanel() {
			super(new FlowLayout());
			color = new JLabel("Hold down the button. A colored strip should light up next to it. What color is the strip?");
			red = new JButton("Red");
			red.setBackground(Color.RED);
			red.addActionListener(this);
			blue = new JButton("Blue");
			blue.setBackground(Color.BLUE);
			blue.addActionListener(this);
			yellow = new JButton("Yellow");
			yellow.setBackground(Color.YELLOW);
			yellow.addActionListener(this);
			white = new JButton("White");
			white.setBackground(Color.WHITE);
			white.addActionListener(this);
			add(color);
			add(red);
			add(blue);
			add(yellow);
			add(white);
			
			setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == red) {
				stripColor = Colors.RED;
			} else if (e.getSource() == blue) {
				stripColor = Colors.BLUE;
			} else if (e.getSource() == yellow) {
				stripColor = Colors.YELLOW;
			} else if (e.getSource() == white) {
				stripColor = Colors.WHITE;
			}
			JOptionPane.showMessageDialog(this, "Release the button when the timer has a " + BombGUI.bomb.solveHold(stripColor) + " in any position.");
			changeLayout("ButtonQuestions");
			BombGUI.returnToMenu();
		}
	}

	/** Panel with the initial button setup
		 * @author Eliza Thornton
		 *
		 */
	private class ButtonQuestions extends JPanel implements ActionListener {

		/** ID number used for object serialization
		 * 
		 */
		private static final long serialVersionUID = 8062439839091201275L;

		/** Asks what color the button is */
		private JLabel color;
		
		/** Asks what text is on the button */
		private JLabel textQuestion;
		
		/** Selector for red */
		private JRadioButton red;
		
		/** Selector for blue */
		private JRadioButton blue;
		
		/** Selector for yellow */
		private JRadioButton yellow;
		
		/** Selector for white */
		private JRadioButton white;
		
		/** Has the selectors for the button color */
		private ButtonGroup colors;
		
		/** The text on the button */
		private JTextField text;
		
		/** Button to submit the button */
		private JButton submit;

		/** Stores the button color */
		private Colors buttonColor;
		
		ButtonQuestions() {
			super(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			color = new JLabel("What color is the button?");
			red = new JRadioButton("Red");
			red.setBackground(Color.RED);
			blue = new JRadioButton("Blue");
			blue.setBackground(Color.BLUE);
			yellow = new JRadioButton("Yellow");
			yellow.setBackground(Color.YELLOW);
			white = new JRadioButton("White");
			white.setBackground(Color.WHITE);
			colors = new ButtonGroup();
			colors.add(red);
			colors.add(blue);
			colors.add(yellow);
			colors.add(white);
			red.addActionListener(this);
			blue.addActionListener(this);
			yellow.addActionListener(this);
			white.addActionListener(this);
			c.gridx = 1;
			c.gridy = 1;
			c.gridwidth = 1;
			add(color, c);
			c.gridx = 2;
			add(red, c);
			c.gridx = 3;
			add(blue, c);
			c.gridx = 4;
			add(yellow, c);
			c.gridx = 5;
			add(white, c);
			
			textQuestion = new JLabel("What is written on the button?");
			text = new JTextField(8);
			c.gridx = 1;
			c.gridy = 2;
			add(textQuestion, c);
			c.gridwidth = 4;
			c.gridx = 2;
			add(text, c);
			
			submit = new JButton("Submit");
			submit.addActionListener(this);
			c.gridx = 1;
			c.gridy = 3;
			c.gridwidth = 5;
			add(submit, c);
			
			setVisible(true);
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == red) {
				buttonColor = Colors.RED;
			} else if (e.getSource() == blue) {
				buttonColor = Colors.BLUE;
			} else if (e.getSource() == yellow) {
				buttonColor = Colors.YELLOW;
			} else if (e.getSource() == white) {
				buttonColor = Colors.WHITE;
			} else if (e.getSource() == submit) {
				Solution solution = null;
				try {
					solution = BombGUI.bomb.solveButton(buttonColor, text.getText());
				} catch (IllegalArgumentException f) {
					JOptionPane.showMessageDialog(this, f.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				switch(solution) {
				  case PRESS:
					  JOptionPane.showMessageDialog(this, "Press and immediately release the button.", "Solution", JOptionPane.INFORMATION_MESSAGE);
					  buttonColor = null;
					  colors.clearSelection();
					  text.setText("");
					  BombGUI.returnToMenu();
					  return;
				  case HOLD:
					  changeLayout("HoldPanel");
					  buttonColor = null;
				      colors.clearSelection();
					  text.setText("");
					  return;
			      default:
			    	  JOptionPane.showMessageDialog(this, "Error", "Error", JOptionPane.ERROR_MESSAGE);
					  return;
				}
			}
			
		}
		
	}

	ButtonPanel() {
		super();
		cardLayout = new CardLayout();
		setLayout(cardLayout);
		hold = new HoldPanel();
		button = new ButtonQuestions();
		add(hold, "HoldPanel");
		add(button, "ButtonQuestions");
		cardLayout.show(this, "ButtonQuestions");
	}
	
	/** Changes the card layout
	 * 
	 * @param name the name of the panel to show
	 */
	private void changeLayout(String name) {
		cardLayout.show(this, name);
	}
}
