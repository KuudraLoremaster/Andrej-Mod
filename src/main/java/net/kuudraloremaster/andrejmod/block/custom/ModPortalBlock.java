package net.kuudraloremaster.andrejmod.block.custom;

import net.kuudraloremaster.andrejmod.worldgen.dimension.ModDimensions;
import net.kuudraloremaster.andrejmod.worldgen.portal.ModTeleporter;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;

public class ModPortalBlock extends Block {
    public ModPortalBlock(Properties pProperties) {
        super(pProperties);
    }
    public static List<Entity> getEntitiesNearPlayer(Player player, double radius) {
        // Get the world (level) the player is in
        Level level = player.level();

        // Get the player's position
        double playerX = player.getX();
        double playerY = player.getY();
        double playerZ = player.getZ();

        // Create an axis-aligned bounding box (AABB) around the player
        AABB aabb = new AABB(
                playerX - radius, playerY - radius, playerZ - radius,
                playerX + radius, playerY + radius, playerZ + radius
        );

        // Get all entities within the AABB
        return level.getEntities(player, aabb, entity -> true);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pPlayer.canChangeDimensions()) {
            handleKaupenPortal(pPlayer, pPos);
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.CONSUME;
        }
    }

    private void handleKaupenPortal(Entity player, BlockPos pPos) {
        if (player.level() instanceof ServerLevel serverlevel) {
            MinecraftServer minecraftserver = serverlevel.getServer();
            Level level = player.level();
            ResourceKey<Level> resourcekey = player.level().dimension() == ModDimensions.INFINITEVOID_LEVEL_KEY ?
                    Level.OVERWORLD : ModDimensions.INFINITEVOID_LEVEL_KEY;
            ServerLevel portalDimension = minecraftserver.getLevel(resourcekey);
            if (portalDimension != null && !player.isPassenger()) {
                if(resourcekey == ModDimensions.INFINITEVOID_LEVEL_KEY) {
                    List<Entity> p = getEntitiesNearPlayer((Player) player, 16);
                    for (Entity entity : p) {
                        player.sendSystemMessage(Component.literal("Found entity: " + entity.getName().getString()));
                        entity.changeDimension(portalDimension, new ModTeleporter(pPos, true));
                    }
                    player.changeDimension(portalDimension, new ModTeleporter(pPos, true));
                } else {
                    List<Entity> p = getEntitiesNearPlayer((Player) player, 16);
                    for (Entity entity : p) {
                        player.sendSystemMessage(Component.literal("Found entity: " + entity.getName().getString()));
                        entity.changeDimension(portalDimension, new ModTeleporter(pPos, false));
                    }
                    player.changeDimension(portalDimension, new ModTeleporter(pPos, false));
                }
            }
        }
    }
}
