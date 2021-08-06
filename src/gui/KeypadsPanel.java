package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modules.Keypads.Symbols;

/**
 * GUI for the keypads panel
 * @author Eliza Thornton
 *
 */
public class KeypadsPanel extends JPanel implements ActionListener {
	
	/** ID number used for object serialization
	 * 
	 */
	private static final long serialVersionUID = -776377273900328793L;

	/** Picture of the Q symbol */
	private static final ImageIcon Q_PICTURE = new ImageIcon("images/keypadSymbols/q.png");
	
	/** Picture of the AT symbol */
	private static final ImageIcon AT_PICTURE = new ImageIcon("images/keypadSymbols/at.png");
	
	/** Picture of the lambda symbol */
	private static final ImageIcon LAMBDA_PICTURE = new ImageIcon("images/keypadSymbols/lambda.png");
	
	/** Picture of the lightning symbol */
	private static final ImageIcon LIGHTNING_PICTURE = new ImageIcon("images/keypadSymbols/lightning.png");
	
	/** Picture of the alien symbol */
	private static final ImageIcon ALIEN_PICTURE = new ImageIcon("images/keypadSymbols/alien.png");
	
	/** Picture of the General Electric symbol */
	private static final ImageIcon GE_PICTURE = new ImageIcon("images/keypadSymbols/ge.png");
	
	/** Picture of the backwards c symbol */
	private static final ImageIcon BACKC_PICTURE = new ImageIcon("images/keypadSymbols/backC.png");
	
	/** Picture of the E symbol */
	private static final ImageIcon E_PICTURE = new ImageIcon("images/keypadSymbols/e.png");
	
	/** Picture of the swirl symbol */
	private static final ImageIcon SWIRL_PICTURE = new ImageIcon("images/keypadSymbols/swirl.png");
	
	/** Picture of the white star symbol */
	private static final ImageIcon WHITE_STAR_PICTURE = new ImageIcon("images/keypadSymbols/whiteStar.png");
	
	/** Picture of the upside down question mark symbol */
	private static final ImageIcon QUESTION_PICTURE = new ImageIcon("images/keypadSymbols/question.png");
	
	/** Picture of the copyright symbol */
	private static final ImageIcon COPYRIGHT_PICTURE = new ImageIcon("images/keypadSymbols/copyright.png");
	
	/** Picture of the W symbol */
	private static final ImageIcon W_PICTURE = new ImageIcon("images/keypadSymbols/w.png");
	
	/** Picture of the xi symbol */
	private static final ImageIcon XI_PICTURE = new ImageIcon("images/keypadSymbols/xi.png");
	
	/** Picture of the droopy r symbol */
	private static final ImageIcon DROOP_R_PICTURE = new ImageIcon("images/keypadSymbols/droopR.png");
	
	/** Picture of the six symbol */
	private static final ImageIcon SIX_PICTURE = new ImageIcon("images/keypadSymbols/six.png");
	
	/** Picture of the paragraph symbol */
	private static final ImageIcon PARAGRAPH_PICTURE = new ImageIcon("images/keypadSymbols/paragraph.png");
	
	/** Picture of the tb symbol */
	private static final ImageIcon TB_PICTURE = new ImageIcon("images/keypadSymbols/tb.png");
	
	/** Picture of the face symbol */
	private static final ImageIcon FACE_PICTURE = new ImageIcon("images/keypadSymbols/face.png");
	
	/** Picture of the psi symbol */
	private static final ImageIcon PSI_PICTURE = new ImageIcon("images/keypadSymbols/psi.png");
	
	/** Picture of the c symbol */
	private static final ImageIcon C_PICTURE = new ImageIcon("images/keypadSymbols/c.png");
	
	/** Picture of the bunny symbol */
	private static final ImageIcon BUNNY_PICTURE = new ImageIcon("images/keypadSymbols/bunny.png");
	
	/** Picture of the black star symbol */
	private static final ImageIcon BLACK_STAR_PICTURE = new ImageIcon("images/keypadSymbols/blackStar.png");
	
	/** Picture of the not equals symbol */
	private static final ImageIcon NOT_EQUALS_PICTURE = new ImageIcon("images/keypadSymbols/notEquals.png");
	
	/** Picture of the ae symbol */
	private static final ImageIcon AE_PICTURE = new ImageIcon("images/keypadSymbols/ae.png");
	
	/** Picture of the N symbol */
	private static final ImageIcon N_PICTURE = new ImageIcon("images/keypadSymbols/N.png");
	
