package WebTable;

import WaitHelperClasss.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class DynamicWebTable {



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
        helper = new WaitHelper();
    }

    @Test
    public void handleDynamicWebTable(){

        driver.get("https://awesomeqa.com/webtable1.html");


        List<WebElement> row = driver.findElements(By.xpath("//tbody//tr//td"));

        for(WebElement col:row)
        {
            System.out.println(col.getText());
        }
        for(int i =0;i<row.size();i++){

            List<WebElement> col = row.get(i).findElements(By.tagName("td"));

            for(WebElement data:col)
            {
                System.out.println(data.getText());
            }

        }

    }



    @AfterTest()
    public void tearDown(){

        driver.quit();
    }






}
