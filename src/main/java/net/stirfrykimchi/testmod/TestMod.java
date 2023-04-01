package net.stirfrykimchi.testmod;

import net.fabricmc.api.ModInitializer;
import net.stirfrykimchi.testmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Very important comment hehe :)
public class TestMod implements ModInitializer {
	public static final String MOD_ID = "testmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// Cal
		ModItems.registerModItems();

	}
}
