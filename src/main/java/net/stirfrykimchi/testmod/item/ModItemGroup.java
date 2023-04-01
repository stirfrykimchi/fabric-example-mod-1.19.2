package net.stirfrykimchi.testmod.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.stirfrykimchi.testmod.TestMod;

public class ModItemGroup {
    // Most things in the game are technically an item, so this file exists (only here and once).
    // Creates the tab in the creative menu and categorizes items.
    public static final ItemGroup TANZANITE = FabricItemGroupBuilder.build(
            new Identifier(TestMod.MOD_ID, "tanzanite"), () -> new ItemStack(ModItems.TANZANITE));
}
