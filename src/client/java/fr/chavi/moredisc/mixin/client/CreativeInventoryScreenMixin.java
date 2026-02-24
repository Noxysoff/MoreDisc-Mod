package fr.chavi.moredisc.mixin.client;

import fr.chavi.moredisc.ModDiscs;
import fr.chavi.moredisc.ModItemGroups;
import fr.chavi.moredisc.MoreDiscMod;
import java.text.Normalizer;
import java.util.Locale;
import net.minecraft.client.gui.screen.ingame.CreativeInventoryScreen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CreativeInventoryScreen.class)
public abstract class CreativeInventoryScreenMixin {
	@Shadow
	private static ItemGroup selectedTab;

	@Shadow
	private TextFieldWidget searchBox;

	@Inject(method = "search", at = @At("RETURN"))
	private void moredisc$searchDiscsBySongTitle(CallbackInfo ci) {
		if (ModItemGroups.MORE_DISC_GROUP == null || selectedTab != ModItemGroups.MORE_DISC_GROUP) {
			return;
		}

		CreativeInventoryScreen screen = (CreativeInventoryScreen) (Object) this;
		CreativeInventoryScreen.CreativeScreenHandler screenHandler = screen.getScreenHandler();
		DefaultedList<ItemStack> itemList = ((CreativeScreenHandlerAccessor) screenHandler).moredisc$getItemList();
		String query = this.searchBox == null ? "" : normalize(this.searchBox.getText());

		itemList.clear();
		for (Item disc : ModDiscs.getRegisteredDiscs()) {
			if (matchesDiscQuery(disc, query)) {
				itemList.add(new ItemStack(disc));
			}
		}

		screenHandler.scrollItems(0.0F);
	}

	private static boolean matchesDiscQuery(Item disc, String normalizedQuery) {
		if (normalizedQuery.isBlank()) {
			return true;
		}

		String discId = Registries.ITEM.getId(disc).getPath();
		String itemName = new ItemStack(disc).getName().getString();
		String songKey = "jukebox_song." + MoreDiscMod.MOD_ID + "." + discId;
		String songTitle = I18n.hasTranslation(songKey) ? I18n.translate(songKey) : discId;
		String searchableText = normalize(discId + " " + itemName + " " + songTitle);

		for (String token : normalizedQuery.split("\\s+")) {
			if (!token.isEmpty() && !searchableText.contains(token)) {
				return false;
			}
		}

		return true;
	}

	private static String normalize(String input) {
		String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
		return normalized.replaceAll("\\p{M}+", "").toLowerCase(Locale.ROOT).trim();
	}
}
