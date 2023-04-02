package net.stirfrykimchi.testmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TanzaniteLampBlock extends Block {
    // A boolean property: To allow the checking of a true/false block state
    // Creates a property to be used
    public static final BooleanProperty LIT = BooleanProperty.of("lit");

    // References Minecraft's source code for blocks for use
    public TanzaniteLampBlock(Settings settings) {
        super(settings);
    }

    @Override
    // Function that gives the block a right-click use: Turn on/off the lamp.
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(!world.isClient() && hand == Hand.MAIN_HAND){
            // cycle: Goes through each possible state of the property. Booleans have 2.
            // On right-click, switches property from true or false.
            world.setBlockState(pos, state.cycle(LIT));
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    // Initializes the property to make it actually used
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        // Adds the 'lit' property
        builder.add(LIT);
    }

    @Override
    // Function that gives the item a tooltip
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        if(Screen.hasShiftDown()){
            tooltip.add(Text.literal("Can be turned on and off by hand").formatted(Formatting.AQUA));
        } else {
            tooltip.add(Text.literal("[Hold Shift for more info]").formatted(Formatting.YELLOW));
        }
        super.appendTooltip(stack, world, tooltip, options);
    }
}
