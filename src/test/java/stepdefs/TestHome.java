package stepdefs;

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
import org.openqa.selenium.firefox.FirefoxOptions;

public class TestHome {
    private static Logger logger = LogManager.getLogger(TestHome.class);
    private WebDriver driver;
    private TestHomeKwd api;

    public WebDriver getDriver() {
        return this.driver;
    }

    @After()
    public void tearDown() {
        driver.quit();
    }

    @Before()
    public void setUp() {
        boolean headless = Boolean.valueOf(System.getProperty("headless", "false"));
        FirefoxOptions firefox_options = new FirefoxOptions();
        if (headless) {
            firefox_options.setHeadless(true);
        }
        driver = new FirefoxDriver(firefox_options);
        //driver.manage().window().setSize(new Dimension(1920,1080));
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

}
