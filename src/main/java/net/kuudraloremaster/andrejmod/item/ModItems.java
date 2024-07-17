package net.kuudraloremaster.andrejmod.item;

import net.kuudraloremaster.andrejmod.AndrejMod;
import net.kuudraloremaster.andrejmod.block.ModBlocks;
import net.kuudraloremaster.andrejmod.entity.ModEntities;
import net.kuudraloremaster.andrejmod.entity.custom.ModBoatEntity;
import net.kuudraloremaster.andrejmod.entity.custom.ModChestBoatEntity;
import net.kuudraloremaster.andrejmod.item.custom.*;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
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
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
            () -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));
    public static final RegistryObject<Item> KFC = ITEMS.register("kfc",
            () -> new Item(new Item.Properties().food(ModFoods.KFC)));
    public static final RegistryObject<Item> RAW_KFC = ITEMS.register("raw_kfc",
            () -> new Item(new Item.Properties().food(ModFoods.RAW_KFC)));
    public static final RegistryObject<Item> KFC_BUCKET = ITEMS.register("kfc_bucket",
            () -> new Item(new Item.Properties().food(ModFoods.KFC_BUCKET)));
    public static final RegistryObject<Item> KYS_GUN = ITEMS.register("kys_gun",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HOLLOW_PURPLE = ITEMS.register("hollow_purple",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PINE_CONE = ITEMS.register("pine_cone",
            () -> new FuelItem(new Item.Properties(), 400));
    public static final RegistryObject<Item> NEVER_GOON = ITEMS.register("never_goon",
            () -> new NGItem(new Item.Properties()));
    public static final RegistryObject<Item> MAGNUS = ITEMS.register("magnus",
            () -> new MagnusItem(new Item.Properties()));
    public static final RegistryObject<Item> WAFFLE = ITEMS.register("waffle",
            () -> new Item(new Item.Properties().food(ModFoods.WAFFLE)));
    public static final RegistryObject<Item> HAND_SIGN = ITEMS.register("hand_sign",
            () -> new HandSignItem(new Item.Properties()));
//    F1 goobers
    public static final RegistryObject<Item> MAX_VERSTAPPEN = ITEMS.register("max_verstappen",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SERGIO_PEREZ = ITEMS.register("sergio_perez",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FERNANDO_ALONSO = ITEMS.register("fernando_alonso",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MICHAEL_SCHUMACHER = ITEMS.register("michael_schumacher",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BALLS_CUTTER = ITEMS.register("balls_cutter",
            () -> new BallsCutterItem(new Item.Properties()));
    public static final RegistryObject<Item> DUMBBELL = ITEMS.register("dumbbell",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WINDOWS = ITEMS.register("windows",
            () -> new WindowsItem(new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_STAFF = ITEMS.register("sapphire_staff",
            () -> new Item(new Item.Properties().stacksTo(1).durability(100)));
    public static final RegistryObject<Item> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword",
            () -> new SwordItem(ModToolTier.SAPPHIRE, 4, 2, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe",
            () -> new PickaxeItem(ModToolTier.SAPPHIRE, 1, 1, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_AXE = ITEMS.register("sapphire_axe",
            () -> new AxeItem(ModToolTier.SAPPHIRE, 7, 1, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel",
            () -> new ShovelItem(ModToolTier.SAPPHIRE, 0.5f, .6f, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe",
            () -> new HoeItem(ModToolTier.SAPPHIRE, 0, 0, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_HELMET = ITEMS.register("sapphire_helmet",
            () -> new ArmorItem(ModArmorMaterials.SAPPHIRE,ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_CHESTPLATE = ITEMS.register("sapphire_chestplate",
            () -> new ArmorItem(ModArmorMaterials.SAPPHIRE,ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_LEGGINGS = ITEMS.register("sapphire_leggings",
            () -> new ArmorItem(ModArmorMaterials.SAPPHIRE,ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_BOOTS = ITEMS.register("sapphire_boots",
            () -> new ModArmorItem(ModArmorMaterials.SAPPHIRE,ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> KUUDRA_FOLLOWER_FRAGMENT = ITEMS.register("kuudra_follower_fragment",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> KUUDRA_FOLLOWER_HELMET = ITEMS.register("kuudra_follower_helmet",
            () -> new ModArmorItem(ModArmorMaterials.KUUDRA, ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> KUUDRA_FOLLOWER_CHESTPLATE = ITEMS.register("kuudra_follower_chestplate",
            () -> new ArmorItem(ModArmorMaterials.KUUDRA, ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> KUUDRA_FOLLOWER_LEGGINGS = ITEMS.register("kuudra_follower_leggings",
            () -> new ArmorItem(ModArmorMaterials.KUUDRA, ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> KUUDRA_FOLLOWER_BOOTS = ITEMS.register("kuudra_follower_boots",
            () -> new ArmorItem(ModArmorMaterials.KUUDRA,ArmorItem.Type.BOOTS,new Item.Properties()));
    public static final RegistryObject<Item> OHIO_HELMET = ITEMS.register("ohio_helmet",
            () -> new ModArmorItem(ModArmorMaterials.OHIO,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> OHIO_CHESTPLATE = ITEMS.register("ohio_chestplate",
            () -> new ArmorItem(ModArmorMaterials.OHIO,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> OHIO_LEGGINGS = ITEMS.register("ohio_leggings",
            () -> new ArmorItem(ModArmorMaterials.OHIO,ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> OHIO_BOOTS = ITEMS.register("ohio_boots",
            () -> new ArmorItem(ModArmorMaterials.OHIO,ArmorItem.Type.BOOTS,new Item.Properties()));
    public static final RegistryObject<Item> OHIO = ITEMS.register("ohio",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MAID = ITEMS.register("maid",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MAID_HELMET = ITEMS.register("maid_helmet",
            () -> new ModArmorItem(ModArmorMaterials.MAID,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> MAID_CHESTPLATE = ITEMS.register("maid_chestplate",
            () -> new ArmorItem(ModArmorMaterials.MAID,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> MAID_LEGGINGS = ITEMS.register("maid_leggings",
            () -> new ArmorItem(ModArmorMaterials.MAID,ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> MAID_BOOTS = ITEMS.register("maid_boots",
            () -> new ArmorItem(ModArmorMaterials.MAID,ArmorItem.Type.BOOTS,new Item.Properties()));
    public static final RegistryObject<Item> STRAWBERRY_SEED = ITEMS.register("strawberry_seeds",
            () -> new ItemNameBlockItem(ModBlocks.STRAWBERRY_CROP.get() ,new Item.Properties()));
    public static final RegistryObject<Item> RHINO_SPAWN_EGG = ITEMS.register("rhino_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.RHINO, 0x7e9680, 0xc5d1c5,new Item.Properties()));
    public static final RegistryObject<Item> GOONER_SPAWN_EGG = ITEMS.register("gooner_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.GOONER, 0xfcba03, 0x32a852,new Item.Properties()));
    public static final RegistryObject<Item> DICE = ITEMS.register("dice",
            () -> new DiceItem(new Item.Properties()));
    public static final RegistryObject<Item> PINE_SIGN = ITEMS.register("pine_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.PINE_SIGN.get(), ModBlocks.PINE_WALL_SIGN.get()));
    public static final RegistryObject<Item> PINE_HANGING_SIGN = ITEMS.register("pine_hanging_sign",
            () -> new HangingSignItem(ModBlocks.PINE_HANGING_SIGN.get(), ModBlocks.PINE_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> PISTOL = ITEMS.register("ak47", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BULLET = ITEMS.register("bullet", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PINE_BOAT = ITEMS.register("pine_boat",
            () -> new ModBoatItem(false, ModBoatEntity.Type.PINE,new Item.Properties()));
    public static final RegistryObject<Item> PINE_CHEST_BOAT = ITEMS.register("pine_chest_boat",
            () -> new ModBoatItem(true, ModBoatEntity.Type.PINE,new Item.Properties()));
    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
    }

}
