package couk.mullak99.alphacraft.data;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import couk.mullak99.alphacraft.common.ModBlocks;
import couk.mullak99.alphacraft.common.ModItems;
import couk.mullak99.alphacraft.common.Registry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.*;
import net.minecraft.loot.functions.ApplyBonus;
import net.minecraft.loot.functions.SetCount;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;
import net.minecraftforge.fml.RegistryObject;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ModLootTableProvider extends LootTableProvider {
    public ModLootTableProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    public String getName() {
        return "AlphaCraft - Loot Tables";
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
        return ImmutableList.of(
                Pair.of(ModBlockLootTables::new, LootParameterSets.BLOCK)
        );
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationtracker) {
        map.forEach((p_218436_2_, p_218436_3_) -> LootTableManager.validate(validationtracker, p_218436_2_, p_218436_3_));
    }

    public static class ModBlockLootTables extends BlockLootTables {
        @Override
        protected void addTables() {
            dropItemsFromOre(ModBlocks.NOSTALGIA_ORE.get(), ModItems.NOSTALGIA_ESSENCE.get(), 4.0F, 5.0F);
            dropOtherFromBlock(ModBlocks.NOSTALGIA_STONE.get(), ModBlocks.NOSTALGIA_COBBLESTONE.get());
            dropSelf(ModBlocks.NOSTALGIA_BLOCK.get());
            dropSelf(ModBlocks.NOSTALGIA_COBBLESTONE.get());
            dropSelf(ModBlocks.NOSTALGIA_COBBLESTONE_SLAB.get());
            dropSelf(ModBlocks.NOSTALGIA_COBBLESTONE_STAIRS.get());
            dropSelf(ModBlocks.NOSTALGIA_COBBLESTONE_WALL.get());
            dropOtherFromBlock(ModBlocks.NOSTALGIA_GRASS_BLOCK.get(), Blocks.DIRT);
            oakLeavesDrop(ModBlocks.NOSTALGIA_LEAVES.get(), ModBlocks.NOSTALGIA_SAPLING.get());
            dropSelf(ModBlocks.NOSTALGIA_SAPLING.get());
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return Registry.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get)
                    .collect(Collectors.toList());
        }

        private void dropItemsFromOre(Block block, IItemProvider item, float min, float max) {
            this.add(block, (p_218464_0_) -> createSilkTouchDispatchTable(p_218464_0_,
                    applyExplosionDecay(p_218464_0_, ItemLootEntry.lootTableItem(item)
                            .apply(SetCount.setCount(RandomValueRange.between(4.0F, 5.0F)))
                            .apply(ApplyBonus.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))));
        }

        private void dropOtherFromBlock(Block orig, Block drop) {
            this.add(orig, (p_218490_0_) -> createSingleItemTableWithSilkTouch(p_218490_0_, drop));
        }

        private void oakLeavesDrop(Block block, Block sapling) {
            this.add(block, (p_218506_0_) -> {
                return createOakLeavesDrops(p_218506_0_, sapling, new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F});
            });
        }
    }
}
