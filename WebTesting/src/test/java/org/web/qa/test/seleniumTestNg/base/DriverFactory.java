package org.web.qa.test.seleniumTestNg.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.web.qa.utils.Browsers;

import java.io.FileNotFoundException;

import static org.web.qa.utils.CommonUtils.CONFIG_FILEPATH;
import static org.web.qa.utils.ReadProperty.*;

public abstract class DriverFactory {

    static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    @BeforeTest
    public static void getDriver() throws FileNotFoundException {
        getProperty(CONFIG_FILEPATH);

        if (BROWSER_NAME.equalsIgnoreCase(Browsers.CHROME.name())) {
            webDriver.set(new ChromeDriver());
        } else if (BROWSER_NAME.equalsIgnoreCase(Browsers.SAFARI.name())) {
            webDriver.set(new SafariDriver());
        } else if (BROWSER_NAME.equalsIgnoreCase(Browsers.EDGE.name())) {
            webDriver.set(new EdgeDriver());
        } else {
            throw new IllegalArgumentException("Invalid browser type");
        }
        webDriver.get().get(URL);
        webDriver.get().manage().window().maximize();
    }

    public ThreadLocal<WebDriver> getWebDriver() {
        return webDriver;
    }

    @AfterTest
    public void closeBrowser() {
        webDriver.get().quit();
    }
}
