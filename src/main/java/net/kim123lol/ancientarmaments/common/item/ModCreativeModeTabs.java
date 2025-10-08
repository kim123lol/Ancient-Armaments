package net.kim123lol.ancientarmaments.common.item;

import net.kim123lol.ancientarmaments.AncientArmaments;
import net.kim123lol.ancientarmaments.common.item.metal.WeaponItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AncientArmaments.MOD_ID);


    public static final Supplier<CreativeModeTab> ANCIENT_ARMAMENTS_WEAPON_TAB = CREATIVE_MODE_TAB.register("ancient_armaments_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(WeaponItems.DAGGER.get()))
                    .title((Component.translatable("creativetab.ancientarms.dagger_items")))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(WeaponItems.DAGGER);
                    })




                    .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
