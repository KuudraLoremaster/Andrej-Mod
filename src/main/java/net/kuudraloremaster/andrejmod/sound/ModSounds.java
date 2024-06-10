package net.kuudraloremaster.andrejmod.sound;

import net.kuudraloremaster.andrejmod.AndrejMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeDeferredRegistriesSetup;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, AndrejMod.MOD_ID);

    public static final RegistryObject<SoundEvent> METAL_DETECOR_FOUND_ORE = registerSoundEvents("metal_detector_found_ore");
    public static final RegistryObject<SoundEvent> SOUND_BLOCK_BREAK = registerSoundEvents("sound_block_break");
    public static final RegistryObject<SoundEvent> SOUND_BLOCK_STEP = registerSoundEvents("sound_block_step");
    public static final RegistryObject<SoundEvent> SOUND_BLOCK_FALL = registerSoundEvents("sound_block_fall");
    public static final RegistryObject<SoundEvent> SOUND_BLOCK_PLACE = registerSoundEvents("sound_block_place");
    public static final RegistryObject<SoundEvent> SOUND_BLOCK_HIT = registerSoundEvents("sound_block_hit");
    public static final RegistryObject<SoundEvent> NEVER_GOON = registerSoundEvents("never_goon");
//  F1 racing insane crazy insanity
    public static final RegistryObject<SoundEvent> MAX_VERSTAPPEN = registerSoundEvents("max_verstappen");
    public static final RegistryObject<SoundEvent> SERGIO_PEREZ = registerSoundEvents("sergio_perez");
    public static final RegistryObject<SoundEvent> FERNANDO_ALONSO = registerSoundEvents("fernando_alonso");
    public static final RegistryObject<SoundEvent> MICHAEL_SCHUMACHER = registerSoundEvents("michael_schumacher");
    public static final RegistryObject<SoundEvent> GOONER_IDLE = registerSoundEvents("gooner_idle");
    public static final RegistryObject<SoundEvent> GOONER_HURT = registerSoundEvents("gooner_hurt");
    public static final RegistryObject<SoundEvent> GOONER_DEATH = registerSoundEvents("gooner_death");
    public static final RegistryObject<SoundEvent> AK_FIRE = registerSoundEvents("ak_fire");
    public static final RegistryObject<SoundEvent> AK_EMPTY = registerSoundEvents("ak_empty");


    public static final ForgeSoundType SOUND_BLOCK_SOUNDS = new ForgeSoundType(1f,1f,
            ModSounds.SOUND_BLOCK_BREAK, ModSounds.SOUND_BLOCK_STEP, ModSounds.SOUND_BLOCK_PLACE, ModSounds.SOUND_BLOCK_HIT, ModSounds.SOUND_BLOCK_FALL);
    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(AndrejMod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }

}
