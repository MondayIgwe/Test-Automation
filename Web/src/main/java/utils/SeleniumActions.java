package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class SeleniumActions {
    private WebDriver driver;
    private final int withTimeout1 = 30;
    private final int withTimeout2 = 5;

    public SeleniumActions(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findOne(By by) {
        return driver.findElement(by);
    }

    public WebElement findOneElement(By by){
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(withTimeout1))
                .pollingEvery(Duration.ofSeconds(withTimeout2))
                .ignoring(Exception.class);
        return wait.until(new Function<>() {
            public WebElement apply(WebDriver driver1) {
                return driver1.findElement(by);
            }
        });
    }
    public WebElement findAll(By by) {
        List<WebElement> elements = driver.findElements(by);
        for (WebElement element : elements) {
            return element;
        }
        return null;
    }

    public void clickElement(By element) {
        this.findOne(element).click();
    }

    public void clearElement(By element) {

        if (this.findOne(element) != null)
            this.findOne(element).clear();
    }

    public void sendkeyz(By element, String text) {
        WebElement ele = this.findOne(element);
        if (ele != null)
            ele.sendKeys(text);
    }

    public void waitForElement(By by, long timeout) {
        (new WebDriverWait(driver, Duration.ofMinutes(timeout))).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driverObj) {
                return driverObj.findElement(by).isDisplayed();
            }
        });
    }

    public void waitForElementIsDisplayed() {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(withTimeout1))
                .pollingEvery(Duration.ofSeconds(withTimeout2))
                .ignoring(Exception.class);
        wait.until(d -> d.findElement(By.tagName("body")).isDisplayed());
    }
}
