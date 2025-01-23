package org.api.qa.test.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = {"src/test/resources/features"},
        glue = {"org/api/qa/test/stepDefinitions", "org/api/qa/test/hook"},
        tags = "@smoke",
        plugin = {"pretty", "html:target/report/cucumber.html",
                "json:target/report/cucumber.json"},
        monochrome = false, publish = true)
public class Runner extends AbstractTestNGCucumberTests {
}
