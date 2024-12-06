package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    // Page Object Pattern
    private WebDriver driver;

    By inventoryObj = By.id("inventory");
    By product = By.id("inventory");
    By quantity = By.id("inventory");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart(String productName, int quantity_) {
        driver.findElement(product).sendKeys(productName);
        driver.findElement(quantity).sendKeys(Integer.toString(quantity_));
        driver.findElement(inventoryObj).click();
    }
}
