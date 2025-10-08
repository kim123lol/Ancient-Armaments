package net.kim123lol.ancientarmaments.common.item.metal;

import net.dries007.tfc.common.TFCTiers;
import net.kim123lol.ancientarmaments.AncientArmaments;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class WeaponItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AncientArmaments.MOD_ID);

    public static final DeferredItem<SwordItem> DAGGER = ITEMS.register("copper_dagger",
            () -> new SwordItem(TFCTiers.COPPER, new Item.Properties()
                    .attributes(SwordItem.createAttributes(TFCTiers.COPPER,5,3f))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

    }

}
