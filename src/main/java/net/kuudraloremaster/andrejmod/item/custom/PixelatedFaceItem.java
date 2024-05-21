package net.kuudraloremaster.andrejmod.item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.camel.Camel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.Objects;

public class PixelatedFaceItem extends Item {
    public PixelatedFaceItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Player player = pContext.getPlayer();
        if (!player.getCommandSenderWorld().isClientSide) {
            player.sendSystemMessage(Component.literal("pixelated face is schizophrenic"));
        }
        BlockPos positionClicked = pContext.getClickedPos();
        Entity camel = new Camel(EntityType.CAMEL, pContext.getLevel());
        camel.moveTo(positionClicked.getX(), positionClicked.getY(), positionClicked.getZ());
        pContext.getLevel().addFreshEntity(camel);

        return InteractionResult.SUCCESS;
    }

}
