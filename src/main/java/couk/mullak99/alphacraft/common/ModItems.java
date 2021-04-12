package couk.mullak99.alphacraft.common;

import couk.mullak99.alphacraft.AlphaCraft;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {
    public static final RegistryObject<Item> NOSTALGIA_ESSENCE = Registry.ITEMS.register("nostalgia_essence", () ->
            new Item(new Item.Properties().tab(AlphaCraft.ALPHA_GROUP)));

    static void Register() {}
}
