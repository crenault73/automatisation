package kwd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestDragndropKwd extends BaseKwd {
    private static Logger logger = LogManager.getLogger(TestDragndropKwd.class);

    public TestDragndropKwd(WebDriver driver) {
        super(driver);
    }

    public void getDragndropPage() {
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");
    }

    public void dragNDrop() {
        WebElement dragged = driver.findElement(By.id("column-a"));
        WebElement dropped = driver.findElement(By.id("column-b"));
        //HTML 5
        final String java_script = ""
                + "var src=arguments[0],tgt=arguments[1];"
                + "var dataTransfer={"
                + "  dropEffect:'',effectAllowed:'all',files:[],items:{},types:[],"
                + "  setData:function(format,data){"
                + "    this.items[format]=data;"
                + "    this.types.push(format);"
                + "  },"
                + "  getData:function(format){"
                + "    return this.items[format];"
                + "  },"
                + "  clearData:function(format){}"
                + "};"
                + "var emit=function(event,target){"
                + "  var evt=document.createEvent('Event');"
                + "  evt.initEvent(event,true,false);"
                + "  evt.dataTransfer=dataTransfer;"
                + "  target.dispatchEvent(evt);"
                + "};"
                + "emit('dragstart',src);"
                + "emit('dragenter',tgt);"
                + "emit('dragover',tgt);"
                + "emit('drop',tgt);"
                + "emit('dragend',src);";

        ((JavascriptExecutor) driver).executeScript(java_script, dragged, dropped);
    }

    public void checkBinPlaceOfA() {
        WebElement column_a = driver.findElement(By.id("column-a"));
        WebElement column_b = driver.findElement(By.id("column-b"));
        logger.debug("column-a: " + column_a.getText() + " column-b: " + column_b.getText());
        Assert.assertEquals("B", column_a.getText());
        Assert.assertEquals("A", column_b.getText());
    }
}
