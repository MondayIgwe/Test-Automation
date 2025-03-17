package org.api.qa.tests.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = {"src/test/resources/features/petstore"},
        glue = {"org/api/qa/tests/stepDefinitions",
                "org/api/qa/tests/hook/Hook"},
        plugin = {"pretty", "html:target/report/cucumber.html",
                "json:target/report/cucumber.json"},
        monochrome = false, publish = true)
public class Runner extends AbstractTestNGCucumberTests {
}
