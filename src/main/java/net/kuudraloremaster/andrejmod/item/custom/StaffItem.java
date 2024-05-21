package net.kuudraloremaster.andrejmod.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class StaffItem extends Item {
    public StaffItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        BlockPos positionClicked = pContext.getClickedPos();
        Level world = pContext.getLevel();
        Entity entity = new LightningBolt(EntityType.LIGHTNING_BOLT, world);
        entity.moveTo(positionClicked.getX(), positionClicked.getY(), positionClicked.getZ());
        world.addFreshEntity(entity);
        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));
        if (!pContext.getPlayer().getCommandSenderWorld().isClientSide) {
            pContext.getPlayer().sendSystemMessage(Component.literal("PREPARE YOUR COCK!"));
        }
        return InteractionResult.SUCCESS;
    }
}
