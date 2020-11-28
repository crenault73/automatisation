package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;

// Used by mvn test
@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
        glue = {"stepdefs"},
        plugin = {"io.qameta.allure.cucumberjvm.AllureCucumberJvm"})
public class RunnerTest {

    private static final Logger logger = LogManager.getLogger(RunnerTest.class);

    //Used by jar
    public static void main(String[] args) throws Throwable {

        //Setting cucumber options
        String cucumberOptions = " --glue stepdefs --plugin io.qameta.allure.cucumberjvm.AllureCucumberJvm classpath:features";
        System.setProperty("cucumber.options", cucumberOptions);
        logger.debug("cucumber.options:" + System.getProperty("cucumber.options"));

        cucumber.api.cli.Main.main(args);

    }
}