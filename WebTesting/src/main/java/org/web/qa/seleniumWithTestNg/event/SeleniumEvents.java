package org.web.qa.seleniumWithTestNg.event;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SeleniumEvents {

    private final WebDriver driver;

    public SeleniumEvents(WebDriver driver) {
        this.driver = driver;
    }

    // Find Elements
    public WebElement findOne(By by) throws NoSuchElementException {
        try {
            return driver.findElement(by);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Element not found");
        }
    }

    Actions performActions() {
        return new Actions(driver);
    }
    public WebElement findAllByText(By by, String eleText) throws NoSuchElementException {
        try {
            List<WebElement> elementList = driver.findElements(by);
            for (WebElement element : elementList) {
                if (element.getText().equalsIgnoreCase(eleText)) {
                    return element;
                }
            }
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Element not found");
        }
        return null;
    }

    public WebElement findAllByIndex(By by, int index) throws NoSuchElementException {
        return driver.findElements(by).get(index);
    }

    // Perform Actions on elements
    public void sendKeyz(By by, String text) throws IllegalArgumentException {
        driver.findElement(by).sendKeys(text, Keys.TAB);
    }

    public void clickElement(By by) {
        driver.findElement(by).click();
    }

    public void submitElement(By by) {
        driver.findElement(by).click();
    }

    public void clearField(By by) {
        driver.findElement(by).click();
    }

    public void selectDropDown(By by, String text) {
        Select dropdown = new Select(driver.findElement(by));
        switch (text) {
            case "index":
                dropdown.selectByIndex(Integer.parseInt(text));
                break;
            case "text":
                dropdown.selectByVisibleText(text);
                break;
            default:
                throw new IllegalArgumentException("Invalid selection type");
        }
    }


    public void dragAndDrop(By by, By target) {
        WebElement sourecElement = driver.findElement(by);
        WebElement targetElement = driver.findElement(target);
        this.performActions().dragAndDrop(sourecElement, targetElement).build().perform();
    }
}
