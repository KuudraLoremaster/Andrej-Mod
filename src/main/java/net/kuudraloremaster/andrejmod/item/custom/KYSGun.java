package net.kuudraloremaster.andrejmod.item.custom;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;

public class KYSGun extends Item {
    public KYSGun(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Player player = pContext.getPlayer();
        player.kill();
        return InteractionResult.SUCCESS;
    }
}
