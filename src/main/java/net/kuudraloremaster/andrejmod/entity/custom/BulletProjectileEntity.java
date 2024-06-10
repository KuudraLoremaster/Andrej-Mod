package net.kuudraloremaster.andrejmod.entity.custom;

import net.kuudraloremaster.andrejmod.block.ModBlocks;
import net.kuudraloremaster.andrejmod.entity.ModEntities;
import net.kuudraloremaster.andrejmod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractGlassBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class BulletProjectileEntity extends ThrowableItemProjectile {
    public BulletProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.BULLET.get();
    }

    public BulletProjectileEntity(Level pLevel) {
        super(ModEntities.BULLET.get(), pLevel);
    }

    public BulletProjectileEntity(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.BULLET.get(), livingEntity, pLevel);
    }


    @Override
    public void tick() {
        super.tick();
        boolean flag = false;
        AABB aabb = this.getBoundingBox().inflate(0.2D);
        for (BlockPos blockPos : BlockPos.betweenClosed(Mth.floor(aabb.minX),
                Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            BlockState blockstate = this.level().getBlockState(blockPos);
            Block block = blockstate.getBlock();
            if (block instanceof AbstractGlassBlock) {
                flag = this.level().destroyBlock(blockPos, true, this) || flag;
            }
            if (block instanceof IronBarsBlock) {
                flag = this.level().destroyBlock(blockPos, true, this) || flag;
            }
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        Entity entity = pResult.getEntity();
        Level world = entity.level();
        entity.hurt(entity.damageSources().generic(), 10.0F);
    }
}