	/** Picture of the omega symbol */
	private static final ImageIcon OMEGA_PICTURE = new ImageIcon("images/keypadSymbols/omega.png");

	/** Shows the solution in a message dialog
		 * @author Eliza Thornton
		 *
		 */
	private class SolutionPanel extends JPanel {

		/** ID used for serialization
		 * 
		 */
		private static final long serialVersionUID = -9202193564472737217L;

		SolutionPanel(Symbols[] solution) {
			super(new FlowLayout());
			for (Symbols s : solution) {
				switch(s) {
					case Q:
						add(new JLabel(Q_PICTURE));
						break;
					case AT:
						add(new JLabel(AT_PICTURE));
						break;
					case AE:
						add(new JLabel(AE_PICTURE));
						break;
					case ALIEN:
						add(new JLabel(ALIEN_PICTURE));
						break;
					case BACK_C:
						add(new JLabel(BACKC_PICTURE));
						break;
					case BLACK_STAR:
						add(new JLabel(BLACK_STAR_PICTURE));
						break;
					case BUNNY:
						add(new JLabel(BUNNY_PICTURE));
						break;
					case C:
						add(new JLabel(C_PICTURE));
						break;
					case COPYRIGHT:
						add(new JLabel(COPYRIGHT_PICTURE));
						break;
					case DROOP_R:
						add(new JLabel(DROOP_R_PICTURE));
						break;
					case E:
						add(new JLabel(E_PICTURE));
						break;
					case FACE:
						add(new JLabel(FACE_PICTURE));
						break;
					case GE:
						add(new JLabel(GE_PICTURE));
						break;
					case LAMBDA:
						add(new JLabel(LAMBDA_PICTURE));
						break;
					case LIGHTNING:
						add(new JLabel(LIGHTNING_PICTURE));
						break;
					case N:
						add(new JLabel(N_PICTURE));
						break;
					case NOT_EQUAL:
						add(new JLabel(NOT_EQUALS_PICTURE));
						break;
					case OHM:
						add(new JLabel(OMEGA_PICTURE));
						break;
					case PARAGRAPH:
						add(new JLabel(PARAGRAPH_PICTURE));
						break;
					case PSI:
						add(new JLabel(PSI_PICTURE));
						break;
					case QUESTION:
						add(new JLabel(QUESTION_PICTURE));
						break;
					case SIX:
						add(new JLabel(SIX_PICTURE));
						break;
					case SWIRL:
						add(new JLabel(SWIRL_PICTURE));
						break;
					case TB:
						add(new JLabel(TB_PICTURE));
						break;
					case W:
						add(new JLabel(W_PICTURE));
						break;
					case WHITE_STAR:
						add(new JLabel(WHITE_STAR_PICTURE));
						break;
					case XI:
						add(new JLabel(XI_PICTURE));
						break;
					default:
						break;
				}
			}
			setVisible(true);
		}
	}

	/** Contains the checkboxes for the panel
		 * @author Eliza Thornton
		 *
		 */
	private class CheckBoxes extends JPanel implements ItemListener {
		
		/** ID used for serialization
		 * 
		 */
		private static final long serialVersionUID = 4070326891809609561L;

		/** Checkbox for the q symbol */
		private JCheckBox q;
		
		/** Checkbox for the at symbol */
		private JCheckBox at;
		
		/** Checkbox for the lambda symbol */
		private JCheckBox lambda;
		
		/** Checkbox for the lightning symbol */
		private JCheckBox lightning;
		
		/** Checkbox for the alien symbol */
		private JCheckBox alien;
		
		/** Checkbox for the general electric symbol */
		private JCheckBox ge;
		
		/** Checkbox for the backwards c symbol */
		private JCheckBox backC;
		
		/** Checkbox for the e symbol */
		private JCheckBox eCheck;
		
		/** Checkbox for the swirl symbol */
		private JCheckBox swirl;
		
		/** Checkbox for the white star symbol */
		private JCheckBox whiteStar;
		
		/** Checkbox for the upside down question mark symbol */
		private JCheckBox question;
		
		/** Checkbox for the copyright symbol */
		private JCheckBox copyright;
		
		/** Checkbox for the w symbol */
		private JCheckBox w;
		
		/** Checkbox for the xi symbol */
		private JCheckBox xi;
		
		/** Checkbox for the droopy r symbol */
		private JCheckBox droopR;
		
		/** Checkbox for the six symbol */
		private JCheckBox six;
		
		/** Checkbox for the paragraph symbol */
		private JCheckBox paragraph;
		
