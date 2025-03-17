package org.api.qa.tests.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.api.qa.tests.resources.PetResources;

public class PetSteps {
    PetResources petResources = new PetResources();

    @Given("User send request api endpoint resource")
    public void userSendRequestApiEndpointResource() {
    }

    @Given("I have a pet with id {int}")
    public void iHaveAPetWithId(int arg0) {
    }

    @When("I get the pet by id")
    public void iGetThePetById() {
    }

    @Then("I should get the pet with id {int}")
    public void iShouldGetThePetWithId(int arg0) {
    }
}
