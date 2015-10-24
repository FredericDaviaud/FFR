package com.cho.ffr.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileUtils {
    
    private final static Logger LOGGER = Logger.getLogger(FileUtils.class.getName());
    
    private FileUtils() {
        
    }
    
    /**
     * Load file as String
     * @param filePath file path
     * @return file as String
     */
    public static String loadFileAsString(String filePath) {
        StringBuffer result = new StringBuffer();
        String line = "";
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }
            reader.close();
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.SEVERE, "File not found: " + filePath + " !", e);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error while trying to load file as string at path " + filePath + " !", e);
        }
        
        return result.toString();
    }
}
