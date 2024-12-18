package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class CreateDriver {

    private static CreateDriver createDriver;
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private CreateDriver() {
    }

    public static CreateDriver getInstance() {
        if (createDriver == null) {
            createDriver = new CreateDriver();
        }
        return createDriver;
    }

    public void setDriverChrome(ChromeOptions options) {
        driver.set(new ChromeDriver(options));
    }

    public void setDriverEdge() {
        driver.set(new EdgeDriver());
    }

    public WebDriver getDriver() {
        return driver.get();
    }
}
