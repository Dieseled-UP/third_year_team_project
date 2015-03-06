/*
 * 5 Mar 2015
 * team_nerd_bank
 * 23:50:31
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

import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblInfoOne;
	private JButton btnLogin;
	private JButton btnForgot;

	public UserLogin() {
		getContentPane().setBackground(Color.WHITE);

		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 139));
		panel.setBounds(10, 10, 654, 69);
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
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(255, 165, 0), 1, true), "Your PIN", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 14), new Color(0, 0, 139)));
		panel_1.setBounds(190, 130, 290, 203);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lblPinOne = new JLabel("Enter the");
		lblPinOne.setForeground(Color.BLUE);
		lblPinOne.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPinOne.setBounds(34, 89, 64, 14);
		panel_1.add(lblPinOne);
		
		lblPinTwo = new JLabel("Enter the");
		lblPinTwo.setForeground(Color.BLUE);
		lblPinTwo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPinTwo.setBounds(34, 126, 64, 14);
		panel_1.add(lblPinTwo);
		
		lblPinThree = new JLabel("Enter the");
		lblPinThree.setForeground(Color.BLUE);
		lblPinThree.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPinThree.setBounds(34, 164, 64, 14);
		panel_1.add(lblPinThree);
		
		lblPinOneText = new JLabel("third");
		lblPinOneText.setForeground(Color.BLUE);
		lblPinOneText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPinOneText.setBounds(98, 89, 46, 14);
		panel_1.add(lblPinOneText);
		
		lblPinTwoText = new JLabel("first");
		lblPinTwoText.setForeground(Color.BLUE);
		lblPinTwoText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPinTwoText.setBounds(98, 126, 46, 14);
		panel_1.add(lblPinTwoText);
		
		lblPinThreeText = new JLabel("second");
		lblPinThreeText.setForeground(Color.BLUE);
		lblPinThreeText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPinThreeText.setBounds(98, 164, 46, 14);
		panel_1.add(lblPinThreeText);
		
		textField = new JTextField();
		textField.setBounds(217, 85, 40, 26);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(217, 122, 40, 26);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(217, 160, 40, 26);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblPinOneNum = new JLabel("number");
		lblPinOneNum.setForeground(Color.BLUE);
		lblPinOneNum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPinOneNum.setBounds(147, 89, 53, 14);
		panel_1.add(lblPinOneNum);
		
		JLabel lblPinTwoNum = new JLabel("number");
		lblPinTwoNum.setForeground(Color.BLUE);
		lblPinTwoNum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPinTwoNum.setBounds(147, 126, 53, 14);
		panel_1.add(lblPinTwoNum);
		
		JLabel lblPinThreeNum = new JLabel("number");
		lblPinThreeNum.setForeground(Color.BLUE);
		lblPinThreeNum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPinThreeNum.setBounds(147, 164, 53, 14);
		panel_1.add(lblPinThreeNum);
		
		lblInfoOne = new JLabel("Enter the following numbers from your PIN");
		lblInfoOne.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInfoOne.setBounds(10, 35, 270, 22);
		panel_1.add(lblInfoOne);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(255, 165, 0), 1, true), "Your Password", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 14), new Color(0, 0, 139)));
		panel_2.setBounds(190, 366, 290, 257);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		btnLogin = new JButton("LOGIN");
		btnLogin.setForeground(Color.BLUE);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.setBounds(502, 699, 89, 26);
		getContentPane().add(btnLogin);
		
		btnForgot = new JButton("<html><strong style=\"color: #FFA500\">==></strong> Forgot your PIN or Password?</html>");
		btnForgot.setForeground(Color.BLUE);
		btnForgot.setOpaque(false);
		btnForgot.setContentAreaFilled(false);
		btnForgot.setBorderPainted(false);
		btnForgot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnForgot.setBounds(55, 649, 256, 32);
		getContentPane().add(btnForgot);
	}

	@Override
	public void run() {

		setSize(680, 815);
		setResizable(false);
		setTitle("Your Login");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
