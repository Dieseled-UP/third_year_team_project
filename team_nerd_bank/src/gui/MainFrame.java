package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


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
	private JPanel mainView;
	private JPanel summary, account, transfer, details, payees;
	private JButton btnSummary;
	private JPanel panel_3;
	
	
	public MainFrame() {
		getContentPane().setBackground(Color.WHITE);
		
		getContentPane().setLayout(null);
		
		summary = new Summary();
		transfer = new Transfers();
		details = new Details();
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 139), 1, true));
		panel.setBackground(new Color(0, 0, 139));
		panel.setBounds(10, 11, 824, 70);
		getContentPane().add(panel);
		
		btnSummary = new JButton("Summary");
		btnSummary.setForeground(new Color(0, 0, 139));
		btnSummary.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSummary.setBackground(new Color(201, 216, 239));
		btnSummary.setBounds(10, 120, 151, 42);
		getContentPane().add(btnSummary);
		
		btnAccounts = new JButton("Accounts");
		btnAccounts.setForeground(new Color(0, 0, 139));
		btnAccounts.setBackground(new Color(201, 216, 239));
		btnAccounts.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAccounts.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAccounts.setBounds(10, 160, 151, 42);
		getContentPane().add(btnAccounts);
		
		btnTransfers = new JButton("Transfers");
		btnTransfers.setForeground(new Color(0, 0, 139));
		btnTransfers.setBackground(new Color(201, 216, 239));
		btnTransfers.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTransfers.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnTransfers.setBounds(10, 200, 151, 42);
		getContentPane().add(btnTransfers);
		
		btnDetails = new JButton("Details");
		btnDetails.setForeground(new Color(0, 0, 139));
		btnDetails.setBackground(new Color(201, 216, 239));
		btnDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDetails.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnDetails.setBounds(10, 239, 151, 42);
		getContentPane().add(btnDetails);
		
		btnPayees = new JButton("Payees");
		btnPayees.setForeground(new Color(0, 0, 139));
		btnPayees.setBackground(new Color(201, 216, 239));
		btnPayees.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPayees.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnPayees.setBounds(10, 279, 151, 42);
		getContentPane().add(btnPayees);
		
		btnLogout = new JButton("Logout");
		btnLogout.setForeground(new Color(0, 0, 139));
		btnLogout.setBackground(new Color(201, 216, 239));
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnLogout.setBounds(10, 319, 151, 42);
		getContentPane().add(btnLogout);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 81, 151, 42);
		getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 361, 151, 200);
		getContentPane().add(panel_2);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 139), 1, true));
		panel_3.setBackground(new Color(0, 0, 139));
		panel_3.setBounds(10, 561, 824, 39);
		getContentPane().add(panel_3);
		
		mainView = new JPanel();
		mainView.setBounds(173, 93, 663, 445);
		getContentPane().add(mainView);
		mainView.setLayout(new CardLayout(0, 0));
		
		mainView.add(transfer, "trans");
		mainView.add(details, "details");
		mainView.add(summary, "summary");
		
		CardLayout cardLayout = (CardLayout) mainView.getLayout();
		
		cardLayout.show(mainView, "summary");
		
		btnSummary.addActionListener(arg0 -> {
			
			cardLayout.show(mainView, "summary");
		});
		
		btnTransfers.addActionListener(arg0 -> {
			
			cardLayout.show(mainView, "trans");
			btnTransfers.setBackground(new Color(166, 166, 166));
		});
		
		btnDetails.addActionListener(arg0 -> {
			
			cardLayout.show(mainView, "details");
		});
	}


	@Override
	public void run() {

		setSize(850, 650);
		setResizable(false);
		setTitle("Template");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
