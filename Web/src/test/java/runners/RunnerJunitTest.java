package runners;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = {"src/test/java/stepdefinitions", "src/test/java/hooks/Hook"},
        plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json"})
public class RunnerJunitTest {
}
