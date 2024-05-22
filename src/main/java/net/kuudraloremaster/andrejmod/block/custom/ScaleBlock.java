package net.kuudraloremaster.andrejmod.block.custom;

import net.kuudraloremaster.andrejmod.AndrejMod;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class ScaleBlock extends Block {
    public ScaleBlock(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        Player player = (Player) pEntity;
        if (!pLevel.isClientSide()){
            player.sendSystemMessage(Component.literal("Your Weight is:" + AndrejMod.weight));
        }
    }
}
