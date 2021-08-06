package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * GUI for the complicated panel
 * @author Eliza Thornton
 *
 */
public class ComplicatedPanel extends JPanel implements ActionListener {

	/** ID number used for object serialization
	 * 
	 */
	private static final long serialVersionUID = -4797265644776364231L;

	/** Asks about the wire properties */
	private JLabel question;
	
	/** Checkbox for red coloring */
	private JCheckBox red;
	
	/** Checkbox for blue coloring */
	private JCheckBox blue;
	
	/** Checkbox for a star */
	private JCheckBox star;
	
	/** Checkbox for the led */
	private JCheckBox led;
	
	/** Button to submit the current wire */
	private JButton submit;
	
	/** Button to finish and give the instructions */
	private JButton done;
	
	/** True if the wire has red coloring */
	private boolean redColor;
	
	/** True if the wire has blue coloring */
	private boolean blueColor;
	
	/** True if the wire has a star */
	private boolean starBoolean;
	
	/** True if the wire has the LED on */
	private boolean lightOn;
	
	/** Shows the instructions to cut or not cut the wires */
	private StringBuilder instructions;
	
	/** The current number of the wire */
	private byte count;
	
	ComplicatedPanel() {
		super(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 2;
		question = new JLabel("Check the details of wire number 1:");
		add(question, c);
		red = new JCheckBox("The wire has red coloring (Stripes count)");
		red.addActionListener(this);
		blue = new JCheckBox("The wire has blue coloring (Stripes count)");
		blue.addActionListener(this);
		star = new JCheckBox("The wire has a star underneath");
		star.addActionListener(this);
		led = new JCheckBox("The LED above the wire is on");
		led.addActionListener(this);
		submit = new JButton("Submit");
		submit.addActionListener(this);
		done = new JButton("Finished");
		done.addActionListener(this);
		c.gridy = 2;
		add(red, c);
		c.gridy = 3;
		add(blue, c);
		c.gridy = 4;
		add(star, c);
		c.gridy = 5;
		add(led, c);
		c.gridy = 6;
		c.gridwidth = 1;
		add(submit, c);
		c.gridx = 2;
		add(done, c);
		
		redColor = false;
		blueColor = false;
		starBoolean = false;
		lightOn = false;
		instructions = new StringBuilder();
		count = 1;
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == red) {
			redColor = red.isSelected();
		} else if (e.getSource() == blue) {
			blueColor = blue.isSelected();
		} else if (e.getSource() == star) {
			starBoolean = star.isSelected();
		} else if (e.getSource() == led) {
			lightOn = led.isSelected();
		} else if (e.getSource() == submit) {
			if (BombGUI.bomb.solveComplicated(redColor, blueColor, starBoolean, lightOn)) {
				instructions.append("Cut, ");
			} else {
				instructions.append("Don't Cut, ");
			}
			red.setSelected(false);
			blue.setSelected(false);
			star.setSelected(false);
			led.setSelected(false);
			redColor = false;
			blueColor = false;
			starBoolean = false;
			lightOn = false;
			if (count == 6) {
				count = 1;
				red.setSelected(false);
				blue.setSelected(false);
				star.setSelected(false);
				led.setSelected(false);
				redColor = false;
				blueColor = false;
				starBoolean = false;
				lightOn = false;
				JOptionPane.showMessageDialog(this, instructions.substring(0, instructions.length() - 2), "Solution", JOptionPane.INFORMATION_MESSAGE);
				instructions.delete(0, instructions.length());
				question.setText("Check the details of wire number 1:");
				BombGUI.returnToMenu();
			} else {
				count++;
				question.setText("Check the details of wire number " + count + ":");
			}
		} else if (e.getSource() == done) {
			if (count == 1) {
				JOptionPane.showMessageDialog(this, "Must input at least one wire", "Invalid input", JOptionPane.ERROR_MESSAGE);
			} else {
				count = 1;
				red.setSelected(false);
				blue.setSelected(false);
				star.setSelected(false);
				led.setSelected(false);
				redColor = false;
				blueColor = false;
				starBoolean = false;
				lightOn = false;
				JOptionPane.showMessageDialog(this, instructions.substring(0, instructions.length() - 2), "Solution", JOptionPane.INFORMATION_MESSAGE);
				instructions.delete(0, instructions.length());
				question.setText("Check the details of wire number 1:");
				BombGUI.returnToMenu();
			}
		}
		
	}

}
