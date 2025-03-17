package com.qa.main.utils;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class CommonUtils {
    public final static String CONFIG_FILEPATH = "src/test/resources/properties/config.properties";
    public final static String REQRES_URI = "https://reqres.in/api/";
    public final static int TIMEOUT = 5;
    public final static List<String> MACHINES = Arrays.asList("Windows", "Mac", "Linux");

    public static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
    }
}
