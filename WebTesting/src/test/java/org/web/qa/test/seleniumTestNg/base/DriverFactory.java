package org.web.qa.test.seleniumTestNg.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.web.qa.utils.Browsers;
import org.web.qa.utils.OS;

import java.io.FileNotFoundException;

import static org.web.qa.utils.CommonUtils.CONFIG_FILEPATH;
import static org.web.qa.utils.ReadProperty.*;

public abstract class DriverFactory {

    ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public void getDriver() throws FileNotFoundException {

        /*
            Executed test on different browsers
         */
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

        switch (OS.WINDOWS) {
            case WINDOWS -> {
                getProperty(CONFIG_FILEPATH);
                switch (Browsers.EDGE) {
                    case EDGE -> {
                        webDriver.set(new EdgeDriver());
                        webDriver.get().get(URL);
                        webDriver.get().manage().window().maximize();
                    }
                }
            }
            default -> throw new IllegalArgumentException("Invalid OS type");
        }
        /*
            Comment out the code below to run the test on different machines
        */
//        switch (OS.MAC) {
//            case MAC -> {
//                getProperty(CONFIG_FILEPATH);
//                switch (Browsers.SAFARI) {
//                    case SAFARI -> {
//                        webDriver.set(new SafariDriver());
//                        webDriver.get().get(URL);
//                        webDriver.get().manage().window().maximize();
//                    }
//                }
//            }
//            default -> throw new IllegalArgumentException("Invalid OS type");
//        }

//        switch (OS.LINUX) {
//            case LINUX -> {
//                getProperty(CONFIG_FILEPATH);
//                switch (Browsers.CHROME) {
//                    case CHROME -> {
//                        webDriver.set(new ChromeDriver());
//                        webDriver.get().get(URL);
//                        webDriver.get().manage().window().maximize();
//                    }
//                }
//            }
//            default -> throw new IllegalArgumentException("Invalid OS type");
//        }


        /*
            Executed test on different browsers using if-else statement
         */

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
    }

    public ThreadLocal<WebDriver> getWebDriver() {
        return webDriver;
    }
}
