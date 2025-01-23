package org.web.qa.test.seleniumTestNg.hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.web.qa.test.seleniumTestNg.base.DriverFactory;

import java.io.FileNotFoundException;

public class Hook extends DriverFactory {

    @Before
    public void setUp() throws FileNotFoundException {
        getDriver();
        System.out.println("Before hook");
    }

    @After
    public void tearDown() {
        System.out.println("After hook");
        getWebDriver().get().close();
        getWebDriver().get().quit();
    }
}
