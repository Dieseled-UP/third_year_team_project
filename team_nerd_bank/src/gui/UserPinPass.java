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
import javax.swing.WindowConstants;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.JTextField;
import javax.swing.JButton;
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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public UserPinPass() {
		getContentPane().setLayout(null);

		pnlHeader_1 = new JPanel();
		pnlHeader_1.setLayout(null);
		pnlHeader_1.setBackground(new Color(0, 0, 139));
		pnlHeader_1.setBounds(10, 11, 637, 69);
		getContentPane().add(pnlHeader_1);

		JLabel label = new JLabel("PMDA BANK");
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

		JLabel lblLogo = new JLabel(new ImageIcon(image));
		lblLogo.setBounds(10, -1, 70, 70);
		pnlHeader_1.add(lblLogo);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 165, 0), 1, true), "Create Pin", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 14), Color.BLUE));
		panel.setBounds(100, 116, 456, 88);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblEnterPin = new JLabel("Enter Pin");
		lblEnterPin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterPin.setForeground(Color.BLUE);
		lblEnterPin.setBounds(117, 18, 67, 14);
		panel.add(lblEnterPin);
		
		JLabel lblRenterPin = new JLabel("Renter Pin");
		lblRenterPin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRenterPin.setForeground(Color.BLUE);
		lblRenterPin.setBounds(117, 43, 67, 14);
		panel.add(lblRenterPin);
		
		textField = new JTextField();
		textField.setBounds(211, 17, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(211, 42, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(255, 165, 0), 1, true), "Create Password", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 14), Color.BLUE));
		panel_1.setBounds(100, 215, 456, 88);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(198, 5, 0, 0);
		panel_1.add(label_1);
		
		JLabel lblNewLabel = new JLabel("Enter Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(78, 22, 120, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Renter Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBounds(78, 47, 120, 14);
		panel_1.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(218, 21, 86, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(218, 46, 86, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(139, 314, 395, 50);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(59, 11, 89, 23);
		panel_2.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
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
