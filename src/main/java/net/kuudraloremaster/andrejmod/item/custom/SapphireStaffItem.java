package net.kuudraloremaster.andrejmod.item.custom;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;

public class SapphireStaffItem extends Item {
    public SapphireStaffItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Entity lightning = new LightningBolt(EntityType.LIGHTNING_BOLT, pContext.getLevel());
        lightning.moveTo(pContext.getClickedPos().getCenter());
        pContext.getLevel().addFreshEntity(lightning);
        return InteractionResult.SUCCESS;
    }
}
