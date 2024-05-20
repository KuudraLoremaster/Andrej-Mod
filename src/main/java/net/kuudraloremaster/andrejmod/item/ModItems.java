package net.kuudraloremaster.andrejmod.item;

import net.kuudraloremaster.andrejmod.AndrejMod;
import net.kuudraloremaster.andrejmod.item.custom.*;
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
    public static final RegistryObject<Item> BOAR = ITEMS.register("boar",
            () -> new BoarItem(new Item.Properties()));
    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
            () -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));
    public static final RegistryObject<Item> KFC = ITEMS.register("kfc",
            () -> new Item(new Item.Properties().food(ModFoods.KFC)));
    public static final RegistryObject<Item> RAW_KFC = ITEMS.register("raw_kfc",
            () -> new Item(new Item.Properties().food(ModFoods.RAW_KFC)));
    public static final RegistryObject<Item> KFC_BUCKET = ITEMS.register("kfc_bucket",
            () -> new Item(new Item.Properties().food(ModFoods.KFC_BUCKET)));
    public static final RegistryObject<Item> KYS_GUN = ITEMS.register("kys_gun",
            () -> new KYSGun(new Item.Properties()));
    public static final RegistryObject<Item> PINE_CONE = ITEMS.register("pine_cone",
            () -> new FuelItem(new Item.Properties(), 400));
    public static final RegistryObject<Item> NEVER_GOON = ITEMS.register("never_goon",
            () -> new NGItem(new Item.Properties()));
    public static final RegistryObject<Item> MAGNUS = ITEMS.register("magnus",
            () -> new MagnusItem(new Item.Properties()));
    public static final RegistryObject<Item> WAFFLE = ITEMS.register("waffle",
            () -> new Item(new Item.Properties().food(ModFoods.WAFFLE)));
    public static final RegistryObject<Item> MAX_VERSTAPPEN = ITEMS.register("max_verstappen",
            () -> new MaxVerstappenItem(new Item.Properties()));
    public static final RegistryObject<Item> BALLS_CUTTER = ITEMS.register("balls_cutter",
            () -> new BallsCutterItem(new Item.Properties()));
    public static final RegistryObject<Item> DUMBBELL = ITEMS.register("dumbbell",
            () -> new DumbBellItem(new Item.Properties()));
    public static final RegistryObject<Item> WINDOWS = ITEMS.register("windows",
            () -> new WindowsItem(new Item.Properties()));
    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
    }

}
