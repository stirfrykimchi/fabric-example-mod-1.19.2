package net.stirfrykimchi.testmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.stirfrykimchi.testmod.TestMod;

public class ModItems {
    // Adds Items
    // e
    // e
    public static final Item RAW_TANZANITE = registerItem("raw_tanzanite",
            new Item(new FabricItemSettings().group(ModItemGroup.TANZANITE)));
    // e
    public static final Item TANZANITE = registerItem("tanzanite",
            new Item(new FabricItemSettings().group(ModItemGroup.TANZANITE)));

    // e
    private static Item registerItem(String name, Item item){
        // e
        return Registry.register(Registry.ITEM, new Identifier(TestMod.MOD_ID, name), item);
    }

    // e
    public static void registerModItems(){
        // D
        TestMod.LOGGER.debug("Registering Mod Items for " + TestMod.MOD_ID);
    }




}
