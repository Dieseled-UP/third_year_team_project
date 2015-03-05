/*
 * 4 Mar 2015
 * team_nerd_bank
 * 01:45:23
 */
package gui;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTable;

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
	private JTable table;
	private JLabel lblImage;
	private String path = "Assets/euroSym.png";
	private File file;
	private BufferedImage image;

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
		panel_1.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(255, 165, 0)));
		panel_1.setBounds(0, 0, 615, 44);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblPAccount = new JLabel("Personal Accounts");
		lblPAccount.setForeground(Color.BLUE);
		lblPAccount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPAccount.setBounds(75, 9, 127, 22);
		panel_1.add(lblPAccount);
		
		file = new File(path);
		try {

			image = ImageIO.read(file);
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		lblImage = new JLabel(new ImageIcon(image));
		lblImage.setBounds(10, 0, 46, 44);
		panel_1.add(lblImage);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(0, 1, 0, 1, (Color) new Color(255, 165, 0)));
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
		
		table = new JTable();
		table.setBorder(new MatteBorder(0, 1, 0, 1, (Color) new Color(255, 165, 0)));
		table.setBounds(0, 78, 615, 210);
		panel.add(table);
	}
}
