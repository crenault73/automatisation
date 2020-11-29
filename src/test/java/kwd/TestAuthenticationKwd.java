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

public class TestAuthenticationKwd extends BaseKwd{

    private static Logger logger = LogManager.getLogger(TestAuthenticationKwd.class);

    public TestAuthenticationKwd(WebDriver driver) {
        super(driver);
    }

    public void getAuthenticationPage() {
        driver.get("http://the-internet.herokuapp.com/login");
        captureScreen("Authentication page");
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
