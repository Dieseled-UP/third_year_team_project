/*
 * 6 Mar 2015
 * team_nerd_bank
 * 11:09:27
 */
package gui;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class UserPinPass extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private JPanel pnlHeader;
	private JLabel lblLogo;
	private String path = "Assets/logo2.svg.png";
	private File file;
	private BufferedImage image;
	private JPanel pnlHeader_1;
	private JTextField txtPin;
	private JTextField txtRePin;
	private JTextField txtPassword;
	private JTextField txtRePassword;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblEnterPin;
	private JLabel lblRenterPin;
	private JButton btnOK;
	private JButton btnCancel;
	private JLabel lblRePassword;
	private JLabel label;
	private JPanel panel_2;

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

		pnlHeader_1 = new JPanel();
		pnlHeader_1.setLayout(null);
		pnlHeader_1.setBackground(new Color(0, 0, 139));
		pnlHeader_1.setBounds(10, 11, 637, 69);
		getContentPane().add(pnlHeader_1);

		label = new JLabel("PMDA BANK");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Serif", Font.BOLD, 40));
		label.setBounds(124, 11, 259, 48);
		pnlHeader_1.add(label);

		file = new File(path);
		try {

			image = ImageIO.read(file);
		} catch (IOException e) {

			e.printStackTrace();
		}

		lblLogo = new JLabel(new ImageIcon(image));
		lblLogo.setBounds(10, -1, 70, 70);
		pnlHeader_1.add(lblLogo);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 165, 0), 1, true), "Create Pin", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 14), Color.BLUE));
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
		lblRenterPin.setBounds(117, 43, 67, 14);
		panel.add(lblRenterPin);
		
		txtPin = new JTextField();
		txtPin.setBounds(211, 17, 86, 20);
		panel.add(txtPin);
		txtPin.setColumns(16);
		
		txtRePin = new JTextField();
		txtRePin.setBounds(211, 42, 86, 20);
		panel.add(txtRePin);
		txtRePin.setColumns(16);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(255, 165, 0), 1, true), "Create Password", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 14), Color.BLUE));
		panel_1.setBounds(100, 215, 456, 88);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(198, 5, 0, 0);
		panel_1.add(label_1);
		
		JLabel lblPassword = new JLabel("Enter Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setForeground(Color.BLUE);
		lblPassword.setBounds(78, 22, 120, 14);
		panel_1.add(lblPassword);
		
		lblRePassword = new JLabel("Renter Password");
		lblRePassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRePassword.setForeground(Color.BLUE);
		lblRePassword.setBounds(78, 47, 120, 14);
		panel_1.add(lblRePassword);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(218, 21, 86, 20);
		panel_1.add(txtPassword);
		txtPassword.setColumns(16);
		
		txtRePassword = new JTextField();
		txtRePassword.setBounds(218, 46, 86, 20);
		panel_1.add(txtRePassword);
		txtRePassword.setColumns(10);
		
		panel_2 = new JPanel();
		panel_2.setBounds(139, 314, 395, 50);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		btnOK = new JButton("OK");
		btnOK.setBackground(new Color(201, 216, 239));
		btnOK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOK.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnOK.setBounds(59, 11, 89, 23);
		panel_2.add(btnOK);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(201, 216, 239));
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCancel.setBounds(221, 11, 89, 23);
		panel_2.add(btnCancel);
		
		

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
