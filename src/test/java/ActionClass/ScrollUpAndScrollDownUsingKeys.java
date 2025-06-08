package ActionClass;

import Boilerplat.TestBoilerPlat;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ScrollUpAndScrollDownUsingKeys extends TestBoilerPlat {




    @Test()
    public void scrollUp_ScrollDown()
    {
        driver.get("https://www.amazon.in/");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
        actions.sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).build().perform();

    }



}
