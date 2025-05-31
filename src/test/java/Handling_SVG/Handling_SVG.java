package Handling_SVG;

import WaitHelperClasss.WaitHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import static WaitHelperClasss.WaitHelper.jvmStop;

public class Handling_SVG {

    EdgeOptions option;
    WebDriver driver;
    WaitHelper helper;

    @BeforeTest
    public void setUp()
    {
        option = new EdgeOptions();
        option.addArguments("guest");
        option.addArguments("--start-maximized");
        driver = new EdgeDriver(option);
    }

    @Test(enabled = false)
    public void test_Flipkart_search_SVG_icon(){


        String URL = "https://www.flipkart.com/search";
        driver.get(URL);

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("macmini");

        // handle the SVG we can use //*[local-name()='svg'] or //*[name()='svg']

        List <WebElement> serachSVG = driver.findElements(By.xpath("//*[local-name()='svg']"));
        serachSVG.get(0).click();

        helper = new WaitHelper();
        helper.checkVisiblityOfElementLocated(driver,By.xpath("//div[contains(@data-id,'CPU')]//a[2]"),10);

        List<WebElement> titles =  driver.findElements
        (By.xpath("//div[contains(@data-id,'CPU')]//a[2]"));

        for(WebElement title:titles)
        {
            System.out.println(title.getText());
        }

        }


     @Test()
     public void test_india_map_svg_icon(){

         String URL = "https://www.amcharts.com/svg-maps/?map=india";
         driver.get(URL);

         List<WebElement> states = driver.findElements(By.xpath("//*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']"));
         JavascriptExecutor js = ((JavascriptExecutor)driver);
         js.executeScript("window.scrollBy(0, 700)");

            jvmStop(3000);
         for (WebElement state: states)
         {
             //getDomAttribute() it will return the original value even the javascript changed the value
             // getAttribute() it will return the changed value if the javascript changed the value.
             String statename  = state.getAttribute("aria-label");
             System.out.println(statename);
             if(statename.contains("Maharashtra"))
             {
                 state.click();
             }





         }


     }


    @AfterTest()
    public void tearDown(){
    jvmStop(1500);
        driver.quit();
    }

}
