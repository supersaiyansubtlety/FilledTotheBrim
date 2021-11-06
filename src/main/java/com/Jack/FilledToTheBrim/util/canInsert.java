package com.Jack.FilledToTheBrim.util;

import net.minecraft.block.Block;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.item.ItemStack;

public class canInsert {

    public static boolean IS_ENABLED = true;

    public static boolean canInsertintoShulkerBox(ItemStack stack) {

        boolean isEmptyShulkerBoxandisEnabled = nbtutil.isEmptyShulkerBox(stack) && IS_ENABLED;
        return !(Block.getBlockFromItem(stack.getItem()) instanceof ShulkerBoxBlock) || isEmptyShulkerBoxandisEnabled;
    }

}

