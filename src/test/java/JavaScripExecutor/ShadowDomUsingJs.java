package JavaScripExecutor;

import Boilerplat.TestBoilerPlat;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.json.Json;
import org.testng.annotations.Test;

import static WaitHelperClasss.WaitHelper.jvmStop;

public class ShadowDomUsingJs extends TestBoilerPlat {


    @Test()
    public void showDomHandleusingJs()
    {

        driver.get("https://selectorshub.com/xpath-practice-page/");

        JavascriptExecutor js  = (JavascriptExecutor)driver;

        WebElement div_Scroll = driver.findElement(By.id("userName"));

        Actions actions = new Actions(driver);
        actions.scrollToElement(div_Scroll).build().perform();
        actions.click().build().perform();



        WebElement inputBox = (WebElement)
        js.executeScript("return document.querySelector(\"div#userName\").shadowRoot.querySelector(\"div#app2\").shadowRoot.querySelector(\"input#pizza\");");

        inputBox.sendKeys("FarmHouse");

    }



}
