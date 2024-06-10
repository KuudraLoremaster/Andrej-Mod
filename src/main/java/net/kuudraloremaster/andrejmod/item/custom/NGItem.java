package net.kuudraloremaster.andrejmod.item.custom;

import net.kuudraloremaster.andrejmod.entity.ModEntities;
import net.kuudraloremaster.andrejmod.entity.custom.BuffMinionEntity;
import net.kuudraloremaster.andrejmod.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
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
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static net.minecraft.world.InteractionResult.CONSUME;
import static net.minecraft.world.InteractionResult.SUCCESS;

public class NGItem extends Item {
    public NGItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Player player = pContext.getPlayer();
        Level world = pContext.getLevel();
        pContext.getLevel().playSeededSound(null,player.getX(), player.getY(), player.getZ(),
                ModSounds.NEVER_GOON.get(), SoundSource.BLOCKS, 1f, 1f,0);



        for (int i = 0; i < 4; i++) {
            Entity buff_minion = new BuffMinionEntity(ModEntities.BUFF_MINION.get(), world);
            double spawnX = player.getX() + Math.random() * 5 - 2.5;
            double spawnY = player.getY();
            double spawnZ = player.getZ() + Math.random() * 5 - 2.5;
            buff_minion.moveTo(spawnX, spawnY, spawnZ);
            world.addFreshEntity(buff_minion);
        }
        Inventory inventory = player.getInventory();
        ItemStack heldItem = inventory.getItem(inventory.selected);
        heldItem.shrink(1);

        return SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.literal("Sounds an alarm whenever someones goons"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
