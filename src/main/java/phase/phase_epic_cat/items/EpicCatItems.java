package phase.phase_epic_cat.items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import phase.phase_epic_cat.PhaseEpicCat;

public class EpicCatItems
{
    public static final Item TEST_ITEM = registerItem("test_item", new Item(new Item.Settings()));

    //cat embryo is the "base" egg that you need to combine with other items
    //to get a cat spawn egg of that type
    public static final Item CAT_EMBRYO = registerItem("cat_embryo", new Item(new Item.Settings()));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries)
    {
        entries.add(TEST_ITEM);
        entries.add(CAT_EMBRYO);
    }

    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, new Identifier(PhaseEpicCat.MOD_ID, name), item);
    }

    public static void registerModItems()
    {
        PhaseEpicCat.LOGGER.info("Registering items for " + PhaseEpicCat.MOD_ID + "...");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(EpicCatItems::addItemsToIngredientItemGroup);
    }
}
