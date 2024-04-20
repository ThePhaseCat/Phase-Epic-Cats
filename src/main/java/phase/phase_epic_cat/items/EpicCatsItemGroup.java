package phase.phase_epic_cat.items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.entity.boss.dragon.phase.Phase;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import phase.phase_epic_cat.PhaseEpicCat;

public class EpicCatsItemGroup
{

    public static final ItemGroup EpicCatsItemGroup = Registry.register(Registries.ITEM_GROUP,
            new Identifier(PhaseEpicCat.MOD_ID, "epic_cats_item_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.name"))
                    .icon(() -> new ItemStack(EpicCatItems.TEST_ITEM)).entries((displayContext, entries) -> {
                        entries.add(EpicCatItems.TEST_ITEM);
                        entries.add(PhaseEpicCat.TEST_BLOCK.asItem());

                        entries.add(Items.DIAMOND);


                    }).build());

    public static void registerItemGroups()
    {
        PhaseEpicCat.LOGGER.info("Registering item groups for " + PhaseEpicCat.MOD_ID + "...");
    }
}
