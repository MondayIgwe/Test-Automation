package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ThreadGuard;

public class BrowserFactory {
    private final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public BrowserFactory(String browserName, String applicationUrl) {
        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                webDriver.set(ThreadGuard.protect(new ChromeDriver()));
                break;
            case "firefox":
                webDriver.set(ThreadGuard.protect(new FirefoxDriver()));
                break;
            case "safari":
                webDriver.set(ThreadGuard.protect(new SafariDriver()));
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
        getDriver().get(applicationUrl);
        getDriver().manage().window().maximize();
    }

    public WebDriver getDriver() {
        if (webDriver.get() == null) {
            throw new IllegalStateException("No WebDriver instance has been set");
        }
        return webDriver.get();
    }

    public void quitDriver() {
        if (getDriver() != null) {
            getDriver().close();
            getDriver().quit();
            webDriver.remove();
        }
    }
}
