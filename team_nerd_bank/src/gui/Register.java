package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class Register extends JFrame implements Runnable {
	
	private static final long serialVersionUID = 1L;
	private JTextField txtFName;
	private JTextField txtName;
	private JTextField textField_1;
	private JPanel pnlHeader;
	private JPanel pnlForm;
	private JLabel lblTitle;
	private JLabel lblName;
	private JLabel label;
	private JLabel lblNewLabel_1;
	private JLabel lblSurname;
	private JTextField txtSurname;
	private JLabel lblAdressOne;
	private JTextField textField;
	private JTextField txtTown;
	private JTextField txtCounty;

	public Register() {

		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);

		pnlForm = new JPanel();
		pnlForm.setBorder(new LineBorder(new Color(255, 165, 0), 1, true));
		pnlForm.setBounds(60, 135, 430, 411);
		getContentPane().add(pnlForm);
		pnlForm.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(52dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(10px;pref)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(7dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(2dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(2dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		pnlHeader = new JPanel();
		pnlHeader.setBackground(new Color(0, 0, 139));
		pnlHeader.setBounds(10, 11, 522, 71);
		getContentPane().add(pnlHeader);
		pnlHeader.setLayout(null);
		
		label = new JLabel("PMDA BANK");
		label.setBounds(124, 11, 259, 48);
		pnlHeader.add(label);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		lblTitle = new JLabel("Registration");
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitle.setBounds(213, 93, 102, 31);
		getContentPane().add(lblTitle);
		
		lblName = new JLabel("Name:");
		lblName.setForeground(Color.BLUE);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlForm.add(lblName, "4, 4");

		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlForm.add(txtName, "10, 4, fill, default");
		txtName.setColumns(10);
		
		lblSurname = new JLabel("Surname:");
		lblSurname.setForeground(Color.BLUE);
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlForm.add(lblSurname, "4, 8");
		
		txtSurname = new JTextField();
		txtSurname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlForm.add(txtSurname, "10, 8, fill, default");
		txtSurname.setColumns(10);
		
		lblAdressOne = new JLabel("Address:");
		lblAdressOne.setForeground(Color.BLUE);
		lblAdressOne.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlForm.add(lblAdressOne, "4, 12");
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlForm.add(textField, "10, 12, fill, default");
		textField.setColumns(10);
		
		txtTown = new JTextField();
		txtTown.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlForm.add(txtTown, "10, 16, fill, default");
		txtTown.setColumns(10);
		
		txtCounty = new JTextField();
		txtCounty.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlForm.add(txtCounty, "10, 20, fill, default");
		txtCounty.setColumns(10);

	}

	@Override
	public void run() {

	}
}
