package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;


public class Login extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	
	public Login() {
		
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NERD BANK");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 31));
		lblNewLabel.setBounds(219, 12, 214, 49);
		getContentPane().add(lblNewLabel);
		
	}

	@Override
	public void run() {

		
	}
}
