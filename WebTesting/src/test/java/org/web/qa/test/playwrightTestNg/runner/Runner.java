package org.web.qa.test.playwrightTestNg.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/playwrightFeature",
        glue = "stepDefinitions",
        plugin = {"pretty", "html:target/report/cucumber.html", "json:target/report/cucumber.json"})
public class Runner extends AbstractTestNGCucumberTests {
}
