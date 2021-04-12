package couk.mullak99.alphacraft.data;

import couk.mullak99.alphacraft.AlphaCraft;
import couk.mullak99.alphacraft.common.ModItems;
import couk.mullak99.alphacraft.common.ModTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagProvider, AlphaCraft.MOD_ID, existingFileHelper);
    }

    @Override
    public String getName() {
        return "AlphaCraft - Items";
    }

    @Override
    protected void addTags() {
        copy(ModTags.Blocks.ORES_NOSTALGIA, ModTags.Items.ORES_NOSTALGIA);
        copy(Tags.Blocks.ORES, Tags.Items.ORES);
        copy(ModTags.Blocks.STORAGE_BLOCKS_NOSTALGIA, ModTags.Items.STORAGE_BLOCKS_NOSTALGIA);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);
        copy(ModTags.Blocks.GRASS_NOSTALGIA, ModTags.Items.GRASS_NOSTALGIA);

        tag(ModTags.Items.DUSTS_NOSTALGIA).add(ModItems.NOSTALGIA_ESSENCE.get());
        tag(Tags.Items.DUSTS).addTag(ModTags.Items.DUSTS_NOSTALGIA);
    }
}