		/** Checkbox for the tb symbol */
		private JCheckBox tb;
		
		/** Checkbox for the psi symbol */
		private JCheckBox psi;
		
		/** Checkbox for the face symbol */
		private JCheckBox face;
		
		/** Checkbox for the bunny symbol */
		private JCheckBox bunny;
		
		/** Checkbox for the black star symbol */
		private JCheckBox blackStar;
		
		/** Checkbox for the not equals symbol */
		private JCheckBox notEquals;
		
		/** Checkbox for the ae symbol */
		private JCheckBox ae;
		
		/** Checkbox for the n symbol */
		private JCheckBox n;
		
		/** Checkbox for the ohm symbol */
		private JCheckBox ohm;
		
		/** Checkbox for the c symbol */
		private JCheckBox c;
		
		CheckBoxes() {
			super(new GridLayout(3, 9));
			q = new JCheckBox(Q_PICTURE);
			q.setSelectedIcon(new ImageIcon("images/keypadSelected/qSelected.png"));
			q.addItemListener(this);
			add(q);
			at = new JCheckBox(AT_PICTURE);
			at.setSelectedIcon(new ImageIcon("images/keypadSelected/atSelected.png"));
			at.addItemListener(this);
			add(at);
			lambda = new JCheckBox(LAMBDA_PICTURE);
			lambda.setSelectedIcon(new ImageIcon("images/keypadSelected/lambdaSelected.png"));
			lambda.addItemListener(this);
			add(lambda);
			lightning = new JCheckBox(LIGHTNING_PICTURE);
			lightning.setSelectedIcon(new ImageIcon("images/keypadSelected/lightningSelected.png"));
			lightning.addItemListener(this);
			add(lightning);
			alien = new JCheckBox(ALIEN_PICTURE);
			alien.setSelectedIcon(new ImageIcon("images/keypadSelected/alienSelected.png"));
			alien.addItemListener(this);
			add(alien);
			ge = new JCheckBox(GE_PICTURE);
			ge.setSelectedIcon(new ImageIcon("images/keypadSelected/geSelected.png"));
			ge.addItemListener(this);
			add(ge);
			backC = new JCheckBox(BACKC_PICTURE);
			backC.setSelectedIcon(new ImageIcon("images/keypadSelected/backCSelected.png"));
			backC.addItemListener(this);
			add(backC);
			eCheck = new JCheckBox(E_PICTURE);
			eCheck.setSelectedIcon(new ImageIcon("images/keypadSelected/eSelected.png"));
			eCheck.addItemListener(this);
			add(eCheck);
			swirl = new JCheckBox(SWIRL_PICTURE);
			swirl.setSelectedIcon(new ImageIcon("images/keypadSelected/swirlSelected.png"));
			swirl.addItemListener(this);
			add(swirl);
			whiteStar = new JCheckBox(WHITE_STAR_PICTURE);
			whiteStar.setSelectedIcon(new ImageIcon("images/keypadSelected/whiteStarSelected.png"));
			whiteStar.addItemListener(this);
			add(whiteStar);
			question = new JCheckBox(QUESTION_PICTURE);
			question.setSelectedIcon(new ImageIcon("images/keypadSelected/questionSelected.png"));
			question.addItemListener(this);
			add(question);
			copyright = new JCheckBox(COPYRIGHT_PICTURE);
			copyright.setSelectedIcon(new ImageIcon("images/keypadSelected/copyrightSelected.png"));
			copyright.addItemListener(this);
			add(copyright);
			w = new JCheckBox(W_PICTURE);
			w.setSelectedIcon(new ImageIcon("images/keypadSelected/wSelected.png"));
			w.addItemListener(this);
			add(w);
			xi = new JCheckBox(XI_PICTURE);
			xi.setSelectedIcon(new ImageIcon("images/keypadSelected/xiSelected.png"));
			xi.addItemListener(this);
			add(xi);
			droopR = new JCheckBox(DROOP_R_PICTURE);
			droopR.setSelectedIcon(new ImageIcon("images/keypadSelected/droopRSelected.png"));
			droopR.addItemListener(this);
			add(droopR);
			six = new JCheckBox(SIX_PICTURE);
			six.setSelectedIcon(new ImageIcon("images/keypadSelected/sixSelected.png"));
			six.addItemListener(this);
			add(six);
			paragraph = new JCheckBox(PARAGRAPH_PICTURE);
			paragraph.setSelectedIcon(new ImageIcon("images/keypadSelected/paragraphSelected.png"));
			paragraph.addItemListener(this);
			add(paragraph);
			tb = new JCheckBox(TB_PICTURE);
			tb.setSelectedIcon(new ImageIcon("images/keypadSelected/tbSelected.png"));
			tb.addItemListener(this);
			add(tb);
			psi = new JCheckBox(PSI_PICTURE);
			psi.setSelectedIcon(new ImageIcon("images/keypadSelected/psiSelected.png"));
			psi.addItemListener(this);
			add(psi);
			face = new JCheckBox(FACE_PICTURE);
			face.setSelectedIcon(new ImageIcon("images/keypadSelected/faceSelected.png"));
			face.addItemListener(this);
			add(face);
			bunny = new JCheckBox(BUNNY_PICTURE);
			bunny.setSelectedIcon(new ImageIcon("images/keypadSelected/bunnySelected.png"));
			bunny.addItemListener(this);
			add(bunny);
			blackStar = new JCheckBox(BLACK_STAR_PICTURE);
			blackStar.setSelectedIcon(new ImageIcon("images/keypadSelected/blackStarSelected.png"));
			blackStar.addItemListener(this);
			add(blackStar);
			notEquals = new JCheckBox(NOT_EQUALS_PICTURE);
			notEquals.setSelectedIcon(new ImageIcon("images/keypadSelected/notEqualsSelected.png"));
			notEquals.addItemListener(this);
			add(notEquals);
			ae = new JCheckBox(AE_PICTURE);
			ae.setSelectedIcon(new ImageIcon("images/keypadSelected/aeSelected.png"));
			ae.addItemListener(this);
			add(ae);
			n = new JCheckBox(N_PICTURE);
			n.setSelectedIcon(new ImageIcon("images/keypadSelected/NSelected.png"));
			n.addItemListener(this);
			add(n);
			ohm = new JCheckBox(OMEGA_PICTURE);
			ohm.setSelectedIcon(new ImageIcon("images/keypadSelected/omegaSelected.png"));
			ohm.addItemListener(this);
			add(ohm);
			c = new JCheckBox(C_PICTURE);
			c.setSelectedIcon(new ImageIcon("images/keypadSelected/cSelected.png"));
			c.addItemListener(this);
			add(c);
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			int select = e.getStateChange();
			if (e.getItemSelectable() == q) {
				addRemove(select, Symbols.Q);
			} else if (e.getItemSelectable() == at) {
				addRemove(select, Symbols.AT);
			} else if (e.getItemSelectable() == lambda) {
				addRemove(select, Symbols.LAMBDA);
			} else if (e.getItemSelectable() == lightning) {
				addRemove(select, Symbols.LIGHTNING);
			} else if (e.getItemSelectable() == alien) {
				addRemove(select, Symbols.ALIEN);
			} else if (e.getItemSelectable() == ge) {
				addRemove(select, Symbols.GE);
			} else if (e.getItemSelectable() == backC) {
				addRemove(select, Symbols.BACK_C);
			} else if (e.getItemSelectable() == eCheck) {
				addRemove(select, Symbols.E);
			} else if (e.getItemSelectable() == swirl) {
				addRemove(select, Symbols.SWIRL);
			} else if (e.getItemSelectable() == whiteStar) {
				addRemove(select, Symbols.WHITE_STAR);
			} else if (e.getItemSelectable() == question) {
				addRemove(select, Symbols.QUESTION);
			} else if (e.getItemSelectable() == copyright) {
				addRemove(select, Symbols.COPYRIGHT);
			} else if (e.getItemSelectable() == w) {
				addRemove(select, Symbols.W);
			} else if (e.getItemSelectable() == xi) {
				addRemove(select, Symbols.XI);
			} else if (e.getItemSelectable() == droopR) {
				addRemove(select, Symbols.DROOP_R);
			} else if (e.getItemSelectable() == six) {
				addRemove(select, Symbols.SIX);
			} else if (e.getItemSelectable() == paragraph) {
				addRemove(select, Symbols.PARAGRAPH);
			} else if (e.getItemSelectable() == tb) {
				addRemove(select, Symbols.TB);
			} else if (e.getItemSelectable() == psi) {
				addRemove(select, Symbols.PSI);
			} else if (e.getItemSelectable() == face) {
				addRemove(select, Symbols.FACE);
			} else if (e.getItemSelectable() == bunny) {
				addRemove(select, Symbols.BUNNY);
			} else if (e.getItemSelectable() == blackStar) {
				addRemove(select, Symbols.BLACK_STAR);
			} else if (e.getItemSelectable() == notEquals) {
				addRemove(select, Symbols.NOT_EQUAL);
			} else if (e.getItemSelectable() == ae) {
				addRemove(select, Symbols.AE);
			} else if (e.getItemSelectable() == n) {
				addRemove(select, Symbols.N);
			} else if (e.getItemSelectable() == ohm) {
				addRemove(select, Symbols.OHM);
			} else if (e.getItemSelectable() == c) {
				addRemove(select, Symbols.C);
			}
		}
		
