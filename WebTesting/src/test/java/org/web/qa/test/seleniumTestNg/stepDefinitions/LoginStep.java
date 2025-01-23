package org.web.qa.test.seleniumTestNg.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.web.qa.test.seleniumTestNg.base.DriverFactory;

public class LoginStep extends DriverFactory {

    @Given("User is on page {string}")
    public void userIsOnPage(String arg0) {
        System.out.println(arg0);
    }

    @When("User enters username {string} and password {string}")
    public void userEntersUsernameAndPassword(String arg0, String arg1) {
        System.out.println(arg1 + arg0);
    }

    @Then("User should be able to login successfully")
    public void userShouldBeAbleToLoginSuccessfully() {
        System.out.println("test passed");
    }
}
