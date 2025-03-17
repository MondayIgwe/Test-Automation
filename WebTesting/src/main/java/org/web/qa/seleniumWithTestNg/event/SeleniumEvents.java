package org.web.qa.seleniumWithTestNg.event;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.remote.ScreenshotException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.time.Duration;

import static java.lang.Integer.parseInt;

public class SeleniumEvents {

    private final WebDriver driver;

    public SeleniumEvents(WebDriver driver) {
        this.driver = driver;
    }

    // Find Elements

    public WebElement findOne(By by) throws NoSuchElementException {
        try {
            return driver.findElement(by);
        } catch (NoSuchElementException | InvalidSelectorException e) {
            throw new NoSuchElementException(driver.findElement(by) + "Element not found in DOM");
        } catch (StaleElementReferenceException stale) {
            // retry again
            return driver.findElement(by);
        }
    }

    public List<WebElement> findAll(By by) throws NoSuchElementException {
        try {
            return driver.findElements(by);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Elements not found");
        }
    }

    private Actions performActions() {
        return new Actions(driver);
    }

    private Alert performAlert() {
        return driver.switchTo().alert();
    }

    public WebElement findAllByText(By by, String eleText) throws NoSuchElementException {
        try {
            List<WebElement> elementList = driver.findElements(by);
            for (WebElement element : elementList) {
                if (element.getText().equalsIgnoreCase(eleText)) {
                    return element;
                }
            }
        } catch (ElementNotInteractableException e) {
            throw new ElementNotInteractableException("Element not found");
        }
        return null;
    }

    public WebElement findAllByIndex(By by, int index) throws NoSuchElementException {
        return driver.findElements(by).get(index);
    }

    public void sendKeyz(By by, String text) throws IllegalArgumentException {
        try {
            driver.findElement(by).sendKeys(text, Keys.TAB);
        } catch (InvalidElementStateException invalidElementStateException) {
            throw new InvalidElementStateException(invalidElementStateException.getMessage());
        }
    }

    public void sendKeyz(WebElement element, String text) throws IllegalArgumentException {
        try {
            element.sendKeys(text, Keys.TAB);
        } catch (InvalidElementStateException invalidElementStateException) {
            throw new InvalidElementStateException(invalidElementStateException.getMessage());
        }
    }

    public void clickElement(By by) {
        try {
            findOne(by).click();
        } catch (ElementClickInterceptedException clickInterceptedException) {
            System.out.println("Element not clickable " + clickInterceptedException.getMessage());
        }
    }

    public void clickElement(WebElement element) {
        try {
            element.click();
        } catch (ElementClickInterceptedException clickInterceptedException) {
            System.out.println("Element not clickable " + clickInterceptedException.getMessage());
        }
    }

    public void clearField(By by) {
        driver.findElement(by).clear();
    }

    public void selectDropDown(By by, String text) {
        Select dropdown = new Select(driver.findElement(by));
        try {
            switch (text) {
                case "index":
                    dropdown.selectByIndex(parseInt(text));
                    break;
                case "text":
                    dropdown.selectByVisibleText(text);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid selection type");
            }
        } catch (NumberFormatException formatException) {
            throw new NumberFormatException("Invalid index or text");
        }
    }

    public void isVisible(By by) {
        try {
            WebElement ele = waitForElement(by);
            if (ele != null) {
                System.out.println("Element is visible");
                ele.click();
                clickElement(by);
            }

        } catch (ElementNotInteractableException e) {
            System.out.println("Element not visible" + e.getMessage());
        }
    }

    public void dragAndDrop(By by, By target) {
        WebElement soure = driver.findElement(by);
        WebElement targetEle = driver.findElement(target);
        this.performActions().dragAndDrop(soure, targetEle).build().perform();
    }

    public void moveToElement(By by, By targetElement, int i, int j) {
        try {
            WebElement target = driver.findElement(targetElement);
            this.performActions().moveToElement(target, i, j).build().perform();
        } catch (MoveTargetOutOfBoundsException moveTargetOutOfBoundsException) {
            throw new MoveTargetOutOfBoundsException("");
        }
    }

    public WebElement waitForElement(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(1)); // 100 milliseconds
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (TimeoutException timeoutException) {
            throw new TimeoutException("WaitForElement");
        }
    }

    public int waitForElement(By by, int n) {
        try {
            WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(1)); // 100 milliseconds
            if (n == 1) return n;
            else {
                return n * waitForElement(by, n - 1);
            }
        } catch (TimeoutException timeoutException) {
            throw new TimeoutException("WaitForElement");
        }
    }

    public void switchToFrame(int index) {
        driver.switchTo().frame(index);
    }

    public void switchToParentFrame() {
        try {
            driver.switchTo().parentFrame();
        } catch (NoSuchFrameException e) {
            System.out.println("No such attribute" + e.getMessage());
        }
    }

    public void scrollDown() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) this.driver;
        jsExecutor.executeScript("window.scrollBy(0,1000)"); // scroll down
    }

    public void scrollUp() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) this.driver;
        jsExecutor.executeScript("window.scrollBy(0,-1000)"); // scroll up
    }

    public void clickJS(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) this.driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    public void makeVisibleJS(WebElement element) {
        try {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) this.driver;
            jsExecutor.executeScript("arguments[0].style.display='block';", element);
        } catch (JavascriptException js) {
            throw new JavascriptException("Error executing");
        }
    }

    public void accept(By by) {
        try {
            this.performAlert().accept();
        } catch (NoAlertPresentException | UnhandledAlertException noAlertPresentException) {
            throw new NoAlertPresentException("No alert present");
        }
    }

    public void dimissAlert() {
        try {
            this.performAlert().dismiss();
        } catch (NoAlertPresentException | UnhandledAlertException noAlertPresentException) {
            throw new NoAlertPresentException("No alert present");
        }
    }

    public void takeScreenshot() {
        File screenshot = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "/screenshots/test.png"));
        } catch (ScreenshotException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void implicitWait() {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        } catch (InvalidArgumentException e) {
            throw new InvalidArgumentException("Invalid time duration");
        }
    }
}
