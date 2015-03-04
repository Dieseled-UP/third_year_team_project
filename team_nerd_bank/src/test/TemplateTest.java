package test;

import gui.MainFrame;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;


public class TemplateTest {

	public static void main(String[] args) {
		
		java.awt.EventQueue.invokeLater(() -> {

			MainFrame frame = new MainFrame();
			SwingUtilities.invokeLater(frame);
			
		});
	}

}