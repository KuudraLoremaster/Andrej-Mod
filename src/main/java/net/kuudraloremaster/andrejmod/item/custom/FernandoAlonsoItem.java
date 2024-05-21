package net.kuudraloremaster.andrejmod.item.custom;

import net.kuudraloremaster.andrejmod.sound.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;

public class FernandoAlonsoItem extends Item {
    public FernandoAlonsoItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Player player = pContext.getPlayer();
        if (!player.getCommandSenderWorld().isClientSide) {
            player.sendSystemMessage(Component.literal("OOOOH FERNANDO ALONSO"));
        }
        pContext.getLevel().playSeededSound(null,player.getX(), player.getY(), player.getZ(),
                ModSounds.FERNANDO_ALONSO.get(), SoundSource.BLOCKS, 1f, 1f,0);
        return InteractionResult.SUCCESS;
    }
}
