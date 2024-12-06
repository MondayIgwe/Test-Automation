package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class Hook {
    public static WebDriver driver;
    private static BrowserFactory browserFactory;

    @Before
    public static void setUpEnvironment() {
        System.out.println("Initialize the environment before running the tests");
        browserFactory = new BrowserFactory("chrome", "https://www.saucedemo.com/");
        driver = browserFactory.getDriver();
        Assert.assertNotNull("Driver Null", driver);
    }

    @After
    public static void tearDownEnvironment() {
        System.out.println("Clean up the environment after running the tests");
        browserFactory.quitDriver();
    }
}
