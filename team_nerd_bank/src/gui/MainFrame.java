package gui;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


/**
 * @author Team Nerd Banks L00099023
 * 26 Feb 2015
 */
public class MainFrame extends JFrame implements Runnable {
	
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton btnAccounts;
	private JButton btnTransfers;
	private JButton btnDetails;
	private JButton btnLogout;
	
	
	public MainFrame() {
		
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(10, 11, 824, 69);
		getContentPane().add(panel);
		
		btnAccounts = new JButton("Accounts");
		btnAccounts.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAccounts.setBounds(10, 79, 151, 42);
		getContentPane().add(btnAccounts);
		
		btnTransfers = new JButton("Transfers");
		btnTransfers.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnTransfers.setBounds(10, 119, 151, 42);
		getContentPane().add(btnTransfers);
		
		btnDetails = new JButton("Details");
		btnDetails.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnDetails.setBounds(10, 159, 151, 42);
		getContentPane().add(btnDetails);
		
		btnLogout = new JButton("Logout");
		btnLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnLogout.setBounds(10, 199, 151, 42);
		getContentPane().add(btnLogout);
	}


	@Override
	public void run() {

		setSize(850, 600);
		setResizable(false);
		setTitle("Template");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
