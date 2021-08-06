/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** Panel to select a specific module
 * @author Eliza Thornton
 *
 */
public class MenuPanel extends JPanel {
	
	/** ID number used for object serialization
	 * 
	 */
	private static final long serialVersionUID = -1834068497922108801L;

	/** Identifier for the button panel */
	private static final String BUTTON = "ButtonPanel";
	
	/** Identifier for the complicated panel */
	private static final String COMPLICATED = "ComplicatedPanel";
	
	/** Identifier for the keypads panel */
	private static final String KEYPADS = "KeypadsPanel";
	
	/** Identifier for the knob panel */
	private static final String KNOB = "KnobPanel";
	
	/** Identifier for the maze panel */
	private static final String MAZE = "MazePanel";
	
	/** Identifier for the memory panel */
	private static final String MEMORY = "MemoryPanel";
	
	/** Identifier for the morse panel */
	private static final String MORSE = "MorsePanel";
	
	/** Identifier for the password panel */
	private static final String PASSWORD = "PasswordPanel";
	
	/** Identifier for the sequence panel */
	private static final String SEQUENCE = "SequencePanel";
	
	/** Identifier for the simon panel */
	private static final String SIMON = "SimonPanel";
	
	/** Identifier for the who's on first panel */
	private static final String WHOS = "WhosOnFirstPanel";
	
	/** Identifier for the wires panel */
	private static final String WIRES = "WiresPanel";
	
	/** Panel containing the buttons
		 * @author Eliza Thornton
		 *
		 */
	private class Buttons extends JPanel implements ActionListener {
		
		/** ID number used for object serialization
		 * 
		 */
		private static final long serialVersionUID = 470534995409801373L;

		/** Button for the button module */
		private JButton button;
		
		/** Picture of the button button */
		private ImageIcon buttonPicture;
		
		/** Button for the complicated wires module */
		private JButton complicated;
		
		/** Picture of the complicated button */
		private ImageIcon complicatedPicture;
		
		/** Button for the keypad module */
		private JButton keypads;
		
		/** Picture of the keypad button */
		private ImageIcon keypadPicture;
		
		/** Button for the knob module */
		private JButton knob;
		
		/** Picture of the knob button */
		private ImageIcon knobPicture;
		
		/** Button for the maze module */
		private JButton maze;
		
		/** Picture of the maze button */
		private ImageIcon mazePicture;
		
		/** Button for the memory module */
		private JButton memory;
		
		/** Picture of the memory button */
		private ImageIcon memoryPicture;
		
		/** Button for the morse module */
		private JButton morse;
		
		/** Picture of the morse button */
		private ImageIcon morsePicture;
		
		/** Button for the password module */
		private JButton password;
		
		/** Picture of the password button */
		private ImageIcon passwordPicture;
		
		/** Button for the sequence module */
		private JButton sequence;
		
		/** Picture of the sequence button */
		private ImageIcon sequencePicture;
		
		/** Button for the simon module */
		private JButton simon;
		
		/** Picture of the simon button */
		private ImageIcon simonPicture;
		
		/** Button for the who's on first module */
		private JButton whos;
		
		/** Picture of the who's on first button */
		private ImageIcon whosPicture;
		
		/** Button for the wires module */
		private JButton wires;
		
		/** Picture of the wires button */
		private ImageIcon wiresPicture;
		
		Buttons() {
			super(new GridLayout(3, 4));
			buttonPicture = new ImageIcon("images/buttonPicture.png");
			button = new JButton(buttonPicture);
			button.addActionListener(this);
			add(button, BUTTON);
			
			complicatedPicture = new ImageIcon("images/complicatedPicture.png");
			complicated = new JButton(complicatedPicture);
			complicated.addActionListener(this);
			add(complicated, COMPLICATED);
			
			keypadPicture = new ImageIcon("images/keypadPicture.png");
			keypads = new JButton(keypadPicture);
			keypads.addActionListener(this);
			add(keypads, KEYPADS);
			
			knobPicture = new ImageIcon("images/knobPicture.png");
			knob = new JButton(knobPicture);
			knob.addActionListener(this);
			add(knob, KNOB);
			
			mazePicture = new ImageIcon("images/mazePicture.png");
			maze = new JButton(mazePicture);
			maze.addActionListener(this);
			add(maze, MAZE);
			
			memoryPicture = new ImageIcon("images/memoryPicture.png");
			memory = new JButton(memoryPicture);
			memory.addActionListener(this);
			add(memory, MEMORY);
			
			morsePicture = new ImageIcon("images/morsePicture.png");
			morse = new JButton(morsePicture);
			morse.addActionListener(this);
			add(morse, MORSE);
			
			passwordPicture = new ImageIcon("images/passwordPicture.png");
			password = new JButton(passwordPicture);
			password.addActionListener(this);
			add(password, PASSWORD);
			
			sequencePicture = new ImageIcon("images/sequencePicture.png");
			sequence = new JButton(sequencePicture);
			sequence.addActionListener(this);
			add(sequence, SEQUENCE);
			
			simonPicture = new ImageIcon("images/simonPicture.png");
			simon = new JButton(simonPicture);
			simon.addActionListener(this);
			add(simon, SIMON);
			
			whosPicture = new ImageIcon("images/whosOnFirstPicture.png");
			whos = new JButton(whosPicture);
			whos.addActionListener(this);
			add(whos, WHOS);
			
			wiresPicture = new ImageIcon("images/wiresPicture.png");
			wires = new JButton(wiresPicture);
			wires.addActionListener(this);
			add(wires, WIRES);
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button) {
				BombGUI.changeLayout(BUTTON);
			} else if (e.getSource() == complicated) {
				BombGUI.changeLayout(COMPLICATED);
			} else if (e.getSource() == keypads) {
				BombGUI.changeLayout(KEYPADS);
			} else if (e.getSource() == knob) {
				BombGUI.changeLayout(KNOB);
			} else if (e.getSource() == maze) {
				BombGUI.changeLayout(MAZE);
			} else if (e.getSource() == memory) {
				BombGUI.changeLayout(MEMORY);
			} else if (e.getSource() == morse) {
				BombGUI.changeLayout(MORSE);
			} else if (e.getSource() == password) {
				BombGUI.changeLayout(PASSWORD);
			} else if (e.getSource() == sequence) {
				BombGUI.changeLayout(SEQUENCE);
			} else if (e.getSource() == simon) {
				BombGUI.changeLayout(SIMON);
			} else if (e.getSource() == whos) {
				BombGUI.changeLayout(WHOS);
			} else if (e.getSource() == wires) {
				BombGUI.changeLayout(WIRES);
			}
			
		}
	}
	
	
	/** Title above the menu */
	private JLabel select;
	
	/** Menu of the buttons */
	private Buttons buttons;
	
	/** The layout of the menu */
	private BorderLayout border;
	
	MenuPanel() {
		super();
		border = new BorderLayout();
		border.setVgap(50);
		setLayout(border);
		select = new JLabel("Select which module to solve: ");
		select.setHorizontalAlignment(JLabel.CENTER);
		select.setVerticalAlignment(JLabel.CENTER);
		this.add(select, BorderLayout.NORTH);
		buttons = new Buttons();
		this.add(buttons, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	
	
}
