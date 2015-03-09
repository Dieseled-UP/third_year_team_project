/*
 * 6 Mar 2015
 * team_nerd_bank
 * 11:09:27
 */
package gui;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.Icon;

public class UserPinPass extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private JPanel pnlHeader;
	private JLabel lblLogo;
	private String path = "Assets/logo2.svg.png";
	private File file;
	private BufferedImage image;
	private JPanel pnlHeader_1;

	public UserPinPass() {
		getContentPane().setLayout(null);

		pnlHeader_1 = new JPanel();
		pnlHeader_1.setLayout(null);
		pnlHeader_1.setBackground(new Color(0, 0, 139));
		pnlHeader_1.setBounds(10, 11, 637, 69);
		getContentPane().add(pnlHeader_1);

		JLabel label = new JLabel("PMDA BANK");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Serif", Font.BOLD, 40));
		label.setBounds(124, 11, 259, 48);
		pnlHeader_1.add(label);

		file = new File(path);
		try {

			image = ImageIO.read(file);
		} catch (IOException e) {

			e.printStackTrace();
		}

		JLabel lblLogo = new JLabel(new ImageIcon(image));
		lblLogo.setBounds(10, -1, 70, 70);
		pnlHeader_1.add(lblLogo);

	}

	@Override
	public void run() {
		setSize(655, 400);
		setResizable(false);
		setTitle("Pin and password creation");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	}
}
