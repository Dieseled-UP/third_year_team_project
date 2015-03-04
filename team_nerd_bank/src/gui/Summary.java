/*
 * 4 Mar 2015
 * team_nerd_bank
 * 01:45:23
 */
package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class Summary extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JLabel lblSumm;
	private JLabel lblLastLog;
	private JLabel lblDate;
	private JLabel lblPAccount;
	private JLabel lblAccName;
	private JLabel lblAccNum;
	private JLabel lblSort;
	private JLabel lblBalance;
	private JLabel lblAvail;

	public Summary() {

		setLayout(null);

		lblSumm = new JLabel("Account Summary");
		lblSumm.setForeground(Color.BLUE);
		lblSumm.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSumm.setBounds(36, 26, 158, 25);
		add(lblSumm);

		lblLastLog = new JLabel("Last Login:");
		lblLastLog.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLastLog.setBounds(36, 62, 65, 20);
		add(lblLastLog);
		
		lblDate = new JLabel("  ");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDate.setBounds(128, 66, 138, 20);
		add(lblDate);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 165, 0)));
		panel.setBounds(22, 93, 615, 299);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 615, 44);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblPAccount = new JLabel("Personal Accounts");
		lblPAccount.setForeground(Color.BLUE);
		lblPAccount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPAccount.setBounds(90, 11, 127, 22);
		panel_1.add(lblPAccount);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(201, 216, 239));
		panel_2.setBounds(0, 44, 615, 34);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		lblAccName = new JLabel("Account Name");
		lblAccName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAccName.setBounds(22, 12, 95, 14);
		panel_2.add(lblAccName);
		
		lblAccNum = new JLabel("Account Number");
		lblAccNum.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAccNum.setBounds(154, 12, 108, 14);
		panel_2.add(lblAccNum);
		
		lblSort = new JLabel("Sort Code");
		lblSort.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSort.setBounds(308, 12, 68, 14);
		panel_2.add(lblSort);
		
		lblBalance = new JLabel("Balance");
		lblBalance.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBalance.setBounds(425, 12, 53, 14);
		panel_2.add(lblBalance);
		
		lblAvail = new JLabel("Available");
		lblAvail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAvail.setBounds(528, 11, 63, 14);
		panel_2.add(lblAvail);
	}
}
