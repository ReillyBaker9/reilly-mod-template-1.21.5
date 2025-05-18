package net.reillyb.reillymod;

import net.fabricmc.api.ModInitializer;

import net.reillyb.reillymod.block.ModBlocks;
import net.reillyb.reillymod.item.ModItemGroups;
import net.reillyb.reillymod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReillyMod implements ModInitializer {
	public static final String MOD_ID = "reillymod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
//		ReillyModDataGenerator.on
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		LOGGER.info("Hello Fabric world!");

	}
}