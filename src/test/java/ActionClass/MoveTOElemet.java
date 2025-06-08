package ActionClass;

import Boilerplat.TestBoilerPlat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MoveTOElemet  extends TestBoilerPlat {

    @Test
    public void moveToelementAndClick()
    {
        driver.get("https://www.spicejet.com/");

        WebElement cityName = driver.findElement(By.xpath("//input"));

        Actions actions = new Actions(driver);
        actions.moveToElement(cityName).click().sendKeys("BLR").build().perform();

    }
}
