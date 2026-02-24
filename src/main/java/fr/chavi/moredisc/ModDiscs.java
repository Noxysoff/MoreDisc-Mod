package fr.chavi.moredisc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public final class ModDiscs {
	public static final int TRACK_COUNT = 23;

	private static final DiscDefinition[] DISC_DEFINITIONS = {
		new DiscDefinition("disc_christmas", "disc_christmas", Rarity.RARE),
		new DiscDefinition("disc_femboy", "disc_femboy", Rarity.EPIC),
		new DiscDefinition("disc_gimme_more", "disc_gimme_more", Rarity.RARE),
		new DiscDefinition("disc_drake_gods_plan", "disc_drake_gods_plan", Rarity.EPIC),
		new DiscDefinition("disc_old_town_road", "disc_old_town_road", Rarity.RARE),
		new DiscDefinition("disc_maneater", "disc_maneater", Rarity.EPIC),
		new DiscDefinition("disc_confine", "disc_confine", Rarity.RARE),
		new DiscDefinition("disc_rock_your_body", "disc_rock_your_body", Rarity.EPIC),
		new DiscDefinition(
			"disc_music_sounds_better_with_you_radio_edit",
			"disc_music_sounds_better_with_you_radio_edit",
			Rarity.EPIC
		),
		new DiscDefinition(
			"disc_meaningful_love_slowed_instrumental",
			"disc_meaningful_love_slowed_instrumental",
			Rarity.RARE
		),
		new DiscDefinition("disc_for_sure", "disc_for_sure", Rarity.RARE),
		new DiscDefinition("disc_millionaire", "disc_millionaire", Rarity.RARE),
		new DiscDefinition("disc_miel_pops", "disc_miel_pops", Rarity.EPIC),
		new DiscDefinition("disc_the_days_notion_remix", "disc_the_days_notion_remix", Rarity.RARE),
		new DiscDefinition("disc_promiscuous", "disc_promiscuous", Rarity.RARE),
		new DiscDefinition("disc_its_my_bass", "disc_its_my_bass", Rarity.RARE),
		new DiscDefinition(
			"disc_offender_dimension_grafix_remix",
			"disc_offender_dimension_grafix_remix",
			Rarity.RARE
		),
		new DiscDefinition(
			"disc_rick_astley_never_gonna_give_you_up_rick",
			"disc_rick_astley_never_gonna_give_you_up_rick",
			Rarity.EPIC
		),
		new DiscDefinition("disc_give_it_to_me_02", "disc_give_it_to_me_02", Rarity.RARE),
		new DiscDefinition("disc_im_a_pancake", "disc_im_a_pancake", Rarity.EPIC),
		new DiscDefinition("disc_tf1", "disc_tf1", Rarity.EPIC),
		new DiscDefinition("disc_psycho_nv", "disc_psycho_nv", Rarity.RARE),
		new DiscDefinition("disc_panic_room", "disc_panic_room", Rarity.RARE)
	};

	private static final List<Item> REGISTERED_DISCS = new ArrayList<>();

	private ModDiscs() {
	}

	public static void register() {
		for (DiscDefinition definition : DISC_DEFINITIONS) {
			RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, id(definition.itemId()));
			RegistryKey<JukeboxSong> songKey = RegistryKey.of(RegistryKeys.JUKEBOX_SONG, id(definition.songId()));

			Item disc = new Item(new Item.Settings()
				.maxCount(1)
				.rarity(definition.rarity())
				.jukeboxPlayable(songKey)
				.registryKey(itemKey)
			);

			REGISTERED_DISCS.add(Registry.register(Registries.ITEM, itemKey, disc));
		}

		MoreDiscMod.LOGGER.info("Registered {} music discs.", REGISTERED_DISCS.size());
	}

	public static List<Item> getRegisteredDiscs() {
		return Collections.unmodifiableList(REGISTERED_DISCS);
	}

	public static boolean isDisc(Item item) {
		return REGISTERED_DISCS.contains(item);
	}

	private static Identifier id(String path) {
		return Identifier.of(MoreDiscMod.MOD_ID, path);
	}

	private record DiscDefinition(String itemId, String songId, Rarity rarity) {
	}
}
