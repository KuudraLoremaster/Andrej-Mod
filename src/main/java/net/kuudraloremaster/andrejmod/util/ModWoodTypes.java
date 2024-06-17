package net.kuudraloremaster.andrejmod.util;

import net.kuudraloremaster.andrejmod.AndrejMod;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {
    public static final WoodType PINE = WoodType.register(new WoodType(AndrejMod.MOD_ID + ":pine", BlockSetType.OAK));
}
