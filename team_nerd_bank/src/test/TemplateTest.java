package test;

import gui.MainFrame;

import javax.swing.SwingUtilities;


public class TemplateTest {

	public static void main(String[] args) {

		java.awt.EventQueue.invokeLater(() -> {

			MainFrame frame = new MainFrame();
			SwingUtilities.invokeLater(frame);
			
		});
	}

}
