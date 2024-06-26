package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kwd.TestDragndropKwd;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class TestDragndrop {
    private static Logger logger = LogManager.getLogger(TestDragndrop.class);
    private BaseSteps baseSteps;

    private WebDriver driver;

    private TestDragndropKwd api;

    public TestDragndrop(BaseSteps baseSteps) {
        this.baseSteps = baseSteps;
        driver = baseSteps.getDriver();
        this.api = new TestDragndropKwd(this.driver);
    }

    @When("^i am on the dragndrop page$")
    public void iAmOnTheDragndropPage() {
        logger.info("i am on the dragndrop page");
        api.getDragndropPage();
    }

    @And("^i move A to B$")
    public void iMoveAToB() {
        logger.info("i move A to B");
        api.dragNDrop();
    }

    @Then("^i see B in place of A$")
    public void iSeeBInPlaceOfA() {
        logger.info("i see B in place of A");
        api.checkBinPlaceOfA();
    }
}