		/** Adds or removes an element based on the input
		 * 
		 * @param selected if the input was selected or deselected
		 * @param element the element to add or remove
		 */
		private void addRemove(int selected, Symbols element) {
			if (selected == ItemEvent.SELECTED) {
				input.add(element);
			} else if (selected == ItemEvent.DESELECTED) {
				input.remove(element);
			}
		}
		
		/** Resets the check boxes for repeated use */
		private void reset() {
			if (q.isSelected()) {
				q.setSelected(false);
			}
			if (at.isSelected()) {
				at.setSelected(false);
			}
			if (lambda.isSelected()) {
				lambda.setSelected(false);
			}
			if (lightning.isSelected()) {
				lightning.setSelected(false);
			}
			if (alien.isSelected()) {
				alien.setSelected(false);
			}
			if (ge.isSelected()) {
				ge.setSelected(false);
			}
			if (backC.isSelected()) {
				backC.setSelected(false);
			}
			if (eCheck.isSelected()) {
				eCheck.setSelected(false);
			}
			if (swirl.isSelected()) {
				swirl.setSelected(false);
			}
			if (whiteStar.isSelected()) {
				whiteStar.setSelected(false);
			}
			if (question.isSelected()) {
				question.setSelected(false);
			}
			if (copyright.isSelected()) {
				copyright.setSelected(false);
			}
			if (w.isSelected()) {
				w.setSelected(false);
			}
			if (xi.isSelected()) {
				xi.setSelected(false);
			}
			if (droopR.isSelected()) {
				droopR.setSelected(false);
			}
			if (six.isSelected()) {
				six.setSelected(false);
			}
			if (paragraph.isSelected()) {
				paragraph.setSelected(false);
			}
			if (tb.isSelected()) {
				tb.setSelected(false);
			}
			if (psi.isSelected()) {
				psi.setSelected(false);
			}
			if (face.isSelected()) {
				face.setSelected(false);
			}
			if (bunny.isSelected()) {
				bunny.setSelected(false);
			}
			if (blackStar.isSelected()) {
				blackStar.setSelected(false);
			}
			if (notEquals.isSelected()) {
				notEquals.setSelected(false);
			}
			if (ae.isSelected()) {
				ae.setSelected(false);
			}
			if (n.isSelected()) {
				n.setSelected(false);
			}
			if (ohm.isSelected()) {
				ohm.setSelected(false);
			}
			if (c.isSelected()) {
				c.setSelected(false);
			}
		}



	}


