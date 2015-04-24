/*4 Mar 2015
team_nerd_bank
11:13:00*/

package gui;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;
import people.Payee;
import table.ForcedListSelectionModel;
import connect.Query;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;

//import com.sun.java.util.jar.pack.Package.Class.Member;

public class Payees extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtFname;
	private JTextField txtLname;
	private JTextField txtAccountNo;
	private JTextField txtSortCode;
	private JButton btnAdd;
	private JLabel lblFname;
	private JLabel lblLname;
	private JLabel lblAccountNo;
	private JLabel lblSortCode;
	private JButton btnRemove;
	private JLabel label;
	private JTextField txtReference;
	private JLabel lblReference;
	private static JTable table;
	private JScrollPane scrollPane;
	private static Payee new_payee = null;
	private static int pin;
	private JPanel pnlList;
	private JPanel pnlTitles;

	public Payees(String autoNumber) {

		setBorder(new LineBorder(new Color(255, 165, 0)));
		setLayout(null);

		pin = Integer.parseInt(autoNumber);

		lblFname = new JLabel("First Name:");
		lblFname.setForeground(Color.BLUE);
		lblFname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFname.setBounds(10, 299, 71, 14);
		add(lblFname);

		txtFname = new JTextField();
		txtFname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFname.setColumns(10);
		txtFname.setBounds(10, 318, 179, 32);
		add(txtFname);

		lblLname = new JLabel("Last Name:");
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

		btnAdd = new JButton("Add ");
		btnAdd.setHorizontalAlignment(SwingConstants.LEADING);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd.setBounds(10, 263, 61, 26);
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
		txtReference.setBounds(214, 390, 179, 32);
		add(txtReference);

		lblReference = new JLabel("Reference:");
		lblReference.setForeground(Color.BLUE);
		lblReference.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReference.setBounds(214, 365, 83, 14);
		add(lblReference);

		pnlList = new JPanel();
		pnlList.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(255, 165, 0)));
		pnlList.setBounds(10, 11, 445, 246);
		add(pnlList);
		pnlList.setLayout(null);

		pnlTitles = new JPanel();
		pnlTitles.setLayout(null);
		pnlTitles.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(255, 165, 0)));
		pnlTitles.setBackground(new Color(201, 216, 239));
		pnlTitles.setBounds(0, 0, 445, 34);
		pnlList.add(pnlTitles);

		JLabel lblReference_1 = new JLabel("Reference");
		lblReference_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblReference_1.setBounds(10, 12, 68, 14);
		pnlTitles.add(lblReference_1);

		JLabel label_2 = new JLabel("Account Number");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(197, 12, 108, 14);
		pnlTitles.add(label_2);

		JLabel label_3 = new JLabel("Sort Code");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(338, 12, 68, 14);
		pnlTitles.add(label_3);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(112, 12, 53, 14);
		pnlTitles.add(lblName);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));

		scrollPane = new JScrollPane();
		scrollPane.setBounds(1, 33, 443, 212);
		pnlList.add(scrollPane);

		table = new JTable() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				// To disable editing
				return false;
			}
		};
		table.setShowGrid(false);
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.setSelectionModel(new ForcedListSelectionModel());
		table.setTableHeader(null);

		scrollPane.setViewportView(table);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(421, 391, 103, 32);
		add(comboBox);

		// JScrollPane scrollPane = new JScrollPane(table);
		try {
			populateTable();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		// ///////////////////////////////////
		// /// Add button to be updated //////
		// ///////////////////////////////////

		btnAdd.addActionListener(arg0 -> {
			try {
				String full_name = txtFname.getText() + " " + txtLname.getText();
				int accNo = Integer.parseInt(txtAccountNo.getText());
				new_payee = new Payee(txtReference.getText(), full_name, accNo, txtSortCode.getText());

				// get assigned account id to be fixed
				Query.setPayee(new_payee.getReference(), new_payee.getName(), new_payee.getPayeeAccNo(),
						new_payee.getPayeeCode(), 1234);

				populateTable();
			} catch (Exception e) {

				System.out.println("No input");
				e.printStackTrace();
			}
		});

		btnRemove.addActionListener(arg0 -> {
			try {
				removePayee();
			} catch (Exception e) {

				System.out.println("No input");
				e.printStackTrace();
			}
		});
	}

	public static void removePayee() {
		// to get account number of selected row
		int selectedAccountRow = table.getSelectedRow();
		int selectedAccountColumn = 2;
		Object selectedAccount = (Object) table.getModel().getValueAt(selectedAccountRow, selectedAccountColumn);
		int accountNo = Integer.parseInt(selectedAccount.toString());
		System.out.println(selectedAccount.toString());
		// System.out.println(selectedRowIndex);

		// to get sort code of selected row
		int selectedSortCodeRow = table.getSelectedRow();
		int selectedSortCodeColumn = 3;
		Object selectedSortCode = (Object) table.getModel().getValueAt(selectedSortCodeRow, selectedSortCodeColumn);
		System.out.println(selectedSortCode.toString());

		// to identify payee in database and remove it
		Query.removePayeeDatabase(accountNo, selectedSortCode.toString());
		try {
			populateTable();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void populateTable() throws SQLException {

		ResultSet result = Query.getPayeeDetails(pin);

		table.setModel(DbUtils.resultSetToTableModel(result));

	}
}
