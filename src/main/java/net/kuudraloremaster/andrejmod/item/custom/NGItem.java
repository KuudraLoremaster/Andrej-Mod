package net.kuudraloremaster.andrejmod.item.custom;

import net.kuudraloremaster.andrejmod.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.village.VillageSiege;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class NGItem extends Item {
    public NGItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Player player = pContext.getPlayer();
        boolean isGooning = true;
        Level world = pContext.getLevel();
        pContext.getLevel().playSeededSound(null,player.getX(), player.getY(), player.getZ(),
                ModSounds.NEVER_GOON.get(), SoundSource.BLOCKS, 1f, 1f,0);



        for (int i = 0; i < 10; i++) {
            Entity vindicator = new Vindicator(EntityType.VINDICATOR, world);
            double spawnX = player.getX() + Math.random() * 5 - 2.5;
            double spawnY = player.getY();
            double spawnZ = player.getZ() + Math.random() * 5 - 2.5;
            vindicator.moveTo(spawnX, spawnY, spawnZ);
            world.addFreshEntity(vindicator);
        }
        for (int i = 0; i < 4; i++) {
            Entity ravager = new Ravager(EntityType.RAVAGER, world);
            double spawnX = player.getX() + Math.random() * 5 - 2.5;
            double spawnY = player.getY();
            double spawnZ = player.getZ() + Math.random() * 5 - 2.5;
            ravager.moveTo(spawnX, spawnY, spawnZ);
            world.addFreshEntity(ravager);
        }
        for (int i = 0; i < 10; i++) {
            Entity pillager = new Pillager(EntityType.PILLAGER, world);
            double spawnX = player.getX() + Math.random() * 5 - 2.5;
            double spawnY = player.getY();
            double spawnZ = player.getZ() + Math.random() * 5 - 2.5;
            pillager.moveTo(spawnX, spawnY, spawnZ);
            world.addFreshEntity(pillager);
        }

        return InteractionResult.SUCCESS;
    }
}
