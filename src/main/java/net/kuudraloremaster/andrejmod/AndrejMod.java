package net.kuudraloremaster.andrejmod;

import com.mojang.logging.LogUtils;
import net.kuudraloremaster.andrejmod.block.ModBlocks;
import net.kuudraloremaster.andrejmod.item.ModArmorMaterials;
import net.kuudraloremaster.andrejmod.item.ModCreativeModeTabs;
import net.kuudraloremaster.andrejmod.item.ModFoods;
import net.kuudraloremaster.andrejmod.item.ModItems;
import net.kuudraloremaster.andrejmod.item.custom.ModArmorItem;
import net.kuudraloremaster.andrejmod.item.custom.WindowsItem;
import net.kuudraloremaster.andrejmod.loot.ModLootModifier;
import net.kuudraloremaster.andrejmod.sound.ModSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Vec3i;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.NoteBlockEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RangedWrapper;
import org.slf4j.Logger;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;
import net.minecraft.world.item.crafting.ShapedRecipe;

import java.awt.event.ComponentListener;
import java.util.List;
import java.util.Map;

import static net.minecraft.world.item.Items.CHEST;
import static net.minecraft.world.level.Explosion.BlockInteraction.DESTROY;
import net.kuudraloremaster.andrejmod.item.custom.ModArmorItem;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(AndrejMod.MOD_ID)
public class AndrejMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "andrejmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public AndrejMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModSounds.register(modEventBus);
        ModLootModifier.register(modEventBus);
        modEventBus.addListener(this::commonSetup);


        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
//        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private  void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.SAPPHIRE);
            event.accept(ModItems.RAW_SAPPHIRE);
        }
    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
    public static Integer weight = 5;
    @Mod.EventBusSubscriber(modid = "andrejmod", bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class FoodEatingEventHandler {

        @SubscribeEvent
            public static void onItemUseFinish(LivingEntityUseItemEvent.Finish event) {
                if (event.getEntity() instanceof Player) {
                    Player player = (Player) event.getEntity();
                    ItemStack itemStack = event.getItem();
                    if (!player.getCommandSenderWorld().isClientSide && itemStack.getItem() == ModItems.KFC_BUCKET.get()) {
                        weight += 20;
                        player.sendSystemMessage(Component.literal("Your weight now is " + weight));
                    }
                    if (!player.getCommandSenderWorld().isClientSide && itemStack.getItem() == ModItems.WAFFLE.get()) {
                        if (weight < 10) {
                            weight = 5;
                        }
                        else {
                            weight -= 10;
                        }
                        player.sendSystemMessage(Component.literal("you have diabetes and you lost 10 weight.\nYour weight is now " + weight));
                    }
                    if(weight >= 300) {
                        player.kill();
                        weight = 0;
                        player.sendSystemMessage(Component.literal("you were too fucking fat lmao"));
                    }

            }
        }
    }

    boolean isJumping = false; // Flag to track jump state
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        Level world = player.getCommandSenderWorld();

        if (!player.onGround()) {
            isJumping = true;
        }
        if (player.onGround() && isJumping && !player.getCommandSenderWorld().isClientSide) {
            isJumping = false;
            if (weight >= 80) {
                double radius = weight * 0.04;
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, (int) radius));
                world.explode(null, player.getX(), player.getY(), player.getZ(), 4, Level.ExplosionInteraction.BLOCK);
            }
        }
        if (weight >= 40) {
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 400, 2));
        }
        if (WindowsItem.activatedWindows) {
            player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 200, 2));
        }
    }


    @SubscribeEvent
    public void onPlayerInteract(PlayerInteractEvent.EntityInteract event) {
        Player player = event.getEntity();
        Level world = event.getLevel();


}}

