package net.kuudraloremaster.andrejmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().nutrition(2).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200), 0.1f).build();

    public static final FoodProperties KFC = new FoodProperties.Builder().nutrition(6)
            .saturationMod(0.5f).build();
    public static final FoodProperties RAW_KFC = new FoodProperties.Builder().nutrition(2)
            .saturationMod(0.1f).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 400), 0.4f).build();
    public static final FoodProperties KFC_BUCKET = new FoodProperties.Builder().nutrition(16)
            .saturationMod(.7f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 400), 1f).build();
    public static final FoodProperties WAFFLE = new FoodProperties.Builder().nutrition(6)
            .saturationMod(.3f).effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 400), 1f).effect(() -> new MobEffectInstance(MobEffects.WEAKNESS, 400), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 400), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.HARM, 1), 1f)
            .build();


}
