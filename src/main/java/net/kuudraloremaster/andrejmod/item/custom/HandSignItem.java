package net.kuudraloremaster.andrejmod.item.custom;

import net.kuudraloremaster.andrejmod.sound.ModSounds;
import net.kuudraloremaster.andrejmod.worldgen.dimension.ModDimensions;
import net.kuudraloremaster.andrejmod.worldgen.portal.ModTeleporter;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.TickTask;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;

import static net.kuudraloremaster.andrejmod.block.custom.ModPortalBlock.getEntitiesNearPlayer;

public class HandSignItem extends Item {
    public HandSignItem(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Player pPlayer = pContext.getPlayer();
        BlockPos pPos = pPlayer.getOnPos();
        if (pPlayer.canChangeDimensions()) {
            handleInfiniteVoid(pPlayer, pPos);
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.CONSUME;
        }
    }

    private void handleInfiniteVoid(Entity player, BlockPos pPos) {
        if (player.level() instanceof ServerLevel serverlevel) {
            MinecraftServer minecraftserver = serverlevel.getServer();

            Level level = player.level();
            ResourceKey<Level> resourcekey = player.level().dimension() == ModDimensions.INFINITEVOID_LEVEL_KEY ?
                    Level.OVERWORLD : ModDimensions.INFINITEVOID_LEVEL_KEY;
            ServerLevel portalDimension = minecraftserver.getLevel(resourcekey);
            if (portalDimension != null && !player.isPassenger()) {
                if(resourcekey == ModDimensions.INFINITEVOID_LEVEL_KEY) {
                    int soundDurationTicks = 70;
                    List<Entity> p = getEntitiesNearPlayer((Player) player, 16);
                    minecraftserver.execute(() -> {
                        try {
                            level.playSeededSound(null, player.getX(), player.getY(), player.getZ(),
                                    ModSounds.INFINITE_VOID.get(), SoundSource.BLOCKS, 1f, 1f,0);
                            Thread.sleep(soundDurationTicks * 50L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        minecraftserver.execute(
                                () -> {

                                    for (Entity entity : p) {
                                        entity.changeDimension(portalDimension, new ModTeleporter(pPos, false));
                                    }
                                    player.changeDimension(portalDimension, new ModTeleporter(pPos, false));
                                }
                        );
                    });

                } else {
                    List<Entity> p = getEntitiesNearPlayer((Player) player, 16);
                    for (Entity entity : p) {
                        entity.changeDimension(portalDimension, new ModTeleporter(pPos, true));
                    }
                    player.changeDimension(portalDimension, new ModTeleporter(pPos, true));

                }
            }
        }
    }
}
