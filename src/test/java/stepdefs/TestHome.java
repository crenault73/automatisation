package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import kwd.TestHomeKwd;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import cucumber.api.java.After;
import cucumber.api.java.Before;
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
        api.getPageCheckboxes();
    }

    @And("^i click on the checkbox (\\d+)$")
    public void iClickOnTheCheckbox(int num) {
        logger.info("i click on the checkbox " + num);
        api.clickoncheckbox(num);
    }

    @Then("^checkbox (\\d+) is unchecked$")
    public void checkbox_is_unchecked(int num) {
        logger.info("checkbox " +num+ " is unchecked");
        api.verifyCheckboxUnchecked(num);

    }

    @Then("^checkbox (\\d+) is checked$")
    public void checkboxIsChecked(int num) {
        logger.info("checkbox " +num+ " is checked");
        api.checkboxIsChecked(num);
    }
}
