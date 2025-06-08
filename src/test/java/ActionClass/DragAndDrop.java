package ActionClass;

import Boilerplat.TestBoilerPlat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDrop extends TestBoilerPlat {


    @Test
    public void DragAndDrop()
    {

        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(0);

        WebElement draggable  = driver.findElement(By.id("draggable"));
        WebElement droppable =  driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, droppable).build().perform();

        String statusCheck = driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();

        Assert.assertEquals(statusCheck, "Dropped!");
    }

}
