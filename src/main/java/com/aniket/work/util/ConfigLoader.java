package com.aniket.work.util;

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class ConfigLoader {
    private static final Logger LOGGER = Logger.getLogger(ConfigLoader.class.getName());

    static {
        try {
            // Check if a custom logging configuration file is specified externally
            String loggingConfigFile = System.getProperty("java.util.logging.config.file");
            if (loggingConfigFile == null) {
                // If not specified externally, load the default logging configuration from the classpath
                LogManager.getLogManager().readConfiguration(ConfigLoader.class.getResourceAsStream("logging.properties"));
            } else {
                // If specified externally, the Java Logging API will automatically load the logging configuration from the specified file
                LogManager.getLogManager().readConfiguration();
            }
        } catch (IOException e) {
            LOGGER.log(java.util.logging.Level.WARNING, "Unable to load log configuration file", e);
        }
    }
}

