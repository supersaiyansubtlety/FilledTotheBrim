package com.Jack.FilledToTheBrim.mixin;




import com.Jack.FilledToTheBrim.FilledToTheBrim;
import net.minecraft.block.Block;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;

import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = ItemStack.class, priority = 69)
public class ItemStackMixin {


    //@Shadow @Final public Item getItem;
    @Shadow @Final public Item item;
    @Shadow private boolean empty;
    public Item getItem() {
        return empty ? Items.AIR : this.item;
        //return empty ? Items.AIR : this.item == null ? Items.AIR : this.item;//Idk
    }


    @Inject(method = "getMaxCount", at = @At("HEAD"), cancellable = true)
    private void ShulkerStackSize(CallbackInfoReturnable<Integer> ci) {


        //boolean isEmptyShulkerBoxandisEnabled = nbtutil.isEmptyShulkerBox("here") && FilledToTheBrim.IS_ENABLED;




        if (Block.getBlockFromItem(getItem()) instanceof ShulkerBoxBlock && FilledToTheBrim.IS_ENABLED) {
            //FilledToTheBrim.LOGGER.info(FilledToTheBrim.SHULKERBOX_STACK_SIZE);//Debug (Lot of Logs So don't use in normal env)
            ci.setReturnValue(FilledToTheBrim.SHULKERBOX_STACK_SIZE);
        }
        else {
            //FilledToTheBrim.LOGGER.info(getItem().getMaxCount());//Debug (Lot of Logs So don't use in normal env)
            ci.setReturnValue(getItem().getMaxCount());
        }


        //ci.setReturnValue(64);

    }


}

/*
 boolean isEmptyShulkerBoxandisEnabled = nbtutil.isEmptyShulkerBox(stack) && FilledToTheBrim.IS_ENABLED;

        return !(Block.getBlockFromItem(stack.getItem()) instanceof ShulkerBoxBlock) || isEmptyShulkerBoxandisEnabled;
 */







/*


        return !(Block.getBlockFromItem(stack.getItem()) instanceof ShulkerBoxBlock) || isEmptyShulkerBoxandisEnabled;
    }

}

*/