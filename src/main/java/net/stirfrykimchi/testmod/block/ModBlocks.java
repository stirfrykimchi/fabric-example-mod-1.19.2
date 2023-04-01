package net.stirfrykimchi.testmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.stirfrykimchi.testmod.TestMod;
import net.stirfrykimchi.testmod.item.ModItemGroup;

public class ModBlocks {
    //** Adds Blocks
    // Uses a function (see below) to create blocks.
    // After 'new', Block and OreBlock are used to specify which properties it'll take after
    public static final Block TANZANITE_BLOCK = registerBlock("tanzanite_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()), ModItemGroup.TANZANITE);
    // Material: The block it'll replicate/copy. A parent parameter that could lead to others (like Strength)
    public static final Block TANZANITE_ORE = registerBlock("tanzanite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
                    UniformIntProvider.create(2, 6)), ModItemGroup.TANZANITE);
    // Strength: Hardness (how long to break) and resistance (anti-blast damage). Stone has 1.5 and 6 respectively.
    public static final Block DEEPSLATE_TANZANITE_ORE = registerBlock("deepslate_tanzanite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
                    UniformIntProvider.create(4, 10)), ModItemGroup.TANZANITE);
    // requiresTool: Must be harvested with tool related to Material (stone uses pick).
    public static final Block NETHERRACK_TANZANITE_ORE = registerBlock("netherrack_tanzanite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
                    UniformIntProvider.create(4, 10)), ModItemGroup.TANZANITE);
    // UniformIntProvider: Exp drop (in orbs).
    public static final Block ENDSTONE_TANZANITE_ORE = registerBlock("endstone_tanzanite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
                    UniformIntProvider.create(6, 12)), ModItemGroup.TANZANITE);

    // Creates a way to add blocks (this is the function used above)
    private static Block registerBlock(String name, Block block, ItemGroup tab){
        // The name of the item then any parameters followed by the item group (block)
        registerBlockItem(name, block, tab);
        // The name of the item then any parameters followed by the item group (block as item)
        return Registry.register(Registry.BLOCK, new Identifier(TestMod.MOD_ID, name), block);
    }

    // Creates a way to register blocks as items, since by default it only exists as a block.
    private static Item registerBlockItem(String name, Block block, ItemGroup tab){
        // The name of the item then any parameters followed by the item group
        return Registry.register(Registry.ITEM, new Identifier(TestMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }

    // Registers the blocks into the game to be ready for initialization
    public static void registerModBlocks(){
        // Sends a message to console to show it ran
        TestMod.LOGGER.debug("Registering Mod Blocks for " + TestMod.MOD_ID);
    }
}
