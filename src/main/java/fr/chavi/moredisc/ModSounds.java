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
	public static final SoundEvent MUSIC_DISC_MILLIONAIRE = register("music_disc.millionaire");
	public static final SoundEvent MUSIC_DISC_MIEL_POPS = register("music_disc.miel_pops");
	public static final SoundEvent MUSIC_DISC_THE_DAYS_NOTION_REMIX = register("music_disc.the_days_notion_remix");
	public static final SoundEvent MUSIC_DISC_PROMISCUOUS = register("music_disc.promiscuous");
	public static final SoundEvent MUSIC_DISC_ITS_MY_BASS = register("music_disc.its_my_bass");
	public static final SoundEvent MUSIC_DISC_OFFENDER_DIMENSION_GRAFIX_REMIX =
		register("music_disc.offender_dimension_grafix_remix");
	public static final SoundEvent MUSIC_DISC_RICK_ASTLEY_NEVER_GONNA_GIVE_YOU_UP_RICK =
		register("music_disc.rick_astley_never_gonna_give_you_up_rick");
	public static final SoundEvent MUSIC_DISC_GIVE_IT_TO_ME_02 = register("music_disc.give_it_to_me_02");
	public static final SoundEvent MUSIC_DISC_IM_A_PANCAKE = register("music_disc.im_a_pancake");
	public static final SoundEvent MUSIC_DISC_TF1 = register("music_disc.tf1");
	public static final SoundEvent MUSIC_DISC_PSYCHO_NV = register("music_disc.psycho_nv");
	public static final SoundEvent MUSIC_DISC_PANIC_ROOM = register("music_disc.panic_room");
	public static final SoundEvent MUSIC_DISC_JOYCA_TRUE_DU_Q = register("music_disc.joyca_true_du_q");
	public static final SoundEvent MUSIC_DISC_MASTU_BELEK = register("music_disc.mastu_belek");
	public static final SoundEvent MUSIC_DISC_NIGHTMARE_AZARI = register("music_disc.nightmare_azari");
	public static final SoundEvent MUSIC_DISC_ON_DAT_BXTCH_SLOWED = register("music_disc.on_dat_bxtch_slowed");
	public static final SoundEvent MUSIC_DISC_OOYY_COME_2GETHER_BASS_BOOSTED =
		register("music_disc.ooyy_come_2gether_bass_boosted");
	public static final SoundEvent MUSIC_DISC_THE_VOID_SLOWED = register("music_disc.the_void_slowed");
	public static final SoundEvent MUSIC_DISC_VAPORCHROME_DECKED_SLOWED_REVERB =
		register("music_disc.vaporchrome_decked_slowed_reverb");
	public static final SoundEvent MUSIC_DISC_WE_FELL_APART_SLOWED = register("music_disc.we_fell_apart_slowed");
	public static final SoundEvent MUSIC_DISC_FINE_LINE_INSTRUMENTAL = register("music_disc.fine_line_instrumental");
	public static final SoundEvent MUSIC_DISC_YOUR_SPELL = register("music_disc.your_spell");
	public static final SoundEvent MUSIC_DISC_RIGHT_HERE_RIGHT_NOW = register("music_disc.right_here_right_now");
	public static final SoundEvent MUSIC_DISC_POKER_FACE = register("music_disc.poker_face");
	public static final SoundEvent MUSIC_DISC_ONE_MORE_TIME = register("music_disc.one_more_time");
	public static final SoundEvent MUSIC_DISC_NIGHTCALL = register("music_disc.nightcall");
	public static final SoundEvent MUSIC_DISC_CLASH_ASSASSINS = register("music_disc.clash_assassins");
	public static final SoundEvent MUSIC_DISC_ATHENA_SMLE_ETERNAL = register("music_disc.athena_smle_eternal");

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
