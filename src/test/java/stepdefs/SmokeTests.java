package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kwd.TestHomeKwd;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class SmokeTests {
    private static Logger logger = LogManager.getLogger(SmokeTests.class);
    private BaseSteps baseSteps;
    private WebDriver driver;
    private TestHomeKwd api;

    public SmokeTests(BaseSteps baseSteps) {
        this.baseSteps = baseSteps;
        driver = baseSteps.getDriver();
        api = new TestHomeKwd(driver);
    }

    @When("i am on the site")
    public void iAmOnTheSite() {
        api.getHome();
        //driver.get("http://localhost:8000");
        logger.debug("Thread ID - " + Thread.currentThread().getId() + " i am on the site: " + driver.getCurrentUrl());

    }

    @Then("i can see a page")
    public void iCanSeeAPage() {
        logger.debug("Thread ID - " + Thread.currentThread().getId() + " i can see a page: " + driver.getCurrentUrl());
        Assert.assertEquals("Welcome to the-internet", api.getTitle());
    }
}
