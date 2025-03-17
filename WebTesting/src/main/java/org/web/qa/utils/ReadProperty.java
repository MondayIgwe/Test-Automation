package org.web.qa.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {
    static FileReader fileReader;
    static Properties properties;
    public static String URL;
    public static String ETE;
    public static String QA;
    public static String BROWSER_NAME;

    public static void getProperty(String fileName) throws FileNotFoundException {
        fileReader = new FileReader(fileName);
        properties = new Properties();
        try {
            properties.load(fileReader);
            URL = properties.getProperty("url");
            ETE = properties.getProperty("ete");
            BROWSER_NAME = properties.getProperty("browser");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
