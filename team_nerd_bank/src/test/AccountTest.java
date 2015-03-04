package test;

import gui.Account;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.JButton;

public class AccountTest extends JFrame implements Runnable {
	
	public AccountTest() {
		
		Account account = new Account();
		getContentPane().add(account);
		account.setLayout(null);
		
	}
	
	

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		java.awt.EventQueue.invokeLater(() -> {

			AccountTest frame = new AccountTest();
			SwingUtilities.invokeLater(frame);
			
		});
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
