/*
 * 10 Apr 2015
 * team_nerd_bank
 * 15:59:28
 */
package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;

public class Statements extends JPanel {

	private static final long serialVersionUID = 1L;

	String[] words = new String[] { "hhdfhjld", "fdgfg" };

	private JTable table;
	private JPanel selectAccPanel;
	private JPanel selectDatePanel;
	private JPanel viewStatements;
	private JLabel lblDate;
	private JLabel lblNewLabel;
	private JLabel lblDebit;
	private JLabel lblCredit;
	private JComboBox<String> AccComboBox;
	private JSpinner spinner;
	private JSpinner spinner_1;
	private JSpinner spinner_2;
	private JLabel lblDay;
	private JLabel lblMonth;
	private JLabel lblYear;
	private JLabel lblTo;
	private JLabel lblNewLabel_1;
	private JSpinner spinner_3;
	private JSpinner spinner_4;
	private JSpinner spinner_5;
	private JLabel lblDay_1;
	private JLabel lblMonth_1;
	private JLabel lblYear_1;

	public Statements() {

		try {

			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look
			// and feel.
		}

		setLayout(null);

		selectAccPanel = new JPanel();
		selectAccPanel.setBorder(new TitledBorder(new LineBorder(new Color(255, 165, 0)), "Select Account to view", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 255)));
		selectAccPanel.setBounds(20, 11, 619, 88);
		add(selectAccPanel);
		selectAccPanel.setLayout(null);

		AccComboBox = new JComboBox<>();
		AccComboBox.setBounds(192, 32, 181, 20);
		selectAccPanel.add(AccComboBox);

		selectDatePanel = new JPanel();
		selectDatePanel.setBorder(new TitledBorder(new LineBorder(new Color(255, 165, 0)), "Select Dates to view", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 255)));
		selectDatePanel.setBounds(20, 110, 619, 88);
		add(selectDatePanel);
		selectDatePanel.setLayout(null);

		spinner = new JSpinner();
		spinner.setBounds(94, 50, 39, 27);
		selectDatePanel.add(spinner);

		spinner_1 = new JSpinner();
		spinner_1.setBounds(149, 50, 64, 27);
		selectDatePanel.add(spinner_1);

		spinner_2 = new JSpinner();
		spinner_2.setBounds(230, 50, 54, 27);
		selectDatePanel.add(spinner_2);

		spinner_3 = new JSpinner();
		spinner_3.setBounds(387, 50, 48, 27);
		selectDatePanel.add(spinner_3);

		spinner_4 = new JSpinner();
		spinner_4.setBounds(451, 50, 73, 27);
		selectDatePanel.add(spinner_4);

		spinner_5 = new JSpinner();
		spinner_5.setBounds(534, 50, 48, 27);
		selectDatePanel.add(spinner_5);

		lblNewLabel_1 = new JLabel("FROM");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(new Color(0, 0, 205));
		lblNewLabel_1.setBounds(26, 38, 48, 27);
		selectDatePanel.add(lblNewLabel_1);

		lblTo = new JLabel("TO");
		lblTo.setForeground(new Color(0, 0, 255));
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTo.setBounds(335, 38, 29, 27);
		selectDatePanel.add(lblTo);

		lblDay = new JLabel("Day");
		lblDay.setForeground(new Color(0, 0, 255));
		lblDay.setBounds(94, 26, 39, 27);
		selectDatePanel.add(lblDay);

		lblMonth = new JLabel("Month");
		lblMonth.setForeground(new Color(0, 0, 255));
		lblMonth.setBounds(159, 26, 48, 27);
		selectDatePanel.add(lblMonth);

		lblYear = new JLabel("Year");
		lblYear.setForeground(new Color(0, 0, 255));
		lblYear.setBounds(230, 29, 48, 20);
		selectDatePanel.add(lblYear);

		lblDay_1 = new JLabel("Day");
		lblDay_1.setForeground(new Color(0, 0, 255));
		lblDay_1.setBounds(387, 26, 29, 27);
		selectDatePanel.add(lblDay_1);

		lblMonth_1 = new JLabel("Month");
		lblMonth_1.setForeground(new Color(0, 0, 255));
		lblMonth_1.setBounds(451, 26, 39, 26);
		selectDatePanel.add(lblMonth_1);

		lblYear_1 = new JLabel("Year");
		lblYear_1.setForeground(new Color(0, 0, 255));
		lblYear_1.setBounds(534, 29, 54, 20);
		selectDatePanel.add(lblYear_1);

		viewStatements = new JPanel();
		viewStatements.setBorder(new TitledBorder(new LineBorder(new Color(255, 165, 0)), "Statements", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 255)));
		viewStatements.setBounds(20, 198, 619, 222);
		add(viewStatements);
		viewStatements.setLayout(null);
		
				table = new JTable();
				table.setBounds(10, 54, 599, 159);
				viewStatements.add(table);
				
				JPanel panel = new JPanel();
				panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				panel.setBackground(SystemColor.inactiveCaption);
				panel.setBounds(10, 23, 599, 32);
				viewStatements.add(panel);
				panel.setLayout(null);
				
						lblDate = new JLabel("Date");
						lblDate.setBounds(21, 11, 61, 19);
						panel.add(lblDate);
						lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
						lblDate.setForeground(Color.BLACK);
						
								lblNewLabel = new JLabel("Description");
								lblNewLabel.setBounds(108, 7, 92, 26);
								panel.add(lblNewLabel);
								lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
								lblNewLabel.setForeground(Color.BLACK);
								
										lblDebit = new JLabel("Debit");
										lblDebit.setBounds(430, 1, 46, 38);
										panel.add(lblDebit);
										lblDebit.setFont(new Font("Tahoma", Font.BOLD, 12));
										lblDebit.setForeground(Color.BLACK);
										
												lblCredit = new JLabel("Credit");
												lblCredit.setBounds(515, 5, 56, 30);
												panel.add(lblCredit);
												lblCredit.setForeground(Color.BLACK);
												lblCredit.setFont(new Font("Tahoma", Font.BOLD, 12));
	}
}
