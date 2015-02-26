package gui;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.CardLayout;


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
	private JButton btnPayees;
	private JButton btnLogout;
	private JPanel panel_1;
	
	
	public MainFrame() {
		
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(10, 12, 824, 69);
		getContentPane().add(panel);
		
		btnAccounts = new JButton("Accounts");
		btnAccounts.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAccounts.setBounds(10, 81, 151, 42);
		getContentPane().add(btnAccounts);
		
		btnTransfers = new JButton("Transfers");
		btnTransfers.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnTransfers.setBounds(10, 121, 151, 42);
		getContentPane().add(btnTransfers);
		
		btnDetails = new JButton("Details");
		btnDetails.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnDetails.setBounds(10, 161, 151, 42);
		getContentPane().add(btnDetails);
		
		btnPayees = new JButton("Payees");
		btnPayees.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnPayees.setBounds(10, 201, 151, 42);
		getContentPane().add(btnPayees);
		
		btnLogout = new JButton("Logout");
		btnLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnLogout.setBounds(10, 242, 151, 42);
		getContentPane().add(btnLogout);
		
		panel_1 = new JPanel();
		panel_1.setBounds(173, 93, 663, 445);
		getContentPane().add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
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
