/*
 * 5 Mar 2015
 * team_nerd_bank
 * 23:50:31
 */
package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import security.AES;

public class UserLogin extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private JLabel lblLogo;
	private String path = "Assets/logo2.svg.png";
	private File file;
	private BufferedImage image;
	private JLabel lblMainName;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblPinOne;
	private JLabel lblPinTwo;
	private JLabel lblPinThree;
	private JLabel lblPinOneText;
	private JLabel lblPinTwoText;
	private JLabel lblPinThreeText;
	private JPasswordField txtPinOne;
	private JPasswordField txtPinTwo;
	private JPasswordField txtPinThree;
	private JLabel lblInfoOne;
	private JButton btnLogin;
	private JButton btnForgot;
	private JPanel panel_5;
	private JPasswordField txtPassOne;
	private JPasswordField txtPassTwo;
	private JPasswordField txtPassThree;
	private String[] pinNumbers = new String[] { "1st", "2nd", "3rd", "4th" };
	private String[] passNumbers = new String[] { "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", "11th", "12th",
			"13th", "14th", "15th", "16th" };
	private Random rand = new Random();
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JLabel lblPinOneNum;
	private JLabel lblPinTwoNum;
	private JLabel lblPinThreeNum;
	private JLabel label;
	private JLabel lblPassOne;
	private JLabel label_2;
	private JLabel lblPassTwo;
	private JLabel lblCharacter_1;
	private JLabel label_4;
	private JLabel lblPassThree;
	private JLabel lblCharacter_2;
	private JLabel lblCharacter;
	private JPanel panel;
	private JLabel lblEnterTheFollowing;
	private ArrayList<String> results;

	// Create variables for label tags
	private String onePinLbl = null;
	private String twoPinLbl = null;
	private String threePinLbl = null;
	private String onePassLbl = null;
	private String twoPassLbl = null;
	private String threePassLbl = null;
	private int pinNumOne;
	private int pinNumTwo;
	private int pinNumThree;
	private int passNumOne;
	private int passNumTwo;
	private int passNumThree;

	public UserLogin(String autoNumber) {

		// Get the decrypted data from the AES class
		try {

			// Create instance of a AES object
			AES secu = new AES();

			// Instantiate the ArrayList
			results = new ArrayList<>();

			// Retrieve the decrypted data
			results = secu.decryptedPinPass();

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look
			// and feel.
		}

		getContentPane().setBackground(Color.WHITE);

		getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 139));
		panel.setBounds(10, 10, 603, 69);
		getContentPane().add(panel);
		panel.setLayout(null);

		file = new File(path);
		try {

			image = ImageIO.read(file);
		} catch (IOException e) {

			e.printStackTrace();
		}
		lblLogo = new JLabel(new ImageIcon(image));
		lblLogo.setBounds(10, -1, 70, 70);
		panel.add(lblLogo);

		lblMainName = new JLabel("PMDA BANK");
		lblMainName.setForeground(Color.WHITE);
		lblMainName.setFont(new Font("Serif", Font.BOLD, 40));
		lblMainName.setBounds(181, 11, 259, 48);
		panel.add(lblMainName);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(255, 165, 0), 1, true), "Your PIN", TitledBorder.LEADING,
				TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 14), new Color(0, 0, 139)));
		panel_1.setBounds(120, 130, 380, 203);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		panel_3 = new JPanel();
		panel_3.setBounds(62, 83, 223, 26);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		lblPinOne = new JLabel("Enter the");
		lblPinOne.setBounds(10, 4, 64, 14);
		panel_3.add(lblPinOne);
		lblPinOne.setForeground(Color.BLUE);
		lblPinOne.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblPinOneText = new JLabel(" ");
		lblPinOneText.setBounds(80, 4, 28, 14);
		panel_3.add(lblPinOneText);
		lblPinOneText.setForeground(Color.BLUE);
		lblPinOneText.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtPinOne = new JPasswordField();
		txtPinOne.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPinOne.setBounds(183, 0, 40, 26);
		txtPinOne.setDocument(new NumLimit(1));
		panel_3.add(txtPinOne);
		txtPinOne.setColumns(10);

		lblPinOneNum = new JLabel("number");
		lblPinOneNum.setBounds(113, 4, 53, 14);
		panel_3.add(lblPinOneNum);
		lblPinOneNum.setForeground(Color.BLUE);
		lblPinOneNum.setFont(new Font("Tahoma", Font.PLAIN, 14));

		panel_4 = new JPanel();
		panel_4.setBounds(62, 120, 223, 26);
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		lblPinTwo = new JLabel("Enter the");
		lblPinTwo.setBounds(10, 4, 64, 14);
		panel_4.add(lblPinTwo);
		lblPinTwo.setForeground(Color.BLUE);
		lblPinTwo.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblPinTwoText = new JLabel(" ");
		lblPinTwoText.setBounds(80, 4, 29, 14);
		panel_4.add(lblPinTwoText);
		lblPinTwoText.setForeground(Color.BLUE);
		lblPinTwoText.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtPinTwo = new JPasswordField();
		txtPinTwo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPinTwo.setBounds(183, 0, 40, 26);
		txtPinTwo.setDocument(new NumLimit(1));
		panel_4.add(txtPinTwo);
		txtPinTwo.setColumns(10);

		lblPinTwoNum = new JLabel("number");
		lblPinTwoNum.setBounds(113, 4, 53, 14);
		panel_4.add(lblPinTwoNum);
		lblPinTwoNum.setForeground(Color.BLUE);
		lblPinTwoNum.setFont(new Font("Tahoma", Font.PLAIN, 14));

		panel_5 = new JPanel();
		panel_5.setBounds(62, 159, 223, 26);
		panel_1.add(panel_5);
		panel_5.setLayout(null);

		lblPinThree = new JLabel("Enter the");
		lblPinThree.setBounds(10, 4, 64, 14);
		panel_5.add(lblPinThree);
		lblPinThree.setForeground(Color.BLUE);
		lblPinThree.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblPinThreeText = new JLabel(" ");
		lblPinThreeText.setBounds(80, 4, 29, 14);
		panel_5.add(lblPinThreeText);
		lblPinThreeText.setForeground(Color.BLUE);
		lblPinThreeText.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtPinThree = new JPasswordField();
		txtPinThree.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPinThree.setBounds(183, 0, 40, 26);
		txtPinThree.setDocument(new NumLimit(1));
		panel_5.add(txtPinThree);
		txtPinThree.setColumns(10);

		lblPinThreeNum = new JLabel("number");
		lblPinThreeNum.setBounds(113, 4, 53, 14);
		panel_5.add(lblPinThreeNum);
		lblPinThreeNum.setForeground(Color.BLUE);
		lblPinThreeNum.setFont(new Font("Tahoma", Font.PLAIN, 14));

		// Set the labels to the random characters
		randomPinLabel();

		lblInfoOne = new JLabel("Enter the following numbers from your PIN");
		lblInfoOne.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInfoOne.setBounds(37, 35, 270, 22);
		panel_1.add(lblInfoOne);

		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(255, 165, 0), 1, true), "Your Password", TitledBorder.LEADING,
				TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 14), new Color(0, 0, 139)));
		panel_2.setBounds(120, 366, 380, 209);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		lblEnterTheFollowing = new JLabel("Enter the following characters from your Password");
		lblEnterTheFollowing.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterTheFollowing.setBounds(37, 34, 324, 22);
		panel_2.add(lblEnterTheFollowing);

		panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(62, 81, 223, 26);
		panel_2.add(panel_6);

		label = new JLabel("Enter the");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(10, 4, 59, 14);
		panel_6.add(label);

		lblPassOne = new JLabel(" ");
		lblPassOne.setForeground(Color.BLUE);
		lblPassOne.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassOne.setBounds(80, 4, 28, 14);
		panel_6.add(lblPassOne);

		txtPassOne = new JPasswordField();
		txtPassOne.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPassOne.setColumns(10);
		txtPassOne.setDocument(new NumLimit(1));
		txtPassOne.setBounds(183, 0, 40, 26);
		panel_6.add(txtPassOne);

		lblCharacter = new JLabel("character");
		lblCharacter.setForeground(Color.BLUE);
		lblCharacter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCharacter.setBounds(113, 4, 64, 14);
		panel_6.add(lblCharacter);

		panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBounds(62, 118, 223, 26);
		panel_2.add(panel_7);

		label_2 = new JLabel("Enter the");
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(10, 4, 57, 14);
		panel_7.add(label_2);

		lblPassTwo = new JLabel(" ");
		lblPassTwo.setForeground(Color.BLUE);
		lblPassTwo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassTwo.setBounds(80, 4, 28, 14);
		panel_7.add(lblPassTwo);

		txtPassTwo = new JPasswordField();
		txtPassTwo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPassTwo.setColumns(10);
		txtPassTwo.setDocument(new NumLimit(1));
		txtPassTwo.setBounds(183, 0, 40, 26);
		panel_7.add(txtPassTwo);

		lblCharacter_1 = new JLabel("character");
		lblCharacter_1.setForeground(Color.BLUE);
		lblCharacter_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCharacter_1.setBounds(113, 4, 64, 14);
		panel_7.add(lblCharacter_1);

		panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBounds(62, 155, 223, 26);
		panel_2.add(panel_8);

		label_4 = new JLabel("Enter the");
		label_4.setForeground(Color.BLUE);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(10, 4, 57, 14);
		panel_8.add(label_4);

		lblPassThree = new JLabel(" ");
		lblPassThree.setForeground(Color.BLUE);
		lblPassThree.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassThree.setBounds(80, 4, 28, 14);
		panel_8.add(lblPassThree);

		// Set the labels to the random characters
		randomPassLabel();

		txtPassThree = new JPasswordField();
		txtPassThree.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPassThree.setColumns(10);
		txtPassThree.setDocument(new NumLimit(1));
		txtPassThree.setBounds(183, 0, 40, 26);
		panel_8.add(txtPassThree);

		lblCharacter_2 = new JLabel("character");
		lblCharacter_2.setForeground(Color.BLUE);
		lblCharacter_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCharacter_2.setBounds(113, 4, 64, 14);
		panel_8.add(lblCharacter_2);

		btnLogin = new JButton("LOGIN");
		btnLogin.setForeground(Color.BLUE);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.setBounds(408, 616, 89, 26);
		btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		getContentPane().add(btnLogin);

		btnForgot = new JButton("<html><strong style=\"color: #FFA500\">==></strong> Forgot your PIN or Password?</html>");
		btnForgot.setForeground(Color.BLUE);
		btnForgot.setOpaque(false);
		btnForgot.setContentAreaFilled(false);
		btnForgot.setBorderPainted(false);
		btnForgot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnForgot.setBounds(55, 613, 256, 32);
		btnForgot.setCursor(new Cursor(Cursor.HAND_CURSOR));
		getContentPane().add(btnForgot);
		
		txtPinOne.addActionListener(arg0 -> {
			txtPinTwo.requestFocusInWindow();
		});
		txtPinTwo.addActionListener(arg0 -> {
			txtPinThree.requestFocusInWindow();
		});
		txtPinThree.addActionListener(arg0 -> {
			txtPassOne.requestFocusInWindow();
		});
		txtPassOne.addActionListener(arg0 -> {
			txtPassTwo.requestFocusInWindow();
		});
		txtPassTwo.addActionListener(arg0 -> {
			txtPassThree.requestFocusInWindow();
		});

		btnLogin.addActionListener(arg0 -> {

			// If validation passes allow the user to continue
			if (checkPinValitation() && checkPassValitation()) {

				java.awt.EventQueue.invokeLater(() -> {

					MainFrame frame = new MainFrame(autoNumber);
					SwingUtilities.invokeLater(frame);

				});
				
				this.dispose();

			} else {

				JOptionPane.showMessageDialog(null, "There seems to be a problem with your login details");
				this.dispose();

				java.awt.EventQueue.invokeLater(() -> {

					Login frame = new Login();
					SwingUtilities.invokeLater(frame);

				});
			}
		});
	}

	/**
	 * Method to set the labels for the pin
	 */
	public void randomPinLabel() {

		// Generate a variable for each label
		if (onePinLbl == null) {
			// Set text for first label using a random String from the Array
			onePinLbl = pinNumbers[rand.nextInt(pinNumbers.length)].toString();
		}
		if (twoPinLbl == null) {
			// Set text for second label using a random String from the Array
			twoPinLbl = pinNumbers[rand.nextInt(pinNumbers.length)].toString();

			// Check that the text has not already been used
			while (twoPinLbl.equalsIgnoreCase(onePinLbl)) {
				twoPinLbl = pinNumbers[rand.nextInt(pinNumbers.length)].toString();
			}
		}
		if (threePinLbl == null) {
			// Set text for third label using a random String from the Array
			threePinLbl = pinNumbers[rand.nextInt(pinNumbers.length)].toString();

			// Check that the text has not already been used
			while (threePinLbl.equalsIgnoreCase(onePinLbl) || threePinLbl.equalsIgnoreCase(twoPinLbl)) {
				threePinLbl = pinNumbers[rand.nextInt(pinNumbers.length)].toString();
			}
		}

		orderPinLables();
	}

	/**
	 * Method to set the labels for the password
	 */
	public void randomPassLabel() {

		String[] size = new String[results.get(1).length()];

		for (int i = 0; i < size.length; i++) {

			size[i] = passNumbers[i];
		}

		// Generate a variable for each label
		if (onePassLbl == null) {
			// Set text for first label using a random String from the Array
			onePassLbl = size[rand.nextInt(size.length)].toString();
		}
		if (twoPassLbl == null) {
			// Set text for second label using a random String from the Array
			twoPassLbl = size[rand.nextInt(size.length)].toString();

			// Check that the text has not already been used
			while (twoPassLbl.equalsIgnoreCase(onePassLbl)) {
				twoPassLbl = size[rand.nextInt(size.length)].toString();
			}
		}
		if (threePassLbl == null) {
			// Set text for third label using a random String from the Array
			threePassLbl = size[rand.nextInt(size.length )].toString();

			// Check that the text has not already been used
			while (threePassLbl.equalsIgnoreCase(onePassLbl) || threePassLbl.equalsIgnoreCase(twoPassLbl)) {
				threePassLbl = size[rand.nextInt(size.length)].toString();
			}
		}

		orderPassLables();
	}

	/**
	 * Add a limiter to the input field that only allows the user to input the
	 * specified number of characters
	 */
	@SuppressWarnings("serial")
	class NumLimit extends PlainDocument {

		private int limit;

		NumLimit(int limit) {
			super();
			this.limit = limit;
		}

		public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
			if (str == null)
				return;

			if ((getLength() + str.length()) <= limit) {
				super.insertString(offset, str, attr);
			}
		}
	}

	/**
	 * Method to set the pin labels in the correct numerical order
	 */
	public void orderPinLables() {

		pinNumOne = Integer.parseInt(onePinLbl.substring(0, 1));
		pinNumTwo = Integer.parseInt(twoPinLbl.substring(0, 1));
		pinNumThree = Integer.parseInt(threePinLbl.substring(0, 1));

		// For testing purposes please remove
		System.out.println(pinNumOne + " " + pinNumTwo + " " + pinNumThree + " Pin munbers");

		// Check to see what number is greater and order correctly
		if (pinNumTwo > pinNumOne && pinNumThree > pinNumOne) {

			lblPinOneText.setText(onePinLbl);

			if (pinNumThree > pinNumTwo) {

				lblPinTwoText.setText(twoPinLbl);
				lblPinThreeText.setText(threePinLbl);
			} else {

				lblPinTwoText.setText(threePinLbl);
				lblPinThreeText.setText(twoPinLbl);
			}
		} else if (pinNumOne > pinNumTwo && pinNumThree > pinNumTwo) {

			lblPinOneText.setText(twoPinLbl);

			if (pinNumThree > pinNumOne) {

				lblPinTwoText.setText(onePinLbl);
				lblPinThreeText.setText(threePinLbl);
			} else {

				lblPinTwoText.setText(threePinLbl);
				lblPinThreeText.setText(onePinLbl);
			}

		} else if (pinNumOne > pinNumThree && pinNumTwo > pinNumThree) {

			lblPinOneText.setText(threePinLbl);

			if (pinNumTwo > pinNumOne) {

				lblPinThreeText.setText(twoPinLbl);
				lblPinTwoText.setText(onePinLbl);
			} else {

				lblPinThreeText.setText(onePinLbl);
				lblPinTwoText.setText(twoPinLbl);
			}
		}
	}

	/**
	 * Method to set the pass labels in the correct numerical order
	 */
	public void orderPassLables() {

		// Change text labels into actual numbers
		passNumOne = Integer.parseInt(onePassLbl.substring(0, 1));
		passNumTwo = Integer.parseInt(twoPassLbl.substring(0, 1));
		passNumThree = Integer.parseInt(threePassLbl.substring(0, 1));

		// For testing purposes please remove
		System.out.println(passNumOne + " " + passNumTwo + " " + passNumThree + " Pass numbers");

		// Check to see what number is greater and order correctly
		if (passNumTwo > passNumOne && passNumThree > passNumOne) {

			lblPassOne.setText(onePassLbl);

			if (passNumThree > passNumTwo) {

				lblPassTwo.setText(twoPassLbl);
				lblPassThree.setText(threePassLbl);
			} else {

				lblPassTwo.setText(threePassLbl);
				lblPassThree.setText(twoPassLbl);
			}
		} else if (passNumOne > passNumTwo && passNumThree > passNumTwo) {

			lblPassOne.setText(twoPassLbl);

			if (passNumThree > passNumOne) {

				lblPassTwo.setText(onePassLbl);
				lblPassThree.setText(threePassLbl);
			} else {

				lblPassTwo.setText(threePassLbl);
				lblPassThree.setText(onePassLbl);
			}

		} else if (passNumOne > passNumThree && passNumTwo > passNumThree) {

			lblPassOne.setText(threePassLbl);

			if (passNumTwo > passNumOne) {

				lblPassTwo.setText(onePassLbl);
				lblPassThree.setText(twoPassLbl);
			} else {

				lblPassTwo.setText(twoPassLbl);
				lblPassThree.setText(onePassLbl);
			}
		}
	}

	/**
	 * Method to check that the pin entered by the user matches what is on record
	 * @return boolean allGood
	 */
	public boolean checkPinValitation() {

		boolean allGood = false;
		// Add pin to char array
		char[] pin = results.get(0).toCharArray();
		ArrayList<Integer> order = new ArrayList<>();
		order.add(pinNumOne - 1);
		order.add(pinNumTwo - 1);
		order.add(pinNumThree - 1);

		Collections.sort(order);

		// For testing purposes please remove
		System.out.println("Actual pin array - " + pin[0] + " " + pin[1] + " " + pin[2] + " " + pin[3]);

		// For testing purposes please remove
		System.out.println("Generated numbers - " + pin[pinNumOne - 1] + " " + pin[pinNumTwo - 1] + " " + pin[pinNumThree - 1]);

		// For testing purposes please remove
		System.out.println("Actual numbers needed - " + txtPinOne.getPassword()[0] + " " + txtPinTwo.getPassword()[0] + " "
				+ txtPinThree.getPassword()[0]);

		// Check that the numbers entered match the numbers in the pin
		if (pin[order.get(0)] == txtPinOne.getPassword()[0] && pin[order.get(1)] == txtPinTwo.getPassword()[0]
				&& pin[order.get(2)] == txtPinThree.getPassword()[0]) {

			allGood = true;
		}
		
		return allGood;
	}

	/**
	 * Method to check that the pass entered by the user matches what is on record
	 * @return boolean allGood
	 */
	public boolean checkPassValitation() {

		boolean allGood = false;
		// Change password in char array
		char[] pass = results.get(1).toCharArray();
		ArrayList<Integer> order = new ArrayList<>();
		order.add(passNumOne - 1);
		order.add(passNumTwo - 1);
		order.add(passNumThree - 1);

		Collections.sort(order);

		// For testing purposes please remove
		System.out
				.println("Actual characters needed - " + pass[passNumOne - 1] + " " + pass[passNumTwo - 1] + " " + pass[passNumThree - 1]);

		// Check that the characters entered match the characters and are in the right order in the password
		if (pass[order.get(0)] == txtPassOne.getPassword()[0] && pass[order.get(1)] == txtPassTwo.getPassword()[0]
				&& pass[order.get(2)] == txtPassThree.getPassword()[0]) {

			allGood = true;
		}
		
		return allGood;
	}

	@Override
	public void run() {

		setSize(631, 700);
		setResizable(false);
		setTitle("Your Login");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
