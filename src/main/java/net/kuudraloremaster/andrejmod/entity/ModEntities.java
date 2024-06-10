package net.kuudraloremaster.andrejmod.entity;

import net.kuudraloremaster.andrejmod.AndrejMod;
import net.kuudraloremaster.andrejmod.entity.custom.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, AndrejMod.MOD_ID);

    public static final RegistryObject<EntityType<RhinoEntity>> RHINO =
            ENTITY_TYPES.register("rhino", () -> EntityType.Builder.of(RhinoEntity::new, MobCategory.CREATURE)
                    .sized(2.5f, 2.5f).build("rhino"));
    public static final RegistryObject<EntityType<GoonerEntity>> GOONER =
            ENTITY_TYPES.register("gooner", () -> EntityType.Builder.of(GoonerEntity::new, MobCategory.MONSTER)
                    .sized(2f, 2f).build("gooner"));
    public static final RegistryObject<EntityType<PexEntity>> PEX =
            ENTITY_TYPES.register("pex", () -> EntityType.Builder.of(PexEntity::new, MobCategory.CREATURE)
                    .sized(1f, 2f).build("pex"));
    public static final RegistryObject<EntityType<BuffMinionEntity>> BUFF_MINION =
            ENTITY_TYPES.register("buff_minion", () -> EntityType.Builder.of(BuffMinionEntity::new, MobCategory.CREATURE)
                    .sized(2f, 6f).build("buff_minion"));
    public static final RegistryObject<EntityType<DiceProjectileEntity>> DICE_PROJECTILE =
            ENTITY_TYPES.register("dice_projectile", () -> EntityType.Builder.<DiceProjectileEntity>of(DiceProjectileEntity::new, MobCategory.MISC)
                    .sized(.5f, .5f).build("dice_projectile"));
    public static final RegistryObject<EntityType<BulletProjectileEntity>> BULLET =
            ENTITY_TYPES.register("bullet_projectile", () -> EntityType.Builder.<BulletProjectileEntity>of(BulletProjectileEntity::new, MobCategory.MISC)
                    .sized(.5f, .5f).build("bullet_projectile"));



    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
