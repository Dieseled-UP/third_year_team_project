package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

import connect.Query;

/**
 * @author Team Nerd Banks L00099023 26 Feb 2015
 */
public class MainFrame extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton btnSummary;
	private static JButton btnAccounts;
	private static JButton btnTransfers;
	private static JButton btnDetails;
	private static JButton btnSecurity;
	private static JButton btnPayees;
	private JButton btnLogout;
	private static JPanel mainView;
	private JPanel summary, account, transfer, details, security, payees, state;
	private JPanel panel_3;
	private JLabel lblLogo;
	private String path = "Assets/logo2.svg.png";
	private File file;
	private BufferedImage image;
	private JLabel lblMainName;
	private JLabel lblWelcome;
	private JLabel lblName;
	private static JButton btnStatements;
	private static CardLayout cardLayout;

	public MainFrame(String autoNumber) {

		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (UnsupportedLookAndFeelException e) {
			// handle exception
		} catch (ClassNotFoundException e) {
			// handle exception
		} catch (InstantiationException e) {
			// handle exception
		} catch (IllegalAccessException e) {
			// handle exception
		}

		int id = Integer.parseInt(autoNumber);

		String name = Query.getUserName(id);

		getContentPane().setBackground(Color.WHITE);

		getContentPane().setLayout(null);

		// Get all panels for the cardLayout
		summary = new Summary(autoNumber);
		account = new Account();
		transfer = new Transfers(autoNumber);
		details = new Details();
		security = new Security();
		payees = new Payees(autoNumber);
		state = new Statements();

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 139), 1, true));
		panel.setBackground(new Color(0, 0, 139));
		panel.setBounds(10, 10, 824, 69);
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

		lblWelcome = new JLabel("Welcome");
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWelcome.setBounds(540, 47, 61, 14);
		panel.add(lblWelcome);

		lblName = new JLabel(name);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(604, 47, 118, 14);
		panel.add(lblName);

		btnSummary = new JButton("Summary");
		btnSummary.setForeground(new Color(0, 0, 139));
		btnSummary.setBackground(new Color(201, 216, 239));
		btnSummary.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSummary.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSummary.setFocusPainted(false);
		btnSummary.setBounds(10, 92, 151, 32);
		getContentPane().add(btnSummary);

		btnAccounts = new JButton("Accounts");
		btnAccounts.setForeground(new Color(0, 0, 139));
		btnAccounts.setBackground(new Color(201, 216, 239));
		btnAccounts.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAccounts.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAccounts.setFocusPainted(false);
		btnAccounts.setBounds(10, 125, 151, 32);
		getContentPane().add(btnAccounts);

		btnTransfers = new JButton("Transfers");
		btnTransfers.setForeground(new Color(0, 0, 139));
		btnTransfers.setBackground(new Color(201, 216, 239));
		btnTransfers.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTransfers.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnTransfers.setFocusPainted(false);
		btnTransfers.setBounds(10, 158, 151, 32);
		getContentPane().add(btnTransfers);

		btnDetails = new JButton("Details");
		btnDetails.setForeground(new Color(0, 0, 139));
		btnDetails.setBackground(new Color(201, 216, 239));
		btnDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDetails.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnDetails.setFocusPainted(false);
		btnDetails.setBounds(10, 191, 151, 32);
		getContentPane().add(btnDetails);

		btnSecurity = new JButton("Security");
		btnSecurity.setForeground(new Color(0, 0, 139));
		btnSecurity.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSecurity.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSecurity.setFocusPainted(false);
		btnSecurity.setBackground(new Color(201, 216, 239));
		btnSecurity.setBounds(10, 224, 151, 32);
		getContentPane().add(btnSecurity);

		btnPayees = new JButton("Payees");
		btnPayees.setForeground(new Color(0, 0, 139));
		btnPayees.setBackground(new Color(201, 216, 239));
		btnPayees.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPayees.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnPayees.setFocusPainted(false);
		btnPayees.setBounds(10, 257, 151, 32);
		getContentPane().add(btnPayees);

		btnStatements = new JButton("Statements");
		btnStatements.setForeground(new Color(0, 0, 139));
		btnStatements.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnStatements.setFocusPainted(false);
		btnStatements.setBackground(new Color(201, 216, 239));
		btnStatements.setBounds(10, 290, 151, 32);
		getContentPane().add(btnStatements);

		btnLogout = new JButton("Logout");
		btnLogout.setForeground(new Color(0, 0, 139));
		btnLogout.setBackground(new Color(201, 216, 239));
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnLogout.setFocusPainted(false);
		btnLogout.setBounds(10, 323, 151, 32);
		getContentPane().add(btnLogout);

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
		mainView.add(account, "account");
		mainView.add(payees, "payee");
		mainView.add(security, "security");
		mainView.add(state, "states");

		cardLayout = (CardLayout) mainView.getLayout();

		cardLayout.show(mainView, "summary");

		btnSummary.addActionListener(arg0 -> {

			cardLayout.show(mainView, "summary");
			// Refresh the table data every time the summary is opened
			try {

				Summary.populateTableSummary();
			} catch (Exception e) {

				e.printStackTrace();
			}

			btnAccounts.setBackground(new Color(201, 216, 239));
			btnTransfers.setBackground(new Color(201, 216, 239));
			btnDetails.setBackground(new Color(201, 216, 239));
			btnPayees.setBackground(new Color(201, 216, 239));
			btnSecurity.setBackground(new Color(201, 216, 239));
			btnStatements.setBackground(new Color(201, 216, 239));
		});

		btnAccounts.addActionListener(arg0 -> {

			cardLayout.show(mainView, "account");
			btnAccounts.setBackground(new Color(166, 166, 166));
			btnTransfers.setBackground(new Color(201, 216, 239));
			btnDetails.setBackground(new Color(201, 216, 239));
			btnPayees.setBackground(new Color(201, 216, 239));
			btnSecurity.setBackground(new Color(201, 216, 239));
			btnStatements.setBackground(new Color(201, 216, 239));
		});

		btnTransfers.addActionListener(arg0 -> {

			cardLayout.show(mainView, "trans");
			btnTransfers.setBackground(new Color(166, 166, 166));
			btnAccounts.setBackground(new Color(201, 216, 239));
			btnDetails.setBackground(new Color(201, 216, 239));
			btnPayees.setBackground(new Color(201, 216, 239));
			btnSecurity.setBackground(new Color(201, 216, 239));
			btnStatements.setBackground(new Color(201, 216, 239));
		});

		btnDetails.addActionListener(arg0 -> {

			cardLayout.show(mainView, "details");
			btnDetails.setBackground(new Color(166, 166, 166));
			btnAccounts.setBackground(new Color(201, 216, 239));
			btnTransfers.setBackground(new Color(201, 216, 239));
			btnPayees.setBackground(new Color(201, 216, 239));
			btnSecurity.setBackground(new Color(201, 216, 239));
			btnStatements.setBackground(new Color(201, 216, 239));
		});

		btnSecurity.addActionListener(arg0 -> {

			cardLayout.show(mainView, "security");
			btnSecurity.setBackground(new Color(166, 166, 166));
			btnAccounts.setBackground(new Color(201, 216, 239));
			btnTransfers.setBackground(new Color(201, 216, 239));
			btnDetails.setBackground(new Color(201, 216, 239));
			btnPayees.setBackground(new Color(201, 216, 239));
			btnStatements.setBackground(new Color(201, 216, 239));
		});

		btnPayees.addActionListener(arg0 -> {

			try {
				Payees.populateTablePayees();

			} catch (Exception e) {

				e.printStackTrace();
			}
			cardLayout.show(mainView, "payee");
			btnPayees.setBackground(new Color(166, 166, 166));
			btnAccounts.setBackground(new Color(201, 216, 239));
			btnTransfers.setBackground(new Color(201, 216, 239));
			btnDetails.setBackground(new Color(201, 216, 239));
			btnSecurity.setBackground(new Color(201, 216, 239));
			btnStatements.setBackground(new Color(201, 216, 239));
		});

		btnStatements.addActionListener(arg0 -> {

			cardLayout.show(mainView, "states");
			btnStatements.setBackground(new Color(166, 166, 166));
			btnAccounts.setBackground(new Color(201, 216, 239));
			btnTransfers.setBackground(new Color(201, 216, 239));
			btnDetails.setBackground(new Color(201, 216, 239));
			btnSecurity.setBackground(new Color(201, 216, 239));
			btnPayees.setBackground(new Color(201, 216, 239));
		});

		// Button to exit session
		btnLogout.addActionListener(arg0 -> this.dispose());
	}

	/**
	 * Method to open Payee panel from the Transfer panel
	 */
	public static void displayPayee() {

		cardLayout.show(mainView, "payee");
		btnPayees.setBackground(new Color(166, 166, 166));
		btnAccounts.setBackground(new Color(201, 216, 239));
		btnTransfers.setBackground(new Color(201, 216, 239));
		btnDetails.setBackground(new Color(201, 216, 239));
		btnSecurity.setBackground(new Color(201, 216, 239));
		btnStatements.setBackground(new Color(201, 216, 239));
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
