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

public class PhaseEpicCat implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("phaseepiccat");
	public static final String MOD_ID = "phase_epic_cats";


	//blocks and items
	public static final Item TEST_ITEM = new Item(new FabricItemSettings());
	public static final Block TEST_BLOCK  = new Block(FabricBlockSettings.create().strength(1.0f));


	private static final ItemGroup EpicCatsItemGroup = FabricItemGroup.builder()
			.icon(() -> new ItemStack(TEST_ITEM))
					.displayName(Text.translatable("Phase's Epic Cats"))
					.entries((context, entries) ->{
						entries.add(new ItemStack(TEST_ITEM));
						entries.add(new ItemStack(TEST_BLOCK));
					})
					.build();

	@Override
	public void onInitialize()
	{
		LOGGER.info("Phase's Epic Cat Mod Main initializing!");

		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "test_item"), TEST_ITEM);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "test_block"), TEST_BLOCK);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "test_block"), new BlockItem(TEST_BLOCK, new FabricItemSettings()));
		Registry.register(Registries.ITEM_GROUP, new Identifier(MOD_ID, "phase_epic_cats"), EpicCatsItemGroup);

		LOGGER.info("Phase's Epic Cat Mod Main initialized!");
	}
}