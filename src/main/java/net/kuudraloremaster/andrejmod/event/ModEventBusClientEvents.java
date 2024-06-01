package net.kuudraloremaster.andrejmod.event;


import net.kuudraloremaster.andrejmod.AndrejMod;
import net.kuudraloremaster.andrejmod.entity.client.GoonerModel;
import net.kuudraloremaster.andrejmod.entity.client.ModModelLayers;
import net.kuudraloremaster.andrejmod.entity.client.PexModel;
import net.kuudraloremaster.andrejmod.entity.client.RhinoModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = AndrejMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.RHINO_LAYER, RhinoModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.GOONER_LAYER, GoonerModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.PEX_LAYER, PexModel::createBodyLayer);
    }

}
