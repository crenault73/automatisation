package kwd;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class BaseKwd {
    public WebDriver driver;

    public BaseKwd(WebDriver driver) {
        this.driver = driver;
    }

    public void captureScreen(String title){
        byte[] screenshotByteArray = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        ByteArrayInputStream imageAsInputStream = new ByteArrayInputStream(screenshotByteArray);
        Allure.addAttachment(title, "image/png", imageAsInputStream, "png");
    }

}
