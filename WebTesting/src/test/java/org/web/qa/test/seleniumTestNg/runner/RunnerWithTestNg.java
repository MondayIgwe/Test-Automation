package org.web.qa.test.seleniumTestNg.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/seleniumFeature",
        glue = {"org/web/qa/test/seleniumTestNg/hook",
                "org/web/qa/test/seleniumTestNg/stepDefinitions"}, tags = "@smoke",
        plugin = {"pretty", "html:target/report/cucumber.html", "json:target/report/cucumber.json"})
public class RunnerWithTestNg extends AbstractTestNGCucumberTests {
}
