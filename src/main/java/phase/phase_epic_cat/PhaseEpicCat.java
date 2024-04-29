package phase.phase_epic_cat;


import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import phase.phase_epic_cat.blocks.EpicCatBlocks;
import phase.phase_epic_cat.event.PhaseEpicCatEventHandler;
import phase.phase_epic_cat.items.EpicCatItems;
import phase.phase_epic_cat.items.EpicCatsItemGroup;

public class PhaseEpicCat implements ModInitializer, ServerWorldEvents.Load {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("phaseepiccat");
	public static final String MOD_ID = "phase_epic_cats";


	public static final PhaseEpicCatEventHandler EVENT_HANDLER = new PhaseEpicCatEventHandler();


	@Override
	public void onInitialize()
	{
		LOGGER.info("Phase's Epic Cat Mod Main initializing!");

		EpicCatsItemGroup.registerItemGroups();
		EpicCatItems.registerModItems();
		EpicCatBlocks.registerModBlocks();

		ServerWorldEvents.LOAD.register(this);
		ServerLifecycleEvents.SERVER_STOPPING.register(EVENT_HANDLER);

		LOGGER.info("Phase's Epic Cat Mod Main initialized!");
	}

	@Override
	public void onWorldLoad(MinecraftServer server, ServerWorld world) {
		if (!server.getOverworld().equals(world)) return;
		/*assert !world.isClient()*/
		EVENT_HANDLER.onWorldLoad(server, world);
	}
}