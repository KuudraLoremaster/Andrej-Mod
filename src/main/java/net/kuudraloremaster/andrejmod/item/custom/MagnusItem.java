package net.kuudraloremaster.andrejmod.item.custom;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;

public class MagnusItem extends Item {
    public MagnusItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Player player = pContext.getPlayer();
        for (int i =0; i<100; i++) {
            Entity bat = new Bat(EntityType.BAT, pContext.getLevel());
            bat.moveTo(player.getX(), player.getY(), player.getZ());
            pContext.getLevel().addFreshEntity(bat);
        }
        for (int i =0; i<50; i++) {
            Entity vex = new Vex(EntityType.VEX, pContext.getLevel());
            vex.moveTo(player.getX(), player.getY(), player.getZ());
            pContext.getLevel().addFreshEntity(vex);
            Entity phantom = new Phantom(EntityType.PHANTOM, pContext.getLevel());
            phantom.moveTo(player.getX(), player.getY(), player.getZ());
            pContext.getLevel().addFreshEntity(phantom);
        }
        return InteractionResult.SUCCESS;
    }
}
