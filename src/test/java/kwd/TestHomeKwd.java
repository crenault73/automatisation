package kwd;

import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.*;
import java.text.ParseException;

public class TestHomeKwd {
    private static Logger logger = LogManager.getLogger(TestHomeKwd.class);
    public WebDriver driver;

    public TestHomeKwd(WebDriver driver){
        this.driver = driver;
    }

    public void getHome(){
        driver.get("http://the-internet.herokuapp.com");
        captureScreen("Home page");
    }

    public void getCheckboxesPage(){
        driver.get("http://the-internet.herokuapp.com/checkboxes");
    }

    public void getAuthenticationPage(){
        driver.get("http://the-internet.herokuapp.com/login");
        captureScreen("Authentication page");
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

    public void captureScreen(String title){
        byte[] screenshotByteArray = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        ByteArrayInputStream imageAsInputStream = new ByteArrayInputStream(screenshotByteArray);
        Allure.addAttachment(title, "image/png", imageAsInputStream, "png");
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
        JSONObject users = (JSONObject) getData("users.json", user);
        JSONObject myUser = (JSONObject) users.get(user);
        String login = (String) myUser.get("login");
        String password = (String) myUser.get("password");
        JSONArray phoneNumbers = (JSONArray) myUser.get("phonenumbers");
//        for(Object num:phoneNumbers){
//            logger.debug("phonenumber: "+num.toString());
//        }
        phoneNumbers.forEach(value -> logger.debug("phonenumber: "+value.toString()));

        authenticate(login, password);
    }

    private Object getData(String file, String user) {
        Object data = null;
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("data" + File.separator + file);
            JSONParser jsonParser = new JSONParser();
            data = jsonParser.parse(new InputStreamReader(inputStream));
            logger.debug("json file" + data.toString());
        }catch(org.json.simple.parser.ParseException pe){
            logger.debug("error parsing file"+file, pe);
        }catch (IOException ioe){
            logger.error("error loading"+file, ioe);
        }
        return data;
    }
}
