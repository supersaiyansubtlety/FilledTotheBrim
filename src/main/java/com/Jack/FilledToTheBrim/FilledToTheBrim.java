package com.Jack.FilledToTheBrim;



import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FilledToTheBrim implements ModInitializer {

    public static final Logger LOGGER = LogManager.getLogger("FilledToTheBrim");
    //Maybe a Main Toggle in the Future?
    public static boolean IS_ENABLED = true;

    //Does Not Care For Carpet Rule But Keeps it on So Yeah. Not Toggleable (Yet?)
    public static Integer SHULKERBOX_STACK_SIZE = 64;
    public static boolean SHULKERBOX_COMPARATOR_OVERLOAD_FIX= true;




    public static void onEnable() {
        LOGGER.info("Filled To The Brim Loaded!");
    }


    @Override
    public void onInitialize() {
        LOGGER.info("Mods Are Now Initializing");

    }
}



