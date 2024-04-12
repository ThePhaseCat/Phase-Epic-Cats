package phase.phase_epic_cat;

import io.wispforest.owo.registration.reflect.FieldRegistrationHandler;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import phase.phase_epic_cat.items.ItemInit;

public class PhaseEpicCat implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("phaseepiccat");
	public static final String MOD_ID = "phase_epic_cats";

	private static final ItemGroup EpicCatsItemGroup = FabricItemGroup.builder()
			.icon(() -> new ItemStack(ItemInit.TEST))
			.displayName(Text.translatable("Phase's Epic Cats"))
			.entries((context, entries) ->{
				entries.add(new ItemStack(ItemInit.TEST));
			})
			.build();

	@Override
	public void onInitialize()
	{
		LOGGER.info("Phase's Epic Cat Mod Main initializing!");
		FieldRegistrationHandler.register(ItemInit.class, MOD_ID, false);
		Registry.register(Registries.ITEM_GROUP, new Identifier(MOD_ID, "phase_epic_cats"), EpicCatsItemGroup);
		LOGGER.info("Phase's Epic Cat Mod Main initialized!");
	}
}