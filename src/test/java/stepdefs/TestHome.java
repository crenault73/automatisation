package stepdefs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestHome {
    private static Logger logger = LogManager.getLogger(TestHome.class);
    @When("^i am on the site$")
    public void i_am_on_the_site() {
        logger.info("i am on the site");
    }

    @Then("^i can see a page$")
    public void i_can_see_a_page() {
        logger.info("i can see a page");
    }

}
