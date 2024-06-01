package net.kuudraloremaster.andrejmod.item;

import net.kuudraloremaster.andrejmod.AndrejMod;
import net.kuudraloremaster.andrejmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AndrejMod.MOD_ID);
    public static final RegistryObject<CreativeModeTab> ANDREJ_TAB = CREATIVE_MODE_TABS.register("andrej_tab",
            ()-> CreativeModeTab.builder().icon(() ->  new ItemStack(ModItems.SAPPHIRE.get()))
                    .title(Component.translatable("creativetab.andrej_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.SAPPHIRE.get());
                        pOutput.accept(ModItems.RAW_SAPPHIRE.get());
                        pOutput.accept(ModItems.PIXEL.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_SAPPHIRE_BLOCK.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
                        pOutput.accept(ModBlocks.END_STONE_SAPPHIRE_ORE.get());
                        pOutput.accept(ModItems.METAL_DETECTOR.get());
                        pOutput.accept(ModBlocks.NETHER_SAPPHIRE_ORE.get());
                        pOutput.accept(ModBlocks.SOUND_BLOCK.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_TRAPDOOR.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_DOOR.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_SLAB.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_STAIRS.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_BUTTON.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_WALL.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_BUTTON.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_FENCE.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_WALL.get());
                        pOutput.accept(ModItems.BOAR.get());
                        pOutput.accept(ModItems.STRAWBERRY.get());
                        pOutput.accept(ModItems.KFC.get());
                        pOutput.accept(ModItems.RAW_KFC.get());
                        pOutput.accept(ModItems.KFC_BUCKET.get());
                        pOutput.accept(ModItems.KYS_GUN.get());
                        pOutput.accept(ModItems.PINE_CONE.get());
                        pOutput.accept(ModItems.NEVER_GOON.get());
                        pOutput.accept(ModItems.WAFFLE.get());
                        pOutput.accept(ModItems.MAGNUS.get());
                        pOutput.accept(ModItems.STRAWBERRY_SEED.get());
//                      DUN DUN DUN SERGIO PEREZ
//                      MAX VERSTAPPEN LALALALALALA
//                      FERNANDO ALONOZO LALALALALA
//                      Have we gone too far? or not far enough
                        pOutput.accept(ModItems.MAX_VERSTAPPEN.get());
                        pOutput.accept(ModItems.SERGIO_PEREZ.get());
                        pOutput.accept(ModItems.FERNANDO_ALONSO.get());
                        pOutput.accept(ModItems.MICHAEL_SCHUMACHER.get());


                        pOutput.accept(ModItems.BALLS_CUTTER.get());
                        pOutput.accept(ModItems.DUMBBELL.get());
                        pOutput.accept(ModItems.SAPPHIRE_STAFF.get());
                        pOutput.accept(ModItems.WINDOWS.get());
                        pOutput.accept(ModItems.SAPPHIRE_PICKAXE.get());
                        pOutput.accept(ModItems.SAPPHIRE_AXE.get());
                        pOutput.accept(ModItems.SAPPHIRE_HOE.get());
                        pOutput.accept(ModItems.SAPPHIRE_SHOVEL.get());
                        pOutput.accept(ModItems.SAPPHIRE_SWORD.get());
                        pOutput.accept(ModItems.SAPPHIRE_BOOTS.get());
                        pOutput.accept(ModItems.SAPPHIRE_CHESTPLATE.get());
                        pOutput.accept(ModItems.SAPPHIRE_LEGGINGS.get());
                        pOutput.accept(ModItems.SAPPHIRE_HELMET.get());
                        pOutput.accept(ModItems.KUUDRA_FOLLOWER_FRAGMENT.get());
                        pOutput.accept(ModItems.KUUDRA_FOLLOWER_LEGGINGS.get());
                        pOutput.accept(ModItems.KUUDRA_FOLLOWER_CHESTPLATE.get());
                        pOutput.accept(ModItems.KUUDRA_FOLLOWER_BOOTS.get());
                        pOutput.accept(ModItems.KUUDRA_FOLLOWER_HELMET.get());
                        pOutput.accept(ModBlocks.SCALE_BLOCK.get());
                        pOutput.accept(ModItems.OHIO.get());
                        pOutput.accept(ModItems.OHIO_CHESTPLATE.get());
                        pOutput.accept(ModItems.OHIO_BOOTS.get());
                        pOutput.accept(ModItems.OHIO_HELMET.get());
                        pOutput.accept(ModItems.OHIO_LEGGINGS.get());
                        pOutput.accept(ModItems.MAID.get());
                        pOutput.accept(ModItems.MAID_LEGGINGS.get());
                        pOutput.accept(ModItems.MAID_CHESTPLATE.get());
                        pOutput.accept(ModItems.MAID_BOOTS.get());
                        pOutput.accept(ModItems.MAID_HELMET.get());
                        pOutput.accept(ModItems.RHINO_SPAWN_EGG.get());
                        pOutput.accept(ModItems.GOONER_SPAWN_EGG.get());
                        pOutput.accept(ModBlocks.GEM_POLISHING_STATION.get());
                    })
                    .build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
