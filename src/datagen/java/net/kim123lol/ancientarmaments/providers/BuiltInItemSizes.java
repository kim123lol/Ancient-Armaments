package net.kim123lol.ancientarmaments.providers;

import net.kim123lol.ancientarmaments.AncientArmaments;
import net.kim123lol.ancientarmaments.common.item.ExampleModItems;
import mod.traister101.datagenutils.data.tfc.ItemSizeProvider;
import net.dries007.tfc.common.component.size.*;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

public class BuiltInItemSizes extends ItemSizeProvider {

	public BuiltInItemSizes(final PackOutput output, final CompletableFuture<Provider> lookup) {
		super(output, AncientArmaments.MOD_ID, lookup);
	}

	@Override
	protected void addData(final Provider provider) {
		add("example_size_def", size(ExampleModItems.EXAMPLE_ITEM, Size.HUGE, Weight.VERY_HEAVY));
	}
}