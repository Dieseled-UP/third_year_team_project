/*
 * 10 Apr 2015
 * team_nerd_bank
 * 15:59:28
 */
package gui;

import java.awt.Color;
import java.awt.Font;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class Statements extends JPanel {

	private static final long serialVersionUID = 1L;

	String[] words = new String[] { "hhdfhjld", "fdgfg" };

	private JTable table;
	private JPanel selectDatePanel;
	private JPanel viewStatements;
	private JLabel lblDate;
	private JLabel lblNewLabel;
	private JLabel lblDebit;
	private JLabel lblCredit;
	private JComboBox<String> AccComboBox;
	private JLabel lblTo;
	private JLabel lblNewLabel_1;
	private JCalendar cal;
	private JPanel pnlDateFrom;
	private JDateChooser dateToChooser;
	private JDateChooser dateFromChooser;

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
		dateFromChooser = new JDateChooser();
		dateFromChooser.setLocale(Locale.UK);

		cal = new JCalendar();
		cal.getYearChooser().getSpinner().setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 12));
		cal.getMonthChooser().getSpinner().setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 12));
		cal.getDayChooser().setDayBordersVisible(true);
		
		setLayout(null);

		selectDatePanel = new JPanel();
		selectDatePanel.setBorder(new TitledBorder(new LineBorder(new Color(255, 165, 0)), "Select Dates to view", TitledBorder.LEADING,
				TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 14), new Color(0, 0, 255)));
		selectDatePanel.setBounds(20, 11, 619, 136);
		add(selectDatePanel);
		selectDatePanel.setLayout(null);

		lblNewLabel_1 = new JLabel("FROM");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(new Color(0, 0, 205));
		lblNewLabel_1.setBounds(58, 88, 48, 27);
		selectDatePanel.add(lblNewLabel_1);

		lblTo = new JLabel("TO");
		lblTo.setForeground(new Color(0, 0, 255));
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTo.setBounds(379, 88, 29, 27);
		selectDatePanel.add(lblTo);
		
		pnlDateFrom = new JPanel();
		pnlDateFrom.setBounds(116, 88, 158, 37);
		selectDatePanel.add(pnlDateFrom);
		
		pnlDateFrom.add(dateFromChooser);
		
				AccComboBox = new JComboBox<>();
				AccComboBox.setBounds(112, 29, 181, 29);
				selectDatePanel.add(AccComboBox);
				
				JLabel lblAccount = new JLabel("Account");
				lblAccount.setForeground(Color.BLUE);
				lblAccount.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 14));
				lblAccount.setBounds(38, 27, 68, 29);
				selectDatePanel.add(lblAccount);
				
				JPanel pnlDateTo = new JPanel();
				pnlDateTo.setBounds(418, 88, 153, 37);
				selectDatePanel.add(pnlDateTo);
				
				dateToChooser = new JDateChooser();
				dateToChooser.setLocale(Locale.UK);
				pnlDateTo.add(dateToChooser);
		
		viewStatements = new JPanel();
		viewStatements.setBorder(new TitledBorder(new LineBorder(new Color(255, 165, 0)), "Statements", TitledBorder.LEADING,
				TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 14), new Color(0, 0, 255)));
		viewStatements.setBounds(20, 158, 619, 258);
		add(viewStatements);
		viewStatements.setLayout(null);

		table = new JTable();
		table.setBounds(4, 54, 609, 199);
		viewStatements.add(table);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(201, 216, 239));
		panel.setBounds(4, 23, 611, 32);
		viewStatements.add(panel);
		panel.setLayout(null);

		lblDate = new JLabel("Date");
		lblDate.setBounds(47, 11, 61, 19);
		panel.add(lblDate);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDate.setForeground(Color.BLACK);

		lblNewLabel = new JLabel("Description");
		lblNewLabel.setBounds(204, 7, 92, 26);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.BLACK);

		lblDebit = new JLabel("Debit");
		lblDebit.setBounds(361, 1, 46, 38);
		panel.add(lblDebit);
		lblDebit.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDebit.setForeground(Color.BLACK);

		lblCredit = new JLabel("Credit");
		lblCredit.setBounds(498, 5, 56, 30);
		panel.add(lblCredit);
		lblCredit.setForeground(Color.BLACK);
		lblCredit.setFont(new Font("Tahoma", Font.BOLD, 12));
	}
}
