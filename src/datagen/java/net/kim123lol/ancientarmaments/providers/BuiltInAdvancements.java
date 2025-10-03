package net.kim123lol.ancientarmaments.providers;

import net.kim123lol.ancientarmaments.advancement.ExampleAdvancements;
import mod.traister101.datagenutils.data.EnhancedAdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public final class BuiltInAdvancements {

	public static EnhancedAdvancementProvider create(final PackOutput output, final CompletableFuture<Provider> registries,
			final ExistingFileHelper existingFileHelper) {
		return new EnhancedAdvancementProvider(output, registries, existingFileHelper, List.of(new ExampleAdvancements()));
	}
}