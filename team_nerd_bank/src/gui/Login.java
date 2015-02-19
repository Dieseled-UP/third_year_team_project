package gui;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextField;


public class Login extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private JTextField txtAutoPin;
	private JLabel lblAutoPin;
	private JLabel lblTitle;
	private JLabel lblimg;
	private String path = "Assets/banklogo.jpg";
	private File file;
	private BufferedImage image;
	
	public Login() {
		
		getContentPane().setLayout(null);
		
		lblTitle = new JLabel("NERD BANK");
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 31));
		lblTitle.setBounds(219, 12, 214, 49);
		getContentPane().add(lblTitle);
		
		lblAutoPin = new JLabel("<html>Please enter your auto generated pin this is your date of birth and the four digits provided e.g. ddmmyy0000</html>");
		lblAutoPin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAutoPin.setBounds(173, 89, 330, 66);
		getContentPane().add(lblAutoPin);
		
		txtAutoPin = new JTextField();
		txtAutoPin.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtAutoPin.setBounds(305, 136, 175, 21);
		getContentPane().add(txtAutoPin);
		txtAutoPin.setColumns(10);
		
		file = new File(path);
		try {

			image = ImageIO.read(file);
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		lblimg = new JLabel(new ImageIcon(image));
		lblimg.setBounds(10, 170, 154, 129);
		getContentPane().add(lblimg);
		
	}

	@Override
	public void run() {

		setSize(520, 300);
		setResizable(false);
		setTitle("Your Solution");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
