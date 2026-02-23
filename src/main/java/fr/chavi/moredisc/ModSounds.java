package fr.chavi.moredisc;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public final class ModSounds {
	public static final SoundEvent MUSIC_DISC_CHRISTMAS = register("music_disc.christmas");
	public static final SoundEvent MUSIC_DISC_FEMBOY = register("music_disc.femboy");
	public static final SoundEvent MUSIC_DISC_GIMME_MORE = register("music_disc.gimme_more");
	public static final SoundEvent MUSIC_DISC_DRAKE_GODS_PLAN = register("music_disc.drake_gods_plan");
	public static final SoundEvent MUSIC_DISC_OLD_TOWN_ROAD = register("music_disc.old_town_road");
	public static final SoundEvent MUSIC_DISC_MANEATER = register("music_disc.maneater");
	public static final SoundEvent MUSIC_DISC_CONFINE = register("music_disc.confine");
	public static final SoundEvent MUSIC_DISC_ROCK_YOUR_BODY = register("music_disc.rock_your_body");
	public static final SoundEvent MUSIC_DISC_MUSIC_SOUNDS_BETTER_WITH_YOU_RADIO_EDIT =
		register("music_disc.music_sounds_better_with_you_radio_edit");
	public static final SoundEvent MUSIC_DISC_MEANINGFUL_LOVE_SLOWED_INSTRUMENTAL =
		register("music_disc.meaningful_love_slowed_instrumental");
	public static final SoundEvent MUSIC_DISC_FOR_SURE = register("music_disc.for_sure");

	private ModSounds() {
	}

	private static SoundEvent register(String path) {
		Identifier id = Identifier.of(MoreDiscMod.MOD_ID, path);
		return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
	}

	public static void register() {
		MoreDiscMod.LOGGER.info("Registered custom sound events for {}.", MoreDiscMod.MOD_ID);
	}
}