	/** Gives instructions about the keypads*/
	private JLabel title;
	
	/** Has all the checkboxes of the symbols */
	private CheckBoxes boxes;
	
	/** Button to submit the keypads */
	private JButton submit;
	
	/** Keeps track of the selected boxes */
	private ArrayList<Symbols> input;
	
	KeypadsPanel() {
		super(new BorderLayout());
		title = new JLabel("Select the four symbols on your keypad.");
		title.setHorizontalAlignment(JLabel.CENTER);
		add(title, BorderLayout.NORTH);
		boxes = new CheckBoxes();
		add(boxes, BorderLayout.CENTER);
		submit = new JButton("Submit");
		submit.addActionListener(this);
		add(submit, BorderLayout.SOUTH);
		input = new ArrayList<Symbols>(4);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit) {
			if (input.size() != 4) {
				JOptionPane.showMessageDialog(this, "Must select 4 symbols", "Invalid Input", JOptionPane.ERROR_MESSAGE);
			} else {
				Symbols[] symbols = new Symbols[4];
				symbols = input.toArray(symbols);
				Symbols[] solution = null;
				try {
					solution = BombGUI.bomb.solveKeypad(symbols);
				} catch (IllegalArgumentException i) {
					JOptionPane.showMessageDialog(this, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				JOptionPane.showMessageDialog(this, new SolutionPanel(solution), "Press the buttons in this order:", JOptionPane.INFORMATION_MESSAGE);
				boxes.reset();
				input.clear();
				BombGUI.returnToMenu();
			}
		}
		
	}
}
