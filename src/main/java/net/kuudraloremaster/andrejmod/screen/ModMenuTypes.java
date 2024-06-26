package net.kuudraloremaster.andrejmod.screen;

import net.kuudraloremaster.andrejmod.AndrejMod;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.rmi.registry.Registry;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, AndrejMod.MOD_ID);
    public static final RegistryObject<MenuType<GemPolishingStationMenu>> GEM_POLISHING_MENU =
            registerMenuType("gem_polishing_menu", GemPolishingStationMenu::new);
    public static final RegistryObject<MenuType<KfcDeepfrierMenu>> KFC_DEEPFRIER_MENU =
            registerMenuType("kfc_deepfrier_menu", KfcDeepfrierMenu::new);
    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
