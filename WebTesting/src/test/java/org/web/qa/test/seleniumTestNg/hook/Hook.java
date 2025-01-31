package org.web.qa.test.seleniumTestNg.hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.web.qa.test.seleniumTestNg.base.DriverFactory;

import java.io.FileNotFoundException;

public class Hook extends DriverFactory {

    @Before
    public void setUp() throws FileNotFoundException {
        Thread thread = new Thread(() -> {
            try {
                super.getDriver();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Before hook");
        }, "Hook");
    }

    @After
    public void tearDown() {
        System.out.println("After hook");
        getWebDriver().get().close();
        getWebDriver().get().quit();
    }
}
