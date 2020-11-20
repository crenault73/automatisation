package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"io.qameta.allure.cucumberjvm.AllureCucumberJvm"},
        features = {"src/test/resources/features"},
        glue = {"stepdefs"}
)
public class RunnerTest {

    private static final Logger logger = LogManager.getLogger(RunnerTest.class);

    public static void main(String[] args) {
        logger.debug("Runner test");
    }

}