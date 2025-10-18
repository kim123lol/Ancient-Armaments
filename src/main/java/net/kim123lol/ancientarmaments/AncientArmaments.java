package net.kim123lol.ancientarmaments;

import com.mojang.logging.LogUtils;
import net.kim123lol.ancientarmaments.common.item.ModCreativeModeTabs;
import net.kim123lol.ancientarmaments.common.item.ModItems;
import net.kim123lol.ancientarmaments.common.item.metal.WeaponItems;
import net.neoforged.bus.api.*;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

@Mod(AncientArmaments.MOD_ID)
public class AncientArmaments {
    public static final String MOD_ID = "ancientarms";
    public static final Logger LOGGER = LogUtils.getLogger();

    public AncientArmaments(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        ModCreativeModeTabs.register(modEventBus);
        WeaponItems.register(modEventBus);
        ModItems.register(modEventBus);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
}