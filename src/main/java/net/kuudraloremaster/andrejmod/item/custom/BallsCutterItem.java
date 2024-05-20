package net.kuudraloremaster.andrejmod.item.custom;

import net.kuudraloremaster.andrejmod.item.ModItems;
import net.kuudraloremaster.andrejmod.sound.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;

public class BallsCutterItem extends Item {
    public BallsCutterItem(Properties pProperties) {
        super(pProperties);
    }
    boolean hasBalls = true;
    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Player player = pContext.getPlayer();
        if (!player.getCommandSenderWorld().isClientSide) {
            if (hasBalls) {
                ItemStack stack = new ItemStack(ModItems.KFC.get(), 1);
                pContext.getLevel().playSeededSound(null,player.getX(), player.getY(), player.getZ(),
                        SoundEvents.SHEEP_SHEAR, SoundSource.PLAYERS, 1f, 1f,0);
                player.getInventory().add(stack);
                hasBalls = false;
            } else {
                player.sendSystemMessage(Component.literal("You have no balls!"));
            }
        }
        return InteractionResult.SUCCESS;
    }
}
