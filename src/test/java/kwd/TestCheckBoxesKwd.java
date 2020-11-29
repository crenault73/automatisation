package kwd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCheckBoxesKwd extends BaseKwd{
    private static Logger logger = LogManager.getLogger(TestDragndropKwd.class);

   public TestCheckBoxesKwd(WebDriver driver) {
        super(driver);
    }

    public void getCheckboxesPage() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
    }
    public void clickoncheckbox(int num) {
        driver.findElement(By.xpath("(//input[@type=\'checkbox\'])[" + num + "]")).click();
    }

    public void verifyCheckboxUnchecked(int num) {
        WebElement element = driver.findElement(By.xpath("(//input[@type=\'checkbox\'])[" + num + "]"));
        logger.debug(element.getAttribute("checked"));
        Assert.assertEquals(null, element.getAttribute("checked"));
    }

    public void checkboxIsChecked(int num) {
        WebElement element = driver.findElement(By.xpath("(//input[@type=\'checkbox\'])[" + num + "]"));
        logger.debug(element.getAttribute("checked"));
        Assert.assertEquals("true", element.getAttribute("checked"));
    }
}
