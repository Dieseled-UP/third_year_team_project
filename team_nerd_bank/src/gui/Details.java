/* 
 * 4 Mar 2015
 * team_nerd_bank
 * 00:10:12
 */
package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

public class Details extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblFName;
	private JTextField txtName;
	private JLabel lblSurname;
	private JTextField txtSurname;
	private JLabel lblAdressOne;
	private JTextField txtAddLine;
	private JLabel lblAdressTwo;
	private JTextField textField;
	private JComboBox cbxCounty;
	private JLabel lblTelPhone;
	private JTextField txtTelPhone;
	private JLabel lblMobile;
	private JTextField textField_1;
	private JLabel lblInfo;

	public Details() {
		setBorder(new LineBorder(new Color(255, 165, 0)));

		setLayout(null);

		lblFName = new JLabel("Name:");
		lblFName.setForeground(Color.BLUE);
		lblFName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFName.setBounds(63, 65, 46, 14);
		add(lblFName);

		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtName.setBounds(63, 84, 179, 20);
		add(txtName);
		txtName.setColumns(10);
		
		lblSurname = new JLabel("Surname:");
		lblSurname.setForeground(Color.BLUE);
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSurname.setBounds(63, 115, 71, 14);
		add(lblSurname);
		
		txtSurname = new JTextField();
		txtSurname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSurname.setBounds(63, 140, 179, 20);
		add(txtSurname);
		txtSurname.setColumns(10);
		
		lblAdressOne = new JLabel("Address Line 1:");
		lblAdressOne.setForeground(Color.BLUE);
		lblAdressOne.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdressOne.setBounds(63, 171, 102, 14);
		add(lblAdressOne);
		
		txtAddLine = new JTextField();
		txtAddLine.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAddLine.setBounds(63, 196, 232, 20);
		add(txtAddLine);
		txtAddLine.setColumns(10);
		
		lblAdressTwo = new JLabel("Address Line 2:");
		lblAdressTwo.setForeground(Color.BLUE);
		lblAdressTwo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdressTwo.setBounds(63, 228, 102, 14);
		add(lblAdressTwo);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(63, 253, 232, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblCounty = new JLabel("County:");
		lblCounty.setForeground(Color.BLUE);
		lblCounty.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCounty.setBounds(380, 230, 62, 14);
		add(lblCounty);
		
		cbxCounty = new JComboBox();
		cbxCounty.setForeground(new Color(0, 0, 0));
		cbxCounty.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxCounty.setBounds(380, 253, 161, 20);
		add(cbxCounty);
		
		lblTelPhone = new JLabel("Tel. Phone:");
		lblTelPhone.setForeground(Color.BLUE);
		lblTelPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelPhone.setBounds(63, 284, 71, 14);
		add(lblTelPhone);
		
		txtTelPhone = new JTextField();
		txtTelPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTelPhone.setBounds(63, 314, 161, 20);
		add(txtTelPhone);
		txtTelPhone.setColumns(10);
		
		lblMobile = new JLabel("Mobile:");
		lblMobile.setForeground(Color.BLUE);
		lblMobile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMobile.setBounds(274, 286, 46, 14);
		add(lblMobile);
		
		textField_1 = new JTextField();
		textField_1.setBounds(274, 314, 168, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		lblInfo = new JLabel("<html>Please fill any new details.  Please be aware that any name changes will have to be comfirmed within <u>seven</u> days at your local brach with the correct documentation.</html>");
		lblInfo.setForeground(Color.BLUE);
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInfo.setBounds(416, 35, 221, 85);
		add(lblInfo);
	}
}
