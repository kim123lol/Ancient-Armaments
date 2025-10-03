package net.kim123lol.ancientarmaments;

import net.kim123lol.ancientarmaments.client.*;
import net.kim123lol.ancientarmaments.client.ExampleModClientEvents;
import net.kim123lol.ancientarmaments.client.ExampleModClientForgeEvents;
import net.kim123lol.ancientarmaments.common.item.ExampleModItems;
import net.kim123lol.ancientarmaments.config.ExampleModConfig;
import net.kim123lol.ancientarmaments.network.ExampleModPackets;
import com.mojang.logging.LogUtils;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.*;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig.Type;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.slf4j.Logger;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab.TabVisibility;
import net.minecraft.world.item.CreativeModeTabs;

@Mod(AncientArmaments.MOD_ID)
public final class AncientArmaments {

	public static final Logger LOG = LogUtils.getLogger();
	public static final String MOD_ID = "ancientarms";

	public AncientArmaments(final ModContainer modContainer, final IEventBus modBus, final Dist dist) {
		modBus.addListener(ExampleModPackets::init);

		// You likely don't want all of these.
		modContainer.registerConfig(Type.COMMON, ExampleModConfig.COMMON.spec());
		modContainer.registerConfig(Type.CLIENT, ExampleModConfig.CLIENT.spec());
		modContainer.registerConfig(Type.SERVER, ExampleModConfig.SERVER.spec());
		modContainer.registerConfig(Type.STARTUP, ExampleModConfig.STARTUP.spec());

		modBus.register(AncientArmaments.class);
		ExampleModItems.ITEMS.register(modBus);

		ExampleModForgeEvents.init(NeoForge.EVENT_BUS);

		if (dist == Dist.CLIENT) {
			ExampleModClientEvents.init(modContainer, modBus);
			ExampleModClientForgeEvents.init(NeoForge.EVENT_BUS);
		}
	}

	@SubscribeEvent
	private static void onCreativeTabBuild(final BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			event.accept(ExampleModItems.EXAMPLE_ITEM.toStack(), TabVisibility.PARENT_AND_SEARCH_TABS);
		}
	}

	/**
	 * Shorthand for {@code ResourceLocation.fromNamespaceAndPath(MOD_ID, path)}
	 */
	public static ResourceLocation location(final String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}

	/**
	 * Helper for creating modid prepended lang keys
	 */
	public static String lang(final String langKey) {
		return MOD_ID + "." + langKey;
	}
}