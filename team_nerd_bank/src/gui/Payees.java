/*4 Mar 2015
team_nerd_bank
11:13:00*/

package gui;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;

import com.mysql.jdbc.Connection;

import connect.Connect_DB;

public class Payees extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtFname;
	private JTextField txtLname;
	private JTextField txtAccountNo;
	private JTextField txtIbanNo;
	private JTextField txtSortCode;
	private JButton btnAdd;
	private JLabel lblFname;
	private JLabel lblLname;
	private JLabel lblAccountNo;
	private JLabel lblIbanNo;
	private JLabel lblInfo;
	private JLabel lblSortCode;
	private JButton btnRemove;
	private JLabel label;
	private JTextField txtReference;
	private JLabel lblReference;
	private static JTable table;
	private JScrollPane scrollPane;
	private Connection conn = null;

	public Payees() {

		setBorder(new LineBorder(new Color(255, 165, 0)));
		setLayout(null);

		lblFname = new JLabel("Name:");
		lblFname.setForeground(Color.BLUE);
		lblFname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFname.setBounds(10, 299, 46, 14);
		add(lblFname);

		txtFname = new JTextField();
		txtFname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFname.setColumns(10);
		txtFname.setBounds(10, 318, 179, 32);
		add(txtFname);

		lblLname = new JLabel("Surname:");
		lblLname.setForeground(Color.BLUE);
		lblLname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLname.setBounds(10, 365, 71, 14);
		add(lblLname);

		txtLname = new JTextField();
		txtLname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtLname.setColumns(10);
		txtLname.setBounds(10, 390, 179, 32);
		add(txtLname);

		txtAccountNo = new JTextField();
		txtAccountNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAccountNo.setColumns(10);
		txtAccountNo.setBounds(214, 318, 179, 32);
		add(txtAccountNo);

		lblAccountNo = new JLabel("Account no:");
		lblAccountNo.setForeground(Color.BLUE);
		lblAccountNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAccountNo.setBounds(215, 299, 83, 14);
		add(lblAccountNo);

		lblIbanNo = new JLabel("IBAN no:");
		lblIbanNo.setForeground(Color.BLUE);
		lblIbanNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIbanNo.setBounds(215, 365, 83, 14);
		add(lblIbanNo);

		txtIbanNo = new JTextField();
		txtIbanNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIbanNo.setColumns(10);
		txtIbanNo.setBounds(214, 390, 179, 32);
		add(txtIbanNo);

		lblInfo = new JLabel(
				"<html>Please fill required details.  Please be aware that the details will be confirmed within <u>seven</u> days .</html>");
		lblInfo.setForeground(Color.BLUE);
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInfo.setBounds(465, 206, 188, 83);
		add(lblInfo);

		btnAdd = new JButton("Add ");
		btnAdd.setHorizontalAlignment(SwingConstants.LEADING);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd.setBounds(10, 262, 61, 26);
		add(btnAdd);

		txtSortCode = new JTextField();
		txtSortCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSortCode.setColumns(10);
		txtSortCode.setBounds(421, 318, 179, 32);
		add(txtSortCode);

		lblSortCode = new JLabel("Sort Code:");
		lblSortCode.setForeground(Color.BLUE);
		lblSortCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSortCode.setBounds(422, 299, 83, 14);
		add(lblSortCode);

		btnRemove = new JButton("Remove");
		btnRemove.setHorizontalAlignment(SwingConstants.LEADING);
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemove.setBounds(81, 263, 87, 26);
		add(btnRemove);

		label = new JLabel(
				"<html>Please fill required details.  Please be aware that the details will be confirmed within <u>seven</u> days .</html>");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(465, 24, 188, 83);
		add(label);

		txtReference = new JTextField();
		txtReference.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtReference.setColumns(10);
		txtReference.setBounds(421, 390, 179, 32);
		add(txtReference);

		lblReference = new JLabel("Reference:");
		lblReference.setForeground(Color.BLUE);
		lblReference.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReference.setBounds(421, 365, 83, 14);
		add(lblReference);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 433, 228);
		add(scrollPane);

		table = new JTable();
		table.setShowGrid(false);
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);
		populateTable();

		scrollPane.setViewportView(table);

		// ///////////////////////////////////
		// /// Add button to be updated //////
		// ///////////////////////////////////

		btnAdd.addActionListener(arg0 -> {
			populateTable();
		});
	}

	public static void populateTable() {

		java.sql.Connection conn = Connect_DB.getConnection();
		try {

			String query = "select CONCAT(First_Name,', ', Last_Name) as Name, Account_No as \"Account No\", Reference from Payee";
			java.sql.PreparedStatement statement = conn.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
