//9 Mar 2015
//team_nerd_bank
//17:54:36
package test;

import javax.swing.SwingUtilities;


import gui.UserPinPass;

public class UserPinPassTest {
	
	public static void main(String[] args) {

		java.awt.EventQueue.invokeLater(() -> {

			UserPinPass frame = new UserPinPass();
			SwingUtilities.invokeLater(frame);
			
		});
	}


}
