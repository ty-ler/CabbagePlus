package cabbageplus.client.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CabbageMenuBar {

	public static JMenuBar menuBar = null;
	public static CabbageMenuBarActionListener actionListener = new CabbageMenuBarActionListener();
	public static JMenu fileMenu = null;
	public static JMenuItem prefsMenuItem = null;

	public static void init(JFrame jFrame) {
		if(System.getProperty("os.name").toLowerCase().contains("mac")) {
			// Move menu bar to the top on Mac OS
			System.setProperty("apple.laf.useScreenMenuBar", "true");
		}

		menuBar = new JMenuBar ();

		fileMenu = new JMenu ("File");
		prefsMenuItem = new JMenuItem("Preferences");
		prefsMenuItem.addActionListener(actionListener);

		fileMenu.add(prefsMenuItem);
		menuBar.add(fileMenu);
		jFrame.setJMenuBar(menuBar);
	}
}

class CabbageMenuBarActionListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if(source == CabbageMenuBar.prefsMenuItem) {
			System.out.println("Opening preferences frame...");
		}
	}
}
