package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

import people.Customer;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import connect.Query;
import connect.SendSMS;


public class Register extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private JTextField txtName;
	private JPanel pnlHeader;
	private JPanel pnlForm;
	private JLabel lblName;
	private JLabel lblMainName;
	private JLabel lblSurname;
	private JTextField txtSurname;
	private JLabel lblAdressOne;
	private JTextField txtStreet;
	private JTextField txtTown;
	private JTextField txtCounty;
	private JLabel lblTelPone;
	private JTextField txtTelPhone;
	private JLabel lblMobile;
	private JTextField txtMobile;
	private JTextField txtFind;
	private JLabel lblConfirm;
	private JButton btnOK;
	private JButton btnCancel;
	private JLabel lblLogo;
	private String path = "Assets/logo2.svg.png";
	private File file;
	private BufferedImage image;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JButton btnGO;
	private JLabel lblFind;
	private JLabel lblDob;
	private JTextField txtDob;
	private static StringBuilder code;
	private String mobile;
	
	// Create a customer object and an array to hold data
	Customer temp;
	String[] acc = new String[2];

	public Register() {
		
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

		pnlForm = new JPanel();
		pnlForm.setBorder(new LineBorder(new Color(255, 165, 0), 1, true));
		pnlForm.setBounds(60, 124, 430, 504);
		getContentPane().add(pnlForm);
		pnlForm.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(52dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(19dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(127dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(1dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(2dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(2dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(2dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(2dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(2dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(2dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));

		pnlHeader = new JPanel();
		pnlHeader.setBackground(new Color(0, 0, 139));
		pnlHeader.setBounds(10, 11, 522, 69);
		getContentPane().add(pnlHeader);
		pnlHeader.setLayout(null);

		lblMainName = new JLabel("PMDA BANK");
		lblMainName.setBounds(124, 11, 259, 48);
		pnlHeader.add(lblMainName);
		lblMainName.setForeground(Color.WHITE);
		lblMainName.setFont(new Font("Serif", Font.BOLD, 40));

		file = new File(path);
		try {

			image = ImageIO.read(file);
		} catch (IOException e) {

			e.printStackTrace();
		}

		lblLogo = new JLabel(new ImageIcon(image));
		lblLogo.setBounds(10, -1, 70, 70);
		pnlHeader.add(lblLogo);

		lblName = new JLabel("Name:");
		lblName.setForeground(Color.BLUE);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlForm.add(lblName, "4, 2");

		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlForm.add(txtName, "10, 2, fill, default");
		txtName.setColumns(10);

		lblSurname = new JLabel("Surname:");
		lblSurname.setForeground(Color.BLUE);
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlForm.add(lblSurname, "4, 4");

		txtSurname = new JTextField();
		txtSurname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlForm.add(txtSurname, "10, 4, fill, default");
		txtSurname.setColumns(10);

		lblDob = new JLabel("D.OB:");
		lblDob.setForeground(Color.BLUE);
		lblDob.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlForm.add(lblDob, "4, 8");

		txtDob = new JTextField();
		txtDob.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlForm.add(txtDob, "10, 8, fill, default");
		txtDob.setColumns(10);

		lblAdressOne = new JLabel("Address:");
		lblAdressOne.setForeground(Color.BLUE);
		lblAdressOne.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlForm.add(lblAdressOne, "4, 12");

		txtStreet = new JTextField();
		txtStreet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlForm.add(txtStreet, "10, 12, fill, default");
		txtStreet.setColumns(10);

		txtTown = new JTextField();
		txtTown.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlForm.add(txtTown, "10, 16, fill, default");
		txtTown.setColumns(10);

		txtCounty = new JTextField();
		txtCounty.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlForm.add(txtCounty, "10, 20, fill, default");
		txtCounty.setColumns(10);

		lblTelPone = new JLabel("Tel. Phone:");
		lblTelPone.setForeground(Color.BLUE);
		lblTelPone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlForm.add(lblTelPone, "4, 24");

		txtTelPhone = new JTextField();
		txtTelPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlForm.add(txtTelPhone, "10, 24, fill, default");
		txtTelPhone.setColumns(10);

		lblMobile = new JLabel("Mobile:");
		lblMobile.setForeground(Color.BLUE);
		lblMobile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlForm.add(lblMobile, "4, 28");
		
		JLabel label = new JLabel("*");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.PLAIN, 24));
		pnlForm.add(label, "8, 28, right, default");

		txtMobile = new JTextField();
		txtMobile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlForm.add(txtMobile, "10, 28, fill, default");
		txtMobile.setColumns(10);

		lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.BLUE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlForm.add(lblEmail, "4, 32");

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setText("");
		pnlForm.add(txtEmail, "10, 32, fill, default");
		txtEmail.setColumns(10);
		
		JPanel panel = new JPanel();
		pnlForm.add(panel, "2, 34, 11, 1, fill, fill");
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please enter a Mobile number to recieve your pin");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(31, 11, 360, 24);
		panel.add(lblNewLabel);

		lblFind = new JLabel("Find by account number:");
		lblFind.setForeground(Color.BLUE);
		lblFind.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFind.setBounds(60, 91, 159, 22);
		getContentPane().add(lblFind);

		txtFind = new JTextField();
		txtFind.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFind.setBounds(229, 91, 159, 24);
		getContentPane().add(txtFind);
		txtFind.setColumns(10);

		lblConfirm = new JLabel("If these details are correct  press OK to continue else press CANCEL");
		lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirm.setForeground(Color.BLUE);
		lblConfirm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirm.setBounds(60, 639, 430, 18);
		getContentPane().add(lblConfirm);

		btnOK = new JButton("OK");
		btnOK.setBackground(new Color(201, 216, 239));
		btnOK.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnOK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOK.setBounds(130, 668, 89, 26);
		getContentPane().add(btnOK);

		btnCancel = new JButton("CANCEL");
		btnCancel.setBackground(new Color(201, 216, 239));
		btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancel.setBounds(340, 668, 89, 26);
		getContentPane().add(btnCancel);

		btnGO = new JButton("GO");
		btnGO.setBackground(new Color(201, 216, 239));
		btnGO.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnGO.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGO.setBounds(401, 91, 89, 26);
		getContentPane().add(btnGO);

		// Action to fill in the form
		btnGO.addActionListener(arg0 -> {

			// Get number from text field
			int number = Integer.parseInt(txtFind.getText());

			// Query the data base for the info based on the account number
			temp = Query.getDetails(number);
			acc = Query.getAccount(number);

			// Split the address to fill in the correct fields
			String[] add = temp.getAddress().split(" ");
			StringBuilder dress = new StringBuilder();

			if (add.length < 3) {

				for (int i = 0; i < add.length - 1; i++) {

					dress.append(add[i]);

				}
			} else {

				for (int i = 0; i < add.length - 2; i++) {

					dress.append(add[i]).append(" ");

				}
			}

			// Name of house/street
			String street = dress.toString();
			// Get substring from street
			String split = street.substring(street.length() - 6, street.length());
			// StringBuilders to store right number of stars
			StringBuilder starsStreet = new StringBuilder();
			// Add correct number of stars
			for (int i = 0; i < split.length() - 1; i++) {

				starsStreet.append('*');
			}
			// Replace the end of street with asterix
			String newStreet = street.replace(split, starsStreet);

			// Telephone number
			String tel = temp.getTelPhone();
			// Get substring from tel
			String splitTel = tel.substring(tel.length() - 4, tel.length());
			// StringBuilders to store right number of stars
			StringBuilder starsTel = new StringBuilder();
			// Add correct number of stars
			for (int i = 0; i < splitTel.length() - 1; i++) {

				starsTel.append('*');
			}
			// Replace the end of tel with asterix
			String stringTel = tel.replace(splitTel, starsTel);

			// Email
			String email = temp.getEmail();
			// Get substring from mobile
			String splitEmail = email.substring(1, 5);
			// StringBuilders to store right number of stars
			StringBuilder starsEmail = new StringBuilder();
			// Add correct number of stars
			for (int i = 0; i < splitEmail.length() - 1; i++) {

				starsEmail.append('*');
			}
			// Replace the end of tel with asterix
			String stringEmail = email.replace(splitEmail, starsEmail);

			// Fill in the registration form
			txtName.setText(temp.getName());
			txtSurname.setText(temp.getSurname());
			txtDob.setText(String.valueOf(temp.getDob()));
			txtStreet.setText(newStreet);
			txtTown.setText(add[add.length - 2]);
			txtCounty.setText(add[add.length - 1]);
			txtTelPhone.setText(stringTel);
			txtEmail.setText(stringEmail);
		});

		// Action to generate code and move customer to next stage
		btnOK.addActionListener(arg0 -> {

			mobile  = txtMobile.getText().toString();
			
			System.out.println(mobile);
			// Create new random
			Random rand = new Random();
			// Create temporary 
			int[] nums = new int[4];
			
			// Split the date of birth String
			String[] birth = String.valueOf(temp.getDob()).split("-");
			code = new StringBuilder();
			
			char[] endYear = birth[0].toCharArray();

			// Create random 4 digit code
			for (int i = 0; i < nums.length; i++) {

				nums[i] = rand.nextInt(9);
			}

			// Append the date and 4 digit code together
			code.append(birth[2]).append(birth[1]).append(endYear[2]).append(endYear[3]);

			for (int i = 0; i < nums.length; i++) {

				code.append(String.valueOf(nums[i]));
			}
			
			// Pass id number and code to UserPinPass
			UserPinPass.getID(temp.getId(), code.toString());

			if (mobile == null) {
				
				JOptionPane.showMessageDialog(null, "You will be forwarded on a auto-generated pin "
						+ ".\nThis will be posted to your home address "
						+ ".\nPlease take note of this code and keep in a safe place.");

				java.awt.EventQueue.invokeLater(() -> {

					UserPinPass frame = new UserPinPass();
					SwingUtilities.invokeLater(frame);

				});
			} else if (NumberTest(mobile)) {
				
				try {
					
					SendSMS.sendVerification(mobile);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "You will be forwarded on a auto-generated pin by SMS. "
						+ ".\nThis will also be posted to your home address "
						+ ".\nPlease take note of this code and keep in a safe place.");

				java.awt.EventQueue.invokeLater(() -> {

					UserPinPass frame = new UserPinPass();
					SwingUtilities.invokeLater(frame);

				});

				this.dispose();
			} else {

				JOptionPane.showMessageDialog(null, "Sorry there seems to be a problem with the nuber you entered");
			}
			
		});

		btnCancel.addActionListener(arg0 -> {

			JOptionPane.showMessageDialog(null, "Please re-enter your account number if you still have problems\n please contact"
					+ " our helpdesk or call in to your nearest branch.\nSorry for any inconvince caused by this fault.");

			java.awt.EventQueue.invokeLater(() -> {

				Login frame = new Login();
				SwingUtilities.invokeLater(frame);

			});

			this.dispose();
		});
	}
	
	public static String getAutoPin() {
		
		return code.toString();
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

		setSize(550, 740);
		setResizable(false);
		setTitle("Your Registration");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
