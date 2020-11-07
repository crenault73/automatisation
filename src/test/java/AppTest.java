import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AppTest {

    public static WebDriver driver;

    public static void tempo(long delay) {
        try {
            driver.wait(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After()
    public void tearDown() {
        driver.quit();
    }

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
    }


    @Test
    public void testSite() {
        driver.get("http://the-internet.herokuapp.com/");
        //<h1 class="heading">Welcome to the-internet</h1>
        WebElement title = driver.findElement(By.xpath("//h1"));
        System.out.println("Contenu de title: " + title.getText());
        Assert.assertEquals("Welcome to the-internet", title.getText());

        List<WebElement> list = driver.findElements(By.xpath("//ul/li/a [contains(@href, 'dynamic')]"));


        System.out.println("The list :");
        for (WebElement we : list) {
            System.out.println(we.getText());
        }

        List<WebElement> filteredElements = (List<WebElement>) list.stream() .filter(we -> we.getText().contains("Controls")) .collect(Collectors.toList());

        for (WebElement we : filteredElements) {
            System.out.println(we.getText());
        }

        WebElement image = driver.findElement(By.xpath("//img[@alt='Fork me on GitHub']"));
        image.click();
        AppTest.tempo(3000);

    }

    @Test
    public void testDropDown() {
        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Dropdown")).click();
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        dropdown.findElement(By.xpath("//option[. = 'Option 2']")).click();
        //Check if selected element in the list is 'Option 2'
        Assert.assertEquals("Option 2", dropdown.findElement(By.xpath("//option [@selected='selected']")).getText() );
        AppTest.tempo(3000);
    }

}
