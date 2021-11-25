package com.Jack.FilledToTheBrim.mixin;


import com.Jack.FilledToTheBrim.FilledToTheBrim;
import com.Jack.FilledToTheBrim.util.nbtutil;

import net.minecraft.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = ItemStack.class, priority = 69)
public class ItemStackMixin {




    @Inject(method = "getMaxCount", at = @At("HEAD"), cancellable = true)
    private void ShulkerStackSize(CallbackInfoReturnable<Integer> ci) {

        if (nbtutil.isEmptyShulkerBox(((ItemStack) (Object) this)) && FilledToTheBrim.IS_ENABLED) {
            //TODO: Fix This Not Working in Non Dev For Some Reason (Works But Does Not Effect Comparators) Might Be Connected to another Mod
            ci.setReturnValue(FilledToTheBrim.SHULKERBOX_STACK_SIZE);

        }

    }

}
