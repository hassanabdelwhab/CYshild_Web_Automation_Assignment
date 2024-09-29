package com.cyshild.utilities;

import java.util.logging.Logger;

public class Log {
    private static final Logger LOGGER = Logger.getLogger(Log.class.getName());

    public static void error(String message) {
        LOGGER.severe("ERROR: " + message);
    }

    public static void info(String message) {
        LOGGER.info("INFO: " + message);
    }

}
