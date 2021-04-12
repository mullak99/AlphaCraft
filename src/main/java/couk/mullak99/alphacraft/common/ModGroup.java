package couk.mullak99.alphacraft.common;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModGroup extends ItemGroup {
    public ModGroup(String label) {
        super(label);
    }

    @Override
    public ItemStack makeIcon() {
        return ModBlocks.NOSTALGIA_GRASS_BLOCK.get().asItem().getDefaultInstance();
    }
}
