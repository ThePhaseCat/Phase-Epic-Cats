package phase.phase_epic_cat.items;

import io.wispforest.owo.registration.reflect.ItemRegistryContainer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public class ItemInit implements ItemRegistryContainer
{
    public static final Item TEST = new Item(new FabricItemSettings());
}
