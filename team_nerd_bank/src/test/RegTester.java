/*
 * 4 Mar 2015
* team_nerd_bank
* 23:39:13
*/
package test;

import gui.Register;

import javax.swing.SwingUtilities;


public class RegTester {

	public static void main(String[] args) {

		java.awt.EventQueue.invokeLater(() -> {

			Register frame = new Register();
			SwingUtilities.invokeLater(frame);
			
		});
	}

}
