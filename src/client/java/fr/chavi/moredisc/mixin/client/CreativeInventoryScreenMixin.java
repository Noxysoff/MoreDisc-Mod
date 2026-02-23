package fr.chavi.moredisc.mixin.client;

import fr.chavi.moredisc.ModDiscs;
import fr.chavi.moredisc.ModItemGroups;
import net.minecraft.client.gui.screen.ingame.CreativeInventoryScreen;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
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

	@Inject(method = "search", at = @At("RETURN"))
	private void moredisc$filterSearchToDiscsOnly(CallbackInfo ci) {
		if (ModItemGroups.MORE_DISC_GROUP == null || selectedTab != ModItemGroups.MORE_DISC_GROUP) {
			return;
		}

		CreativeInventoryScreen screen = (CreativeInventoryScreen) (Object) this;
		CreativeInventoryScreen.CreativeScreenHandler screenHandler = screen.getScreenHandler();
		DefaultedList<ItemStack> itemList = ((CreativeScreenHandlerAccessor) screenHandler).moredisc$getItemList();
		itemList.removeIf(stack -> !ModDiscs.isDisc(stack.getItem()));
		screenHandler.scrollItems(0.0F);
	}
}
