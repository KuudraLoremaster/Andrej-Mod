package net.kuudraloremaster.andrejmod.datagen;

import com.sun.jna.WString;
import net.kuudraloremaster.andrejmod.AndrejMod;
import net.kuudraloremaster.andrejmod.block.ModBlocks;
import net.kuudraloremaster.andrejmod.block.custom.StrawberryCropBlock;
import net.minecraft.commands.arguments.blocks.BlockStateParser;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.structures.StrongholdPieces;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, AndrejMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.SAPPHIRE_BLOCK);
        blockWithItem(ModBlocks.RAW_SAPPHIRE_BLOCK);
        blockWithItem(ModBlocks.END_STONE_SAPPHIRE_ORE);
        blockWithItem(ModBlocks.SAPPHIRE_ORE);
        blockWithItem(ModBlocks.NETHER_SAPPHIRE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
        blockWithItem(ModBlocks.SOUND_BLOCK);
        blockWithItem(ModBlocks.SCALE_BLOCK);
        logBlock(((RotatedPillarBlock) ModBlocks.PINE_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.PINE_WOOD.get()), blockTexture(ModBlocks.PINE_LOG.get()), blockTexture(ModBlocks.PINE_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_PINE_LOG.get()), blockTexture(ModBlocks.STRIPPED_PINE_LOG.get()),
                new ResourceLocation(AndrejMod.MOD_ID, "block/stripped_pine_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_PINE_WOOD.get()), blockTexture(ModBlocks.STRIPPED_PINE_LOG.get()), blockTexture(ModBlocks.STRIPPED_PINE_LOG.get()));
        blockItem(ModBlocks.PINE_LOG);
        blockItem(ModBlocks.PINE_WOOD);
        blockItem(ModBlocks.STRIPPED_PINE_LOG);
        blockItem(ModBlocks.STRIPPED_PINE_WOOD);
        leavesBlock(ModBlocks.PINE_LEAVES);
        signBlock(((StandingSignBlock) ModBlocks.PINE_SIGN.get()), ((WallSignBlock) ModBlocks.PINE_WALL_SIGN.get()),
                blockTexture(ModBlocks.PINE_PLANKS.get()));
        blockWithItem(ModBlocks.PINE_PLANKS);
        simpleBlockWithItem(ModBlocks.GEM_POLISHING_STATION.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/gem_polishing_station")));
        simpleBlockWithItem(ModBlocks.KFC_DEEPFRIER.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/kfc_deepfrier")));

        stairsBlock(((StairBlock) ModBlocks.SAPPHIRE_STAIRS.get()), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.SAPPHIRE_SLAB.get()), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));

        buttonBlock(((ButtonBlock) ModBlocks.SAPPHIRE_BUTTON.get()), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.SAPPHIRE_PRESSURE_PLATE.get()), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));

        fenceBlock(((FenceBlock) ModBlocks.SAPPHIRE_FENCE.get()), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.SAPPHIRE_FENCE_GATE.get()), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.SAPPHIRE_WALL.get()), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));
        saplingBlock(ModBlocks.PINE_SAPLING);
        doorBlockWithRenderType(((DoorBlock) ModBlocks.SAPPHIRE_DOOR.get()), modLoc("block/sapphire_door_bottom"), modLoc("block/sapphire_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.SAPPHIRE_TRAPDOOR.get()), modLoc("block/sapphire_trapdoor"), true, "cutout");
        makeStrawberryCrop((CropBlock) ModBlocks.STRAWBERRY_CROP.get(), "strawberry_stage", "strawberry_stage");
        hangingSignBlock(ModBlocks.PINE_HANGING_SIGN.get(), ModBlocks.PINE_WALL_HANGING_SIGN.get(), blockTexture(ModBlocks.PINE_PLANKS.get()));
    }
    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(name(signBlock), texture);
        hangingSignBlock(signBlock, wallSignBlock, sign);
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
    public String name(Block block) { return key(block).getPath(); }
    private ResourceLocation key(Block block) { return ForgeRegistries.BLOCKS.getKey(block); }
    public void makeStrawberryCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> strawberryStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get()))
                        .renderType("cutout"));
    }
    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(AndrejMod.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }
    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(),
                        new ResourceLocation("minecraft:block/leaves"), "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
    private ConfiguredModel[] strawberryStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((StrawberryCropBlock) block).getAgeProperty()),
                new ResourceLocation(AndrejMod.MOD_ID, "block/" + textureName + state.getValue(((StrawberryCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

}
