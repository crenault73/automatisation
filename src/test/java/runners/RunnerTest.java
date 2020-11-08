package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:reports/cucumber-html-report",
                "json:reports/cucumber.json",
                "pretty"},
        //tags = {"@SmokeTests"},
        features = {"src/test/resources/features"},
        glue = {"stepdefs"}
)
public class RunnerTest {
}