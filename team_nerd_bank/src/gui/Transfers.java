/*
* 3 Mar 2015
* team_nerd_bank
* 18:55:48
*/
package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;


public class Transfers extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private static JList<String> dataList;
	private static DefaultListModel<String> dataModel;
	private JScrollPane dataHolder;
	private JPanel pnlPayee;
	private JComboBox cbxAccounts;
	private JLabel lblFrom;
	private JSpinner sprMoney;
	private JLabel lblValue;
	private JLabel lblTo;
	private JComboBox comboBox;
	private JLabel lblOr;
	private JPanel pnlDate;
	private JSpinner spinner;
	private JSpinner spinner_1;
	private JSpinner spinner_2;
	private JLabel lblDay;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblTranInfo;
	
	public Transfers() {
		
		setLayout(null);
		
		lblFrom = new JLabel("<html><span style=\"font-size: 11\">From<br/> </span>Current Account</html>");
		lblFrom.setForeground(Color.BLUE);
		lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFrom.setBounds(27, 42, 115, 31);
		add(lblFrom);
		
		cbxAccounts = new JComboBox();
		cbxAccounts.setBounds(27, 77, 101, 20);
		add(cbxAccounts);
		
		sprMoney = new JSpinner();
		sprMoney.setBounds(271, 77, 101, 20);
		add(sprMoney);
		
		lblValue = new JLabel("<html>Amount<br/>to Pay</html>");
		lblValue.setForeground(Color.BLUE);
		lblValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValue.setBounds(271, 41, 63, 31);
		add(lblValue);
		
		pnlPayee = new JPanel();
		pnlPayee.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, new Color(64, 64, 64), null, new Color(128, 128, 128), null), "Pay", TitledBorder.LEADING, TitledBorder.TOP, new Font("ariel", Font.BOLD, 15), new Color(0, 0, 255)));
		pnlPayee.setBounds(22, 137, 615, 140);
		add(pnlPayee);
		pnlPayee.setLayout(null);
		
		lblTo = new JLabel("To");
		lblTo.setForeground(Color.BLUE);
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTo.setBounds(10, 24, 46, 14);
		pnlPayee.add(lblTo);
		
		comboBox = new JComboBox();
		comboBox.setBounds(20, 47, 246, 20);
		pnlPayee.add(comboBox);
		
		lblOr = new JLabel("Or");
		lblOr.setForeground(Color.BLUE);
		lblOr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOr.setBounds(10, 78, 46, 14);
		pnlPayee.add(lblOr);
		
		JButton btnAddPayee = new JButton("Add Someone New");
		btnAddPayee.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddPayee.setHorizontalAlignment(SwingConstants.LEADING);
		btnAddPayee.setBounds(20, 103, 165, 23);
		pnlPayee.add(btnAddPayee);
		
		pnlDate = new JPanel();
		pnlDate.setLayout(null);
		pnlDate.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, new Color(64, 64, 64), null, new Color(128, 128, 128), null), "Date", TitledBorder.LEADING, TitledBorder.TOP, new Font("ariel", Font.BOLD, 15), new Color(0, 0, 255)));
		pnlDate.setBounds(22, 307, 615, 87);
		add(pnlDate);
		
		spinner = new JSpinner();
		spinner.setBounds(21, 44, 52, 20);
		pnlDate.add(spinner);
		
		spinner_1 = new JSpinner();
		spinner_1.setBounds(120, 44, 67, 20);
		pnlDate.add(spinner_1);
		
		spinner_2 = new JSpinner();
		spinner_2.setBounds(228, 44, 89, 20);
		pnlDate.add(spinner_2);
		
		lblDay = new JLabel("Day");
		lblDay.setForeground(Color.BLUE);
		lblDay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDay.setBounds(29, 18, 35, 20);
		pnlDate.add(lblDay);
		
		lblNewLabel_1 = new JLabel("Month");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(128, 18, 46, 20);
		pnlDate.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Year");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(252, 18, 35, 20);
		pnlDate.add(lblNewLabel_2);
		
		lblTranInfo = new JLabel("<html>Please choose an account and an amount you wish to transfer.  Then select who you want to transfer too, and finally choose the date on which you wish the transfer to go through on.</html>");
		lblTranInfo.setForeground(Color.BLUE);
		lblTranInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTranInfo.setBounds(416, 11, 221, 126);
		add(lblTranInfo);
		
		dataList = new JList<String>();
		dataHolder.setViewportView(dataList);
		dataList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dataList.setBorder(new BevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, null, null, null));

		dataModel = new DefaultListModel<>();
	}
}