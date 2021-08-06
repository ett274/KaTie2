/**
 * 
 */
package gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import modules.Knob.Directions;

/** GUI for the knob module
 * @author Eliza Thornton
 *
 */
public class KnobPanel extends JPanel implements ActionListener {

	/** ID number used for object serialization
	 * 
	 */
	private static final long serialVersionUID = 5397131626877155560L;

	/** The checkboxes for the lights
		 * @author Eliza Thornton
		 *
		 */
	private class CheckBoxes extends JPanel implements ItemListener {

		/** ID number used for object serialization
		 * 
		 */
		private static final long serialVersionUID = 6971280266341826534L;

		/** Checkbox representing the top left light */
		private JCheckBox topLeftBox;
		
		/** Checkbox representing the bottom left light */
		private JCheckBox bottomLeftBox;
		
		/** Checkbox representing the middle top light */
		private JCheckBox middleTopBox;
		
		/** Checkbox representing the middle bottom light */
		private JCheckBox middleBottomBox;
		
		/** Checkbox representing the top right light */
		private JCheckBox topRightBox;
		
		/** Checkbox representing the bottom right light */
		private JCheckBox bottomRightBox;
		
		CheckBoxes() {
			super(new GridLayout(2, 3));
			topLeftBox = new JCheckBox();
			topLeftBox.addItemListener(this);
			add(topLeftBox);
			middleTopBox = new JCheckBox();
			middleTopBox.addItemListener(this);
			add(middleTopBox);
			topRightBox = new JCheckBox();
			add(topRightBox);
			bottomLeftBox = new JCheckBox();
			bottomLeftBox.addItemListener(this);
			add(bottomLeftBox);
			middleBottomBox = new JCheckBox();
			middleBottomBox.addItemListener(this);
			add(middleBottomBox);
			bottomRightBox = new JCheckBox();
			bottomRightBox.addItemListener(this);
			add(bottomRightBox);
			
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			int selected = e.getStateChange();
			if (e.getItemSelectable() == topLeftBox) {
				if (selected == ItemEvent.SELECTED) {
					topLeft = true;
				} else if (selected == ItemEvent.DESELECTED) {
					topLeft = false;
				}
			} else if (e.getItemSelectable() == bottomLeftBox) {
				if (selected == ItemEvent.SELECTED) {
					bottomLeft = true;
				} else if (selected == ItemEvent.DESELECTED) {
					bottomLeft = false;
				}
			} else if (e.getItemSelectable() == middleTopBox) {
				if (selected == ItemEvent.SELECTED) {
					middleTop = true;
				} else if (selected == ItemEvent.DESELECTED) {
					middleTop = false;
				}
			} else if (e.getItemSelectable() == middleBottomBox) {
				if (selected == ItemEvent.SELECTED) {
					middleBottom = true;
				} else if (selected == ItemEvent.DESELECTED) {
					middleBottom = false;
				}
			} else if (e.getItemSelectable() == bottomRightBox) {
				if (selected == ItemEvent.SELECTED) {
					bottomRight = true;
				} else if (selected == ItemEvent.DESELECTED) {
					bottomRight = false;
				}
			} 

		}

		protected void finish() {
			topLeft = false;
			middleBottom = false;
			middleTop = false;
			bottomLeft = false;
			bottomRight = false;
			if (topLeftBox.isSelected()) {
				topLeftBox.setSelected(false);
			}
			if (topRightBox.isSelected()) {
				topRightBox.setSelected(false);
			}
			if (middleTopBox.isSelected()) {
				middleTopBox.setSelected(false);
			}
			if (middleBottomBox.isSelected()) {
				middleBottomBox.setSelected(false);
			}
			if (bottomLeftBox.isSelected()) {
				bottomLeftBox.setSelected(false);
			}
			if (bottomRightBox.isSelected()) {
				bottomRightBox.setSelected(false);
			}
			BombGUI.returnToMenu();
		}
	}


	

	/** Picture to show which lights to look at */
	private JLabel info;
	
