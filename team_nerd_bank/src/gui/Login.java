package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;


public class Login extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private JTextField txtAutoPin;
	private JLabel lblAutoPin;
	private JLabel lblTitle;
	
	public Login() {
		
		getContentPane().setLayout(null);
		
		lblTitle = new JLabel("NERD BANK");
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 31));
		lblTitle.setBounds(219, 12, 214, 49);
		getContentPane().add(lblTitle);
		
		lblAutoPin = new JLabel("<html>Please enter your auto generated pin this is your date of birth and the four digits provided e.g. ddmmyy0000</html>");
		lblAutoPin.setBounds(173, 89, 343, 66);
		getContentPane().add(lblAutoPin);
		
		txtAutoPin = new JTextField();
		txtAutoPin.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtAutoPin.setBounds(305, 136, 175, 21);
		getContentPane().add(txtAutoPin);
		txtAutoPin.setColumns(10);
		
	}

	@Override
	public void run() {

		
	}
}
