package com.Jack.FilledToTheBrim;


import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FilledToTheBrim implements ModInitializer {

    public static final Logger LOGGER = LogManager.getLogger("FilledToTheBrim");

    public static boolean IS_ENABLED = true;


    @Override
    public void onInitialize() {
        //not Logger I know...
        LOGGER.info("Filled To The Brim Loaded!");

    }
}



