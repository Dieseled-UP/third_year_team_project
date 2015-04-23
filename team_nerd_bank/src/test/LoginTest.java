package test;

import gui.Login;

import javax.swing.SwingUtilities;


public class LoginTest {

	public static void main(String[] args) {

		java.awt.EventQueue.invokeLater(() -> {

			Login frame = new Login();
			SwingUtilities.invokeLater(frame);
			
		});
	}

}