package org.web.qa.test.seleniumTestNg.base;

import org.web.qa.seleniumWithTestNg.page.LoginPage;
import org.web.qa.test.cucumber.ScenarioContext;
import org.web.qa.test.cucumber.TestContext;

import static org.web.qa.test.seleniumTestNg.hook.Hook.getWebDriver;

public class BaseStep {

    protected ScenarioContext scenarioContext;
    protected LoginPage loginPage;

    public BaseStep() {
        loginPage = new LoginPage(getWebDriver());
        TestContext context = new TestContext();
        scenarioContext = context.getScenarioContext();
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}
