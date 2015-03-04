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
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Login extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private JTextField txtAutoPin;
	private JLabel lblAutoPin;
	private JLabel lblTitle;
	private JLabel lblimg;
	private String path = "Assets/banklogo.jpg";
	private File file;
	private BufferedImage image;
	private JLabel lblNewLabel;
	private JButton btnReg;
	
	public Login() {
		
		setBackground(Color.WHITE);
		
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		lblAutoPin = new JLabel("<html>Please enter your auto generated pin this is your date of birth and the four digits provided e.g. ddmmyy0000</html>");
		lblAutoPin.setForeground(Color.BLACK);
		lblAutoPin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAutoPin.setBounds(173, 89, 330, 78);
		getContentPane().add(lblAutoPin);
		
		txtAutoPin = new JTextField();
		txtAutoPin.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtAutoPin.setBounds(305, 136, 175, 26);
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
		
		lblNewLabel = new JLabel("<html>If you have an account please feel free </html>");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(369, 203, 220, 88);
		getContentPane().add(lblNewLabel);
		
		btnReg = new JButton("<html><u>register</u></html>");
		btnReg.setForeground(Color.BLUE);
		btnReg.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReg.setOpaque(false);
		btnReg.setContentAreaFilled(false);
		btnReg.setBorderPainted(false);
		btnReg.setBounds(388, 245, 77, 21);
		getContentPane().add(btnReg);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 139));
		panel.setBounds(10, 11, 619, 67);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblTitle = new JLabel("PMDA BANK");
		lblTitle.setBounds(199, 11, 214, 49);
		panel.add(lblTitle);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 31));
		
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
