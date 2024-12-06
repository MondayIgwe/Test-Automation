package runners;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@CucumberOptions(features = "./src/test/resources/features",
        glue = {"./src/test/java/stepdefinitions"},
        monochrome = true,
        tags = "@smoke",
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber-reports",
                "json:target/cucumber.json"})
public class RunnerTest {
}
