package fr.chavi.moredisc.mixin.client;

import net.minecraft.client.gui.screen.ingame.CreativeInventoryScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(CreativeInventoryScreen.CreativeScreenHandler.class)
public interface CreativeScreenHandlerAccessor {
	@Accessor("itemList")
	DefaultedList<ItemStack> moredisc$getItemList();
}
