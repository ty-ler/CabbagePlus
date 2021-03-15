package cabbageplus;

import cabbageplus.client.gui.CabbageMenuBar;
import cabbageplus.client.gui.prefs.PluginSettingsPanel;
import orsc.OpenRSC;

import javax.swing.*;
import java.awt.*;

public class CabbagePlus {
	public final static int MIN_WIDTH = 512 + PluginSettingsPanel.WIDTH;
	public final static int MIN_HEIGHT = 385;

	public static JFrame jFrame;
	public static PluginSettingsPanel settingsPanel;

	public static void init() {
		jFrame = (JFrame) CabbageUtils.getReflector().getClassMember(OpenRSC.class.getName(), "jframe");

		if(jFrame != null) {
			CabbageMenuBar.init(jFrame);
			settingsPanel = new PluginSettingsPanel(jFrame);

			jFrame.setPreferredSize(new Dimension(MIN_WIDTH, MIN_HEIGHT));
			jFrame.setMinimumSize(new Dimension(MIN_WIDTH, MIN_HEIGHT));
			jFrame.pack();
		}
	}
}
