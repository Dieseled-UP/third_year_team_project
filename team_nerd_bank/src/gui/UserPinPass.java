/*
 * 6 Mar 2015
 * team_nerd_bank
 * 11:09:27
 */
package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import security.AES;

public class UserPinPass extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private JLabel lblLogo;
	private String path = "Assets/logo2.svg.png";
	private File file;
	private BufferedImage image;
	private JPanel pnlHeader;
	private JPasswordField txtPin;
	private JPasswordField txtRePin;
	private JPasswordField txtPassword;
	private JPasswordField txtRePassword;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblEnterPin;
	private JLabel lblRenterPin;
	private JButton btnOK;
	private JButton btnCancel;
	private JLabel lblRePassword;
	private JLabel label;
	private JPanel panel_2;
	private JLabel lblPassword;
	private static int num;
	private static String pinString;

	public UserPinPass() {

		getContentPane().setBackground(Color.WHITE);

		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (UnsupportedLookAndFeelException e) {
			// handle exception
		} catch (ClassNotFoundException e) {
			// handle exception
		} catch (InstantiationException e) {
			// handle exception
		} catch (IllegalAccessException e) {
			// handle exception
		}

		getContentPane().setLayout(null);

		pnlHeader = new JPanel();
		pnlHeader.setLayout(null);
		pnlHeader.setBackground(new Color(0, 0, 139));
		pnlHeader.setBounds(10, 11, 637, 69);
		getContentPane().add(pnlHeader);

		label = new JLabel("PMDA BANK");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Serif", Font.BOLD, 40));
		label.setBounds(124, 11, 259, 48);
		pnlHeader.add(label);

		file = new File(path);
		try {

			image = ImageIO.read(file);
		} catch (IOException e) {

			e.printStackTrace();
		}

		lblLogo = new JLabel(new ImageIcon(image));
		lblLogo.setBounds(10, -1, 70, 70);
		pnlHeader.add(lblLogo);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 165, 0), 1, true), "Create Pin", TitledBorder.LEADING,
				TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 14), Color.BLUE));
		panel.setBounds(100, 116, 456, 88);
		getContentPane().add(panel);
		panel.setLayout(null);

		lblEnterPin = new JLabel("Enter Pin");
		lblEnterPin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterPin.setForeground(Color.BLUE);
		lblEnterPin.setBounds(117, 18, 67, 14);
		panel.add(lblEnterPin);

		lblRenterPin = new JLabel("Renter Pin");
		lblRenterPin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRenterPin.setForeground(Color.BLUE);
		lblRenterPin.setBounds(117, 55, 67, 14);
		panel.add(lblRenterPin);

		txtPin = new JPasswordField();
		txtPin.setBounds(211, 14, 86, 26);
		txtPin.setDocument(new PinLimit(4));
		panel.add(txtPin);
		txtPin.setColumns(4);

		txtRePin = new JPasswordField();
		txtRePin.setBounds(211, 51, 86, 26);
		txtRePin.setInputVerifier(new verificationPin());
		txtRePin.setDocument(new PinLimit(4));
		panel.add(txtRePin);
		txtRePin.setColumns(4);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(255, 165, 0), 1, true), "Create Password", TitledBorder.LEADING,
				TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 14), Color.BLUE));
		panel_1.setBounds(100, 215, 456, 88);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		lblPassword = new JLabel("Enter Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setForeground(Color.BLUE);
		lblPassword.setBounds(78, 22, 120, 14);
		panel_1.add(lblPassword);

		lblRePassword = new JLabel("Renter Password");
		lblRePassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRePassword.setForeground(Color.BLUE);
		lblRePassword.setBounds(78, 55, 120, 14);
		panel_1.add(lblRePassword);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(218, 18, 160, 26);
		txtPassword.setDocument(new PassLimit(16));
		panel_1.add(txtPassword);
		txtPassword.setColumns(16);

		txtRePassword = new JPasswordField();
		txtRePassword.setBounds(218, 51, 160, 26);
		txtRePassword.setDocument(new PassLimit(16));
		txtRePassword.setInputVerifier(new verificationPass());
		panel_1.add(txtRePassword);
		txtRePassword.setColumns(16);

		panel_2 = new JPanel();
		panel_2.setBounds(139, 314, 395, 50);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		btnOK = new JButton("OK");
		btnOK.setBackground(new Color(201, 216, 239));
		btnOK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOK.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnOK.setBounds(59, 11, 89, 26);
		panel_2.add(btnOK);

		btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(201, 216, 239));
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCancel.setBounds(221, 11, 89, 26);
		panel_2.add(btnCancel);

		btnOK.addActionListener(arg0 -> {

			// Check that the user has filled out all fields
			if (txtRePin.getPassword().length == 0 && txtRePassword.getPassword().length == 0) {

				JOptionPane.showMessageDialog(null, "Please fill out all sections before proceeding");
			} else {
				
				

				// Create StringBuilders to convert pin and password fields into
				// strings
				StringBuilder pinB = new StringBuilder();
				StringBuilder passB = new StringBuilder();

				// Append pin characters
				for (int i = 0; i < txtPin.getPassword().length; i++) {

					pinB.append(txtPin.getPassword()[i]);
				}

				// Append password characters
				for (int i = 0; i < txtPassword.getPassword().length; i++) {

					passB.append(txtPassword.getPassword()[i]);
				}

				// For testing purpose
				System.out.println(pinString + " " + pinB.toString() + " " + passB.toString() + " " + num);

				try {

					AES secu = new AES();

					// Send data to AES class to encrypt
					secu.encryptPinPass(pinString, pinB.toString(), passB.toString(), num);
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}

				this.dispose();

				java.awt.EventQueue.invokeLater(() -> {

					Login frame = new Login();
					SwingUtilities.invokeLater(frame);

				});
			}
		});

		btnCancel.addActionListener(arg0 -> {

			dispose();
		});

	}

	/**
	 * Check that the to pin numbers entered match
	 */
	class verificationPin extends InputVerifier {

		@Override
		public boolean verify(JComponent input) {

			boolean result = false;
			StringBuilder pinB = new StringBuilder();

			// Get the second password
			JPasswordField tField = (JPasswordField) input;

			// Append pin characters
			for (int i = 0; i < tField.getPassword().length; i++) {

				pinB.append(tField.getPassword()[i]);
			}
			// For testing purpose please remove
			System.out.println(pinB.toString());

			if (NumberTest(pinB.toString())) {

				// Check that the user enter 4 numbers for pin
				if (checkPinLength(pinB.toString())) {

					// Check that the two arrays are the same
					if (Arrays.equals(tField.getPassword(), txtPin.getPassword())) {

						result = true;
						return result;

					} else {

						// Instruct user that the passwords don't match
						JOptionPane.showMessageDialog(null, "Sorry the fields don't match");

						// Reset input field
						txtRePin.setText(null);
						tField.setText(null);
					}
				} else {

					JOptionPane.showMessageDialog(null, "Pin must be at 4 digits!!");

					txtPin.setText(null);
					txtRePin.setText(null);

					txtPin.grabFocus();
				}

			} else {

				JOptionPane.showMessageDialog(null, "Pin can only consist of numbers!!");

				txtPin.setText(null);
				txtRePin.setText(null);

				txtPin.grabFocus();
			}

			return result;
		}
	}

	/**
	 * Check that the to passwords entered match
	 */
	class verificationPass extends InputVerifier {

		@Override
		public boolean verify(JComponent input) {

			boolean result = false;
			StringBuilder passB = new StringBuilder();

			// Get the second password
			JPasswordField tField = (JPasswordField) input;

			// Append pin characters
			for (int i = 0; i < tField.getPassword().length; i++) {

				passB.append(tField.getPassword()[i]);
			}
			
			System.out.println(passB.toString().length());

			// Check that the password has a minimum of seven characters
			if (checkPassLength(passB.toString())) {

				// Check that the two arrays are the same
				if (Arrays.equals(tField.getPassword(), txtPassword.getPassword())) {

					result = true;
					return result;

				} else {

					// Instruct user that the passwords don't match
					JOptionPane.showMessageDialog(null, "Sorry the fields don't match");

					// Reset input field
					txtPassword.setText(null);
					txtRePassword.setText(null);

					txtPassword.grabFocus();
				}
			} else {
				
				JOptionPane.showMessageDialog(null, "Password must consist of at least 7 characters!!");

				txtPassword.setText(null);
				txtRePassword.setText(null);

				txtPassword.grabFocus();
			}

			return result;
		}
	}

	/**
	 * Add a limiter to the input field that only allows the user to input the
	 * specified number of characters
	 */
	@SuppressWarnings("serial")
	class PinLimit extends PlainDocument {

		private int limit;

		PinLimit(int limit) {
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
	 * Add a limiter to the input field that only allows the user to input the
	 * specified number of characters
	 */
	@SuppressWarnings("serial")
	class PassLimit extends PlainDocument {

		private int limit;

		PassLimit(int limit) {
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
	 * Method to ensure user enters numbers only
	 * 
	 * @param num
	 * @return boolean
	 */
	public boolean NumberTest(String num) {

		try {

			Integer.parseInt(num);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * Method to check that the user enters 4 digits
	 * @param num
	 * @return boolean good
	 */
	public boolean checkPinLength(String num) {

		boolean good = true;
		char[] size = num.toCharArray();

		if (size.length < 4) {

			good = false;
		}
		return good;
	}

	/**
	 * Method to check that the password is not to weak by been greater than 6 characters
	 * @param num
	 * @return boolean good
	 */
	public boolean checkPassLength(String num) {

		boolean good = true;
		char[] size = num.toCharArray();
		
		System.out.println(size.length);

		if (size.length < 7) {

			good = false;
		}
		return good;
	}

	/**
	 * Method to get customer ID number and auto-generated pin
	 * 
	 * @param id
	 * @param autoPin
	 */
	public static void getID(int id, String autoPin) {

		// Set the ID and pin
		num = id;
		pinString = autoPin;
	}

	@Override
	public void run() {
		setSize(655, 400);
		setResizable(false);
		setTitle("Your Pin and Password Creation");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	}
}
