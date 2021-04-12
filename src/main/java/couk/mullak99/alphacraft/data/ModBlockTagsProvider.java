package couk.mullak99.alphacraft.data;

import couk.mullak99.alphacraft.AlphaCraft;
import couk.mullak99.alphacraft.common.ModBlocks;
import couk.mullak99.alphacraft.common.ModTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
        super(generatorIn, AlphaCraft.MOD_ID, existingFileHelper);
    }

    @Override
    public String getName() {
        return "AlphaCraft - Blocks";
    }

    @Override
    protected void addTags() {
        tag(ModTags.Blocks.ORES_NOSTALGIA).add(ModBlocks.NOSTALGIA_ORE.get());
        tag(Tags.Blocks.ORES).addTag(ModTags.Blocks.ORES_NOSTALGIA);

        tag(ModTags.Blocks.STORAGE_BLOCKS_NOSTALGIA).add(ModBlocks.NOSTALGIA_BLOCK.get());
        tag(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.STORAGE_BLOCKS_NOSTALGIA);

        tag(ModTags.Blocks.GRASS_NOSTALGIA).add(ModBlocks.NOSTALGIA_GRASS_BLOCK.get());
        tag(Tags.Blocks.DIRT).addTag(ModTags.Blocks.GRASS_NOSTALGIA);
        tag(BlockTags.VALID_SPAWN).addTag(ModTags.Blocks.GRASS_NOSTALGIA);
        tag(BlockTags.BAMBOO_PLANTABLE_ON).addTag(ModTags.Blocks.GRASS_NOSTALGIA);

        tag(ModTags.Blocks.SLAB_COBBLESTONE_NOSTALGIA).add(ModBlocks.NOSTALGIA_COBBLESTONE_SLAB.get());
        tag(BlockTags.SLABS).addTag(ModTags.Blocks.SLAB_COBBLESTONE_NOSTALGIA);

        tag(ModTags.Blocks.STAIRS_COBBLESTONE_NOSTALGIA).add(ModBlocks.NOSTALGIA_COBBLESTONE_STAIRS.get());
        tag(BlockTags.STAIRS).addTag(ModTags.Blocks.STAIRS_COBBLESTONE_NOSTALGIA);

        tag(ModTags.Blocks.WALL_COBBLESTONE_NOSTALGIA).add(ModBlocks.NOSTALGIA_COBBLESTONE_WALL.get());
        tag(BlockTags.WALLS).addTag(ModTags.Blocks.WALL_COBBLESTONE_NOSTALGIA);

        tag(ModTags.Blocks.SAPLING_NOSTALGIA).add(ModBlocks.NOSTALGIA_SAPLING.get());
        tag(BlockTags.SAPLINGS).addTag(ModTags.Blocks.SAPLING_NOSTALGIA);

        tag(ModTags.Blocks.LEAVES_NOSTALGIA).add(ModBlocks.NOSTALGIA_LEAVES.get());
        tag(BlockTags.LEAVES).addTag(ModTags.Blocks.LEAVES_NOSTALGIA);
    }
}
