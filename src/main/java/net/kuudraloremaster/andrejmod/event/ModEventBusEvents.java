package net.kuudraloremaster.andrejmod.event;


import net.kuudraloremaster.andrejmod.AndrejMod;
import net.kuudraloremaster.andrejmod.entity.ModEntities;
import net.kuudraloremaster.andrejmod.entity.custom.BuffMinionEntity;
import net.kuudraloremaster.andrejmod.entity.custom.GoonerEntity;
import net.kuudraloremaster.andrejmod.entity.custom.RaEntity;
import net.kuudraloremaster.andrejmod.entity.custom.RhinoEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AndrejMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.RHINO.get(), RhinoEntity.createAttributes().build());
        event.put(ModEntities.GOONER.get(), GoonerEntity.createAttributes().build());
        event.put(ModEntities.PEX.get(), GoonerEntity.createAttributes().build());
        event.put(ModEntities.BUFF_MINION.get(), BuffMinionEntity.createAttributes().build());
        event.put(ModEntities.RA.get(), RaEntity.createAttributes().build());
    }


}
