/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
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

/** GUI for the maze module
 * @author Eliza Thornton
 *
 */
public class MazePanel extends JPanel {
	
	/** ID number used for object serialization
	 * 
	 */
	private static final long serialVersionUID = 1611929741382725894L;

	/** Value of one */
	private static final byte ONE = 1;
	
	/** Value of two */
	private static final byte TWO = 2;
	
	/** Value of three */
	private static final byte THREE = 3;
	
	/** Value of four */
	private static final byte FOUR = 4;
	
	/** Value of five */
	private static final byte FIVE = 5;
	
	/** Value of six */
	private static final byte SIX = 6;

	/** Asks where the white square is
		 * @author Eliza Thornton
		 *
		 */
	private class WhiteSquareQuestion extends JPanel implements ActionListener {

		
		/** ID number used for object serialization
		 * 
		 */
		private static final long serialVersionUID = -8042961035749879549L;
		
		/** Contains the radio button group of the maze
				 * @author Eliza Thornton
				 *
				 */
		private class MazeRadioButtons extends JPanel implements ActionListener {
			
			/** ID number used for object serialization
			 * 
			 */
			private static final long serialVersionUID = -5581640536398712823L;

			/** The group of buttons representing the maze */
			private ButtonGroup maze;
			
			/** The radio button at (1,1) */
			private JRadioButton box11;
			
			/** The radio button at (1,2) */
			private JRadioButton box12;
			
			/** The radio button at (1,3) */
			private JRadioButton box13;
			
			/** The radio button at (1,4) */
			private JRadioButton box14;
			
			/** The radio button at (1,5) */
			private JRadioButton box15;
			
			/** The radio button at (1,6) */
			private JRadioButton box16;
			
			/** The radio button at (2,1) */
			private JRadioButton box21;
			
			/** The radio button at (2,2) */
			private JRadioButton box22;
			
			/** The radio button at (2,3) */
			private JRadioButton box23;
			
			/** The radio button at (2,4) */
			private JRadioButton box24;
			
			/** The radio button at (2,5) */
			private JRadioButton box25;
			
			/** The radio button at (2,6) */
			private JRadioButton box26;
			
			/** The radio button at (3,1) */
			private JRadioButton box31;
			
			/** The radio button at (3,2) */
			private JRadioButton box32;
			
			/** The radio button at (3,3) */
			private JRadioButton box33;
			
			/** The radio button at (3,4) */
			private JRadioButton box34;
			
			/** The radio button at (3,5) */
			private JRadioButton box35;
			
			/** The radio button at (3,6) */
			private JRadioButton box36;
			
			/** The radio button at (4,1) */
			private JRadioButton box41;
			
			/** The radio button at (4,2) */
			private JRadioButton box42;
			
			/** The radio button at (4,3) */
			private JRadioButton box43;
			
			/** The radio button at (4,4) */
			private JRadioButton box44;
			
			/** The radio button at (4,5) */
			private JRadioButton box45;
			
			/** The radio button at (4,6) */
			private JRadioButton box46;
			
			/** The radio button at (5,1) */
			private JRadioButton box51;
			
			/** The radio button at (5,2) */
			private JRadioButton box52;
			
			/** The radio button at (5,3) */
			private JRadioButton box53;
			
			/** The radio button at (5,4) */
			private JRadioButton box54;
			
			/** The radio button at (5,5) */
			private JRadioButton box55;
			
			/** The radio button at (5,6) */
			private JRadioButton box56;
			
			/** The radio button at (6,1) */
			private JRadioButton box61;
			
			/** The radio button at (6,2) */
			private JRadioButton box62;
			
			/** The radio button at (6,3) */
			private JRadioButton box63;
			
			/** The radio button at (6,4) */
			private JRadioButton box64;
			
			/** The radio button at (6,5) */
			private JRadioButton box65;
			
			/** The radio button at (6,6) */
			private JRadioButton box66;
			
