package cabbageplus.plugins;

import cabbageplus.CabbageUtils;
import orsc.enumerations.MenuItemAction;
import orsc.graphics.gui.MenuItem;

import java.util.Arrays;
import java.util.List;

public class MenuPlugin {
	public static List<String> prioritizedLabels = Arrays.asList("Cage", "Bury All");
	public static List<String> prioritizedActors = Arrays.asList("Bones", "Feather");

	public static int getMenuItemPriority(MenuItem menuItem) {
		// Get fields from the menu item using cabbageplus.reflection since they are not public.
		String label = CabbageUtils.getObjectMemberString(menuItem, "label");
		String actor = CabbageUtils.getObjectMemberString(menuItem, "actor");
		actor = PluginHelper.removeColorFromString(actor);
		actor = PluginHelper.removeCombatLevelFromString(actor);
		MenuItemAction actionID = (MenuItemAction) CabbageUtils.getObjectMember(menuItem, "actionID");
		int priority = actionID.priority();

		if(
			MenuPlugin.prioritizedLabels.contains(label) ||
			(MenuPlugin.prioritizedActors.contains(actor) && label.equals("Take")) ||
			label.equals("Drop All") && actor.contains("Burnt") ||
			priority == MenuItemAction.NPC_COMMAND1.priority()
		) {
			return 0;
		}

		return priority;
	}
}
