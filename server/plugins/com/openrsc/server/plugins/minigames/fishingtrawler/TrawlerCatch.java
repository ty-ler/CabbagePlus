package com.openrsc.server.plugins.minigames.fishingtrawler;

import static com.openrsc.server.plugins.Functions.addItem;
import static com.openrsc.server.plugins.Functions.message;
import static com.openrsc.server.plugins.Functions.showBubble;

import com.openrsc.server.external.EntityHandler;
import com.openrsc.server.model.Skills;
import com.openrsc.server.model.container.Item;
import com.openrsc.server.model.entity.GameObject;
import com.openrsc.server.model.entity.player.Player;
import com.openrsc.server.plugins.listeners.action.ObjectActionListener;
import com.openrsc.server.plugins.listeners.executive.ObjectActionExecutiveListener;
import com.openrsc.server.util.rsc.DataConversions;

public class TrawlerCatch implements ObjectActionListener, ObjectActionExecutiveListener {

	public static final int TRAWLER_CATCH = 1106;
	public static final int[] JUNK_ITEMS = new int[] {
		1155, // Old boot
		1157, // Damaged armour
		1158, // Damaged armour
		1159, // Rusty sword
		1165, // broken arrow
		1166, // buttons
		1167, // broken staff
		1168, // vase
		1169, // ceramic remains
		1170 // Broken glass
	};

	@Override
	public boolean blockObjectAction(GameObject obj, String command, Player p) {
		return obj.getID() == TRAWLER_CATCH;
	}

	@Override
	public void onObjectAction(GameObject obj, String command, Player p) {
		if (obj.getID() == TRAWLER_CATCH) {
			message(p, 1900, "you search the smelly net");
			showBubble(p, new Item(376));
			if (p.getCache().hasKey("fishing_trawler_reward")) {
				p.message("you find...");
				int fishCaught = p.getCache().getInt("fishing_trawler_reward");
				for (int fishGiven = 0; fishGiven < fishCaught; fishGiven++) {
					if (catchFish(81, p.getSkills().getLevel(Skills.FISHING))) {
						message(p, 1200, "..some manta ray");
						addItem(p, 1190, 1); // RAW MANTA RAY
						p.incExp(Skills.FISHING, 460, false);
					} else if (catchFish(79, p.getSkills().getLevel(Skills.FISHING))) {
						message(p, 1200, "..some sea turtle");
						addItem(p, 1192, 1); // RAW SEA TURTLE
						p.incExp(Skills.FISHING, 420, false);
					} else if (catchFish(76, p.getSkills().getLevel(Skills.FISHING))) {
						message(p, 1200, "..some shark");
						addItem(p, 545, 1); // RAW SHARK
						p.incExp(Skills.FISHING, 440, false);
					} else if (catchFish(50, p.getSkills().getLevel(Skills.FISHING))) {
						message(p, 1200, "..some swordfish");
						addItem(p, 369, 1); // RAW SWORDFISH
						p.incExp(Skills.FISHING, 400, false);
					} else if (catchFish(40, p.getSkills().getLevel(Skills.FISHING))) {
						message(p, 1200, "..some lobster...");
						addItem(p, 372, 1); // RAW LOBSTER
						p.incExp(Skills.FISHING, 360, false);
					} else if (catchFish(30, p.getSkills().getLevel(Skills.FISHING))) {
						message(p, 1200, "..some tuna...");
						addItem(p, 366, 1); // RAW TUNA
						p.incExp(Skills.FISHING, 320, false);
					} else if (catchFish(15, p.getSkills().getLevel(Skills.FISHING))) {
						message(p, 1200, "..some anchovies...");
						addItem(p, 351, 1); // RAW ANCHOVIES
						p.incExp(Skills.FISHING, 160, false);
					} else if (catchFish(5, p.getSkills().getLevel(Skills.FISHING))) {
						message(p, 1200, "..some sardine...");
						addItem(p, 354, 1); // RAW SARDINE
						p.incExp(Skills.FISHING, 80, false);
					} else if (catchFish(1, p.getSkills().getLevel(Skills.FISHING))) {
						message(p, 1200, "..some shrimp...");
						addItem(p, 349, 1); // RAW SHRIMP
						p.incExp(Skills.FISHING, 40, false);
					} else {
						int randomJunkItem = JUNK_ITEMS[DataConversions.random(0, JUNK_ITEMS.length - 1)];
						message(p, 1200, "..some " + EntityHandler.getItemDef(randomJunkItem).getName().toLowerCase());
						addItem(p, randomJunkItem, 1);
					}
				}
				p.getCache().remove("fishing_trawler_reward");
				p.message("that's the lot");
			} else {
				p.message("the smelly net is empty");
			}
		}
	}

	public boolean catchFish(int levelReq, int level) {
		int levelDiff = level - levelReq;
		if (levelDiff <= 0) {
			return false;
		}
		return DataConversions.percentChance(offsetToPercent(levelDiff));
	}

	private static int offsetToPercent(int levelDiff) {
		return levelDiff > 40 ? 60 : 20 + levelDiff;
	}

}
