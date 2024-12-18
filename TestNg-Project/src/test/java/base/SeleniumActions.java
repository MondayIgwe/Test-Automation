package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumActions {

    WebDriver driver = CreateDriver.getInstance().getDriver();
    String mainWindow = driver.getWindowHandle();

    public void getMainWindows() {
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    // Frame Handles
    public void navigateBack() {
        driver.switchTo().window(mainWindow);
    }

    public void navigateForward() {
        driver.navigate().forward();
    }


    public void switchToFrame(String frameName) {
        driver.switchTo().frame(frameName);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void closeBrowser() {
        driver.quit();
    }

    public void switchToParentWindow() {
        driver.switchTo().parentFrame();
    }

    // Alert Handles
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public void setAlertText(String alertText) {
        driver.switchTo().alert().sendKeys(alertText);
    }

    public void waitForWindows() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }
}
