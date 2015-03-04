package gui;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.JComboBox;
import javax.swing.JLabel;
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
	
	public Account() {
		setLayout(null);
		
		comboBox = new JComboBox(words);
		comboBox.setBounds(70, 30, 80, 20);
		add(comboBox);
		
		lblNewLabel = new JLabel("Account No.");
		lblNewLabel.setBounds(33, 80, 67, 25);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(110, 82, 101, 20);
		add(textField);
		textField.setColumns(10);
		
		lblType = new JLabel("Type");
		lblType.setBounds(33, 133, 46, 14);
		add(lblType);
		
		textField_1 = new JTextField();
		textField_1.setBounds(110, 130, 101, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		lblBalance = new JLabel("Balance");
		lblBalance.setBounds(33, 185, 46, 14);
		add(lblBalance);
		
		textField_2 = new JTextField();
		textField_2.setBounds(110, 180, 101, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(52, 266, 89, 23);
		add(btnAdd);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(303, 266, 89, 23);
		add(btnDelete);
		
		
		
	}
}
