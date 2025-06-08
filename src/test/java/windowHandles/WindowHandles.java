package windowHandles;

import Boilerplat.TestBoilerPlat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WindowHandles  extends TestBoilerPlat {


    // as we know ever window has the 16 digit unique id assigned to it
    // and we can switch between the these windows by using selenium methods
    // if we use getWindowHandle it will return 16-digit id of window
    // if we use getWindowHandles it will return set of id's



    @Test()
    public void windowHandle()
    {

        driver.get("https://the-internet.herokuapp.com/windows");

        String parent = driver.getWindowHandle();

        WebElement openLik = driver.findElement(By.xpath("//a[text()='Click Here']"));
        openLik.click();

        Set<String> childIds = driver.getWindowHandles();

        for(String ids : childIds)
        {

            driver.switchTo().window(ids);
            if(driver.getPageSource().contains("New Window"))
            {
                System.out.println("Test Pass");

            }
        }







    }

}
