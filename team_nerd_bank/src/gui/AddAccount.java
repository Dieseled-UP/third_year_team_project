package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class AddAccount extends JPanel {
	public AddAccount() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 5, 450, 295);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblEnterAccountNo = new JLabel("Enter Account No.");
		lblEnterAccountNo.setBounds(83, 67, 96, 14);
		panel.add(lblEnterAccountNo);
	}
}
