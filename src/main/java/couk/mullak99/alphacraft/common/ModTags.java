package couk.mullak99.alphacraft.common;

import couk.mullak99.alphacraft.AlphaCraft;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class ModTags {
    public static final class Blocks {
        public static final ITag.INamedTag<Block> ORES_NOSTALGIA = forge("ores/nostalgia_ore");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_NOSTALGIA = forge("storage_blocks/nostalgia_block");
        public static final ITag.INamedTag<Block> GRASS_NOSTALGIA = forge("dirt/nostalgia_grass_block");
        public static final ITag.INamedTag<Block> WALL_COBBLESTONE_NOSTALGIA = forge("walls/nostalgia_cobblestone_wall");
        public static final ITag.INamedTag<Block> SLAB_COBBLESTONE_NOSTALGIA = forge("slabs/nostalgia_cobblestone_slab");
        public static final ITag.INamedTag<Block> STAIRS_COBBLESTONE_NOSTALGIA = forge("stairs/nostalgia_cobblestone_stairs");
        public static final ITag.INamedTag<Block> SAPLING_NOSTALGIA = forge("sapling/nostalgia_sapling");
        public static final ITag.INamedTag<Block> LEAVES_NOSTALGIA = forge("leaves/nostalgia_leaves");

        private static ITag.INamedTag<Block> forge(String path) {
            return BlockTags.bind(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Block> mod(String path) {
            return BlockTags.bind(new ResourceLocation(AlphaCraft.MOD_ID, path).toString());
        }
    }

    public static final class Items {
        public static final ITag.INamedTag<Item> ORES_NOSTALGIA = forge("ores/nostalgia_ore");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_NOSTALGIA = forge("storage_blocks/nostalgia_block");
        public static final ITag.INamedTag<Item> GRASS_NOSTALGIA = forge("dirt/nostalgia_grass_block");

        public static final ITag.INamedTag<Item> DUSTS_NOSTALGIA = forge("dust/nostalgia_essence");

        private static ITag.INamedTag<Item> forge(String path) {
            return ItemTags.bind(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Item> mod(String path) {
            return ItemTags.bind(new ResourceLocation(AlphaCraft.MOD_ID, path).toString());
        }
    }
}
