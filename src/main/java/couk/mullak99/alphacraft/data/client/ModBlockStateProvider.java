package couk.mullak99.alphacraft.data.client;

import couk.mullak99.alphacraft.AlphaCraft;
import couk.mullak99.alphacraft.common.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import static couk.mullak99.alphacraft.AlphaCraft.modId;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, AlphaCraft.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.NOSTALGIA_ORE.get());
        simpleBlock(ModBlocks.NOSTALGIA_BLOCK.get());
        simpleBlock(ModBlocks.NOSTALGIA_COBBLESTONE.get());
        slabBlock(ModBlocks.NOSTALGIA_COBBLESTONE_SLAB.get(), modId("block/nostalgia_cobblestone"), modId("block/nostalgia_cobblestone"));
        stairsBlock(ModBlocks.NOSTALGIA_COBBLESTONE_STAIRS.get(), modId("block/nostalgia_cobblestone"));
        wallBlock(ModBlocks.NOSTALGIA_COBBLESTONE_WALL.get(), modId("block/nostalgia_cobblestone"));
        simpleBlock(ModBlocks.NOSTALGIA_STONE.get());
        grassBlock(ModBlocks.NOSTALGIA_GRASS_BLOCK.get(), mcLoc("block/dirt"),
                modId("block/nostalgia_grass_block_top"), modId("block/nostalgia_grass_block_side"),
                mcLoc("block/dirt"));
        leavesBlock(ModBlocks.NOSTALGIA_LEAVES.get());
        crossBlock(ModBlocks.NOSTALGIA_SAPLING.get());
    }

    private void grassBlock(Block block, ResourceLocation bottom, ResourceLocation top, ResourceLocation side, ResourceLocation particle) {
        getVariantBuilder(block).forAllStates(state -> {
            String name = "block/" + name(block);
            return ConfiguredModel.builder()
                    .modelFile(models()
                            .withExistingParent(name, mcLoc("block/cube_bottom_top"))
                            .texture("particle", particle)
                            .texture("bottom", bottom)
                            .texture("top", top)
                            .texture("side", side))
                    .build();
        });
    }

    private void crossBlock(Block block) {
        getVariantBuilder(block).forAllStates(state -> {
            String name = "block/" + name(block);
            return ConfiguredModel.builder()
                    .modelFile(models()
                            .withExistingParent(name, mcLoc("block/cross"))
                            .texture("cross", modId("block/" + name(block))))
                    .build();
        });
    }

    private void leavesBlock(Block block) {
        getVariantBuilder(block).forAllStates(state -> {
            String name = "block/" + name(block);
            return ConfiguredModel.builder()
                    .modelFile(models()
                            .withExistingParent(name, mcLoc("block/leaves"))
                            .texture("all", modId("block/" + name(block))))
                    .build();
        });
    }

    private String name(Block block) {
        return block.getRegistryName().getPath();
    }
}
