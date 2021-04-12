package couk.mullak99.alphacraft.data.client;

import couk.mullak99.alphacraft.AlphaCraft;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, AlphaCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent("nostalgia_ore", modLoc("block/nostalgia_ore"));
        withExistingParent("nostalgia_block", modLoc("block/nostalgia_block"));
        withExistingParent("nostalgia_cobblestone", modLoc("block/nostalgia_cobblestone"));
        withExistingParent("nostalgia_cobblestone_slab", modLoc("block/nostalgia_cobblestone_slab"));
        withExistingParent("nostalgia_cobblestone_stairs", modLoc("block/nostalgia_cobblestone_stairs"));
        withExistingParent("nostalgia_stone", modLoc("block/nostalgia_stone"));
        withExistingParent("nostalgia_grass_block", modLoc("block/nostalgia_grass_block"));
        withExistingParent("nostalgia_leaves", modLoc("block/nostalgia_leaves"));

        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));

        ItemBuilder(itemGenerated, "nostalgia_essence");
        ItemBuilderAsBlock(itemGenerated, "nostalgia_sapling");
        WallItemBuilder("nostalgia_cobblestone_wall", modLoc("block/nostalgia_cobblestone"));
    }

    private ItemModelBuilder ItemBuilder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }

    private ItemModelBuilder ItemBuilderAsBlock(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "block/" + name);
    }

    private ItemModelBuilder WallItemBuilder(String name, ResourceLocation tex) {
        ModelFile model = getExistingFile(mcLoc("block/wall_inventory"));
        return getBuilder(name).parent(model).texture("wall", tex);
    }
}
