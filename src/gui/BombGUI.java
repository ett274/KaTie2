/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import manager.Bomb;

/** Class for the Bomb GUI
 * @author Eliza Thornton
 *
 */
public class BombGUI {
	
	private class SetUpPanel extends JPanel implements ActionListener {
		
		
		/** ID number used for object serialization
		 * 
		 */
		private static final long serialVersionUID = -5853475737895157580L;

		/** Title for the set up panel */
		private JLabel title;
		
		/** Question for CAR indicator */
		private JLabel car;
		
		/** Question for FRK indicator */
		private JLabel frk;
		
		/** Question for number of batteries */
		private JLabel batteries;
		
		/** Question for last digit of serial number */
		private JLabel digit;
		
		/** Question for parallel port */
		private JLabel parallel;
		
		/** Question for vowel */
		private JLabel vowel;
		
		/** Yes or No for CAR indicator */
		private ButtonGroup carYN;
		
		/** Yes or No for FRK indicator */
		private ButtonGroup frkYN;
		
		/** Yes or No for parallel port */
		private ButtonGroup parallelYN;
		
		/** Yes or No for vowel in serial number */
		private ButtonGroup vowelYN;
		
		/** Yes for CAR */
		private JRadioButton carYes;
		
		/** No for CAR */
		private JRadioButton carNo;
		
		/** Yes for FRK */
		private JRadioButton frkYes;
		
		/** No for FRK */
		private JRadioButton frkNo;
		
		/** Yes for parallel port */
		private JRadioButton paraYes;
		
		/** No for parallel port */
		private JRadioButton paraNo;
		
		/** Yes for vowel */
		private JRadioButton vowYes;
		
		/** No for vowel */
		private JRadioButton vowNo;
		
		/** Button to finish setup */
		private JButton confirm;
		
		/** Boolean representing the CAR indicator */
		private boolean carBool;
		
		/** Boolean representing the FRK indicator */
		private boolean frkBool;
		
		/** Integer representing the number of batteries */
		private byte numOfBatteries;
		
		/** Boolean representing the parallel port */
		private boolean parallelBool;
		
		/** Boolean representing a vowel in the serial number */
		private boolean vowelBool;
		
		
		/** Place to enter the number of batteries
		 * 
		 */
		private JTextField batteriesText;
		
		/** Place to enter the last digit
		 * 
		 */
		private JTextField digitText;
		
