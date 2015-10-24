package com.cho.ffr.logger;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyLogger {

    private static FileHandler logFile;
    private static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    
    public static  void init() {
        try {
            logFile = new FileHandler("log.txt");
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
        ConsoleHandler console = new ConsoleHandler();
        console.setFormatter(new SimpleFormatter());
        console.setLevel(Level.ALL);
        logger.setLevel(Level.ALL);
        logFile.setFormatter(new SimpleFormatter());
        logger.addHandler(logFile);
        logger.addHandler(console);
    }
}
