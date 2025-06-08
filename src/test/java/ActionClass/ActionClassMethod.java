package ActionClass;

import Boilerplat.TestBoilerPlat;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


import javax.swing.*;

import static WaitHelperClasss.WaitHelper.jvmStop;

public class ActionClassMethod extends TestBoilerPlat {



    @Test
    public void action_Methods(){

        driver.get("https://awesomeqa.com/practice.html");

        WebElement firstName = driver.findElement(By.name("firstname"));

        // keyDown used to click and hold the keyboard keys
        // keyUp used to release the keyboard keys
        // build is method to build action when there are multiple command
        // perform is used to perform the action
        Actions action = new Actions(driver);
        action.keyDown(Keys.SHIFT).sendKeys(firstName,"sannket")
                .keyUp(Keys.SHIFT).build().perform();

    }

}
