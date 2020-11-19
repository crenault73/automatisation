package kwd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestHomeKwd {
    private static Logger logger = LogManager.getLogger(TestHomeKwd.class);
    public WebDriver driver;

    public TestHomeKwd(WebDriver driver){
        this.driver = driver;
    }

    public void getHome(){
        driver.get("http://the-internet.herokuapp.com");
    }

    public void getPageCheckboxes(){
        driver.get("http://the-internet.herokuapp.com/checkboxes");
    }

    public String getTitle(){
        WebElement h1 = driver.findElement(By.xpath("//h1"));
        return h1.getText();
    }

    public void clickoncheckbox(int num){
        driver.findElement(By.xpath("(//input[@type=\'checkbox\'])["+num+"]")).click();
    }

    public void verifyCheckboxUnchecked(int num){
        WebElement element = driver.findElement(By.xpath("(//input[@type=\'checkbox\'])["+num+"]"));
        logger.debug(element.getAttribute("checked"));
        Assert.assertEquals(null, element.getAttribute("checked"));
    }


    public void checkboxIsChecked(int num) {
        WebElement element = driver.findElement(By.xpath("(//input[@type=\'checkbox\'])["+num+"]"));
        logger.debug(element.getAttribute("checked"));
        Assert.assertEquals("true", element.getAttribute("checked"));
    }
}
