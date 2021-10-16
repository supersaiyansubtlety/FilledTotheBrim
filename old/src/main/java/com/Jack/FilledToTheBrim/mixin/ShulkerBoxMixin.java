package com.Jack.FilledToTheBrim.mixin;


import net.minecraft.screen.slot.ShulkerBoxSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ShulkerBoxSlot.class)
public class ShulkerBoxMixin {
	@Inject(method = "canInsert(Lnet/minecraft/item/ItemStack;)Z", at = @At("RETURN"), cancellable = true)
	private void injected(CallbackInfoReturnable<Boolean> cir) {
		if (cir.getReturnValue() == true) {
			System.out.println("Yelp");
		}


		cir.setReturnValue(cir.getReturnValue()); //Og Return
	}

}
