package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import kwd.TestCheckBoxesKwd;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class TestCheckBoxes {

    private static Logger logger = LogManager.getLogger(TestCheckBoxes.class);
    private TestHome baseSteps;

    private WebDriver driver;
    private TestCheckBoxesKwd api;

    public TestCheckBoxes(TestHome baseSteps) {
        this.baseSteps = baseSteps;
        driver = baseSteps.getDriver();
        this.api = new TestCheckBoxesKwd(this.driver);
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
}
