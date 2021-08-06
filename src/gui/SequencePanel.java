package gui;

import java.awt.Color;
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

import modules.Colors;
import modules.Sequence.Letters;

/**
 * GUI for the wire sequence panel
 * @author Eliza Thornton
 *
 */
public class SequencePanel extends JPanel implements ActionListener  {
	
	/** ID number used for object serialization
	 * 
	 */
	private static final long serialVersionUID = 7984489349157373580L;

	/** Indicates which wire we're looking at */
	private JLabel wireNumber;
	
	/** Asks what color the wire is */
	private JLabel colorAsk;
	
	/** Asks what letter the wire is connected to */
	private JLabel letterAsk;
	
	/** The group of radio buttons for the wire colors */
	private ButtonGroup colors;
	
	/** Button for the color red */
	private JRadioButton red;
	
	/** Button for the color blue */
	private JRadioButton blue;
	
	/** Button for the color black */
	private JRadioButton black;
	
	/** The group of radio buttons for the wire letters */
	private ButtonGroup letters;
	
	/** Button for the letter A */
	private JRadioButton a;
	
	/** Button for the letter B */
	private JRadioButton b;
	
	/** Button for the letter A */
	private JRadioButton c;
	
	/** Button to submit the wire */
	private JButton submit;
	
	/** Button to finish the current panel */
	private JButton finish;
	
	/** Buttons for the color question */
	private JPanel colorPanel;
	
	/** Buttons for the letter question */
	private JPanel letterPanel;
	
	/** Place to keep the buttons */
	private JPanel buttonsPanel;
	
	/** The wire count in the current panel */
	private byte wireCount;
	
	/** The current panel in the module */
	private byte panelCount;
	
	/** The color of the current wire */
	private Colors wireColor;
	
	/** The letter of the current wire */
	private Letters wireLetter;
	
	/** Describes which wires to cut */
	private StringBuilder instructions;
	
	SequencePanel() {
		super(new GridLayout(4, 1));
		wireCount = 1;
		panelCount = 1;
		wireNumber = new JLabel();
		wireNumber.setText("Check wire number " + wireCount + " from the top - ignore gaps. Press Finish when all the wires in the panel have been submitted.");
		wireNumber.setHorizontalAlignment(JLabel.CENTER);
		add(wireNumber);
		
		colorPanel = new JPanel(new FlowLayout());
		colorAsk = new JLabel("What color is the wire?");
		colorPanel.add(colorAsk);
		colors = new ButtonGroup();
		red = new JRadioButton("Red");
		red.setBackground(Color.RED);
		colors.add(red);
		blue = new JRadioButton("Blue");
		blue.setBackground(Color.BLUE);
		colors.add(blue);
		black = new JRadioButton("Black");
		black.setBackground(Color.GRAY);
		colors.add(black);
		red.addActionListener(this);
		blue.addActionListener(this);
		black.addActionListener(this);
		colorPanel.add(red);
		colorPanel.add(blue);
		colorPanel.add(black);
		add(colorPanel);
		
		letterPanel = new JPanel(new FlowLayout());
		letterAsk = new JLabel("What letter is the wire connected to?");
		letterPanel.add(letterAsk);
		letters = new ButtonGroup();
		a = new JRadioButton("A");
		letters.add(a);
		b = new JRadioButton("B");
		letters.add(b);
		c = new JRadioButton("C");
		letters.add(c);
		a.addActionListener(this);
		b.addActionListener(this);
		c.addActionListener(this);
		letterPanel.add(a);
		letterPanel.add(b);
		letterPanel.add(c);
		add(letterPanel);
		
		buttonsPanel = new JPanel(new FlowLayout());
		submit = new JButton("Submit");
		submit.addActionListener(this);
		buttonsPanel.add(submit);
		finish = new JButton("Finish Panel");
		finish.addActionListener(this);
		buttonsPanel.add(finish);
		add(buttonsPanel);
		
		panelCount = 1;
		wireColor = null;
		wireLetter = null;
		instructions = new StringBuilder();
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == red) {
			wireColor = Colors.RED;
		} else if (e.getSource() == blue) {
			wireColor = Colors.BLUE;
		} else if (e.getSource() == black) {
			wireColor = Colors.BLACK;
		} else if (e.getSource() == a) {
			wireLetter = Letters.A;
		} else if (e.getSource() == b) {
			wireLetter = Letters.B;
		} else if (e.getSource() == c) {
			wireLetter = Letters.C;
		} else if (e.getSource() == submit) {
			try {
				if (BombGUI.bomb.solveSequence(wireColor, wireLetter, panelCount == 1 && wireCount == 1)) {
					instructions.append("Cut, ");
				} else {
					instructions.append("Don't Cut, ");
				}
				if (wireCount == 3) {
					JOptionPane.showMessageDialog(this, instructions.substring(0, instructions.length() - 2), "From top to bottom:", JOptionPane.INFORMATION_MESSAGE);
					nextPanel();
				} else {
					wireCount++;
					wireNumber.setText("Check wire number " + wireCount + " from the top - ignore gaps. Press Finish when all the wires in the panel have been submitted.");
					colors.clearSelection();
					letters.clearSelection();
					wireColor = null;
					wireLetter = null;
				}
			} catch (IllegalArgumentException i) {
				JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getSource() == finish) {
			if (instructions.length() == 0) {
				JOptionPane.showMessageDialog(this, "Just proceed to the next panel.", "Instructions:", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, instructions.substring(0, instructions.length() - 2), "From top to bottom:", JOptionPane.INFORMATION_MESSAGE);
			}
			nextPanel();
		}
		
	}
	
	private void nextPanel() {
		instructions.delete(0, instructions.length());
		wireCount = 1;
		wireNumber.setText("Check wire number " + wireCount + " from the top - ignore gaps. Press Finish when all the wires in the panel have been submitted.");
		wireColor = null;
		wireLetter = null;
		colors.clearSelection();
		letters.clearSelection();
		if (panelCount == 4) {
			panelCount = 1;
			BombGUI.returnToMenu();
		} else {
			panelCount++;
		}
	}

}
