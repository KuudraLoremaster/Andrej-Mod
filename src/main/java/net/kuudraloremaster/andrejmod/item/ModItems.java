package net.kuudraloremaster.andrejmod.item;

import net.kuudraloremaster.andrejmod.AndrejMod;
import net.kuudraloremaster.andrejmod.item.custom.MetalDetectorItem;
import net.kuudraloremaster.andrejmod.item.custom.PixelatedFaceItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AndrejMod.MOD_ID);
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PIXEL = ITEMS.register("pixel",
            ()-> new PixelatedFaceItem(new Item.Properties()));
    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            ()-> new MetalDetectorItem(new Item.Properties().durability(100)));
    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
    }

}
