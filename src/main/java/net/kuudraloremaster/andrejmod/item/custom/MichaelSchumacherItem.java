package net.kuudraloremaster.andrejmod.item.custom;

import net.kuudraloremaster.andrejmod.sound.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class MichaelSchumacherItem extends Item {
    public MichaelSchumacherItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Player player = pContext.getPlayer();
        Level world = pContext.getLevel();
        world.playSeededSound(null,player.getX(), player.getY(), player.getZ(),
                ModSounds.MICHAEL_SCHUMACHER.get(), SoundSource.BLOCKS, 1f, 1f,0);
        if (!player.getCommandSenderWorld().isClientSide) {
            player.sendSystemMessage(Component.literal("MICHAEL SCHUMACHER BAM BAM BAM BAM"));
        }
        return InteractionResult.SUCCESS;
    }
}
