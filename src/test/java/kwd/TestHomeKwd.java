package kwd;

import common.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
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

    public void getCheckboxesPage() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
    }

    public void getAuthenticationPage() {
        driver.get("http://the-internet.herokuapp.com/login");
        captureScreen("Authentication page");
    }

    public String getTitle() {
        WebElement h1 = driver.findElement(By.xpath("//h1"));
        return h1.getText();
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

    public void authenticate(String login, String password) {
        WebElement inputUsername = driver.findElement(By.id("username"));
        inputUsername.sendKeys(login);
        WebElement inputPassword = driver.findElement(By.name("password"));
        inputPassword.sendKeys(password);

        captureScreen("Authentication");

        WebElement button = driver.findElement(By.xpath("//button [@type='submit' and contains(.,'Login')]"));
        button.click();
    }

    public void checkLogged() {
        captureScreen("Welcome page");

        WebElement welcome = driver.findElement(By.xpath("//h4 [contains(., 'Welcome')]"));
        Assert.assertEquals("Welcome to the Secure Area. When you are done click logout below.", welcome.getText());
    }

    public void authenticate(String user) {
        JSONObject users = (JSONObject) Utils.getData("users.json");
        JSONObject myUser = (JSONObject) users.get(user);
        String login = (String) myUser.get("login");
        String password = (String) myUser.get("password");
        JSONArray phoneNumbers = (JSONArray) myUser.get("phonenumbers");
        phoneNumbers.forEach(value -> logger.debug("phonenumber: " + value.toString()));

        authenticate(login, password);
    }


}
