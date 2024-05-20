package net.kuudraloremaster.andrejmod.item.custom;

import net.kuudraloremaster.andrejmod.AndrejMod;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;

import static net.kuudraloremaster.andrejmod.AndrejMod.weight;

public class DumbBellItem extends Item {
    public DumbBellItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Player player = pContext.getPlayer();
        if (weight <= 40) {
            weight = 5;
        }
        else {
            weight -= 40;
        }
        if (!player.getCommandSenderWorld().isClientSide) {
            player.sendSystemMessage(Component.literal("Your weight is " + weight));
        }
        return InteractionResult.SUCCESS;
    }
}
