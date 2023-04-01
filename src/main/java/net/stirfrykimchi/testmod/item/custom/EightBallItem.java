package net.stirfrykimchi.testmod.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

// extends Item: Opens access Minecraft's source code
public class EightBallItem extends Item {
    // References Minecraft's source code for items to use it
    public EightBallItem(Settings settings) {
        // Superclass: The parent class (source code)
        super(settings);
    }
    // Indicates that this class method is over-writing its base class method (custom modification to base item code)
    @Override
    // Function that gives the item a right-click use: tells the player a random number
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        // Make it happen server-side. By default, happens twice. Main hand makes it happen once.
        if(!world.isClient() && hand == Hand.MAIN_HAND){
            // Outputs a random number to the play
            outputRandomNumber(user);
            // Adds a Cooldown to the item itself. 20 ticks = 1 second.
            user.getItemCooldownManager().set(this, 20);
        }
        // e
        return super.use(world, user, hand);
    }

    // Tells the player in chat the randomly generated number
    private void outputRandomNumber(PlayerEntity player){
        player.sendMessage(Text.literal("Your number is " + getRandomNumber()));
    }

    // Generates a random number
    private int getRandomNumber(){
        return Random.createLocal().nextInt(10);
    }

    @Override
    // appendToolTip: Extra information on an item when hovering over it and holding a keybind
    // Function that gives the item a tooltip
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        // Checks if player is holding down shift
        if(Screen.hasShiftDown()){
            // Displays a tip in yellow if holding shift while hovering
            tooltip.add(Text.literal("Generate a random number, just for you  :)").formatted(Formatting.AQUA));
        } else { // Displays a tip in white to hold shift when hovering
            tooltip.add(Text.literal("[Hold Shift for more info]").formatted(Formatting.YELLOW));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
