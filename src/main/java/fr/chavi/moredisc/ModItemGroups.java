package fr.chavi.moredisc;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public final class ModItemGroups {
	public static final RegistryKey<ItemGroup> MORE_DISC_GROUP_KEY =
		RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(MoreDiscMod.MOD_ID, "moredisc_discs"));

	public static ItemGroup MORE_DISC_GROUP;

	private ModItemGroups() {
	}

	public static void register() {
		MORE_DISC_GROUP = Registry.register(Registries.ITEM_GROUP, MORE_DISC_GROUP_KEY, new SearchableItemGroupBuilder()
			.asSearchGroup()
			.displayName(Text.translatable("itemGroup.moredisc.discs"))
			.icon(() -> new ItemStack(Registries.ITEM.get(Identifier.of(MoreDiscMod.MOD_ID, "disc_christmas"))))
			.entries((context, entries) -> {
				for (var disc : ModDiscs.getRegisteredDiscs()) {
					entries.add(disc);
				}
			})
			.build());
	}

	private static final class SearchableItemGroupBuilder extends ItemGroup.Builder {
		private SearchableItemGroupBuilder() {
			super(ItemGroup.Row.TOP, 0);
		}

		private SearchableItemGroupBuilder asSearchGroup() {
			this.texture(ItemGroup.getTabTextureId("item_search"));
			this.special();
			this.type(ItemGroup.Type.SEARCH);
			return this;
		}
	}
}
