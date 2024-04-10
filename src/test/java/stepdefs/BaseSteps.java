package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.util.HashMap;

public class BaseSteps {
    private static Logger logger = LogManager.getLogger(BaseSteps.class);

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    private void initWithLocalWebDriver(){
        ChromeOptions chrome_options = new ChromeOptions();
        if (true) {
            chrome_options.addArguments("headless");
        }
        driver = new ChromeDriver(chrome_options);
    }

    private void initWithRemoteWebDriver() throws MalformedURLException {

        String hubURL = "https://hub.lambdatest.com/wd/hub";

        String[] Tags = new String[] { "Feature", "Falcon", "Severe" };

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("browserVersion", "latest");

        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("user",  System.getenv("LT_USERNAME"));
        ltOptions.put("accessKey", System.getenv("LT_ACCESS_KEY"));
        ltOptions.put("build", "Automation Sample Selenium 4");
        ltOptions.put("name", this.getClass().getName());
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("seCdp", true);
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("tags", Tags);
        capabilities.setCapability("LT:Options", ltOptions);

        driver = new RemoteWebDriver(new URL(hubURL), capabilities);
    }

    @Before()
    public void setup(Scenario scenario) {

        try {
            initWithRemoteWebDriver();
        } catch (MalformedURLException e) {
            logger.error("Error while initializing remote driver: ", e.getMessage());
        }
//        ChromeOptions chrome_options = new ChromeOptions();
//        if (true) {
//            chrome_options.addArguments("headless");
//        }
//        driver = new ChromeDriver(chrome_options);
        logger.debug("Thread ID - " + Thread.currentThread().getId() + " Scenario: " + scenario.getName());
    }

    @After()
    public void quitBrowser() {
        driver.quit();

    }

}
