package net.kuudraloremaster.andrejmod.entity.custom;

import net.kuudraloremaster.andrejmod.block.ModBlocks;
import net.kuudraloremaster.andrejmod.block.custom.DiceBlock;
import net.kuudraloremaster.andrejmod.entity.ModEntities;
import net.kuudraloremaster.andrejmod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractGlassBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class DiceProjectileEntity extends ThrowableItemProjectile {
    public DiceProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public DiceProjectileEntity(Level pLevel) {
        super(ModEntities.DICE_PROJECTILE.get(), pLevel);
    }

    public DiceProjectileEntity(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.DICE_PROJECTILE.get(), livingEntity, pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.DICE.get();
    }



    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        if (!this.level().isClientSide()) {
            this.level().broadcastEntityEvent(this, ((byte) 3));
            this.level().setBlock(blockPosition(), ((DiceBlock) ModBlocks.DICE_BLOCK.get()).getRandomBlockState(), 3);
        }
        super.onHitBlock(pResult);
    }

}
