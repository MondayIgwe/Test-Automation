package org.web.qa.test.seleniumTestNg.base;

import com.qa.main.utils.Browsers;
import com.qa.main.utils.CustomAnnotations;
import com.qa.main.utils.OS;
import org.openqa.selenium.InsecureCertificateException;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import static com.qa.main.utils.Browsers.CHROME;
import static com.qa.main.utils.CommonUtils.*;
import static com.qa.main.utils.Utility.setChromeOptions;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.time.Duration;
import static com.qa.main.utils.ReadProperty.*;
import static com.qa.main.utils.Utility.timeOut;

@CustomAnnotations(description = "Get WebDriver instance to be consumed by other objects", time = 1)
public abstract class DriverFactory {

    ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();


    public synchronized void getDriver() throws FileNotFoundException {
        try {
        /*
            Executed test on different browsers
         */
            label:
            // terminate here
            for (OS os : OS.values()) {
                getProperty(CONFIG_FILEPATH);
                // Select an OS to run tests (Windows, Mac, Safari,)
                if (os.getOs().equalsIgnoreCase(MACHINES.get(0))) {
                    switch (CHROME) {
                        case CHROME:
                            webDriver.set(new ChromeDriver(setChromeOptions()));
                            String id = CHROME.getBrowserId();
                            System.out.println(id);
                            break label;
                        case FIREFOX:
                            webDriver.set(new FirefoxDriver());
                            break label;
                        case EDGE:
                            webDriver.set(new EdgeDriver());
                            break label;
                        case SAFARI:
                            webDriver.set(new SafariDriver());
                            break label;
                        default:
                            throw new IllegalArgumentException("Invalid OS type");
                    }
                }
                webDriver.get().get(URL);
                webDriver.get().manage().window().maximize();
                webDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
                sleep(timeOut);
            }
        } catch (SessionNotCreatedException | InsecureCertificateException sessionIdException) {
            System.out.println("Session ID is invalid. WebDriver not instantiated." + sessionIdException.getMessage());
        }
    }

    public void getDriver(int i) {
        try {
            getProperty(CONFIG_FILEPATH);
            if (BROWSER_NAME.equalsIgnoreCase(CHROME.name())) {
                webDriver.set(new ChromeDriver());
            } else if (BROWSER_NAME.equalsIgnoreCase(Browsers.SAFARI.name())) {
                webDriver.set(new SafariDriver());
            } else if (BROWSER_NAME.equalsIgnoreCase(Browsers.EDGE.name())) {
                webDriver.set(new EdgeDriver());
            } else {
                throw new IllegalArgumentException("Invalid browser type");
            }
        } catch (WebDriverException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ThreadLocal<WebDriver> getWebDriver() {
        return webDriver;
    }
}
