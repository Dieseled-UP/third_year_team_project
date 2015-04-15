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
	private JLabel lblTo;
	private JLabel lblNewLabel_1;

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
		
		//datePicker
		/*UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		 
		frame.add(datePicker);  */
		
		
		
		
		

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
