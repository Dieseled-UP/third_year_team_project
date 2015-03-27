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
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look
			// and feel.
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

				// Create StringBuilders to convert pin and password fields into strings
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

			// Get the second pin
			JPasswordField tField = (JPasswordField) input;

			// Check that the two arrays are the same
			if (Arrays.equals(tField.getPassword(), txtPin.getPassword())) {

				return true;

			} else {

				// Instruct user that the pin numbers don't match
				JOptionPane.showMessageDialog(null, "Sorry the fields don't match");

				// Reset input field
				txtRePin.setText(null);
				tField.setText(null);
				return false;
			}
		}
	}

	/**
	 * Check that the to passwords entered match
	 */
	class verificationPass extends InputVerifier {

		@Override
		public boolean verify(JComponent input) {

			// Get the second password
			JPasswordField tField = (JPasswordField) input;

			// Check that the two arrays are the same
			if (Arrays.equals(tField.getPassword(), txtPassword.getPassword())) {

				return true;

			} else {

				// Instruct user that the passwords don't match
				JOptionPane.showMessageDialog(null, "Sorry the fields don't match");

				// Reset input field
				txtRePassword.setText(null);
				tField.setText(null);
				return false;
			}
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

	public static void getID(int id, String autoPin) {

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
