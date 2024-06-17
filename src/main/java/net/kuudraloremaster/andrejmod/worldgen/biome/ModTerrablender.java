package net.kuudraloremaster.andrejmod.worldgen.biome;

import net.kuudraloremaster.andrejmod.AndrejMod;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerrablender {
    public static void registerBiomes() {
        Regions.register(new ModOverworldRegion(new ResourceLocation(AndrejMod.MOD_ID, "overworld"), 5));
    }
}
