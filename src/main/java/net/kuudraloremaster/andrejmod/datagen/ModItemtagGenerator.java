package net.kuudraloremaster.andrejmod.datagen;

import net.kuudraloremaster.andrejmod.AndrejMod;
import net.kuudraloremaster.andrejmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.crafting.conditions.AndCondition;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemtagGenerator extends ItemTagsProvider {
    public ModItemtagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, AndrejMod.MOD_ID,existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.SAPPHIRE_HELMET.get(),
                        ModItems.SAPPHIRE_BOOTS.get(),
                        ModItems.SAPPHIRE_CHESTPLATE.get(),
                        ModItems.SAPPHIRE_LEGGINGS.get(),
                        ModItems.KUUDRA_FOLLOWER_BOOTS.get(),
                        ModItems.KUUDRA_FOLLOWER_CHESTPLATE.get(),
                        ModItems.KUUDRA_FOLLOWER_HELMET.get(),
                        ModItems.KUUDRA_FOLLOWER_LEGGINGS.get(),
                        ModItems.MAID_LEGGINGS.get(),
                        ModItems.MAID_HELMET.get(),
                        ModItems.MAID_CHESTPLATE.get(),
                        ModItems.MAID_BOOTS.get()

                );}
}
