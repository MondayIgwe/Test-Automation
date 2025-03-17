package org.web.qa.test.seleniumTestNg.hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.web.qa.test.seleniumTestNg.base.DriverFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.web.qa.test.seleniumTestNg.base.DriverFactory.getDriver;

public class Hook {
    private static WebDriver webDriver;

    @Before
    public void setUp() throws FileNotFoundException {
        webDriver = getDriver();
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Test case failed: " + scenario.getName());
            System.out.println("Screenshot saved as: " + new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) + ".png");
            try {
                FileUtils.copyFile(new File("target/cucumber-reports/screenshots/" + scenario.getName() + ".png"),
                        new File("target/cucumber-reports/screenshots/" + scenario.getId() + ".png"));
                System.out.println("Status: " + scenario.getStatus());
                scenario.log(scenario.getId());
            } catch (IOException e) {
                e.getLocalizedMessage();
            }
        }

        if (webDriver != null) {
            webDriver.close();
            webDriver.quit();
        }
    }
}
