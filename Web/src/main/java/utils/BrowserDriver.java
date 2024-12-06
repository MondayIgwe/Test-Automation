package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserDriver {
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver setDriver(String browserName) {
        switch (browserName) {
            case "chrome":
                webDriver.set(new ChromeDriver());
                break;
            case "firefox":
                webDriver.set(new FirefoxDriver());
                break;
            case "safari":
                webDriver.set(new SafariDriver());
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
        getDriver().manage().window().maximize();
        return getDriver();
    }

    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            throw new IllegalStateException("No WebDriver instance has been set");
        }
        return webDriver.get();
    }

    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().close();
            getDriver().quit();
            webDriver.remove();
        }
    }
}
