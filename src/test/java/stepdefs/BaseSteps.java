package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseSteps {
    private static Logger logger = LogManager.getLogger(BaseSteps.class);

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @Before()
    public void setup(Scenario scenario) {

        ChromeOptions chrome_options = new ChromeOptions();
        if (true) {
            chrome_options.addArguments("headless");
        }
        driver = new ChromeDriver(chrome_options);
        logger.debug("Thread ID - " + Thread.currentThread().getId() + " Scenario: " + scenario.getName());
    }

    @After()
    public void quitBrowser() {
        driver.quit();

    }

}
