package couk.mullak99.alphacraft.common.block.trees;

import couk.mullak99.alphacraft.common.ModFeatures;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class NostalgiaTree extends Tree {
    @Nullable
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getConfiguredFeature(Random p_225546_1_, boolean p_225546_2_) {
        if (p_225546_1_.nextInt(10) == 0) {
            return ModFeatures.BIG_ALPHA;
        } else {
            return ModFeatures.ALPHA;
        }
    }
}
