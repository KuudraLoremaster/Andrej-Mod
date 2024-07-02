package net.kuudraloremaster.andrejmod.worldgen.dimension;

import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.util.Pair;
import net.kuudraloremaster.andrejmod.AndrejMod;
import net.kuudraloremaster.andrejmod.worldgen.biome.ModBiomes;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.chunk.ChunkGenerators;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.FlatLevelSource;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.flat.FlatLayerInfo;
import net.minecraft.world.level.levelgen.flat.FlatLevelGeneratorPreset;
import net.minecraft.world.level.levelgen.flat.FlatLevelGeneratorPresets;
import net.minecraft.world.level.levelgen.flat.FlatLevelGeneratorSettings;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.presets.WorldPreset;
import net.minecraft.world.level.levelgen.presets.WorldPresets;
import net.minecraft.world.level.levelgen.structure.BuiltinStructureSets;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.StructureSpawnOverride;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.stream.Collectors;

public class ModDimensions {
    public static final ResourceKey<LevelStem> INFINITEVOID_KEY = ResourceKey.create(Registries.LEVEL_STEM,
            new ResourceLocation(AndrejMod.MOD_ID, "infinitevoid"));
    public static final ResourceKey<Level> INFINITEVOID_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION,
            new ResourceLocation(AndrejMod.MOD_ID, "infinitevoid"));
    public static final ResourceKey<DimensionType> INFINITEVOID_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
            new ResourceLocation(AndrejMod.MOD_ID, "infinitevoid_type"));


    public static void bootstrapType(BootstapContext<DimensionType> context) {
        context.register(INFINITEVOID_DIM_TYPE, new DimensionType(
                OptionalLong.of(12000), // fixedTime
                false, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                false, // natural
                1.0, // coordinateScale
                true, // bedWorks
                false, // respawnAnchorWorks
                0, // minY
                256, // height
                256, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                BuiltinDimensionTypes.OVERWORLD_EFFECTS, // effectsLocation
                1.0f, // ambientLight
                new DimensionType.MonsterSettings(false, false, ConstantInt.of(0), 0)));
    }

    public static void bootstrapStem(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<PlacedFeature> featureRegistry = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);
        HolderGetter<StructureSet> holdergetter = context.lookup(Registries.STRUCTURE_SET);
        HolderSet.Direct<StructureSet> direct = HolderSet.direct(ImmutableSet.of(BuiltinStructureSets.VILLAGES).stream().map(holdergetter::getOrThrow).collect(Collectors.toList()));
        List<FlatLayerInfo> layers = new ArrayList<>();
        layers.add(new FlatLayerInfo(1, Blocks.BARRIER));
        NoiseBasedChunkGenerator noiseBasedChunkGenerator = new NoiseBasedChunkGenerator(
                MultiNoiseBiomeSource.createFromList(
                        new Climate.ParameterList<>(List.of(Pair.of(
                                        Climate.parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.INFINITE_VOID))

                        ))),
                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.OVERWORLD));
        FlatLevelGeneratorSettings flatLevelGeneratorSettings = new FlatLevelGeneratorSettings(Optional.of(direct), biomeRegistry.getOrThrow(ModBiomes.INFINITE_VOID), FlatLevelGeneratorSettings.createLakesList(featureRegistry));
        FlatLayerInfo barrier = new FlatLayerInfo(14, Blocks.BARRIER);
        flatLevelGeneratorSettings.getLayersInfo().add(barrier);
        FlatLevelSource flatLevelSource = new FlatLevelSource(
                flatLevelGeneratorSettings
        );
        LevelStem stem = new LevelStem(dimTypes.getOrThrow(ModDimensions.INFINITEVOID_DIM_TYPE), flatLevelSource);

        context.register(INFINITEVOID_KEY, stem);
    }
}
