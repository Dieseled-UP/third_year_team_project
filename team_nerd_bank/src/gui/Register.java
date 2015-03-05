package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.LineBorder;


import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;


import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Register extends JFrame implements Runnable {
	
	private static final long serialVersionUID = 1L;
	private JTextField txtName;
	private JPanel pnlHeader;
	private JPanel pnlForm;
	private JLabel lblTitle;
	private JLabel lblName;
	private JLabel label;
	private JLabel lblSurname;
	private JTextField txtSurname;
	private JLabel lblAdressOne;
	private JTextField textField;
	private JTextField txtTown;
	private JTextField txtCounty;
	private JLabel lblTelPone;
	private JTextField txtTelPhone;
	private JLabel lblMobile;
	private JTextField txtMobile;
	private JTextField txtFind;
	private JTextField txtAccNum;
	private JLabel lblSortCode;
	private JTextField txtSortCode;
	private JLabel lblConfirm;
	private JButton btnOK;
	private JButton btnCancel;
	private JLabel lblLogo;
	private String path = "Assets/logo2.svg.png";
	private File file;
	private BufferedImage image;

	public Register() {

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
		
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);

		pnlForm = new JPanel();
		pnlForm.setBorder(new LineBorder(new Color(255, 165, 0), 1, true));
		pnlForm.setBounds(60, 153, 430, 331);
		getContentPane().add(pnlForm);
		pnlForm.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(52dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(19dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(127dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(5px;pref)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(5dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(2dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(2dlu;default)"),
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
		pnlHeader.setBounds(10, 11, 522, 69);
		getContentPane().add(pnlHeader);
		pnlHeader.setLayout(null);
		
		label = new JLabel("PMDA BANK");
		label.setBounds(124, 11, 259, 48);
		pnlHeader.add(label);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Serif", Font.BOLD, 40));
		
		file = new File(path);
		try {

			image = ImageIO.read(file);
		} catch (IOException e) {

			e.printStackTrace();
		}

		lblLogo = new JLabel(new ImageIcon(image));
		lblLogo.setBounds(10, -1, 70, 70);
		pnlHeader.add(lblLogo);
		
		lblTitle = new JLabel("Registration");
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitle.setBounds(213, 86, 102, 26);
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
		
		lblTelPone = new JLabel("Tel. Phone:");
		lblTelPone.setForeground(Color.BLUE);
		lblTelPone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlForm.add(lblTelPone, "4, 24");
		
		txtTelPhone = new JTextField();
		txtTelPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlForm.add(txtTelPhone, "10, 24, fill, default");
		txtTelPhone.setColumns(10);
		
		lblMobile = new JLabel("Mobile:");
		lblMobile.setForeground(Color.BLUE);
		lblMobile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlForm.add(lblMobile, "4, 28");
		
		txtMobile = new JTextField();
		txtMobile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlForm.add(txtMobile, "10, 28, fill, default");
		txtMobile.setColumns(10);
		
		JLabel lblFind = new JLabel("Find by account number");
		lblFind.setForeground(Color.BLUE);
		lblFind.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFind.setBounds(60, 120, 159, 22);
		getContentPane().add(lblFind);
		
		txtFind = new JTextField();
		txtFind.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFind.setBounds(255, 120, 159, 24);
		getContentPane().add(txtFind);
		txtFind.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 165, 0)));
		panel.setBounds(60, 506, 430, 100);
		getContentPane().add(panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(12dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(129dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				RowSpec.decode("10dlu"),
				RowSpec.decode("max(15dlu;default)"),
				RowSpec.decode("12dlu"),
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblAccNum = new JLabel("Account Number:");
		lblAccNum.setForeground(Color.BLUE);
		lblAccNum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblAccNum, "4, 2");
		
		txtAccNum = new JTextField();
		txtAccNum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(txtAccNum, "8, 2, fill, default");
		txtAccNum.setColumns(10);
		
		lblSortCode = new JLabel("Sort Code:");
		lblSortCode.setForeground(Color.BLUE);
		lblSortCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblSortCode, "4, 4");
		
		txtSortCode = new JTextField();
		txtSortCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(txtSortCode, "8, 4, fill, default");
		txtSortCode.setColumns(10);
		
		lblConfirm = new JLabel("If these details are correct  press OK to continue else press CANCEL");
		lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirm.setForeground(Color.BLUE);
		lblConfirm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirm.setBounds(60, 617, 430, 18);
		getContentPane().add(lblConfirm);
		
		btnOK = new JButton("OK");
		btnOK.setBackground(new Color(201, 216, 239));
		btnOK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOK.setBounds(130, 660, 89, 26);
		getContentPane().add(btnOK);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.setBackground(new Color(201, 216, 239));
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancel.setBounds(340, 660, 89, 26);
		getContentPane().add(btnCancel);
		
		btnOK.addActionListener(arg0 -> {
			
			java.awt.EventQueue.invokeLater(() -> {

				Login frame = new Login();
				SwingUtilities.invokeLater(frame);
				
			});
		});
		
		btnCancel.addActionListener(arg0 -> {
			
			JOptionPane.showMessageDialog(null, "Please re-enter your account number if you still have problems\n please contact"
					+ " our helpdesk or call in to your nearest branch.\nSorry for any inconvince caused by this fault.");
		});

	}

	@Override
	public void run() {

		setSize(559, 740);
		setResizable(false);
		setTitle("Your Registration");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
