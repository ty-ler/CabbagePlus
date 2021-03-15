package cabbageplus.plugins;

import cabbageplus.reflection.Reflector;

public class PluginHelper {
	public static String removeColorFromString(String str) {
		return str.replaceAll("@.*?@", "");
	}

	public static String removeCombatLevelFromString(String str) {
		return str.replaceAll("\\(level-.*?\\)", "");
	}
}