			MazeRadioButtons() {
				super(new GridLayout(SIX, SIX));
				box11 = new JRadioButton(CHECK);
				box11.setSelectedIcon(CHECK_SELECTED);
				box12 = new JRadioButton(CHECK);
				box12.setSelectedIcon(CHECK_SELECTED);
				box13 = new JRadioButton(CHECK);
				box13.setSelectedIcon(CHECK_SELECTED);
				box14 = new JRadioButton(CHECK);
				box14.setSelectedIcon(CHECK_SELECTED);
				box15 = new JRadioButton(CHECK);
				box15.setSelectedIcon(CHECK_SELECTED);
				box16 = new JRadioButton(CHECK);
				box16.setSelectedIcon(CHECK_SELECTED);
				box21 = new JRadioButton(CHECK);
				box21.setSelectedIcon(CHECK_SELECTED);
				box22 = new JRadioButton(CHECK);
				box22.setSelectedIcon(CHECK_SELECTED);
				box23 = new JRadioButton(CHECK);
				box23.setSelectedIcon(CHECK_SELECTED);
				box24 = new JRadioButton(CHECK);
				box24.setSelectedIcon(CHECK_SELECTED);
				box25 = new JRadioButton(CHECK);
				box25.setSelectedIcon(CHECK_SELECTED);
				box26 = new JRadioButton(CHECK);
				box26.setSelectedIcon(CHECK_SELECTED);
				box31 = new JRadioButton(CHECK);
				box31.setSelectedIcon(CHECK_SELECTED);
				box32 = new JRadioButton(CHECK);
				box32.setSelectedIcon(CHECK_SELECTED);
				box33 = new JRadioButton(CHECK);
				box33.setSelectedIcon(CHECK_SELECTED);
				box34 = new JRadioButton(CHECK);
				box34.setSelectedIcon(CHECK_SELECTED);
				box35 = new JRadioButton(CHECK);
				box35.setSelectedIcon(CHECK_SELECTED);
				box36 = new JRadioButton(CHECK);
				box36.setSelectedIcon(CHECK_SELECTED);
				box41 = new JRadioButton(CHECK);
				box41.setSelectedIcon(CHECK_SELECTED);
				box42 = new JRadioButton(CHECK);
				box42.setSelectedIcon(CHECK_SELECTED);
				box43 = new JRadioButton(CHECK);
				box43.setSelectedIcon(CHECK_SELECTED);
				box44 = new JRadioButton(CHECK);
				box44.setSelectedIcon(CHECK_SELECTED);
				box45 = new JRadioButton(CHECK);
				box45.setSelectedIcon(CHECK_SELECTED);
				box46 = new JRadioButton(CHECK);
				box46.setSelectedIcon(CHECK_SELECTED);
				box51 = new JRadioButton(CHECK);
				box51.setSelectedIcon(CHECK_SELECTED);
				box52 = new JRadioButton(CHECK);
				box52.setSelectedIcon(CHECK_SELECTED);
				box53 = new JRadioButton(CHECK);
				box53.setSelectedIcon(CHECK_SELECTED);
				box54 = new JRadioButton(CHECK);
				box54.setSelectedIcon(CHECK_SELECTED);
				box55 = new JRadioButton(CHECK);
				box55.setSelectedIcon(CHECK_SELECTED);
				box56 = new JRadioButton(CHECK);
				box56.setSelectedIcon(CHECK_SELECTED);
				box61 = new JRadioButton(CHECK);
				box61.setSelectedIcon(CHECK_SELECTED);
				box62 = new JRadioButton(CHECK);
				box62.setSelectedIcon(CHECK_SELECTED);
				box63 = new JRadioButton(CHECK);
				box63.setSelectedIcon(CHECK_SELECTED);
				box64 = new JRadioButton(CHECK);
				box64.setSelectedIcon(CHECK_SELECTED);
				box65 = new JRadioButton(CHECK);
				box65.setSelectedIcon(CHECK_SELECTED);
				box66 = new JRadioButton(CHECK);
				box66.setSelectedIcon(CHECK_SELECTED);
				maze = new ButtonGroup();
				
				maze.add(box11);
				maze.add(box12);
				maze.add(box13);
				maze.add(box14);
				maze.add(box15);
				maze.add(box16);
				maze.add(box21);
				maze.add(box22);
				maze.add(box23);
				maze.add(box24);
				maze.add(box25);
				maze.add(box26);
				maze.add(box31);
				maze.add(box32);
				maze.add(box33);
				maze.add(box34);
				maze.add(box35);
				maze.add(box36);
				maze.add(box41);
				maze.add(box42);
				maze.add(box43);
				maze.add(box44);
				maze.add(box45);
				maze.add(box46);
				maze.add(box51);
				maze.add(box52);
				maze.add(box53);
				maze.add(box54);
				maze.add(box55);
				maze.add(box56);
				maze.add(box61);
				maze.add(box62);
				maze.add(box63);
				maze.add(box64);
				maze.add(box65);
				maze.add(box66);
				
				box11.addActionListener(this);
				box12.addActionListener(this);
				box13.addActionListener(this);
				box14.addActionListener(this);
				box15.addActionListener(this);
				box16.addActionListener(this);
				box21.addActionListener(this);
				box22.addActionListener(this);
				box23.addActionListener(this);
				box24.addActionListener(this);
				box25.addActionListener(this);
				box26.addActionListener(this);
				box31.addActionListener(this);
				box32.addActionListener(this);
				box33.addActionListener(this);
				box34.addActionListener(this);
				box35.addActionListener(this);
				box36.addActionListener(this);
				box41.addActionListener(this);
				box42.addActionListener(this);
				box43.addActionListener(this);
				box44.addActionListener(this);
				box45.addActionListener(this);
				box46.addActionListener(this);
				box51.addActionListener(this);
				box52.addActionListener(this);
				box53.addActionListener(this);
				box54.addActionListener(this);
				box55.addActionListener(this);
				box56.addActionListener(this);
				box61.addActionListener(this);
				box62.addActionListener(this);
				box63.addActionListener(this);
				box64.addActionListener(this);
				box65.addActionListener(this);
				box66.addActionListener(this);
				
				add(box61);
				add(box62);
				add(box63);
				add(box64);
				add(box65);
				add(box66);
				add(box51);
				add(box52);
				add(box53);
				add(box54);
				add(box55);
				add(box56);
				add(box41);
				add(box42);
				add(box43);
				add(box44);
				add(box45);
				add(box46);
				add(box31);
				add(box32);
				add(box33);
				add(box34);
				add(box35);
				add(box36);
				add(box21);
				add(box22);
				add(box23);
				add(box24);
				add(box25);
				add(box26);
				add(box11);
				add(box12);
				add(box13);
				add(box14);
				add(box15);
				add(box16);
				
				whitex = 0;
				whitey = 0;
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == box11) {
					whitey = ONE;
					whitex = ONE;
				} else if (e.getSource() == box12) {
					whitey = ONE;
					whitex = TWO;
				} else if (e.getSource() == box13) {
					whitey = ONE;
					whitex = 3;
				} else if (e.getSource() == box14) {
					whitey = ONE;
					whitex = FOUR;
				} else if (e.getSource() == box15) {
					whitey = ONE;
					whitex = FIVE;
				} else if (e.getSource() == box16) {
					whitey = ONE;
					whitex = SIX;
				} else if (e.getSource() == box21) {
					whitey = TWO;
					whitex = ONE;
				} else if (e.getSource() == box22) {
					whitey = TWO;
					whitex = TWO;
				} else if (e.getSource() == box23) {
					whitey = TWO;
					whitex = THREE;
				} else if (e.getSource() == box24) {
					whitey = TWO;
					whitex = FOUR;
				} else if (e.getSource() == box25) {
					whitey = TWO;
					whitex = FIVE;
				} else if (e.getSource() == box26) {
					whitey = TWO;
					whitex = SIX;
				} else if (e.getSource() == box31) {
					whitey = THREE;
					whitex = ONE;
				} else if (e.getSource() == box32) {
					whitey = THREE;
					whitex = TWO;
				} else if (e.getSource() == box33) {
					whitey = THREE;
					whitex = THREE;
				} else if (e.getSource() == box34) {
					whitey = THREE;
					whitex = FOUR;
				} else if (e.getSource() == box35) {
					whitey = THREE;
					whitex = FIVE;
				} else if (e.getSource() == box36) {
					whitey = THREE;
					whitex = SIX;
				} else if (e.getSource() == box41) {
					whitey = FOUR;
					whitex = ONE;
				} else if (e.getSource() == box42) {
					whitey = FOUR;
					whitex = TWO;
				} else if (e.getSource() == box43) {
					whitey = FOUR;
					whitex = THREE;
				} else if (e.getSource() == box44) {
					whitey = FOUR;
					whitex = FOUR;
				} else if (e.getSource() == box45) {
					whitey = FOUR;
					whitex = FIVE;
				} else if (e.getSource() == box46) {
					whitey = FOUR;
					whitex = SIX;
				} else if (e.getSource() == box51) {
					whitey = FIVE;
					whitex = ONE;
				} else if (e.getSource() == box52) {
					whitey = FIVE;
					whitex = TWO;
				} else if (e.getSource() == box53) {
					whitey = FIVE;
					whitex = THREE;
				} else if (e.getSource() == box54) {
					whitey = FIVE;
					whitex = FOUR;
				} else if (e.getSource() == box55) {
					whitey = FIVE;
					whitex = FIVE;
				} else if (e.getSource() == box56) {
					whitey = FIVE;
					whitex = SIX;
				} else if (e.getSource() == box61) {
					whitey = SIX;
					whitex = ONE;
				} else if (e.getSource() == box62) {
					whitey = SIX;
					whitex = TWO;
				} else if (e.getSource() == box63) {
					whitey = SIX;
					whitex = THREE;
				} else if (e.getSource() == box64) {
					whitey = SIX;
					whitex = FOUR;
				} else if (e.getSource() == box65) {
					whitey = SIX;
					whitex = FIVE;
				} else if (e.getSource() == box66) {
					whitey = SIX;
					whitex = SIX;
				}
					
			}

		}
		