	/** Text clarifying about the lights */
	private JLabel label;
	
	/** Text asking which direction the UP label is */
	private JLabel upLabel;
	
	/** Panel containing the radio buttons and label for the up label */
	private JPanel upLabelQuestion;
	
	/** The group of radio buttons for the up label direction */
	private ButtonGroup directions;
	
	/** The button representing up */
	private JRadioButton up;
	
	/** The button representing down */
	private JRadioButton down;
	
	/** The button representing left */
	private JRadioButton left;
	
	/** The button representing right */
	private JRadioButton right;
	
	/** Label instructing to select the boxes */
	private JLabel selectText;
	
	/** Panel that contains the check boxes for the lights */
	private CheckBoxes boxes;
	
	/** Button to submit the knob */
	private JButton submit;
	
	/** Represents if the top left light is on */
	private boolean topLeft;
	
	/** Represents if the bottom left light is on */
	private boolean bottomLeft;
	
	/** Represents if the middle bottom light is on */
	private boolean middleBottom;
	
	/** Represents if the middle top light is on */
	private boolean middleTop;
	
	/** Represents if the bottom right light is on */
	private boolean bottomRight;
	
	/** The direction the up label is facing */
	private Directions labelDirection;
	
	KnobPanel() {
		super(new GridLayout(6, 1));
		info = new JLabel(new ImageIcon("images/knobInfo.png"));
		label = new JLabel("ONLY LOOK AT THE LIGHTS ON THE LEFT SIDE!");
		label.setLabelFor(info);
		label.setHorizontalAlignment(JLabel.CENTER);
		add(info);
		add(label);
		upLabelQuestion = new JPanel(new FlowLayout());
		upLabel = new JLabel("What direction is the UP label facing?");
		upLabel.setHorizontalAlignment(JLabel.CENTER);
		upLabelQuestion.add(upLabel);
		up = new JRadioButton("Up", true);
		down = new JRadioButton("Down", false);
		left = new JRadioButton("Left", false);
		right = new JRadioButton("Right", false);
		directions = new ButtonGroup();
		directions.add(up);
		directions.add(down);
		directions.add(left);
		directions.add(right);
		up.addActionListener(this);
		down.addActionListener(this);
		left.addActionListener(this);
		right.addActionListener(this);
		upLabelQuestion.add(up);
		upLabelQuestion.add(down);
		upLabelQuestion.add(left);
		upLabelQuestion.add(right);
		add(upLabelQuestion);
		
		selectText = new JLabel("Select which lights are on:");
		selectText.setHorizontalAlignment(JLabel.CENTER);
		add(selectText);
		
		boxes = new CheckBoxes();
		add(boxes);
		
		submit = new JButton("Submit");
		submit.addActionListener(this);
		add(submit);
		
		topLeft = false;
		middleBottom = false;
		middleTop = false;
		bottomLeft = false;
		bottomRight = false;
		labelDirection = Directions.UP;
		
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == up) {
			labelDirection = Directions.UP;
		} else if (e.getSource() == down) {
			labelDirection = Directions.DOWN;
		} else if (e.getSource() == left) {
			labelDirection = Directions.LEFT;
		} else if (e.getSource() == right) {
			labelDirection = Directions.RIGHT;
		} else if (e.getSource() == submit) {
			Directions solution = BombGUI.bomb.solveKnob(labelDirection, topLeft, bottomLeft, bottomRight, middleBottom, middleTop);
			switch(solution) {
			case DOWN:
				JOptionPane.showMessageDialog(this, "Turn the knob down.");
				boxes.finish();
				break;
			case LEFT:
				JOptionPane.showMessageDialog(this, "Turn the knob left.");
				boxes.finish();
				break;
			case RIGHT:
				JOptionPane.showMessageDialog(this, "Turn the knob right.");
				boxes.finish();
				break;
			case UP:
				JOptionPane.showMessageDialog(this, "Turn the knob up.");
				boxes.finish();
				break;
			default:
				break;
				
			}
		}
		
	}
	
}
