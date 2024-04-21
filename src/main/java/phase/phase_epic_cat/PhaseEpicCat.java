package phase.phase_epic_cat;

import io.wispforest.owo.registration.reflect.FieldRegistrationHandler;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import phase.phase_epic_cat.blocks.EpicCatBlocks;
import phase.phase_epic_cat.items.EpicCatItems;
import phase.phase_epic_cat.items.EpicCatsItemGroup;

public class PhaseEpicCat implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("phaseepiccat");
	public static final String MOD_ID = "phase_epic_cats";


	@Override
	public void onInitialize()
	{
		LOGGER.info("Phase's Epic Cat Mod Main initializing!");

		EpicCatsItemGroup.registerItemGroups();
		EpicCatItems.registerModItems();
		EpicCatBlocks.registerModBlocks();


		LOGGER.info("Phase's Epic Cat Mod Main initialized!");
	}
}