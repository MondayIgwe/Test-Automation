package org.web.qa.test.seleniumTestNg.base;

import com.qa.main.utils.Browsers;
import com.qa.main.utils.CustomAnnotations;
import org.openqa.selenium.InsecureCertificateException;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import static com.qa.main.utils.Utility.setChromeOptions;

import java.io.FileNotFoundException;

import static com.qa.main.utils.CommonUtils.CONFIG_FILEPATH;
import static com.qa.main.utils.ReadProperty.*;
import static com.qa.main.utils.OS.*;

@CustomAnnotations(description = "Get WebDriver instance to be consumed by other objects", time = 1)
public abstract class DriverFactory {

    ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public synchronized void getDriver() throws FileNotFoundException {
        try {
        /*
            Executed test on different browsers
         */
            switch (WINDOWS) {
                case WINDOWS -> {
                    getProperty(CONFIG_FILEPATH);
                    switch (Browsers.CHROME) {
                        case CHROME -> {
                            webDriver.set(new ChromeDriver(setChromeOptions()));
                            webDriver.get().get(URL);
                            webDriver.get().manage().window().maximize();
                        }
                    }
                }
                default -> throw new IllegalArgumentException("Invalid OS type");
            }


            switch (WINDOWS) {
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
            switch (MAC) {
                case MAC -> {
                    getProperty(CONFIG_FILEPATH);
                    switch (Browsers.SAFARI) {
                        case SAFARI -> {
                            webDriver.set(new SafariDriver());
                            webDriver.get().get(URL);
                            webDriver.get().manage().window().maximize();
                        }
                    }
                }
                default -> throw new IllegalArgumentException("Invalid OS type");
            }

            switch (LINUX) {
                case LINUX -> {
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
        } catch (SessionNotCreatedException | InsecureCertificateException sessionIdException) {
            System.out.println("Session ID is invalid. WebDriver not instantiated." + sessionIdException.getMessage());
        } finally {

        }
    }

    public void getDriver(int i) {
        /*
            Executed test on different browsers
         */

        try {
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
        } catch (WebDriverException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ThreadLocal<WebDriver> getWebDriver() {
        return webDriver;
    }
}
