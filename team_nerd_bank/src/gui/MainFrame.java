package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import connect.Connect_DB;

/**
 * @author Team Nerd Banks L00099023 26 Feb 2015
 */
public class MainFrame extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton btnSummary;
	private JButton btnAccounts;
	private JButton btnTransfers;
	private JButton btnDetails;
	private JButton btnSecurity;
	private JButton btnPayees;
	private JButton btnLogout;
	private JPanel mainView;
	private JPanel summary, account, transfer, details, payees;
	private JPanel panel_3;
	private JLabel lblLogo;
	private String path = "Assets/logo2.svg.png";
	private File file;
	private BufferedImage image;
	private JLabel lblMainName;
	private JLabel lblWelcome;
	private JLabel lblName;

	public MainFrame() {

		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look
			// and feel.
		}

		getContentPane().setBackground(Color.WHITE);

		getContentPane().setLayout(null);

		summary = new Summary();
		transfer = new Transfers();
		details = new Details();

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
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblWelcome.setBounds(540, 47, 70, 14);
		panel.add(lblWelcome);
		
		lblName = new JLabel("");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblName.setBounds(620, 48, 118, 14);
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

		btnLogout = new JButton("Logout");
		btnLogout.setForeground(new Color(0, 0, 139));
		btnLogout.setBackground(new Color(201, 216, 239));
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnLogout.setFocusPainted(false);
		btnLogout.setBounds(10, 290, 151, 32);
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

		CardLayout cardLayout = (CardLayout) mainView.getLayout();

		cardLayout.show(mainView, "summary");

		btnSummary.addActionListener(arg0 -> {

			cardLayout.show(mainView, "summary");
			btnTransfers.setBackground(new Color(201, 216, 239));
			btnDetails.setBackground(new Color(201, 216, 239));
		});

		btnTransfers.addActionListener(arg0 -> {

			cardLayout.show(mainView, "trans");
			btnTransfers.setBackground(new Color(166, 166, 166));
			btnDetails.setBackground(new Color(201, 216, 239));
		});

		btnDetails.addActionListener(arg0 -> {

			cardLayout.show(mainView, "details");
			btnDetails.setBackground(new Color(166, 166, 166));
			btnTransfers.setBackground(new Color(201, 216, 239));
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
