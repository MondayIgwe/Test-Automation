package org.web.qa.test.playwrightTestNg.stepDefinitions;


import org.web.qa.test.playwrightTestNg.base.DriverFactory;
import org.web.qa.playwrightWithTestNg.page.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep extends DriverFactory {

    LoginPage loginPage;
    DriverFactory driverFactory;

    @Before
    public void setup() {
        driverFactory = new LoginStep();
        driverFactory.getPage("chrome");
        loginPage = new LoginPage(super.page);
    }

    @Given("User is on HRMLogin page {string}")
    public void user_is_on_hrm_login_page(String string) {

    }

    @When("User enters username as {string} and password as {string}")
    public void user_enters_username_as_and_password_as(String string, String string2) {

    }

    @Then("User should be able to login successfully and new page open")
    public void user_should_be_able_to_login_successfully_and_new_page_open() {

    }


//    @After
//    public void tearDown() {
//        super.page.close();
//        super.browser.close();
//        super.playwright.close();
//    }

    @Then("User should be able to see error message {string}")
    public void userShouldBeAbleToSeeErrorMessage(String arg0) {
    }
}
