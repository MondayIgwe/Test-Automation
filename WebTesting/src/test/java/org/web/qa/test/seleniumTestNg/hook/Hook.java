package org.web.qa.test.seleniumTestNg.hook;

import com.qa.main.utils.SessionNotFoundException;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.web.qa.test.seleniumTestNg.base.DriverFactory;

import java.io.FileNotFoundException;

public class Hook extends DriverFactory {

    @Before(value = "@smoke", order = 1000)
    public void setUp() throws FileNotFoundException {
        super.getDriver();
    }

    @After
    public void tearDown() throws SessionNotFoundException {
        try {
            System.out.println("After hook");
            getWebDriver().get().close();
            getWebDriver().get().quit();
        } catch (RuntimeException e) {
            System.out.println("Error on tearDown: " + e.getMessage());
        }
    }
}
