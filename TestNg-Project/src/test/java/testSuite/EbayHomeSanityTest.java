package testSuite;

import base.CreateDriver;
import base.WebDriverFactory;

import static base.WebDriverFactory.*;

import org.openqa.selenium.By;

import static org.testng.Assert.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class EbayHomeSanityTest {
    @BeforeMethod
    public void setUp() {
        WebDriverFactory.setup("edge");
    }

    @Test
    public void verifyEbayHomeSanity() {
        SoftAssert softAssert;
        try {
            softAssert = new SoftAssert();
            CreateDriver.getInstance().getDriver().findElement(By.xpath("//input[@name='_nkw']")).sendKeys("gucci");
            assertTrue(CreateDriver.getInstance().getDriver().findElement(By.cssSelector("input#gh-btn")).isEnabled());
            CreateDriver.getInstance().getDriver().findElement(By.cssSelector("input#gh-btn")).click();

            String expected = CreateDriver.getInstance().getDriver().getTitle();
            String actual = "Gucci for sale | eBay";
            softAssert.assertEquals(actual, expected);
            softAssert.assertAll();

            System.out.println("Thread: " + Thread.currentThread().getId() + " " + getClass().getSimpleName());
        } catch (Exception e) {
            assertNotNull(CreateDriver.getInstance().getDriver());
        }
    }

    @Test
    public void verifySearchSuggestions() {
        System.out.println("search");
        System.out.println("Thread: " + Thread.currentThread().getId() + " " + getClass().getSimpleName());
    }

    @Test
    public void verifySearchField() {
        System.out.println("search");
        System.out.println("Thread: " + Thread.currentThread().getId() + getClass().getSimpleName());
    }


    @AfterMethod
    public void tearDown() {
        CreateDriver.getInstance().getDriver().close();
        CreateDriver.getInstance().getDriver().quit();
    }
}
