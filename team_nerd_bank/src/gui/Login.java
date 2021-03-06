package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.WindowConstants;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import security.AES;
import connect.Query;

public class Login extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private static JTextField txtAutoPin;
	private JLabel lblAutoPin;
	private JLabel lblTitle;
	private JLabel lblimg;
	private String length;
	private static String autoNumber;
	private String path = "Assets/banklogo.jpg";
	private File file;
	private BufferedImage image;
	private JLabel lblNewLabel;
	private JButton btnReg;
	private JLabel lblLogo;
	private String path2 = "Assets/logo2.svg.png";
	private File file2;
	private BufferedImage image2;
	private JButton btnNext;
	private boolean correct = false;
	private JPanel panel;

	public Login() {

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
		getContentPane().setBackground(Color.WHITE);

		lblAutoPin = new JLabel(
				"<html>Please enter your auto generated pin this is your date of birth and the four digits provided e.g. ddmmyy0000</html>");
		lblAutoPin.setForeground(Color.BLUE);
		lblAutoPin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAutoPin.setBounds(173, 89, 330, 78);
		getContentPane().add(lblAutoPin);

		txtAutoPin = new JTextField();
		txtAutoPin.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtAutoPin.setBounds(305, 136, 175, 26);
		txtAutoPin.setDocument(new NumLimit(10));
		getContentPane().add(txtAutoPin);
		txtAutoPin.setColumns(10);

		file = new File(path);
		try {

			image = ImageIO.read(file);
		} catch (IOException e) {

			e.printStackTrace();
		}

		lblimg = new JLabel(new ImageIcon(image));
		lblimg.setBounds(10, 153, 226, 210);
		getContentPane().add(lblimg);
		
				btnReg = new JButton("<html><u>register</u></html>");
				btnReg.setForeground(Color.RED);
				btnReg.setCursor(new Cursor(Cursor.HAND_CURSOR));
				btnReg.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnReg.setOpaque(false);
				btnReg.setContentAreaFilled(false);
				btnReg.setBorderPainted(false);
				btnReg.setBounds(433, 255, 70, 21);
				getContentPane().add(btnReg);
				
						btnReg.addActionListener(arg0 -> {
				
							this.dispose();
				
							java.awt.EventQueue.invokeLater(() -> {
				
								Register frame = new Register();
								SwingUtilities.invokeLater(frame);
				
							});
						});

		lblNewLabel = new JLabel("<html>If you have an account and wish to use this service please feel free to</html>");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(369, 203, 198, 91);
		getContentPane().add(lblNewLabel);

		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 139));
		panel.setBounds(10, 11, 619, 69);
		getContentPane().add(panel);
		panel.setLayout(null);

		lblTitle = new JLabel("PMDA BANK");
		lblTitle.setBounds(199, 11, 247, 49);
		panel.add(lblTitle);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Serif", Font.BOLD, 40));

		file2 = new File(path2);
		try {

			image2 = ImageIO.read(file2);
		} catch (IOException e) {

			e.printStackTrace();
		}

		lblLogo = new JLabel(new ImageIcon(image2));
		lblLogo.setBounds(10, -1, 70, 70);
		panel.add(lblLogo);

		btnNext = new JButton("Next");
		btnNext.setBackground(new Color(201, 216, 239));
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNext.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNext.setBounds(513, 135, 89, 26);
		getContentPane().add(btnNext);

		btnNext.addActionListener(arg0 -> {

			if (NumberTest(txtAutoPin.getText())) {

				// Get the user input
				length = txtAutoPin.getText();
				// Split the string to check the count is correct return message
				// if
				// number is to small or large
				String[] count = length.split("");
				autoNumber = null;

				// Parse the input to an int return message if there is a
				// problem
				try {

					autoNumber = txtAutoPin.getText();
				} catch (NumberFormatException e) {

					txtAutoPin.setText("");
				} catch (StackOverflowError e) {

					txtAutoPin.setText("");
				} catch (Exception e) {

					txtAutoPin.setText("");
				} finally {

					if (count.length < 10 || count.length > 10) {

						JOptionPane.showMessageDialog(null, "Sorry this pin is incorrect please try again");
						txtAutoPin.setText("");
					} else {

						// Pass the number to the query to check that the
						// autopin
						// exists

						System.out.println(autoNumber + " Login class");

						correct = Query.getAutoID(autoNumber);

						System.out.println(correct);

						// If the autopin is a match let the user continue
						if (correct == true) {

							AES.getAutoPin(txtAutoPin.getText());
							txtAutoPin.setText("");
							this.dispose();

							// Open the UserPinPass frame
							java.awt.EventQueue.invokeLater(() -> {

								UserLogin frame = new UserLogin(autoNumber);
								SwingUtilities.invokeLater(frame);

							});
						} else {

							JOptionPane.showMessageDialog(null, "Sorry this pin is incorrect please try again"
									+ "\nor contact our customer help desk");
							txtAutoPin.setText("");
						}
					}
				}
			} else {

				JOptionPane.showMessageDialog(null, "Sorry this pin is incorrect please try again" + "\nor contact our customer help desk");
				txtAutoPin.setText("");
			}

		});

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

	@Override
	public void run() {

		setSize(655, 400);
		setResizable(false);
		setTitle("Your Solution");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
