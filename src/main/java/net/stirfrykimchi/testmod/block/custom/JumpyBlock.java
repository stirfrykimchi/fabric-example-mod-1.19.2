package net.stirfrykimchi.testmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
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

// Middle-click 'Block' after extends to see the source code for blocks. Works for items too.
// After "tabbing" 'Block', hover over method line and construct super.
public class JumpyBlock extends Block {
    public JumpyBlock(Settings settings) {
        super(settings);
    }
    // When typing in a method to override, just put the name of it and "tab" it (onStepp [tab])
    @Override
    // Function that gives the block a step-on use: living entities that step on the block get jump boost
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        // Checks if the entity is alive (basically, a mob)
        if(entity instanceof LivingEntity livingEntity){
            // Gives whatever stood on the block jump boost 3 for a second. Effect level = amp + 1
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 20, 2));
        }
        // For all intents and purposes, it's like a return line
        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    // Function that gives the block a right-click use: Tells the player a message
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player,
                              Hand hand, BlockHitResult hit) {
        // By default, this function would occur 4 times (twice on server and client, one per hand)
        if(!world.isClient() && hand == Hand.MAIN_HAND){
            // Tells the player a message through chat
            player.sendMessage(Text.literal("You right-clicked this block!"));
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    // append: Fancy word for 'add'
    // Function that gives the item a tooltip
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        if(Screen.hasShiftDown()){
            tooltip.add(Text.literal("Gives Jump Boost 3 if stepped on").formatted(Formatting.AQUA));
        } else {
            tooltip.add(Text.literal("[Hold Shift for more info]").formatted(Formatting.YELLOW));
        }
        super.appendTooltip(stack, world, tooltip, options);
    }
}
