package couk.mullak99.alphacraft.common.world;

import couk.mullak99.alphacraft.common.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OreGeneration {
    public static void generateOres(final BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder builder = event.getGeneration();

        if (event.getCategory().equals(Biome.Category.NETHER)) {
            // Nether Ores

        }
        else if (event.getCategory().equals(Biome.Category.THEEND)) {
            // End Ores

        }
        else {
            // Overworld
            genOre(builder, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.NOSTALGIA_ORE.get().defaultBlockState(), 4, 1, 18, 10);
        }
    }

    private static void genOre(BiomeGenerationSettingsBuilder builder, RuleTest fillerType, BlockState state, int veinSize, int minHeight, int maxHeight, int maxPerChunk) {
        builder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                Feature.ORE.configured(new OreFeatureConfig(fillerType, state, veinSize)).decorated(Placement.RANGE
                        .configured(new TopSolidRangeConfig(minHeight, 0, maxHeight)))
                        .squared().count(maxPerChunk));
    }
}
