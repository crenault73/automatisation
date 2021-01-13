package runners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
        glue = {"stepdefs"},
        plugin = {"io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"})
public class RunnerTest {

    private static final Logger logger = LogManager.getLogger(RunnerTest.class);

    //Used by jar
    public static void main(String[] args) throws Throwable {

        //Setting cucumber options
        String cucumberOptions = " --glue stepdefs --plugin io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm classpath:features";
        System.setProperty("cucumber.options", cucumberOptions);
        logger.debug("cucumber.options:" + System.getProperty("cucumber.options"));

        //cucumber.api.cli.Main.main(args);
        io.cucumber.core.cli.Main.main(args);
    }
}