		/** Gives instructions about entering the white square coordinates */
		private JLabel question;
		
		/** Contains the radio buttons representing the maze */
		private MazeRadioButtons radioButtons;
		
		/** Button to submit the coordinates */
		private JButton submit;
		
		WhiteSquareQuestion() {
			super(new BorderLayout());
			question = new JLabel("Select where the white square is:");
			question.setHorizontalAlignment(JLabel.CENTER);
			add(question, BorderLayout.NORTH);
			radioButtons = new MazeRadioButtons();
			add(radioButtons, BorderLayout.CENTER);
			submit = new JButton("Submit");
			submit.addActionListener(this);
			add(submit, BorderLayout.SOUTH);
			
			whitex = 0;
			whitey = 0;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == submit) {
				if (whitex == 0 || whitey == 0) {
					JOptionPane.showMessageDialog(this, "Select a button", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					changeLayout("Red Triangle");
				}
			}

		}

	}

	/** Asks where the white square is
	 * @author Eliza Thornton
	 *
	 */
	private class RedTriangleQuestion extends JPanel implements ActionListener {
	
		
		/** ID number used for object serialization
		 * 
		 */
		private static final long serialVersionUID = 4034842981940162093L;
		
		/** Contains the radio button group of the maze
				 * @author Eliza Thornton
				 *
				 */
		private class MazeRadioButtons extends JPanel implements ActionListener {
			
			/** ID number used for object serialization
			 * 
			 */
			private static final long serialVersionUID = -4575263628888411218L;

			/** The group of buttons representing the maze */
			private ButtonGroup maze;
			
			/** The radio button at (1,1) */
			private JRadioButton box11;
			
			/** The radio button at (1,2) */
			private JRadioButton box12;
			
			/** The radio button at (1,3) */
			private JRadioButton box13;
			
			/** The radio button at (1,4) */
			private JRadioButton box14;
			
			/** The radio button at (1,5) */
			private JRadioButton box15;
			
			/** The radio button at (1,6) */
			private JRadioButton box16;
			
			/** The radio button at (2,1) */
			private JRadioButton box21;
			
			/** The radio button at (2,2) */
			private JRadioButton box22;
			
			/** The radio button at (2,3) */
			private JRadioButton box23;
			
			/** The radio button at (2,4) */
			private JRadioButton box24;
			
			/** The radio button at (2,5) */
			private JRadioButton box25;
			
			/** The radio button at (2,6) */
			private JRadioButton box26;
			
			/** The radio button at (3,1) */
			private JRadioButton box31;
			
			/** The radio button at (3,2) */
			private JRadioButton box32;
			
			/** The radio button at (3,3) */
			private JRadioButton box33;
			
			/** The radio button at (3,4) */
			private JRadioButton box34;
			
			/** The radio button at (3,5) */
			private JRadioButton box35;
			
			/** The radio button at (3,6) */
			private JRadioButton box36;
			
			/** The radio button at (4,1) */
			private JRadioButton box41;
			
			/** The radio button at (4,2) */
			private JRadioButton box42;
			
			/** The radio button at (4,3) */
			private JRadioButton box43;
			
			/** The radio button at (4,4) */
			private JRadioButton box44;
			
			/** The radio button at (4,5) */
			private JRadioButton box45;
			
			/** The radio button at (4,6) */
			private JRadioButton box46;
			
			/** The radio button at (5,1) */
			private JRadioButton box51;
			
			/** The radio button at (5,2) */
			private JRadioButton box52;
			
			/** The radio button at (5,3) */
			private JRadioButton box53;
			
			/** The radio button at (5,4) */
			private JRadioButton box54;
			
			/** The radio button at (5,5) */
			private JRadioButton box55;
			
			/** The radio button at (5,6) */
			private JRadioButton box56;
			
			/** The radio button at (6,1) */
			private JRadioButton box61;
			
			/** The radio button at (6,2) */
			private JRadioButton box62;
			
			/** The radio button at (6,3) */
			private JRadioButton box63;
			
			/** The radio button at (6,4) */
			private JRadioButton box64;
			
			/** The radio button at (6,5) */
			private JRadioButton box65;
			
			/** The radio button at (6,6) */
			private JRadioButton box66;
			
			MazeRadioButtons() {
				super(new GridLayout(SIX, SIX));
				box11 = new JRadioButton(CHECK);
				box11.setSelectedIcon(CHECK_SELECTED);
				box12 = new JRadioButton(CHECK);
				box12.setSelectedIcon(CHECK_SELECTED);
				box13 = new JRadioButton(CHECK);
				box13.setSelectedIcon(CHECK_SELECTED);
				box14 = new JRadioButton(CHECK);
				box14.setSelectedIcon(CHECK_SELECTED);
				box15 = new JRadioButton(CHECK);
				box15.setSelectedIcon(CHECK_SELECTED);
				box16 = new JRadioButton(CHECK);
				box16.setSelectedIcon(CHECK_SELECTED);
				box21 = new JRadioButton(CHECK);
				box21.setSelectedIcon(CHECK_SELECTED);
				box22 = new JRadioButton(CHECK);
				box22.setSelectedIcon(CHECK_SELECTED);
				box23 = new JRadioButton(CHECK);
				box23.setSelectedIcon(CHECK_SELECTED);
				box24 = new JRadioButton(CHECK);
				box24.setSelectedIcon(CHECK_SELECTED);
				box25 = new JRadioButton(CHECK);
				box25.setSelectedIcon(CHECK_SELECTED);
				box26 = new JRadioButton(CHECK);
				box26.setSelectedIcon(CHECK_SELECTED);
				box31 = new JRadioButton(CHECK);
				box31.setSelectedIcon(CHECK_SELECTED);
				box32 = new JRadioButton(CHECK);
				box32.setSelectedIcon(CHECK_SELECTED);
				box33 = new JRadioButton(CHECK);
				box33.setSelectedIcon(CHECK_SELECTED);
				box34 = new JRadioButton(CHECK);
				box34.setSelectedIcon(CHECK_SELECTED);
				box35 = new JRadioButton(CHECK);
				box35.setSelectedIcon(CHECK_SELECTED);
				box36 = new JRadioButton(CHECK);
				box36.setSelectedIcon(CHECK_SELECTED);
				box41 = new JRadioButton(CHECK);
				box41.setSelectedIcon(CHECK_SELECTED);
				box42 = new JRadioButton(CHECK);
				box42.setSelectedIcon(CHECK_SELECTED);
				box43 = new JRadioButton(CHECK);
				box43.setSelectedIcon(CHECK_SELECTED);
				box44 = new JRadioButton(CHECK);
				box44.setSelectedIcon(CHECK_SELECTED);
				box45 = new JRadioButton(CHECK);
				box45.setSelectedIcon(CHECK_SELECTED);
				box46 = new JRadioButton(CHECK);
				box46.setSelectedIcon(CHECK_SELECTED);
				box51 = new JRadioButton(CHECK);
				box51.setSelectedIcon(CHECK_SELECTED);
				box52 = new JRadioButton(CHECK);
				box52.setSelectedIcon(CHECK_SELECTED);
				box53 = new JRadioButton(CHECK);
				box53.setSelectedIcon(CHECK_SELECTED);
				box54 = new JRadioButton(CHECK);
				box54.setSelectedIcon(CHECK_SELECTED);
				box55 = new JRadioButton(CHECK);
				box55.setSelectedIcon(CHECK_SELECTED);
				box56 = new JRadioButton(CHECK);
				box56.setSelectedIcon(CHECK_SELECTED);
				box61 = new JRadioButton(CHECK);
				box61.setSelectedIcon(CHECK_SELECTED);
				box62 = new JRadioButton(CHECK);
				box62.setSelectedIcon(CHECK_SELECTED);
				box63 = new JRadioButton(CHECK);
				box63.setSelectedIcon(CHECK_SELECTED);
				box64 = new JRadioButton(CHECK);
				box64.setSelectedIcon(CHECK_SELECTED);
				box65 = new JRadioButton(CHECK);
				box65.setSelectedIcon(CHECK_SELECTED);
				box66 = new JRadioButton(CHECK);
				box66.setSelectedIcon(CHECK_SELECTED);
				maze = new ButtonGroup();
				
				maze.add(box11);
				maze.add(box12);
				maze.add(box13);
				maze.add(box14);
				maze.add(box15);
				maze.add(box16);
				maze.add(box21);
				maze.add(box22);
				maze.add(box23);
				maze.add(box24);
				maze.add(box25);
				maze.add(box26);
				maze.add(box31);
				maze.add(box32);
				maze.add(box33);
				maze.add(box34);
				maze.add(box35);
				maze.add(box36);
				maze.add(box41);
				maze.add(box42);
				maze.add(box43);
				maze.add(box44);
				maze.add(box45);
				maze.add(box46);
				maze.add(box51);
				maze.add(box52);
				maze.add(box53);
				maze.add(box54);
				maze.add(box55);
				maze.add(box56);
				maze.add(box61);
				maze.add(box62);
				maze.add(box63);
				maze.add(box64);
				maze.add(box65);
				maze.add(box66);
				
				box11.addActionListener(this);
				box12.addActionListener(this);
				box13.addActionListener(this);
				box14.addActionListener(this);
				box15.addActionListener(this);
				box16.addActionListener(this);
				box21.addActionListener(this);
				box22.addActionListener(this);
				box23.addActionListener(this);
				box24.addActionListener(this);
				box25.addActionListener(this);
				box26.addActionListener(this);
				box31.addActionListener(this);
				box32.addActionListener(this);
				box33.addActionListener(this);
				box34.addActionListener(this);
				box35.addActionListener(this);
				box36.addActionListener(this);
				box41.addActionListener(this);
				box42.addActionListener(this);
				box43.addActionListener(this);
				box44.addActionListener(this);
				box45.addActionListener(this);
				box46.addActionListener(this);
				box51.addActionListener(this);
				box52.addActionListener(this);
				box53.addActionListener(this);
				box54.addActionListener(this);
				box55.addActionListener(this);
				box56.addActionListener(this);
				box61.addActionListener(this);
				box62.addActionListener(this);
				box63.addActionListener(this);
				box64.addActionListener(this);
				box65.addActionListener(this);
				box66.addActionListener(this);
				
				add(box61);
				add(box62);
				add(box63);
				add(box64);
				add(box65);
				add(box66);
				add(box51);
				add(box52);
				add(box53);
				add(box54);
				add(box55);
				add(box56);
				add(box41);
				add(box42);
				add(box43);
				add(box44);
				add(box45);
				add(box46);
				add(box31);
				add(box32);
				add(box33);
				add(box34);
				add(box35);
				add(box36);
				add(box21);
				add(box22);
				add(box23);
				add(box24);
				add(box25);
				add(box26);
				add(box11);
				add(box12);
				add(box13);
				add(box14);
				add(box15);
				add(box16);
				
				redx = 0;
				redy = 0;
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == box11) {
					redy = ONE;
					redx = ONE;
				} else if (e.getSource() == box12) {
					redy = ONE;
					redx = TWO;
				} else if (e.getSource() == box13) {
					redy = ONE;
					redx = THREE;
				} else if (e.getSource() == box14) {
					redy = ONE;
					redx = FOUR;
				} else if (e.getSource() == box15) {
					redy = ONE;
					redx = FIVE;
				} else if (e.getSource() == box16) {
					redy = ONE;
					redx = SIX;
				} else if (e.getSource() == box21) {
					redy = TWO;
					redx = ONE;
				} else if (e.getSource() == box22) {
					redy = TWO;
					redx = TWO;
				} else if (e.getSource() == box23) {
					redy = TWO;
					redx = THREE;
				} else if (e.getSource() == box24) {
					redy = TWO;
					redx = FOUR;
				} else if (e.getSource() == box25) {
					redy = TWO;
					redx = FIVE;
				} else if (e.getSource() == box26) {
					redy = TWO;
					redx = SIX;
				} else if (e.getSource() == box31) {
					redy = THREE;
					redx = ONE;
				} else if (e.getSource() == box32) {
					redy = THREE;
					redx = TWO;
				} else if (e.getSource() == box33) {
					redy = THREE;
					redx = THREE;
				} else if (e.getSource() == box34) {
					redy = THREE;
					redx = FOUR;
				} else if (e.getSource() == box35) {
					redy = THREE;
					redx = FIVE;
				} else if (e.getSource() == box36) {
					redy = THREE;
					redx = SIX;
				} else if (e.getSource() == box41) {
					redy = FOUR;
					redx = ONE;
				} else if (e.getSource() == box42) {
					redy = FOUR;
					redx = TWO;
				} else if (e.getSource() == box43) {
					redy = FOUR;
					redx = THREE;
				} else if (e.getSource() == box44) {
					redy = FOUR;
					redx = FOUR;
				} else if (e.getSource() == box45) {
					redy = FOUR;
					redx = FIVE;
				} else if (e.getSource() == box46) {
					redy = FOUR;
					redx = SIX;
				} else if (e.getSource() == box51) {
					redy = FIVE;
					redx = ONE;
				} else if (e.getSource() == box52) {
					redy = FIVE;
					redx = TWO;
				} else if (e.getSource() == box53) {
					redy = FIVE;
					redx = THREE;
				} else if (e.getSource() == box54) {
					redy = FIVE;
					redx = FOUR;
				} else if (e.getSource() == box55) {
					redy = FIVE;
					redx = FIVE;
				} else if (e.getSource() == box56) {
					redy = FIVE;
					redx = SIX;
				} else if (e.getSource() == box61) {
					redy = SIX;
					redx = ONE;
				} else if (e.getSource() == box62) {
					redy = SIX;
					redx = TWO;
				} else if (e.getSource() == box63) {
					redy = SIX;
					redx = THREE;
				} else if (e.getSource() == box64) {
					redy = SIX;
					redx = FOUR;
				} else if (e.getSource() == box65) {
					redy = SIX;
					redx = FIVE;
				} else if (e.getSource() == box66) {
					redy = SIX;
					redx = SIX;
				}
					
			}
	
		}
		
		/** Gives instructions about entering the red tiangle coordinates */
		private JLabel question;
		
		/** Contains the radio buttons representing the maze */
		private MazeRadioButtons radioButtons;
		
		/** Button to submit the coordinates */
		private JButton submit;
		
		RedTriangleQuestion() {
			super(new BorderLayout());
			question = new JLabel("Select where the red triangle is:");
			question.setHorizontalAlignment(JLabel.CENTER);
			add(question, BorderLayout.NORTH);
			radioButtons = new MazeRadioButtons();
			add(radioButtons, BorderLayout.CENTER);
			submit = new JButton("Submit");
			submit.addActionListener(this);
			add(submit, BorderLayout.SOUTH);
			
			redx = 0;
			redy = 0;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == submit) {
				if (redx == 0 || redy == 0) {
					JOptionPane.showMessageDialog(this, "Select a button", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						String instructions = BombGUI.bomb.solveMaze(circlex1, circley1, circlex2, circley2, whitex, whitey, redx, redy);
						JOptionPane.showMessageDialog(this, instructions, "Enter the arrows in this order:", JOptionPane.INFORMATION_MESSAGE);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					} finally {
						reset();
						BombGUI.returnToMenu();
					}
				}
			}
	
		}
	
	}

	/** Asks where the green circles are
		 * @author Eliza Thornton
		 *
		 */
	private class CirclesQuestion extends JPanel implements ActionListener {
		
		/** ID number used for object serialization
		 * 
		 */
		private static final long serialVersionUID = 8419464409860862395L;

		/** Contains the check boxes of the maze
				 * @author Eliza Thornton
				 *
				 */
		private class MazeBoxes extends JPanel implements ItemListener {

			/** ID number used for object serialization
			 * 
			 */
			private static final long serialVersionUID = -64250130438376591L;

			/** The check box at (1,1) */
			private JCheckBox box11;
			
			/** The check box at (1,2) */
			private JCheckBox box12;
			
			/** The check box at (1,3) */
			private JCheckBox box13;
			
			/** The check box at (1,4) */
			private JCheckBox box14;
			
			/** The check box at (1,5) */
			private JCheckBox box15;
			
			/** The check box at (1,6) */
			private JCheckBox box16;
			
			/** The check box at (2,1) */
			private JCheckBox box21;
			
			/** The check box at (2,2) */
			private JCheckBox box22;
			
			/** The check box at (2,3) */
			private JCheckBox box23;
			
			/** The check box at (2,4) */
			private JCheckBox box24;
			
			/** The check box at (2,5) */
			private JCheckBox box25;
			
			/** The check box at (2,6) */
			private JCheckBox box26;
			
			/** The check box at (3,1) */
			private JCheckBox box31;
			
			/** The check box at (3,2) */
			private JCheckBox box32;
			
			/** The check box at (3,3) */
			private JCheckBox box33;
			
			/** The check box at (3,4) */
			private JCheckBox box34;
			
			/** The check box at (3,5) */
			private JCheckBox box35;
			
			/** The check box at (3,6) */
			private JCheckBox box36;
			
			/** The check box at (4,1) */
			private JCheckBox box41;
			
			/** The check box at (4,2) */
			private JCheckBox box42;
			
			/** The check box at (4,3) */
			private JCheckBox box43;
			
			/** The check box at (4,4) */
			private JCheckBox box44;
			
			/** The check box at (4,5) */
			private JCheckBox box45;
			
			/** The check box at (4,6) */
			private JCheckBox box46;
			
			/** The check box at (5,1) */
			private JCheckBox box51;
			
			/** The check box at (5,2) */
			private JCheckBox box52;
			
			/** The check box at (5,3) */
			private JCheckBox box53;
			
			/** The check box at (5,4) */
			private JCheckBox box54;
			
			/** The check box at (5,5) */
			private JCheckBox box55;
			
			/** The check box at (5,6) */
			private JCheckBox box56;
			
			/** The check box at (6,1) */
			private JCheckBox box61;
			
			/** The check box at (6,2) */
			private JCheckBox box62;
			
			/** The check box at (6,3) */
			private JCheckBox box63;
			
			/** The check box at (6,4) */
			private JCheckBox box64;
			
			/** The check box at (6,5) */
			private JCheckBox box65;
			
			/** The check box at (6,6) */
			private JCheckBox box66;
			
			MazeBoxes() {
				super(new GridLayout(SIX, SIX));
				box61 = new JCheckBox(CHECK);
				box61.setSelectedIcon(CHECK_SELECTED);
				box61.addItemListener(this);
				add(box61);
				box62 = new JCheckBox(CHECK);
				box62.setSelectedIcon(CHECK_SELECTED);
				box62.addItemListener(this);
				add(box62);
				box63 = new JCheckBox(CHECK);
				box63.setSelectedIcon(CHECK_SELECTED);
				box63.addItemListener(this);
				add(box63);
				box64 = new JCheckBox(CHECK);
				box64.setSelectedIcon(CHECK_SELECTED);
				box64.addItemListener(this);
				add(box64);
				box65 = new JCheckBox(CHECK);
				box65.setSelectedIcon(CHECK_SELECTED);
				box65.addItemListener(this);
				add(box65);
				box66 = new JCheckBox(CHECK);
				box66.setSelectedIcon(CHECK_SELECTED);
				box66.addItemListener(this);
				add(box66);
				
				box51 = new JCheckBox(CHECK);
				box51.setSelectedIcon(CHECK_SELECTED);
				box51.addItemListener(this);
				add(box51);
				box52 = new JCheckBox(CHECK);
				box52.setSelectedIcon(CHECK_SELECTED);
				box52.addItemListener(this);
				add(box52);
				box53 = new JCheckBox(CHECK);
				box53.setSelectedIcon(CHECK_SELECTED);
				box53.addItemListener(this);
				add(box53);
				box54 = new JCheckBox(CHECK);
				box54.setSelectedIcon(CHECK_SELECTED);
				box54.addItemListener(this);
				add(box54);
				box55 = new JCheckBox(CHECK);
				box55.setSelectedIcon(CHECK_SELECTED);
				box55.addItemListener(this);
				add(box55);
				box56 = new JCheckBox(CHECK);
				box56.setSelectedIcon(CHECK_SELECTED);
				box56.addItemListener(this);
				add(box56);
				
				box41 = new JCheckBox(CHECK);
				box41.setSelectedIcon(CHECK_SELECTED);
				box41.addItemListener(this);
				add(box41);
				box42 = new JCheckBox(CHECK);
				box42.setSelectedIcon(CHECK_SELECTED);
				box42.addItemListener(this);
				add(box42);
				box43 = new JCheckBox(CHECK);
				box43.setSelectedIcon(CHECK_SELECTED);
				box43.addItemListener(this);
				add(box43);
				box44 = new JCheckBox(CHECK);
				box44.setSelectedIcon(CHECK_SELECTED);
				box44.addItemListener(this);
				add(box44);
				box45 = new JCheckBox(CHECK);
				box45.setSelectedIcon(CHECK_SELECTED);
				box45.addItemListener(this);
				add(box45);
				box46 = new JCheckBox(CHECK);
				box46.setSelectedIcon(CHECK_SELECTED);
				box46.addItemListener(this);
				add(box46);
				
				box31 = new JCheckBox(CHECK);
				box31.setSelectedIcon(CHECK_SELECTED);
				box31.addItemListener(this);
				add(box31);
				box32 = new JCheckBox(CHECK);
				box32.setSelectedIcon(CHECK_SELECTED);
				box32.addItemListener(this);
				add(box32);
				box33 = new JCheckBox(CHECK);
				box33.setSelectedIcon(CHECK_SELECTED);
				box33.addItemListener(this);
				add(box33);
				box34 = new JCheckBox(CHECK);
				box34.setSelectedIcon(CHECK_SELECTED);
				box34.addItemListener(this);
				add(box34);
				box35 = new JCheckBox(CHECK);
				box35.setSelectedIcon(CHECK_SELECTED);
				box35.addItemListener(this);
				add(box35);
				box36 = new JCheckBox(CHECK);
				box36.setSelectedIcon(CHECK_SELECTED);
				box36.addItemListener(this);
				add(box36);
				
				box21 = new JCheckBox(CHECK);
				box21.setSelectedIcon(CHECK_SELECTED);
				box21.addItemListener(this);
				add(box21);
				box22 = new JCheckBox(CHECK);
				box22.setSelectedIcon(CHECK_SELECTED);
				box22.addItemListener(this);
				add(box22);
				box23 = new JCheckBox(CHECK);
				box23.setSelectedIcon(CHECK_SELECTED);
				box23.addItemListener(this);
				add(box23);
				box24 = new JCheckBox(CHECK);
				box24.setSelectedIcon(CHECK_SELECTED);
				box24.addItemListener(this);
				add(box24);
				box25 = new JCheckBox(CHECK);
				box25.setSelectedIcon(CHECK_SELECTED);
				box25.addItemListener(this);
				add(box25);
				box26 = new JCheckBox(CHECK);
				box26.setSelectedIcon(CHECK_SELECTED);
				box26.addItemListener(this);
				add(box26);
				
				box11 = new JCheckBox(CHECK);
				box11.setSelectedIcon(CHECK_SELECTED);
				box11.addItemListener(this);
				add(box11);
				box12 = new JCheckBox(CHECK);
				box12.setSelectedIcon(CHECK_SELECTED);
				box12.addItemListener(this);
				add(box12);
				box13 = new JCheckBox(CHECK);
				box13.setSelectedIcon(CHECK_SELECTED);
				box13.addItemListener(this);
				add(box13);
				box14 = new JCheckBox(CHECK);
				box14.setSelectedIcon(CHECK_SELECTED);
				box14.addItemListener(this);
				add(box14);
				box15 = new JCheckBox(CHECK);
				box15.setSelectedIcon(CHECK_SELECTED);
				box15.addItemListener(this);
				add(box15);
				box16 = new JCheckBox(CHECK);
				box16.setSelectedIcon(CHECK_SELECTED);
				box16.addItemListener(this);
				add(box16);
			}

			@Override
			public void itemStateChanged(ItemEvent e) {
				int selected = e.getStateChange();
				if (e.getItemSelectable() == box11) {
					try {
						addRemoveCoordinates(ONE, ONE, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box11.setSelected(false);
					}
				} else if (e.getItemSelectable() == box12) {
					try {
						addRemoveCoordinates(ONE, TWO, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box12.setSelected(false);
					}
				} else if (e.getItemSelectable() == box13) {
					try {
						addRemoveCoordinates(ONE, THREE, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box13.setSelected(false);
					}
				} else if (e.getItemSelectable() == box14) {
					try {
						addRemoveCoordinates(ONE, FOUR, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box14.setSelected(false);
					}
				} else if (e.getItemSelectable() == box15) {
					try {
						addRemoveCoordinates(ONE, FOUR, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box15.setSelected(false);
					}
				} else if (e.getItemSelectable() == box16) {
					try {
						addRemoveCoordinates(ONE, SIX, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box16.setSelected(false);
					}
				} else if (e.getItemSelectable() == box21) {
					try {
						addRemoveCoordinates(TWO, ONE, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box21.setSelected(false);
					}
				} else if (e.getItemSelectable() == box22) {
					try {
						addRemoveCoordinates(TWO, TWO, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box22.setSelected(false);
					}
				} else if (e.getItemSelectable() == box23) {
					try {
						addRemoveCoordinates(TWO, THREE, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box23.setSelected(false);
					}
				} else if (e.getItemSelectable() == box24) {
					try {
						addRemoveCoordinates(TWO, FOUR, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box24.setSelected(false);
					}
				} else if (e.getItemSelectable() == box25) {
					try {
						addRemoveCoordinates(TWO, FIVE, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box25.setSelected(false);
					}
				} else if (e.getItemSelectable() == box26) {
					try {
						addRemoveCoordinates(TWO, SIX, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box26.setSelected(false);
					}
				} else if (e.getItemSelectable() == box31) {
					try {
						addRemoveCoordinates(THREE, ONE, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box31.setSelected(false);
					}
				} else if (e.getItemSelectable() == box32) {
					try {
						addRemoveCoordinates(THREE, TWO, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box32.setSelected(false);
					}
				} else if (e.getItemSelectable() == box33) {
					try {
						addRemoveCoordinates(THREE, THREE, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box33.setSelected(false);
					}
				} else if (e.getItemSelectable() == box34) {
					try {
						addRemoveCoordinates(THREE, FOUR, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box34.setSelected(false);
					}
				} else if (e.getItemSelectable() == box35) {
					try {
						addRemoveCoordinates(THREE, FIVE, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box35.setSelected(false);
					}
				} else if (e.getItemSelectable() == box36) {
					try {
						addRemoveCoordinates(THREE, SIX, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box36.setSelected(false);
					}
				} else if (e.getItemSelectable() == box41) {
					try {
						addRemoveCoordinates(FOUR, ONE, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box41.setSelected(false);
					}
				} else if (e.getItemSelectable() == box42) {
					try {
						addRemoveCoordinates(FOUR, TWO, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box42.setSelected(false);
					}
				} else if (e.getItemSelectable() == box43) {
					try {
						addRemoveCoordinates(FOUR, THREE, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box43.setSelected(false);
					}
				} else if (e.getItemSelectable() == box44) {
					try {
						addRemoveCoordinates(FOUR, FOUR, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box44.setSelected(false);
					}
				} else if (e.getItemSelectable() == box45) {
					try {
						addRemoveCoordinates(FOUR, FIVE, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box45.setSelected(false);
					}
				} else if (e.getItemSelectable() == box46) {
					try {
						addRemoveCoordinates(FOUR, SIX, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box46.setSelected(false);
					}
				} else if (e.getItemSelectable() == box51) {
					try {
						addRemoveCoordinates(FIVE, ONE, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box51.setSelected(false);
					}
				} else if (e.getItemSelectable() == box52) {
					try {
						addRemoveCoordinates(FIVE, TWO, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box52.setSelected(false);
					}
				} else if (e.getItemSelectable() == box53) {
					try {
						addRemoveCoordinates(FIVE, THREE, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box53.setSelected(false);
					}
				} else if (e.getItemSelectable() == box54) {
					try {
						addRemoveCoordinates(FIVE, FOUR, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box54.setSelected(false);
					}
				} else if (e.getItemSelectable() == box55) {
					try {
						addRemoveCoordinates(FIVE, FIVE, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box55.setSelected(false);
					}
				} else if (e.getItemSelectable() == box56) {
					try {
						addRemoveCoordinates(FIVE, SIX, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box56.setSelected(false);
					}
				} else if (e.getItemSelectable() == box61) {
					try {
						addRemoveCoordinates(SIX, ONE, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box61.setSelected(false);
					}
				} else if (e.getItemSelectable() == box62) {
					try {
						addRemoveCoordinates(SIX, TWO, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box62.setSelected(false);
					}
				} else if (e.getItemSelectable() == box63) {
					try {
						addRemoveCoordinates(SIX, THREE, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box63.setSelected(false);
					}
				} else if (e.getItemSelectable() == box64) {
					try {
						addRemoveCoordinates(SIX, FOUR, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box64.setSelected(false);
					}
				} else if (e.getItemSelectable() == box65) {
					try {
						addRemoveCoordinates(SIX, FIVE, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box65.setSelected(false);
					}
				} else if (e.getItemSelectable() == box66) {
					try {
						addRemoveCoordinates(SIX, SIX, selected);
					} catch (IllegalArgumentException i) {
						JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						box66.setSelected(false);
					}
				}
			}
			
			private void addRemoveCoordinates(byte y, byte x, int selected) {
				if (selected == ItemEvent.SELECTED) {
					switch(boxesSelected) {
						case 0:
							circlex1 = x;
							circley1 = y;
							boxesSelected++;
							break;
						case 1:
							circlex2 = x;
							circley2 = y;
							boxesSelected++;
							break;
						default:
							boxesSelected++;
							throw new IllegalArgumentException("Cannot select more than two boxes");
					}
				} else if (selected == ItemEvent.DESELECTED) {
					switch(boxesSelected) {
						case 2:
							circlex2 = 0;
							circley2 = 0;
							boxesSelected--;
							break;
						case 1:
							circlex1 = 0;
							circley1 = 0;
							boxesSelected--;
							break;
						case 3:
							boxesSelected--;
							break;
						default:
							throw new IllegalArgumentException("Invalid boxes selected number");
					}
				} else {
					throw new IllegalArgumentException("Invalid selected value");
				}
			}
			
			private void resetCheckBoxes() {
				if (box11.isSelected()) {
					box11.setSelected(false);
				}
				if (box12.isSelected()) {
					box12.setSelected(false);
				}
				if (box13.isSelected()) {
					box13.setSelected(false);
				}
				if (box14.isSelected()) {
					box14.setSelected(false);
				}
				if (box15.isSelected()) {
					box15.setSelected(false);
				}
				if (box16.isSelected()) {
					box16.setSelected(false);
				}
				if (box21.isSelected()) {
					box21.setSelected(false);
				}
				if (box22.isSelected()) {
					box22.setSelected(false);
				}
				if (box23.isSelected()) {
					box23.setSelected(false);
				}
				if (box24.isSelected()) {
					box24.setSelected(false);
				}
				if (box25.isSelected()) {
					box25.setSelected(false);
				}
				if (box26.isSelected()) {
					box26.setSelected(false);
				}
				if (box31.isSelected()) {
					box31.setSelected(false);
				}
				if (box32.isSelected()) {
					box32.setSelected(false);
				}
				if (box33.isSelected()) {
					box33.setSelected(false);
				}
				if (box34.isSelected()) {
					box34.setSelected(false);
				}
				if (box35.isSelected()) {
					box35.setSelected(false);
				}
				if (box36.isSelected()) {
					box36.setSelected(false);
				}
				if (box41.isSelected()) {
					box41.setSelected(false);
				}
				if (box42.isSelected()) {
					box42.setSelected(false);
				}
				if (box43.isSelected()) {
					box43.setSelected(false);
				}
				if (box44.isSelected()) {
					box44.setSelected(false);
				}
				if (box45.isSelected()) {
					box45.setSelected(false);
				}
				if (box46.isSelected()) {
					box46.setSelected(false);
				}
				if (box51.isSelected()) {
					box51.setSelected(false);
				}
				if (box52.isSelected()) {
					box52.setSelected(false);
				}
				if (box53.isSelected()) {
					box53.setSelected(false);
				}
				if (box54.isSelected()) {
					box54.setSelected(false);
				}
				if (box55.isSelected()) {
					box55.setSelected(false);
				}
				if (box56.isSelected()) {
					box56.setSelected(false);
				}
				if (box61.isSelected()) {
					box61.setSelected(false);
				}
				if (box62.isSelected()) {
					box62.setSelected(false);
				}
				if (box63.isSelected()) {
					box63.setSelected(false);
				}
				if (box64.isSelected()) {
					box64.setSelected(false);
				}
				if (box65.isSelected()) {
					box65.setSelected(false);
				}
				if (box66.isSelected()) {
					box66.setSelected(false);
				}
			}
		}

		

		/** Contains the check boxes of the maze */
		private MazeBoxes mazeChecks;
		
		/** Instructs the user about selecting the green circles */
		private JLabel title;
		
		/** The button to submit the circles */
		private JButton submit;
		
		/** The number of boxes selected in the maze */
		private byte boxesSelected = 0;
		
		CirclesQuestion() {
			super(new BorderLayout());
			title = new JLabel("Select the locations of the two green circles:");
			title.setHorizontalAlignment(JLabel.CENTER);
			add(title, BorderLayout.NORTH);
			mazeChecks = new MazeBoxes();
			add(mazeChecks, BorderLayout.CENTER);
			submit = new JButton("Submit");
			submit.addActionListener(this);
			add(submit, BorderLayout.SOUTH);
			circlex1 = 0;
			circley1 = 0;
			circlex2 = 0;
			circley2 = 0;
			boxesSelected = 0;
			setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == submit) {
				if (boxesSelected != 2) {
					JOptionPane.showMessageDialog(this, "Must select two boxes", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					changeLayout("White Square");
				}
			}

		}

	}

	/** Asks about the green circles */
	private CirclesQuestion circles;
	
	/** Asks about the white square */
	private WhiteSquareQuestion whiteSquare;
	
	/** Asks about the red triangle */
	private RedTriangleQuestion redTriangle;
	
	/** The x coordinate of the first green circle */
	private byte circlex1;
	
	/** The y coordinate of the first green circle */
	private byte circley1;
	
	/** The x coordinate of the second green circle */
	private byte circlex2;
	
	/** The y coordinate of the second green circle */
	private byte circley2;
	
	/** The x coordinate of the white square */
	private byte whitex;
	
	/** The y coordinate of the white square */
	private byte whitey;
	
	/** The x coordinate of the red triangle */
	private byte redx;
	
	/** The y coordinate of the red triangle */
	private byte redy;
	
	/** The card layout used to switch between panels */
	protected CardLayout card;
	
	/** Represents a checkbox */
	private static final ImageIcon CHECK = new ImageIcon("images/mazeCheck.png");
	
	/** Represents a checkbox */
	private static final ImageIcon CHECK_SELECTED = new ImageIcon("images/mazeCheckSelected.png");
	
	MazePanel() {
		super();
		card = new CardLayout();
		setLayout(card);
		circles = new CirclesQuestion();
		add(circles, "Circles");
		whiteSquare = new WhiteSquareQuestion();
		add(whiteSquare, "White Square");
		redTriangle = new RedTriangleQuestion();
		add(redTriangle, "Red Triangle");
		card.show(this, "Circles");
	}
	
	/** Changes the layout of the panel 
	 * 
	 * @param name the identifier of the panel to show
	 * */
	private void changeLayout(String name) {
		card.show(this, name);
	}
	
	/** Resets the panel for future use */
	private void reset() {
		whiteSquare.radioButtons.maze.clearSelection();
		redTriangle.radioButtons.maze.clearSelection();
		circles.mazeChecks.resetCheckBoxes();
		whitex = 0;
		whitey = 0;
		redx = 0;
		redy = 0;
		circlex1 = 0;
		circley1 = 0;
		circlex2 = 0;
		circley2 = 0;
		card.show(this, "Circles");
	}
}
