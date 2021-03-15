package cabbageplus.client.gui.prefs;

import javax.swing.*;
import java.awt.*;

public class PluginSettingsPanel extends JPanel {
	public final static int WIDTH = 100;

	public PluginSettingsPanel(JFrame jFrame) {
		super();

		this.setPreferredSize(new Dimension(WIDTH, 0));
		jFrame.add(this, BorderLayout.LINE_END);
	}
}