		/** Creates the setupPanel
		 * 
		 */
		public SetUpPanel() {
			super(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			title = new JLabel("Before we get into solving the modules, we need to look at the sides of the bomb for some information.");
			c.gridwidth = 3;
			c.gridx = 0;
			c.gridy = 0;
			add(title, c);
			
			car = new JLabel("Is there a lit indicator labeled CAR on the bomb?");
			c.gridwidth = 1;
			c.weightx = 0.5;
			c.gridx = 0;
			c.gridy = 1;
			add(car, c);
			
			carYes = new JRadioButton("Yes");
			carNo = new JRadioButton("No", true);
			carYN = new ButtonGroup();
			carYN.add(carYes);
			carYN.add(carNo);
			carYes.addActionListener(this);
			carNo.addActionListener(this);
			c.gridx = 1;
			add(carYes, c);
			c.gridx = 2;
			add(carNo, c);
			
			frk = new JLabel("Is there a lit indicator labeled FRK on the bomb?");
			c.gridwidth = 1;
			c.weightx = 0.5;
			c.gridx = 0;
			c.gridy = 2;
			add(frk, c);
			
			frkYes = new JRadioButton("Yes");
			frkNo = new JRadioButton("No", true);
			frkYN = new ButtonGroup();
			frkYN.add(frkYes);
			frkYN.add(frkNo);
			frkYes.addActionListener(this);
			frkNo.addActionListener(this);
			c.gridx = 1;
			add(frkYes, c);
			c.gridx = 2;
			add(frkNo, c);
			
			
			parallel = new JLabel("Is there a long pink port on the bomb?");
			c.gridwidth = 1;
			c.weightx = 0.5;
			c.gridx = 0;
			c.gridy = 3;
			add(parallel, c);
			
			paraYes = new JRadioButton("Yes");
			paraNo = new JRadioButton("No", true);
			parallelYN = new ButtonGroup();
			parallelYN.add(paraYes);
			parallelYN.add(paraNo);
			paraYes.addActionListener(this);
			paraNo.addActionListener(this);
			c.gridx = 1;
			add(paraYes, c);
			c.gridx = 2;
			add(paraNo, c);
			
			batteries = new JLabel("How many batteries are on the bomb?");
			c.gridwidth = 1;
			c.gridx = 0;
			c.gridy = 4;
			add(batteries, c);
			
			batteriesText = new JTextField(1);
			c.gridwidth = 2;
			c.gridx = 1;
			add(batteriesText, c);
			
			vowel = new JLabel("Does the serial number have a vowel?");
			c.gridy = 5;
			c.gridx = 0;
			c.gridwidth = 1;
			add(vowel, c);
			
			vowYes = new JRadioButton("Yes");
			vowNo = new JRadioButton("No", true);
			vowelYN = new ButtonGroup();
			vowelYN.add(vowYes);
			vowelYN.add(vowNo);
			vowYes.addActionListener(this);
			vowNo.addActionListener(this);
			c.gridx = 1;
			add(vowYes, c);
			c.gridx = 2;
			add(vowNo, c);
			
			digit = new JLabel("What is the last digit of the serial number?");
			c.gridwidth = 1;
			c.gridx = 0;
			c.gridy = 6;
			add(digit, c);
			
			digitText = new JTextField(1);
			c.gridwidth = 2;
			c.gridx = 1;
			digitText.addActionListener(this);
			add(digitText, c);
			
			confirm = new JButton("Confirm");
			c.gridy = 7;
			c.gridx = 0;
			c.gridwidth = 3;
			confirm.addActionListener(this);
			add(confirm, c);
			
			bomb = null;
			this.carBool = false;
			this.frkBool = false;
			this.parallelBool = false;
			this.vowelBool = false;
			setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == carYes) {
				this.carBool = true;
			} else if (e.getSource() == carNo) {
				this.carBool = false;
			} else if (e.getSource() == frkYes) {
				this.frkBool = true;
			} else if (e.getSource() == frkNo) {
				this.frkBool = false;
			} else if (e.getSource() == paraYes) {
				this.parallelBool = true;
			} else if (e.getSource() == paraNo) {
				this.parallelBool = false;
			} else if (e.getSource() == vowYes) {
				this.vowelBool = true;
			} else if (e.getSource() == vowNo) {
				this.vowelBool = false;
			} else if (e.getSource() == confirm) {
				if (batteriesText.getText().isBlank()) {
					JOptionPane.showMessageDialog(this, "Enter the number of batteries", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				} else if (digitText.getText().length() != 1) {
					JOptionPane.showMessageDialog(this, "Enter a single digit", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					numOfBatteries = Byte.parseByte(batteriesText.getText());
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(this, "Number of batteries must be a positive number", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				char digitChar = digitText.getText().charAt(0);
				try {
					bomb = new Bomb(carBool, frkBool, numOfBatteries, digitChar, vowelBool, parallelBool);
				} catch (IllegalArgumentException f) {
					JOptionPane.showMessageDialog(this, f.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				returnToMenu();
			}
			
		}
	}

	/** JFrame for the GUI */
	private JFrame gui;
	
	/** Place to enter the bomb's initial information
	 * 
	 */
	private SetUpPanel setUp;
	
	/** Panel for the main menu to select a module
	 * 
	 */
	private MenuPanel menu;
	
	/** Panel for the button module */
	private ButtonPanel button;
	
	/** Panel for the complicated wires module */
	private ComplicatedPanel complicated;
	
	/** Panel for the keypad module */
	private KeypadsPanel keypad;
	
	/** Panel for the knob module */
	private KnobPanel knob;
	
	/** Panel for the maze module */
	private MazePanel maze;
	
	/** Panel for the memory module */
	private MemoryPanel memory;
	
	/** Panel for the morse code module */
	private MorsePanel morse;
	
	/** Panel for the password module */
	private PasswordPanel password;
	
	/** Panel for the wire sequence module */
	private SequencePanel sequence;
	
	/** Panel for the simon says module */
	private SimonPanel simon;
	
	/** Panel for the who's on first module */
	private WhosOnFirstPanel whos;
	
	/** Panel for the wires module */
	private WiresPanel wires;
	
	/** Identifier for the setup panel */
	private static final String SETUP = "SetUpPanel";
	
	/** Identifier for the menu panel */
	private static final String MENU = "MenuPanel";
	
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
	
	
	
	/** Panel that will contain all of the application views */
	private static JPanel panel;

	/** Card layout for the GUI */
	private static CardLayout cardLayout;
	
	/** The bomb created after the setup */
	protected static Bomb bomb;


	/** Constructs a new BombGUI and creates the menus and panels.
	 * 
	 */
	public BombGUI() {
		gui = new JFrame();
		gui.setSize(700, 700);
		gui.setLocation(600, 100);
		gui.setTitle("KaTie 2");
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setUp = new SetUpPanel();
		menu = new MenuPanel();
		button = new ButtonPanel();
		complicated = new ComplicatedPanel();
		keypad = new KeypadsPanel();
		knob = new KnobPanel();
		maze = new MazePanel();
		memory = new MemoryPanel();
		morse = new MorsePanel();
		password = new PasswordPanel();
		sequence = new SequencePanel();
		simon = new SimonPanel();
		whos = new WhosOnFirstPanel();
		wires = new WiresPanel();
		
		panel = new JPanel();
		cardLayout = new CardLayout();
		panel.setLayout(cardLayout);
		panel.add(setUp, SETUP);
		panel.add(menu, MENU);
		panel.add(button, BUTTON);
		panel.add(complicated, COMPLICATED);
		panel.add(keypad, KEYPADS);
		panel.add(knob, KNOB);
		panel.add(maze, MAZE);
		panel.add(memory, MEMORY);
		panel.add(morse, MORSE);
		panel.add(password, PASSWORD);
		panel.add(sequence, SEQUENCE);
		panel.add(simon, SIMON);
		panel.add(whos, WHOS);
		panel.add(wires, WIRES);

		cardLayout.show(panel, SETUP);
		
		Container c = gui.getContentPane();
		c.add(panel, BorderLayout.CENTER);
			
		gui.setVisible(true);
	}
	
	protected static void changeLayout(String name) {
		cardLayout.show(panel, name);
	}
	
	protected static void returnToMenu() {
		changeLayout(MENU);
	}
	
	/** Creates the GUI 
	 * 
	 * @param args command line arguments
	 * */
	public static void main(String[] args) {
		new BombGUI();
	}
	
}
