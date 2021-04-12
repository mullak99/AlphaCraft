package couk.mullak99.alphacraft.common;

import couk.mullak99.alphacraft.AlphaCraft;
import couk.mullak99.alphacraft.common.block.NostalgiaGrassBlock;
import couk.mullak99.alphacraft.common.block.NostalgiaLeavesBlock;
import couk.mullak99.alphacraft.common.block.NostalgiaSaplingBlock;
import couk.mullak99.alphacraft.common.block.trees.NostalgiaTree;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final RegistryObject<Block> NOSTALGIA_ORE = register("nostalgia_ore", () ->
            new Block(AbstractBlock.Properties.of(Material.STONE).strength(3.0F, 3.0F).requiresCorrectToolForDrops().harvestLevel(2).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> NOSTALGIA_BLOCK = register("nostalgia_block", () ->
            new Block(AbstractBlock.Properties.of(Material.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));
    public static final RegistryObject<Block> NOSTALGIA_COBBLESTONE = register("nostalgia_cobblestone", () ->
            new Block(AbstractBlock.Properties.of(Material.STONE).strength(2.0F, 6.0F).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
    public static final RegistryObject<SlabBlock> NOSTALGIA_COBBLESTONE_SLAB = registerSlab("nostalgia_cobblestone_slab", () ->
            new SlabBlock(AbstractBlock.Properties.of(Material.STONE).strength(2.0F, 6.0F).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
    public static final RegistryObject<StairsBlock> NOSTALGIA_COBBLESTONE_STAIRS = registerStairs("nostalgia_cobblestone_stairs", () ->
            new StairsBlock(NOSTALGIA_COBBLESTONE.get().defaultBlockState(), AbstractBlock.Properties.copy(NOSTALGIA_COBBLESTONE.get())));
    public static final RegistryObject<WallBlock> NOSTALGIA_COBBLESTONE_WALL = registerWall("nostalgia_cobblestone_wall", () ->
            new WallBlock(AbstractBlock.Properties.of(Material.STONE).strength(2.0F, 6.0F).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> NOSTALGIA_STONE = register("nostalgia_stone", () ->
            new Block(AbstractBlock.Properties.of(Material.STONE).strength(1.5F, 6.0F).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> NOSTALGIA_GRASS_BLOCK = register("nostalgia_grass_block", () ->
            new NostalgiaGrassBlock(AbstractBlock.Properties.of(Material.GRASS).randomTicks().strength(0.6F).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> NOSTALGIA_LEAVES = register("nostalgia_leaves", () ->
            new NostalgiaLeavesBlock(AbstractBlock.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(ModBlocks::ocelotOrParrot).isSuffocating(ModBlocks::never).isViewBlocking(ModBlocks::never)));
    public static final RegistryObject<Block> NOSTALGIA_SAPLING = register("nostalgia_sapling", () ->
            new NostalgiaSaplingBlock(new NostalgiaTree(), AbstractBlock.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));

    static void Register() {}

    private static <T extends Block>RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
        return Registry.BLOCKS.register(name, block);
    }

    private static <T extends Block>RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> ret = registerNoItem(name, block);
        Registry.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties().tab(AlphaCraft.ALPHA_GROUP)));
        return ret;
    }

    private static <T extends SlabBlock>RegistryObject<T> registerSlab(String name, Supplier<T> block) {
        RegistryObject<T> ret = registerNoItem(name, block);
        Registry.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties().tab(AlphaCraft.ALPHA_GROUP)));
        return ret;
    }

    private static <T extends StairsBlock>RegistryObject<T> registerStairs(String name, Supplier<T> block) {
        RegistryObject<T> ret = registerNoItem(name, block);
        Registry.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties().tab(AlphaCraft.ALPHA_GROUP)));
        return ret;
    }

    private static <T extends WallBlock>RegistryObject<T> registerWall(String name, Supplier<T> block) {
        RegistryObject<T> ret = registerNoItem(name, block);
        Registry.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties().tab(AlphaCraft.ALPHA_GROUP)));
        return ret;
    }

    private static boolean always(BlockState blockState, IBlockReader iBlockReader, BlockPos blockPos) {
        return true;
    }

    private static boolean never(BlockState blockState, IBlockReader iBlockReader, BlockPos blockPos) {
        return false;
    }

    private static Boolean ocelotOrParrot(BlockState blockState, IBlockReader iBlockReader, BlockPos blockPos, EntityType<?> entityType) {
        return entityType == EntityType.OCELOT || entityType == EntityType.PARROT;
    }
}
