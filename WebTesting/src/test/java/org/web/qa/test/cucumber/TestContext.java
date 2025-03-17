package org.web.qa.test.cucumber;


public class TestContext {

    // Has-A (composition and Aggregations)
    private final ScenarioContext scenarioContext;

    public TestContext() {
        scenarioContext = new ScenarioContext();  // HAS-A represent composition relationship
    }

    // Uses-a relationship - A method of one class is using an object of another class
    public ScenarioContext getScenarioContext() {
        return scenarioContext; // get the instance/object ScenarioContext
    }
}
