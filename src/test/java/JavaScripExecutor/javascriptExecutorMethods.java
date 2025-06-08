package JavaScripExecutor;

import Boilerplat.TestBoilerPlat;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class javascriptExecutorMethods extends TestBoilerPlat {


    /*
          JavascriptExecutor is the interface in the selenium webDriver that allow to execute javascript
          code within the browser context

          Key Features
          Enabled execution of javascript code in the current window or frame
          It provides two main methods: executeScript() and executeAsyncScript();
          It is useful to handle the Dynamic web Content and complex interaction
    */



    @Test()
    public void clickUsingJscode()
    {

        driver.get("https://selectorshub.com/xpath-practice-page/");

        JavascriptExecutor js = (JavascriptExecutor)driver;

        String url = js.executeScript("return document.URL;").toString();
        System.out.println(url);

        String title = js.executeScript("return document.title;").toString();
        System.out.println(title);


        WebElement userName = driver.findElement(By.id("userName"));
        js.executeScript("arguments[0].scrollIntoView(true);",userName);

       // js.executeScript("arguments[0].click();", userName);

        js.executeScript("window.scrollBy(0, 1000);");



    }









}