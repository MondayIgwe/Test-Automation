package com.qa.main.utils;

import org.openqa.selenium.chrome.ChromeOptions;

public class Utility {
    public static int timeOut;
    public final static String GO_REST_API_BASE_URI = "https://gorest.co.in/public/v2/";

    static {
        timeOut = 10000; // 10 seconds
    }

    public static ChromeOptions setChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);
        return chromeOptions;
    }
}
