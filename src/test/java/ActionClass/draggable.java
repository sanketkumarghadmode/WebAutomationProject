package ActionClass;

import Boilerplat.TestBoilerPlat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class draggable extends TestBoilerPlat {


    @Test()
    public void dragAndDropUsingAction()
    {

        driver.get("https://jqueryui.com/draggable/");

        Actions actions = new Actions(driver);

        WebElement iframe = driver.findElement(By.cssSelector(".demo-frame"));
        driver.switchTo().frame(iframe);

        // only drag
        WebElement draggable = driver.findElement(By.id("draggable"));
        actions.dragAndDropBy(draggable, 200, 200).build().perform();


    }


}
