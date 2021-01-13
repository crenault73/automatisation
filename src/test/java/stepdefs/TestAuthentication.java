package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kwd.TestAuthenticationKwd;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class TestAuthentication {

    private static Logger logger = LogManager.getLogger(TestAuthentication.class);
    private BaseSteps baseSteps;
    private WebDriver driver;

    private TestAuthenticationKwd api;

    public TestAuthentication(BaseSteps baseSteps) {
        this.baseSteps = baseSteps;
        driver = baseSteps.getDriver();
        this.api = new TestAuthenticationKwd(this.driver);
        logger.debug("Thread ID - " + Thread.currentThread().getId() + " TestAuthentication: " + driver.getCurrentUrl());
    }

    @Given("^i am on the authentication page$")
    public void iAmOnTheAuthenticationPage() {
        api.getAuthenticationPage();
        logger.info("Thread ID - " + Thread.currentThread().getId() + " i am on the authentication page: " + driver.getCurrentUrl());
    }

    @When("^i log with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iLogWithAnd(String login, String password) {
        logger.info("Thread ID - " + Thread.currentThread().getId() + " i log with '" + login + "' and '" + password + "': " + driver.getCurrentUrl());
        api.authenticate(login, password);
    }

    @Then("^i am logged into secure area$")
    public void iAmLoggedIntoSecureArea() {
        logger.info("Thread ID - " + Thread.currentThread().getId() + " i am logged into secure area: " + driver.getCurrentUrl());
        api.checkLogged();
    }

    @When("^i log with \"([^\"]*)\"$")
    public void iLogWith(String user) {
        logger.info("Thread ID - " + Thread.currentThread().getId() + " i log with '" + user + "': " + driver.getCurrentUrl());
        api.authenticate(user);
    }
}
