/*
 * 5 Mar 2015
 * team_nerd_bank
 * 17:12:36
 */
package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

public class Security extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JLabel lblConfirmPin;
	private JTextField txtOldPin;
	private JLabel lblNewPin;
	private JTextField textField;
	private JLabel lblNewPass;
	private JPasswordField pasNew;
	private JLabel lblConfirm;
	private JPasswordField pasConfirm;
	private JPanel pnlChange;
	private JButton btnOK;
	private JButton btnCancel;
	private JLabel lblInfo;
	private JLabel lblSecur;
	private JLabel lblLogDetails;

	public Security() {

		setLayout(null);
		
		pnlChange = new JPanel();
		pnlChange.setBorder(new LineBorder(new Color(255, 165, 0), 1, true));
		pnlChange.setBounds(24, 179, 615, 147);
		add(pnlChange);
		pnlChange.setLayout(null);
		
				lblConfirmPin = new JLabel("Please confirm old PIN");
				lblConfirmPin.setBounds(22, 11, 143, 23);
				pnlChange.add(lblConfirmPin);
				lblConfirmPin.setForeground(Color.BLUE);
				lblConfirmPin.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				txtOldPin = new JTextField();
				txtOldPin.setBounds(22, 34, 86, 26);
				pnlChange.add(txtOldPin);
				txtOldPin.setColumns(10);
				
				lblNewPin = new JLabel("Enter new PIN");
				lblNewPin.setBounds(22, 71, 111, 14);
				pnlChange.add(lblNewPin);
				lblNewPin.setForeground(Color.BLUE);
				lblNewPin.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				textField = new JTextField();
				textField.setBounds(22, 90, 86, 26);
				pnlChange.add(textField);
				textField.setColumns(10);
				
				lblNewPass = new JLabel("New Password");
				lblNewPass.setBounds(255, 15, 100, 14);
				pnlChange.add(lblNewPass);
				lblNewPass.setForeground(Color.BLUE);
				lblNewPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				pasNew = new JPasswordField();
				pasNew.setBounds(374, 10, 157, 26);
				pnlChange.add(pasNew);
				pasNew.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				lblConfirm = new JLabel("Confirm Password");
				lblConfirm.setBounds(255, 67, 118, 22);
				pnlChange.add(lblConfirm);
				lblConfirm.setForeground(Color.BLUE);
				lblConfirm.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				pasConfirm = new JPasswordField();
				pasConfirm.setBounds(374, 66, 157, 26);
				pnlChange.add(pasConfirm);
				pasConfirm.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				btnOK = new JButton("OK");
				btnOK.setForeground(Color.BLUE);
				btnOK.setBackground(new Color(201, 216, 239));
				btnOK.setCursor(new Cursor(Cursor.HAND_CURSOR));
				btnOK.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnOK.setBounds(337, 376, 89, 26);
				add(btnOK);
				
				btnCancel = new JButton("CANCEL");
				btnCancel.setForeground(Color.BLUE);
				btnCancel.setBackground(new Color(201, 216, 239));
				btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
				btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnCancel.setBounds(500, 376, 89, 26);
				add(btnCancel);
				
				lblInfo = new JLabel("<html>Please fill in the details below. If you exprience any difficulties or you fell you maybe a victim of online fruad please contact or helpdesk or call into your local branch.</html>");
				lblInfo.setForeground(Color.BLUE);
				lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblInfo.setBounds(416, 35, 221, 102);
				add(lblInfo);
				
				lblSecur = new JLabel("Security");
				lblSecur.setForeground(Color.BLUE);
				lblSecur.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblSecur.setBounds(36, 26, 89, 25);
				add(lblSecur);
				
				lblLogDetails = new JLabel("Login Details");
				lblLogDetails.setForeground(Color.BLUE);
				lblLogDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblLogDetails.setBounds(106, 98, 106, 24);
				add(lblLogDetails);
	}
}
