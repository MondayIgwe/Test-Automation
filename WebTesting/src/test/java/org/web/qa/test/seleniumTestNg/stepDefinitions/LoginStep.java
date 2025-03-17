package org.web.qa.test.seleniumTestNg.stepDefinitions;

import io.cucumber.core.exception.CucumberException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.testng.Assert;
import org.web.qa.test.seleniumTestNg.base.BaseStep;
import java.util.List;

public class LoginStep extends BaseStep {

    @When("User enters username {string} and password {string}")
    public void userEntersUsernameAndPassword(String arg0, String arg1) {
        System.out.println(arg1 + arg0);
    }

    @Then("User should be able to login successfully")
    public void userShouldBeAbleToLoginSuccessfully() {
        System.out.println("test passed");
    }

    @Given("User is on page")
    public void userIsOnPage() {
    }

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
    }

    @Then("validate data from web table")
    public void validateDataFromWebTable() {
    }

    @When("user enter username {string}")
    public void userEnterUsername(String user) {
        getScenarioContext().setContext("id", user);
    }

    @And("user enter password {string}")
    public void userEnterPassword(String arg0) {
        Object id = (String) getScenarioContext().getContext("id");
        System.out.println("Get username: " + id);
    }

    @When("user select data from web table")
    public void userSelectDataFromWebTable(DataTable dataTable) {
        Assert.assertNotNull(loginPage);
        try {
            if (!dataTable.isEmpty()) {
                DataTable rows = dataTable.rows(1);
                List<List<String>> r = rows.cells();
                for (int i = 0; i < r.size(); i++) {
                    for (int j = i; j < r.get(i).size(); j++) {
                        System.out.println("Data: " + r.get(j).get(i));
                    }
                }

            }
        } catch (CucumberException cucumberException) {
            for (StackTraceElement stack : cucumberException.getStackTrace()) {
                System.out.println(stack.getClassName() + stack.getFileName()
                        + stack.getMethodName()
                        + stack.getLineNumber());
            }
        }
    }

    @Then("User is not logged in")
    public void userIsNotLoggedIn() {
    }

    @And("Error is should be displayed")
    public void errorIsShouldBeDisplayed() {
    }

    @But("user should not see {string} role")
    public void userShouldNotSeeRole(String arg0) {

    }

    @Then("User is logged in")
    public void userIsLoggedIn() {
    }

    @Then("the ATM cashslot should dispense ${int}")
    public void theATMCashslotShouldDispense$(int arg0) {

    }

    @When("the user enters valid credentials")
    public void theUserEntersValidCredentials() {
    }

    @Then("the user should be redirected to the dashboard")
    public void theUserShouldBeRedirectedToTheDashboard() {
    }

    @When("the user enters invalid credentials")
    public void theUserEntersInvalidCredentials() {
    }

    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
    }


    @Given("a book {string}")
    public void aBook(String arg0) {

    }


    @Given("the user {string}{string}{string}")
    public void theUser(String arg0, String arg1, String arg2) {
        System.out.println(arg0);
    }

    @And("verify that is able to log in")
    public void verifyThatIsAbleToLogIn(DataTable dataTable) {
        long count = dataTable.cells().stream().sorted().count();
        System.out.println("Total rows: " + count);
    }
}
