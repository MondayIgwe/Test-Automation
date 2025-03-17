package org.web.qa.test.seleniumTestNg.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.web.qa.test.seleniumTestNg.base.BaseStep;

import static org.jsoup.nodes.Entities.EscapeMode.base;

public class DispenseCashSteps extends BaseStep {


    @And("the card is valid")
    public void theCardIsValid() {
    }

    @And("the ATM contains sufficient money")
    public void theATMContainsSufficientMoney() {

    }

    @Given("the account balance is ${int}")
    public void theAccountBalanceIs$(int arg0) {
    }

    @When("I insert the card")
    public void iInsertTheCard() {
        Object requestData = (String) getScenarioContext().getContext("requestData");
        System.out.println(requestData);
    }

    @And("I request ${int}")
    public void iRequest$(int port) {
        getScenarioContext().setContext("requestData", port);
    }


    @And("the account balance should be ${int}")
    public void theAccountBalanceShouldBe$(int arg0) {

    }

    @Given("Alice has ${double} in their account")
    public void aliceHas$InTheirAccount(int arg0, int arg1) {
    }

    @When("Alice tries to withdraw ${double}")
    public void aliceTriesToWithdraw$(int arg0, int arg1) {
    }

    @Then("the withdrawal is successful")
    public void theWithdrawalIsSuccessful() {
    }

    @Given("Hamza has ${double} in their account")
    public void hamzaHas$InTheirAccount(int arg0, int arg1) {
    }

    @When("Hamza tries to withdraw ${double}")
    public void hamzaTriesToWithdraw$(int arg0, int arg1) {
    }

    @Then("the withdrawal is declined")
    public void theWithdrawalIsDeclined() {
    }
}
