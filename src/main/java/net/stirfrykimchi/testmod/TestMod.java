package net.stirfrykimchi.testmod;

import net.fabricmc.api.ModInitializer;
import net.stirfrykimchi.testmod.block.ModBlocks;
import net.stirfrykimchi.testmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// The actual meat. Only misc. things should be outside of methods in this file.
public class TestMod implements ModInitializer {
	// Used to reference the Mod ID in a simpler manner
	public static final String MOD_ID = "testmod";
	// Used to shorten Debug lines
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// Calls the methods that created the items and blocks
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

	}
}
