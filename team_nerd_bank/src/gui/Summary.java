/*
 * 4 Mar 2015
 * team_nerd_bank
 * 01:45:23
 */
package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import net.proteanit.sql.DbUtils;
import table.ForcedListSelectionModel;
import connect.Query;

public class Summary extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblSumm;
	private JLabel lblLastLog;
	private JLabel lblDate;
	private JLabel lblPAccount;
	private JLabel lblAccName;
	private JLabel lblAccNum;
	private JLabel lblSort;
	private JLabel lblBalance;
	private JLabel lblAvail;
	private static JTable table;
	private JLabel lblImage;
	private String path = "Assets/mmEuroSign.gif";
	private File file;
	private BufferedImage image;
	private static int pin;
	private JScrollPane scrollPane;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel;
	private JPanel panel_3;

	public Summary(String autoNumber) {

		pin = Integer.parseInt(autoNumber);

		setLayout(null);

		lblSumm = new JLabel("Account Summary");
		lblSumm.setForeground(Color.BLUE);
		lblSumm.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSumm.setBounds(36, 26, 158, 25);
		add(lblSumm);

		lblLastLog = new JLabel("Last Login:");
		lblLastLog.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLastLog.setBounds(36, 62, 65, 20);
		add(lblLastLog);

		lblDate = new JLabel("  ");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDate.setBounds(128, 66, 138, 20);
		add(lblDate);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 165, 0)));
		panel.setBounds(24, 93, 615, 299);
		add(panel);
		panel.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(255, 165, 0)));
		panel_1.setBounds(0, 0, 615, 44);
		panel.add(panel_1);
		panel_1.setLayout(null);

		lblPAccount = new JLabel("Personal Accounts");
		lblPAccount.setForeground(Color.BLUE);
		lblPAccount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPAccount.setBounds(75, 9, 127, 22);
		panel_1.add(lblPAccount);

		file = new File(path);
		try {

			image = ImageIO.read(file);
		} catch (IOException e) {

			e.printStackTrace();
		}

		lblImage = new JLabel(new ImageIcon(image));
		lblImage.setBounds(10, 0, 46, 44);
		panel_1.add(lblImage);

		panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(0, 42, 615, 1);
		panel_1.add(panel_3);

		panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(0, 1, 0, 1, (Color) new Color(255, 165, 0)));
		panel_2.setBackground(new Color(201, 216, 239));
		panel_2.setBounds(0, 44, 615, 34);
		panel.add(panel_2);
		panel_2.setLayout(null);

		lblAccName = new JLabel("Type");
		lblAccName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAccName.setBounds(10, 12, 46, 14);
		panel_2.add(lblAccName);

		lblAccNum = new JLabel("Account Number");
		lblAccNum.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAccNum.setBounds(97, 12, 108, 14);
		panel_2.add(lblAccNum);

		lblSort = new JLabel("Sort Code");
		lblSort.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSort.setBounds(245, 12, 68, 14);
		panel_2.add(lblSort);

		lblBalance = new JLabel("Balance");
		lblBalance.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBalance.setBounds(365, 12, 53, 14);
		panel_2.add(lblBalance);

		lblAvail = new JLabel("Transaction");
		lblAvail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAvail.setBounds(478, 12, 80, 14);
		panel_2.add(lblAvail);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(1, 78, 613, 220);
		panel.add(scrollPane);

		table = new JTable() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				// To disable editing
				return false;
			}
		};
		table.setShowGrid(false);
		table.setSelectionModel(new ForcedListSelectionModel());
		table.setBorder(new MatteBorder(0, 1, 0, 1, (Color) new Color(255, 165, 0)));
		table.setTableHeader(null);

		scrollPane.setViewportView(table);

		try {
			populateTableSummary();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Method to populate the table with past 7 days transactions
	 * @throws SQLException
	 */
	public static void populateTableSummary() throws SQLException {

		table.removeAll();
		ResultSet result = Query.getSummary(pin);

		table.setModel(DbUtils.resultSetToTableModel(result));

	}
}
