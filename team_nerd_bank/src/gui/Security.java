/*
 * 5 Mar 2015
 * team_nerd_bank
 * 17:12:36
 */
package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

public class Security extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JLabel lblConfirmPin;
	private JTextField txtOldPin;
	private JLabel lblNewPin;
	private JTextField textField;

	public Security() {

		setLayout(null);

		lblConfirmPin = new JLabel("Please confirm old PIN");
		lblConfirmPin.setForeground(Color.BLUE);
		lblConfirmPin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirmPin.setBounds(55, 52, 143, 23);
		add(lblConfirmPin);
		
		txtOldPin = new JTextField();
		txtOldPin.setBounds(80, 76, 86, 26);
		add(txtOldPin);
		txtOldPin.setColumns(10);
		
		lblNewPin = new JLabel("Enter new PIN");
		lblNewPin.setForeground(Color.BLUE);
		lblNewPin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewPin.setBounds(55, 117, 111, 14);
		add(lblNewPin);
		
		textField = new JTextField();
		textField.setBounds(80, 139, 86, 26);
		add(textField);
		textField.setColumns(10);
	}
}
