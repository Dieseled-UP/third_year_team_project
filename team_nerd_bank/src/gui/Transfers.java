/*
 * 3 Mar 2015
 * team_nerd_bank
 * 18:55:48
 */
package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import connect.Query;

public class Transfers extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel pnlPayee;
	private JComboBox<String> cbxAccounts;
	private JLabel lblFrom;
	private JSpinner sprMoney;
	private SpinnerModel spinMod;
	private JLabel lblValue;
	private JLabel lblTo;
	private JComboBox<String> cobkNames;
	private JLabel lblOr;
	private JPanel pnlDate;
	private JLabel lblNewLabel_2;
	private JLabel lblTranInfo;
	private JLabel lblTran;
	private JButton btnOK;
	private JButton btnAddPayee;
	private int pin;
	private JPanel panel;
	private JDateChooser dateChooser;
	private ArrayList<String> accounts;
	private ArrayList<String> payeeName;
	private int accountNum;
	private String name;
	private double amount;
	private String date;

	public Transfers(String autoNumber) {

		pin = Integer.parseInt(autoNumber);

		accounts = Query.getAccountNumbers(pin);
		payeeName = Query.getPayeesNames(pin);

		spinMod = new SpinnerNumberModel(0, 0, 500000, 1);
		setBorder(new LineBorder(new Color(255, 165, 0)));

		setLayout(null);

		lblFrom = new JLabel("<html><span style=\"font-size: 11\">From<br/> </span>Account</html>");
		lblFrom.setForeground(Color.BLUE);
		lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFrom.setBounds(239, 48, 115, 31);
		add(lblFrom);

		cbxAccounts = new JComboBox<String>();
		fillAccountCombo();
		cbxAccounts.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxAccounts.setBounds(239, 90, 101, 26);
		add(cbxAccounts);

		pnlPayee = new JPanel();
		pnlPayee.setBorder(new TitledBorder(new LineBorder(new Color(255, 165, 0)), "Pay", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Tahoma", Font.BOLD, 14), new Color(0, 0, 139)));
		pnlPayee.setBounds(24, 143, 615, 140);
		add(pnlPayee);
		pnlPayee.setLayout(null);

		lblTo = new JLabel("To");
		lblTo.setForeground(Color.BLUE);
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTo.setBounds(10, 24, 46, 14);
		pnlPayee.add(lblTo);

		cobkNames = new JComboBox<String>();
		fillNameSCombo();
		cobkNames.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cobkNames.setBounds(20, 47, 246, 26);
		pnlPayee.add(cobkNames);

		lblOr = new JLabel("Or");
		lblOr.setForeground(Color.BLUE);
		lblOr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOr.setBounds(10, 78, 46, 14);
		pnlPayee.add(lblOr);

		btnAddPayee = new JButton("Add Someone New");
		btnAddPayee.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddPayee.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAddPayee.setBackground(new Color(201, 216, 239));
		btnAddPayee.setBounds(20, 103, 155, 26);
		pnlPayee.add(btnAddPayee);

		lblValue = new JLabel("<html>Amount<br/>to Pay</html>");
		lblValue.setBounds(318, 25, 63, 31);
		pnlPayee.add(lblValue);
		lblValue.setForeground(Color.BLUE);
		lblValue.setFont(new Font("Tahoma", Font.PLAIN, 14));

		sprMoney = new JSpinner(spinMod);
		sprMoney.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sprMoney.setBounds(391, 30, 101, 26);
		pnlPayee.add(sprMoney);

		pnlDate = new JPanel();
		pnlDate.setLayout(null);
		pnlDate.setBorder(new TitledBorder(new LineBorder(new Color(255, 165, 0)), "Date", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Tahoma", Font.BOLD, 14), new Color(0, 0, 139)));
		pnlDate.setBounds(24, 294, 615, 87);
		add(pnlDate);

		lblNewLabel_2 = new JLabel("<html> choose the date you wish to send the transfer on </html>");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(288, 27, 219, 37);
		pnlDate.add(lblNewLabel_2);

		panel = new JPanel();
		panel.setBounds(86, 27, 158, 34);
		pnlDate.add(panel);

		dateChooser = new JDateChooser();
		dateChooser.setLocale(Locale.UK);
		panel.add(dateChooser);

		lblTranInfo = new JLabel(
				"<html>Please choose an account and an amount you wish to transfer.  Then select who you want to transfer too, and finally choose the date on which you wish the transfer to go through on.</html>");
		lblTranInfo.setForeground(Color.BLUE);
		lblTranInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTranInfo.setBounds(416, 35, 221, 102);
		add(lblTranInfo);

		lblTran = new JLabel("Transfers");
		lblTran.setForeground(Color.BLUE);
		lblTran.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTran.setBounds(36, 26, 101, 25);
		add(lblTran);

		btnOK = new JButton("OK");
		btnOK.setForeground(Color.BLUE);
		btnOK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOK.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnOK.setBackground(new Color(201, 216, 239));
		btnOK.setBounds(500, 400, 89, 26);
		add(btnOK);

		// Open Payee Panel if the user wishes to add a new Payee
		btnAddPayee.addActionListener(arg0 -> {

			MainFrame.displayPayee();
		});

		btnOK.addActionListener(arg0 -> {

			getDetails();
			checkUserInput();
			sortFunds();
			updateTransaction();
		});
	}

	/**
	 * Method to fill the accounts combo box
	 */
	public void fillAccountCombo() {

		cbxAccounts.addItem("-Select-");
		for (int i = 0; i < accounts.size(); i++) {

			cbxAccounts.addItem(accounts.get(i));
		}
	}

	/**
	 * Method to fill the Payees combo box
	 */
	public void fillNameSCombo() {

		cobkNames.addItem("-Select-");
		for (int i = 0; i < payeeName.size(); i++) {

			cobkNames.addItem(payeeName.get(i));
		}
	}

	/**
	 * Method to get User inputs
	 */
	public void getDetails() {

		try {

			accountNum = Integer.parseInt(cbxAccounts.getSelectedItem().toString());
			name = cobkNames.getSelectedItem().toString();
			amount = Integer.parseInt(sprMoney.getValue().toString());
			date = dateChooser.getDateFormatString();

		} catch (NumberFormatException e) {

			JOptionPane.showMessageDialog(null, "Sorry please check that you have filled all fields correctly");
			e.printStackTrace();
		}
	}

	/**
	 * Method to ensure user input is correct
	 */
	public void checkUserInput() {

		if (name == null) {

			JOptionPane.showMessageDialog(null, "Sorry please check that you have filled all fields correctly");
		}
		if (date == null) {

			date = Calendar.getInstance(Locale.UK).toString();
		}
	}

	/**
	 * Method to Ensure user has enough funds and if so proceeded to subtract
	 * transfer amount
	 */
	public void sortFunds() {

		boolean goodToGo = Query.checkBalance(amount, accountNum, pin);

		if (goodToGo) {

			boolean executed = Query.subtractBalance(amount, accountNum);

			if (executed) {

				JOptionPane.showMessageDialog(null, "Transfer has been complete");
			}
		}
	}

	/**
	 * Method to update Transaction table
	 */
	public void updateTransaction() {

		Query.insertTransaction(name, accountNum, -amount, pin);
	}
}
