package kwd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestHomeKwd extends BaseKwd {
    private static Logger logger = LogManager.getLogger(TestHomeKwd.class);

    public TestHomeKwd(WebDriver driver) {
        super(driver);
    }

    public void getHome() {
        driver.get("http://the-internet.herokuapp.com");
        captureScreen("Home page");
    }

    public String getTitle() {
        WebElement h1 = driver.findElement(By.xpath("//h1"));
        return h1.getText();
    }

 }
