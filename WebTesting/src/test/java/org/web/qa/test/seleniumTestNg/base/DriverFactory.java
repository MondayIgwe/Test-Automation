package org.web.qa.test.seleniumTestNg.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.web.qa.utils.Browsers;
import org.web.qa.utils.OS;

import java.io.FileNotFoundException;

import static org.web.qa.utils.CommonUtils.CONFIG_FILEPATH;
import static org.web.qa.utils.ReadProperty.getProperty;
import static org.web.qa.utils.ReadProperty.URL;

public abstract class DriverFactory {
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver() throws FileNotFoundException {
        switch (OS.WINDOWS) {
            case WINDOWS -> {
                getProperty(CONFIG_FILEPATH);
                switch (Browsers.CHROME) {
                    case CHROME -> {
                        webDriver.set(new ChromeDriver());
                        webDriver.get().get(URL);
                        webDriver.get().manage().window().maximize();
                    }
                }
            }
            default -> throw new IllegalArgumentException("Invalid OS type");
        }
        return webDriver.get();
    }
}
