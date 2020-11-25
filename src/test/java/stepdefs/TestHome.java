package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import kwd.TestHomeKwd;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestHome {
    private static Logger logger = LogManager.getLogger(TestHome.class);
    private WebDriver driver;
    private TestHomeKwd api;

    @After()
    public void tearDown() {
        driver.quit();
    }

    @Before()
    public void setUp() {
        driver = new FirefoxDriver();
        api = new TestHomeKwd(driver);
    }

    @When("^i am on the site$")
    public void i_am_on_the_site() {
        logger.info("i am on the site");
        api.getHome();
    }

    @Then("^i can see a page$")
    public void i_can_see_a_page() {
        logger.info("i can see a page");
        Assert.assertEquals("Welcome to the-internet", api.getTitle());
    }

    @When("^i am on the checkboxes page$")
    public void iAmOnTheCheckboxesPage() {
        logger.info("i am on the checkboxes page");
        api.getCheckboxesPage();
    }

    @And("^i click on the checkbox (\\d+)$")
    public void iClickOnTheCheckbox(int num) {
        logger.info("i click on the checkbox " + num);
        api.clickoncheckbox(num);
    }

    @Then("^checkbox (\\d+) is unchecked$")
    public void checkbox_is_unchecked(int num) {
        logger.info("checkbox " + num + " is unchecked");
        api.verifyCheckboxUnchecked(num);

    }

    @Then("^checkbox (\\d+) is checked$")
    public void checkboxIsChecked(int num) {
        logger.info("checkbox " + num + " is checked");
        api.checkboxIsChecked(num);
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
    public void iLogWith(String user){
        logger.info("i log with '" + user + "'");
        api.authenticate(user);
    }
}
