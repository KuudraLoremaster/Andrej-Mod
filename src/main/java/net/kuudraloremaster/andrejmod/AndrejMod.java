package net.kuudraloremaster.andrejmod;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.logging.LogUtils;
import net.kuudraloremaster.andrejmod.block.ModBlocks;
import net.kuudraloremaster.andrejmod.block.entities.ModBlockEntities;
import net.kuudraloremaster.andrejmod.entity.ModEntities;
import net.kuudraloremaster.andrejmod.entity.client.*;
import net.kuudraloremaster.andrejmod.entity.custom.BulletProjectileEntity;
import net.kuudraloremaster.andrejmod.entity.custom.DiceProjectileEntity;
import net.kuudraloremaster.andrejmod.entity.custom.HollowPurpleEntity;
import net.kuudraloremaster.andrejmod.entity.custom.ModBoatEntity;
import net.kuudraloremaster.andrejmod.util.ModWoodTypes;
import net.kuudraloremaster.andrejmod.worldgen.biome.ModTerrablender;
import net.kuudraloremaster.andrejmod.worldgen.biome.surface.ModSurfaceRules;
import net.kuudraloremaster.andrejmod.worldgen.dimension.ModDimensions;
import net.kuudraloremaster.andrejmod.worldgen.portal.ModTeleporter;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.kuudraloremaster.andrejmod.item.ModArmorMaterials;
import net.kuudraloremaster.andrejmod.item.ModCreativeModeTabs;
import net.kuudraloremaster.andrejmod.recipe.ModRecipes;
import net.kuudraloremaster.andrejmod.screen.GemPolishingStationScreen;
import net.kuudraloremaster.andrejmod.screen.KfcDeepfrierScreen;
import net.kuudraloremaster.andrejmod.item.ModFoods;
import net.kuudraloremaster.andrejmod.item.ModItems;
import net.kuudraloremaster.andrejmod.item.custom.ModArmorItem;
import net.kuudraloremaster.andrejmod.item.custom.WindowsItem;
import net.kuudraloremaster.andrejmod.loot.ModLootModifier;
import net.kuudraloremaster.andrejmod.screen.ModMenuTypes;
import net.kuudraloremaster.andrejmod.sound.ModSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.telemetry.TelemetryProperty;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Vec3i;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.commands.GameModeCommand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
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

