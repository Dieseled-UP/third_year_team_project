/*
 * 5 Mar 2015
 * team_nerd_bank
 * 23:50:31
 */
package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

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
	private JTextField txtPinOne;
	private JTextField txtPinTwo;
	private JTextField txtPinThree;
	private JLabel lblInfoOne;
	private JButton btnLogin;
	private JButton btnForgot;
	private JPanel panel_5;
	private JTextField txtPassOne;
	private JTextField txtPassTwo;
	private JTextField txtPassThree;
	private String[] pinNumbers = new String[] { "1st", "2nd", "3rd", "4th" };
	private String[] passNumbers = new String[] { "1st", "2nd", "3rd", "4th",
			"5th", "6th", "7th", "8th", "9th", "10th", "11th", "12th", "13th",
			"14th", "15th", "16th" };
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
	private ArrayList<String> temp;

	public UserLogin() {

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
		panel_1.setBorder(new TitledBorder(new LineBorder(
				new Color(255, 165, 0), 1, true), "Your PIN",
				TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma",
						Font.BOLD, 14), new Color(0, 0, 139)));
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

		lblPinOneText = new JLabel("third");
		lblPinOneText.setBounds(80, 4, 28, 14);
		panel_3.add(lblPinOneText);
		lblPinOneText.setForeground(Color.BLUE);
		lblPinOneText.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtPinOne = new JTextField();
		txtPinOne.setBounds(183, 0, 40, 26);
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

		lblPinTwoText = new JLabel("first");
		lblPinTwoText.setBounds(80, 4, 29, 14);
		panel_4.add(lblPinTwoText);
		lblPinTwoText.setForeground(Color.BLUE);
		lblPinTwoText.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtPinTwo = new JTextField();
		txtPinTwo.setBounds(183, 0, 40, 26);
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

		lblPinThreeText = new JLabel("second");
		lblPinThreeText.setBounds(80, 4, 29, 14);
		panel_5.add(lblPinThreeText);
		lblPinThreeText.setForeground(Color.BLUE);
		lblPinThreeText.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtPinThree = new JTextField();
		txtPinThree.setBounds(183, 0, 40, 26);
		panel_5.add(txtPinThree);
		txtPinThree.setColumns(10);

		lblPinThreeNum = new JLabel("number");
		lblPinThreeNum.setBounds(113, 4, 53, 14);
		panel_5.add(lblPinThreeNum);
		lblPinThreeNum.setForeground(Color.BLUE);
		lblPinThreeNum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		randomPinLabel();

		lblInfoOne = new JLabel("Enter the following numbers from your PIN");
		lblInfoOne.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInfoOne.setBounds(37, 35, 270, 22);
		panel_1.add(lblInfoOne);

		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(
				new Color(255, 165, 0), 1, true), "Your Password",
				TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma",
						Font.BOLD, 14), new Color(0, 0, 139)));
		panel_2.setBounds(120, 366, 380, 209);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		lblEnterTheFollowing = new JLabel(
				"Enter the following characters from your Password");
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

		lblPassOne = new JLabel("third");
		lblPassOne.setForeground(Color.BLUE);
		lblPassOne.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassOne.setBounds(75, 4, 28, 14);
		panel_6.add(lblPassOne);

		txtPassOne = new JTextField();
		txtPassOne.setColumns(10);
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

		lblPassTwo = new JLabel("third");
		lblPassTwo.setForeground(Color.BLUE);
		lblPassTwo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassTwo.setBounds(75, 4, 28, 14);
		panel_7.add(lblPassTwo);

		txtPassTwo = new JTextField();
		txtPassTwo.setColumns(10);
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

		lblPassThree = new JLabel("third");
		lblPassThree.setForeground(Color.BLUE);
		lblPassThree.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassThree.setBounds(75, 4, 28, 14);
		panel_8.add(lblPassThree);

		txtPassThree = new JTextField();
		txtPassThree.setColumns(10);
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
		getContentPane().add(btnLogin);

		btnForgot = new JButton(
				"<html><strong style=\"color: #FFA500\">==></strong> Forgot your PIN or Password?</html>");
		btnForgot.setForeground(Color.BLUE);
		btnForgot.setOpaque(false);
		btnForgot.setContentAreaFilled(false);
		btnForgot.setBorderPainted(false);
		btnForgot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnForgot.setBounds(55, 613, 256, 32);
		getContentPane().add(btnForgot);

		btnLogin.addActionListener(arg0 -> {

		});
	}

	/**
	 * Method to set the labels for the pin
	 */
	public void randomPinLabel() {

		// Create variables for label tags
		String one = null;
		String two = null;
		String three = null;

		// Generate a variable for each label 
		if (one == null) {
			// Set text for first label using a random String from the Array
			one = pinNumbers[rand.nextInt(pinNumbers.length)];
		}
		if (two == null) {
			// Set text for second label using a random String from the Array
			two = pinNumbers[rand.nextInt(pinNumbers.length)];

			// Check that the text has not already been used
			while (two == one) {
				two = pinNumbers[rand.nextInt(pinNumbers.length)];
			}
		}
		if (three == null) {
			// Set text for third label using a random String from the Array
			three = pinNumbers[rand.nextInt(pinNumbers.length)];

			// Check that the text has not already been used
			while (three == one || three == two) {
				three = pinNumbers[rand.nextInt(pinNumbers.length)];
			}
		}
		
		// Set the text
		lblPinOneText.setText(one);
		lblPinTwoText.setText(two);
		lblPinThreeText.setText(three);
	}
	
	/**
	 * Method to set the labels for the pin
	 */
	public void randomPassLabel() {
		
		getloginDetails();

		// Create variables for label tags
		String one = null;
		String two = null;
		String three = null;
		
		String[] size = new String[temp.get(1).length()];
		
		for (int i = 0; i < size.length-1; i++) {
			
			size[i] = passNumbers[i];
		}

		// Generate a variable for each label 
		if (one == null) {
			// Set text for first label using a random String from the Array
			one = size[rand.nextInt(size.length)];
		}
		if (two == null) {
			// Set text for second label using a random String from the Array
			two = size[rand.nextInt(size.length)];

			// Check that the text has not already been used
			while (two == one) {
				two = size[rand.nextInt(size.length)];
			}
		}
		if (three == null) {
			// Set text for third label using a random String from the Array
			three = size[rand.nextInt(size.length)];

			// Check that the text has not already been used
			while (three == one || three == two) {
				three = size[rand.nextInt(size.length)];
			}
		}
		
		// Set the text
		lblPassOne.setText(one);
		lblPassTwo.setText(two);
		lblPassThree.setText(three);
	}
	
	public void getloginDetails() {
		
		temp = AES.decryptedPinPass();
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
