package fr.chavi.moredisc;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreDiscMod implements ModInitializer {
	public static final String MOD_ID = "moredisc";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModSounds.register();
		ModDiscs.register();
		ModItemGroups.register();
		LOGGER.info("Loaded {} with {} custom music discs.", MOD_ID, ModDiscs.TRACK_COUNT);
	}
}
