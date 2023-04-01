package net.stirfrykimchi.testmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.stirfrykimchi.testmod.TestMod;
import net.stirfrykimchi.testmod.item.custom.EightBallItem;

public class ModItems {
    //** Adds Items
    // Uses a function (see below) to create items.
    public static final Item RAW_TANZANITE = registerItem("raw_tanzanite",
            new Item(new FabricItemSettings().group(ModItemGroup.TANZANITE)));
    // Ignore the difference of the items (grey vs purple). It means nothing.
    // Usually, it'll be grey. It's only purple because it shares a name.
    public static final Item TANZANITE = registerItem("tanzanite",
            new Item(new FabricItemSettings().group(ModItemGroup.TANZANITE)));
    // When registering an item, ensure the 'new X' is the correct class (EightBallItem class instead of Item)
    // maxCount: The stacks max amount. Set to 1 to disable stacking.
    public static final Item EIGHT_BALL = registerItem("eight_ball",
            new EightBallItem(new FabricItemSettings().group(ModItemGroup.TANZANITE).maxCount(1)));

    // Creates a way to add items (this is the function used above)
    private static Item registerItem(String name, Item item){
        // The name of the item then any parameters
        return Registry.register(Registry.ITEM, new Identifier(TestMod.MOD_ID, name), item);
    }

    // Registers the items into the game to be ready for initialization
    public static void registerModItems(){
        // Sends a message to console to show it ran
        TestMod.LOGGER.debug("Registering Mod Items for " + TestMod.MOD_ID);
    }




}
