package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import kwd.TestAuthenticationKwd;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class TestAuthentication {

    private static Logger logger = LogManager.getLogger(TestAuthentication.class);
    private TestHome baseSteps;
    private WebDriver driver;

    private TestAuthenticationKwd api;

    public TestAuthentication(TestHome baseSteps) {
        this.baseSteps = baseSteps;
        driver = baseSteps.getDriver();
        this.api = new TestAuthenticationKwd(this.driver);
    }

    @Given("^i am on the authentication page$")
    public void iAmOnTheAuthenticationPage() {
        logger.info("i am on the authentication page");
        api.getAuthenticationPage();
    }

    @When("^i log with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iLogWithAnd(String login, String password) {
        logger.info("i log with '" + login + "' and '" + password + "'");
        api.authenticate(login, password);
    }

    @Then("^i am logged into secure area$")
    public void iAmLoggedIntoSecureArea() {
        logger.info("i am logged into secure area");
        api.checkLogged();
    }

    @When("^i log with \"([^\"]*)\"$")
    public void iLogWith(String user) {
        logger.info("i log with '" + user + "'");
        api.authenticate(user);
    }
}