import java.awt.*;
import java.awt.event.ComponentListener;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static net.minecraft.util.datafix.fixes.ItemIdFix.getItem;
import static net.minecraft.world.InteractionHand.MAIN_HAND;
import static net.minecraft.world.InteractionHand.OFF_HAND;
import static net.minecraft.world.item.Items.*;
import static net.minecraft.world.level.Explosion.BlockInteraction.DESTROY;
import net.kuudraloremaster.andrejmod.item.custom.ModArmorItem;
import team.lodestar.lodestone.handlers.RenderHandler;
import team.lodestar.lodestone.registry.client.LodestoneRenderTypeRegistry;
import team.lodestar.lodestone.registry.common.particle.LodestoneParticleRegistry;
import team.lodestar.lodestone.systems.easing.Easing;
import team.lodestar.lodestone.systems.particle.builder.WorldParticleBuilder;
import team.lodestar.lodestone.systems.particle.data.GenericParticleData;
import team.lodestar.lodestone.systems.particle.data.color.ColorParticleData;
import team.lodestar.lodestone.systems.particle.data.spin.SpinParticleData;
import team.lodestar.lodestone.systems.postprocess.PostProcessHandler;
import team.lodestar.lodestone.systems.rendering.VFXBuilders;
import team.lodestar.lodestone.systems.rendering.rendeertype.RenderTypeToken;
import terrablender.api.SurfaceRuleManager;

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
        ModMenuTypes.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModSounds.register(modEventBus);
        ModEntities.register(modEventBus);
        ModLootModifier.register(modEventBus);
        ModRecipes.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        ModTerrablender.registerBiomes();

        MinecraftForge.EVENT_BUS.register(new PlayerDeathListener());
        MinecraftForge.EVENT_BUS.register(new PlayerSleepListener());
        MinecraftForge.EVENT_BUS.register(new PlayerInteractionHandler());
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
//        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, ModSurfaceRules.makeRules());
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
            EntityRenderers.register(ModEntities.RHINO.get(), RhinoRenderer::new);
            EntityRenderers.register(ModEntities.GOONER.get(), GoonerRenderer::new);
            EntityRenderers.register(ModEntities.HOLLOW_PURPLE.get(), HollowPurpleRenderer::new);
            EntityRenderers.register(ModEntities.RA.get(), RaRenderer::new);
            EntityRenderers.register(ModEntities.PEX.get(), PexRenderer::new);
            EntityRenderers.register(ModEntities.BUFF_MINION.get(), BuffMinionRenderer::new);
            EntityRenderers.register(ModEntities.DICE_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.BULLET.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.MOD_BOAT.get(), pContext -> new ModBoatRenderer(pContext, false));
            EntityRenderers.register(ModEntities.MOD_CHEST_BOAT.get(), pContext -> new ModBoatRenderer(pContext, true));
            MenuScreens.register(ModMenuTypes.GEM_POLISHING_MENU.get(), GemPolishingStationScreen::new);
            MenuScreens.register(ModMenuTypes.KFC_DEEPFRIER_MENU.get(), KfcDeepfrierScreen::new);
            Sheets.addWoodType(ModWoodTypes.PINE);
        }
    }
    public static Integer weight = 5;
    public static Integer karma = 1;

    @Mod.EventBusSubscriber(modid=MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class PlayerDeathListener {

    @SubscribeEvent
    public void onLivingDeath(LivingDeathEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof LivingEntity) {
            if (entity.level() instanceof ServerLevel serverlevel) {

                ResourceKey<Level> resourcekey = entity.level().dimension() == ModDimensions.INFINITEVOID_LEVEL_KEY ?
                        Level.OVERWORLD : ModDimensions.INFINITEVOID_LEVEL_KEY;
                MinecraftServer minecraftserver = serverlevel.getServer();
                ServerLevel portalDimension = minecraftserver.getLevel(resourcekey);
                if (portalDimension != null && !entity.isPassenger()) {
                    if (!(resourcekey == ModDimensions.INFINITEVOID_LEVEL_KEY)) {
                        int radius = 64;
                        AABB aabb = new AABB(
                                entity.getX() - radius, entity.getY() - radius, entity.getZ() - radius,
                                entity.getX() + radius, entity.getY() + radius, entity.getZ() + radius
                        );
                        List<Entity> entityList = entity.level().getEntities(entity, aabb, entity1 -> true);
                        for (Entity entity2 : entityList) {
                            entity2.changeDimension(portalDimension, new ModTeleporter(entity2.getOnPos(), true));
                        }
                    }
                }
            }
        }
        if (entity instanceof Player) {
            Player player = (Player) entity;
            if (!player.getCommandSenderWorld().isClientSide()) {
                karma -= 1;
                if (karma <= 0) {
                    karma = 1;
                }
                player.sendSystemMessage(Component.literal("Your karma is " + karma));
            }
        }
    }
}
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class PlayerSleepListener {


        @SubscribeEvent
        public void onWakeUp(PlayerWakeUpEvent event) {
            if (event.getEntity() instanceof Player) {
                Player player = event.getEntity();
                if (!player.getCommandSenderWorld().isClientSide() && !(karma == 10)) {
                    karma += 1;
                    player.sendSystemMessage(Component.literal("Your karma is " + karma));
                }
            }
        }

    }
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
        if (player.isInWater()) {
            if (karma == 10) {
                player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 600, 2));
            }
            // removed his rainworld reference until i added the new pex du la lex
        }
        if (!player.onGround()) {
            isJumping = true;
        }
        if (player.onGround() && isJumping && !player.getCommandSenderWorld().isClientSide) {
            isJumping = false;
            if (weight >= 80) {
                float radius = (float) (weight * 0.04);
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 5));
                world.explode(null, player.getX(), player.getY(), player.getZ(), radius, Level.ExplosionInteraction.BLOCK);
            }
        }
        if (weight >= 40) {
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 400, 2));
        }
        if (weight >= 300) {
            player.kill();
            weight = 0;
            player.sendSystemMessage(Component.literal("you were too fucking fat lmao"));
        }
        if (WindowsItem.activatedWindows) {
            player.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 200, 2));
        }

    }
    @Mod.EventBusSubscriber(modid = "andrejmod", bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class PlayerInteractionHandler {
    @SubscribeEvent
    public void onPlayerInteract(PlayerInteractEvent.RightClickItem event) {
        if (event.getEntity() instanceof Player) {
            Player player = event.getEntity();
            Level world = event.getLevel();
            Item item = player.getItemInHand(MAIN_HAND).getItem();
            Item offHandItem = player.getItemInHand(OFF_HAND).getItem();

            if (item != null) {
                if (item == Items.CLOCK) {
                    if (!player.getCommandSenderWorld().isClientSide()) {
                        player.sendSystemMessage(Component.literal("Your karma is " + karma));
                    }
                }
                if (item == ModItems.HOLLOW_PURPLE.get()) {
                    if (!world.isClientSide && player != null) {
                        world.playSeededSound(null, player.getX(), player.getY(), player.getZ(),
                                ModSounds.PURPLE.get(), SoundSource.BLOCKS, 1f, 1f,0);
                        // Spawn the sphere entity at the clicked position
                        HollowPurpleEntity entity = new HollowPurpleEntity(ModEntities.HOLLOW_PURPLE.get(), world);
                        entity.moveTo(player.getPosition(Minecraft.getInstance().getPartialTick()));
                        Vec3 lookVec = player.getLookAngle();
                        double speed = 2;
                        Vec3 motion = lookVec.scale(speed);
                        entity.setMotion(motion);
                        world.addFreshEntity(entity);
                    }
                }
                if (item == ModItems.MAX_VERSTAPPEN.get()) {
                    if (!player.getCommandSenderWorld().isClientSide()) {
                        world.playSeededSound(null,player.getX(), player.getY(), player.getZ(),
                                ModSounds.MAX_VERSTAPPEN.get(), SoundSource.BLOCKS, 1f, 1f,0);
                        player.sendSystemMessage(Component.literal("DUH DUH DUH DUH MAX VERSTAPPEN"));

                    }
                }
                if (item == ModItems.SERGIO_PEREZ.get()) {
                    if (!player.getCommandSenderWorld().isClientSide) {
                        player.sendSystemMessage(Component.literal("SERGIO PEREZ LALALALALALALA"));
                    }
                    world.playSeededSound(null,player.getX(), player.getY(), player.getZ(),
                            ModSounds.SERGIO_PEREZ.get(), SoundSource.BLOCKS, 1f, 1f,0);
                }
                if (item == ModItems.FERNANDO_ALONSO.get()) {
                    if (!player.getCommandSenderWorld().isClientSide) {
                        player.sendSystemMessage(Component.literal("OOOOH FERNANDO ALONSO"));
                    }
                    world.playSeededSound(null,player.getX(), player.getY(), player.getZ(),
                            ModSounds.FERNANDO_ALONSO.get(), SoundSource.BLOCKS, 1f, 1f,0);
                }
                if (item == ModItems.MICHAEL_SCHUMACHER.get()) {
                    world.playSeededSound(null,player.getX(), player.getY(), player.getZ(),
                            ModSounds.MICHAEL_SCHUMACHER.get(), SoundSource.BLOCKS, 1f, 1f,0);
                    if (!player.getCommandSenderWorld().isClientSide) {
                        player.sendSystemMessage(Component.literal("MICHAEL SCHUMACHER BAM BAM BAM BAM"));
                    }
                }
                if (item == ModItems.KYS_GUN.get()) {
                    weight = 5;
                    player.kill();
                }
                if (item == ModItems.BOAR.get()) {
                    player.playSound(SoundEvents.GENERIC_EXPLODE, 1, 1);
                    if (!player.getCommandSenderWorld().isClientSide) {
                        player.sendSystemMessage(Component.literal("Boar"));
                    }
                }
                if (item == ModItems.DUMBBELL.get()) {
                    if(!hasFullSpecificArmorOn(player, ModArmorMaterials.MAID)) {
                        if (weight <= 40) {
                            weight = 5;
                        } else {
                            weight -= 40;
                        }
                        if (!player.getCommandSenderWorld().isClientSide) {
                            player.sendSystemMessage(Component.literal("Your weight is " + weight));
                        }
                    }
                else {
                    if (!player.getCommandSenderWorld().isClientSide()) {
                        player.sendSystemMessage(Component.literal("You're a cute femboy you can't use this :3"));
                    }
                }
                }
                if (item == ModItems.SAPPHIRE_STAFF.get()) {
                    Entity lightning = new LightningBolt(EntityType.LIGHTNING_BOLT, world);
                    Vec3 lookVec = player.getViewVector(Minecraft.getInstance().getPartialTick());
                    lightning.moveTo(getPlayerPOVHitResult(world, player, ClipContext.Fluid.NONE).getBlockPos().getCenter());
                    world.addFreshEntity(lightning);
                }
                if (item == ModItems.PISTOL.get()) {
                    ItemStack bulletItem = new ItemStack(ModItems.BULLET.get());
                        if (player.getInventory().findSlotMatchingItem(bulletItem) != -1) {
                            Entity bullet = new BulletProjectileEntity(ModEntities.BULLET.get(), world);
                            bullet.moveTo(player.getPosition(Minecraft.getInstance().getPartialTick()));
                            player.playSound(ModSounds.AK_FIRE.get(), 1.0f, 1.0f);
                            world.addFreshEntity(bullet);
                            int slot = player.getInventory().findSlotMatchingItem(bulletItem);
                            player.getInventory().getItem(slot).shrink(1);
                            bullet.teleportTo(player.getX(), player.getY() + 1, player.getZ());
                            Vec3 lookVec = player.getViewVector(Minecraft.getInstance().getPartialTick());
                            bullet.setDeltaMovement(lookVec.scale(2.0));

                        }
                        else if (offHandItem == ModItems.BULLET.get() ) {
                            Entity bullet = new BulletProjectileEntity(ModEntities.BULLET.get(), world);
                            bullet.moveTo(player.getPosition(Minecraft.getInstance().getPartialTick()));
                            player.playSound(ModSounds.AK_FIRE.get(), 1.0f, 1.0f);
                            world.addFreshEntity(bullet);
                            player.getOffhandItem().shrink(1);
                            bullet.teleportTo(player.getX(), player.getY() + 1, player.getZ());
                            Vec3 lookVec = player.getViewVector(Minecraft.getInstance().getPartialTick());
                            bullet.setDeltaMovement(lookVec.scale(2.0));
                    }
                        else {
                            player.playSound(ModSounds.AK_EMPTY.get(), 1.0f, 1.0f);
                        }




                }
                }

            }
        }
        protected static BlockHitResult getPlayerPOVHitResult(Level pLevel, Player pPlayer, ClipContext.Fluid pFluidMode) {
            float f = pPlayer.getXRot();
            float f1 = pPlayer.getYRot();
            Vec3 vec3 = pPlayer.getEyePosition();
            float f2 = Mth.cos(-f1 * 0.017453292F - 3.1415927F);
            float f3 = Mth.sin(-f1 * 0.017453292F - 3.1415927F);
            float f4 = -Mth.cos(-f * 0.017453292F);
            float f5 = Mth.sin(-f * 0.017453292F);
            float f6 = f3 * f4;
            float f7 = f2 * f4;
            double d0 = pPlayer.getBlockReach();
            Vec3 vec31 = vec3.add((double)f6 * d0, (double)f5 * d0, (double)f7 * d0);
            return pLevel.clip(new ClipContext(vec3, vec31, net.minecraft.world.level.ClipContext.Block.OUTLINE, pFluidMode, pPlayer));
        }

        public static void spawnHollowPurple(PoseStack poseStack) {
            VFXBuilders.WorldVFXBuilder builder = VFXBuilders.createWorld();
            builder.renderSphere(poseStack, 10f, 10, 10);
        }
        public boolean hasFullSpecificArmorOn(Player player, ArmorMaterial material) {
            if (player.getInventory().getArmor(0).getItem() == Items.AIR || player.getInventory().getArmor(1).getItem() == Items.AIR
                    || player.getInventory().getArmor(2).getItem() == Items.AIR
                    || player.getInventory().getArmor(3).getItem() == Items.AIR) {
                return false;
            }

            ArmorItem boots = (ArmorItem) player.getInventory().getArmor(0).getItem();
            ArmorItem leggings = ((ArmorItem)player.getInventory().getArmor(1).getItem());
            ArmorItem breastplate = ((ArmorItem)player.getInventory().getArmor(2).getItem());
            ArmorItem helmet = ((ArmorItem)player.getInventory().getArmor(3).getItem());

            return boots.getMaterial() == material && leggings.getMaterial() == material
                    && breastplate.getMaterial() == material
                    && helmet.getMaterial() == material;
        }
    }
    }





