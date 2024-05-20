package net.kuudraloremaster.andrejmod.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;

import java.util.Objects;

public class WindowsItem extends Item {
    public WindowsItem(Properties pProperties) {
        super(pProperties);
    }
    public static boolean activatedWindows = false;
    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Player player = pContext.getPlayer();
        if (!player.getCommandSenderWorld().isClientSide) {
            String username = player.getName().getString();
            if (username.equals("ZeldaLord1")) {
                player.sendSystemMessage(Component.literal("You can never activate windows, Zeldalord"));
            }
            else if (activatedWindows){
                player.sendSystemMessage(player.getName());;
            }
            else {
            player.sendSystemMessage(Component.literal("You have activated windows, GG!"));
            activatedWindows = true;
            }
        }
        return InteractionResult.SUCCESS;
    }
}
