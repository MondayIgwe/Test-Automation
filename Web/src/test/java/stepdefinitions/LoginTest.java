package stepdefinitions;
import io.cucumber.java.en.*;
public class LoginTest {
    @When("the user logs in with username {string} and password {string}")
    public void theUserLogsInWithUsernameAndPassword(String arg0, String arg1) {
    }

    @Given("a user with username {string} and password {string}")
    public void aUserWithUsernameAndPassword(String arg0, String arg1) {
    }

    @Then("the user should be successfully logged in")
    public void theUserShouldBeSuccessfullyLoggedIn() {
    }
}
