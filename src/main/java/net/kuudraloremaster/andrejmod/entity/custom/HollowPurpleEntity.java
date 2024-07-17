package net.kuudraloremaster.andrejmod.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

public class HollowPurpleEntity extends Entity {
    public HollowPurpleEntity(EntityType<? extends HollowPurpleEntity> type, Level world) {
        super(type, world);
        this.noPhysics = true; // Prevent the entity from being affected by physics
    }
    int lifespan = 100;

    @Override
    public void tick() {
        super.tick();
        this.move();
        boolean flag = false;
        AABB aabb = this.getBoundingBox().inflate(0.2D);
        for (BlockPos blockPos : BlockPos.betweenClosed(Mth.floor(aabb.minX),
                Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            BlockState blockstate = this.level().getBlockState(blockPos);
            Block block = blockstate.getBlock();
            if (!(block instanceof BarrierBlock)) {
                flag = this.level().destroyBlock(blockPos, false, this) || flag;
            }
        }

        // Check for collisions with entities
        for (Entity entity : this.level().getEntities(this, this.getBoundingBox())) {
            if (entity != this) {
                onHitEntity(entity);
            }
        }

        // Remove the entity after a certain amount of ticks
        if (lifespan-- <= 0) {
            this.discard();
            return;
        }
    }
    private void move() {
        Vec3 motion = this.getDeltaMovement();
        this.setPos(this.getX() + motion.x, this.getY() + motion.y, this.getZ() + motion.z);
    }
    public void setMotion(Vec3 motion) {
        this.setDeltaMovement(motion);
    }

    @Override
    protected void defineSynchedData() {
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {
    }


    protected void onHitEntity(Entity entity) {
        entity.hurt(entity.damageSources().generic(), 20.0F);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

}
