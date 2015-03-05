package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * @author Team Nerd Banks L00099023
 * 26 Feb 2015
 */
public class Account extends JPanel {
	
	private static final long serialVersionUID = 1L;
	String[] words = new String[] {"hhdfhjldh;h","fdgfg"};
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox comboBox;
	private JLabel lblNewLabel;
	private JLabel lblType;
	private JLabel lblBalance;
	private JButton btnAdd;
	private JButton btnDelete;
	private JLabel lblSelectAccount;
	
	public Account() {
		setLayout(null);
		
		comboBox = new JComboBox(words);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setForeground(Color.BLUE);
		comboBox.setBounds(295, 134, 80, 26);
		add(comboBox);
		
		lblNewLabel = new JLabel("Account No:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(52, 91, 89, 25);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setForeground(Color.BLUE);
		textField.setBounds(52, 116, 159, 26);
		add(textField);
		textField.setColumns(10);
		
		lblType = new JLabel("Account Type:");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblType.setForeground(Color.BLUE);
		lblType.setBounds(52, 158, 101, 17);
		add(lblType);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setBounds(52, 182, 159, 26);
		add(textField_1);
		textField_1.setColumns(10);
		
		lblBalance = new JLabel("Balance:");
		lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBalance.setForeground(Color.BLUE);
		lblBalance.setBounds(53, 245, 65, 14);
		add(lblBalance);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setBounds(52, 270, 159, 26);
		add(textField_2);
		textField_2.setColumns(10);
		
		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd.setForeground(Color.BLUE);
		btnAdd.setBounds(122, 350, 89, 26);
		add(btnAdd);
		
		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setForeground(Color.BLUE);
		btnDelete.setBounds(358, 350, 89, 26);
		add(btnDelete);
		
		lblSelectAccount = new JLabel("Select Account:");
		lblSelectAccount.setForeground(Color.BLUE);
		lblSelectAccount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelectAccount.setBounds(295, 96, 101, 14);
		add(lblSelectAccount);
		
		
		
	}
}
