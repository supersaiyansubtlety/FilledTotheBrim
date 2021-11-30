package com.Jack.FilledToTheBrim.mixin;


import com.Jack.FilledToTheBrim.FilledToTheBrim;
import com.Jack.FilledToTheBrim.util.nbtutil;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;




@Mixin(value = ScreenHandler.class, priority = 69)
public class ScreenHandlerMixin {
    @Redirect(method = "calculateComparatorOutput(Lnet/minecraft/inventory/Inventory;)I", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;getMaxCount()I"))
    private static int GetMaxCount(ItemStack itemStack) {
        if (!FilledToTheBrim.SHULKERBOX_COMPARATOR_OVERLOAD_FIX && nbtutil.isEmptyShulkerBox(itemStack)) {
            return 1;
        }
        return itemStack.getMaxCount();

    }
}