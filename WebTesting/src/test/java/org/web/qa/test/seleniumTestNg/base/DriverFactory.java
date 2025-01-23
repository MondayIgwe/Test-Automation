package org.web.qa.test.seleniumTestNg.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.web.qa.utils.Browsers;
import org.web.qa.utils.OS;

import java.io.FileNotFoundException;

import static org.web.qa.utils.CommonUtils.CONFIG_FILEPATH;
import static org.web.qa.utils.ReadProperty.*;

public abstract class DriverFactory {

    ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public void getDriver() throws FileNotFoundException {

        // Executed test on different browsers
        switch (OS.WINDOWS) {
            case WINDOWS -> {
                getProperty(CONFIG_FILEPATH);
                switch (Browsers.CHROME) {
                    case CHROME -> webDriver.set(new ChromeDriver());
                    case FIREFOX -> webDriver.set(new FirefoxDriver());
                    case EDGE -> webDriver.set(new EdgeDriver());
                }
            }
            case MAC -> {
                getProperty(CONFIG_FILEPATH);
                switch (Browsers.SAFARI) {
                    case SAFARI -> webDriver.set(new SafariDriver());
                }
            }
            case LINUX, SOLARIS -> {
                getProperty(CONFIG_FILEPATH);
                switch (Browsers.CHROME) {
                    case CHROME -> webDriver.set(new ChromeDriver());
                    case FIREFOX -> webDriver.set(new FirefoxDriver());
                }
            }
            default -> throw new IllegalArgumentException("Invalid OS type");

        }
//        try {
//            getProperty(CONFIG_FILEPATH);
//            if (BROWSER_NAME.equalsIgnoreCase(Browsers.CHROME.name())) {
//                webDriver.set(new ChromeDriver());
//            } else if (BROWSER_NAME.equalsIgnoreCase(Browsers.SAFARI.name())) {
//                webDriver.set(new SafariDriver());
//            } else if (BROWSER_NAME.equalsIgnoreCase(Browsers.EDGE.name())) {
//                webDriver.set(new EdgeDriver());
//            } else {
//                throw new IllegalArgumentException("Invalid browser type");
//            }
//        } catch (WebDriverException e) {
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        webDriver.get().get(URL);
        webDriver.get().manage().window().maximize();
    }

    public ThreadLocal<WebDriver> getWebDriver() {
        return webDriver;
    }
}
