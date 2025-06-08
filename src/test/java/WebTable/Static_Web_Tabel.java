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

public class Static_Web_Tabel {


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

    @Test()
    public void verifyThe_tableValues(){

        driver.get("https://awesomeqa.com/webtable.html");

       int row = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
       int col = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td")).size();


       String firstPart =  "//table[@id='customers']/tbody/tr[";
       String secPart =  "]/td[";
       String last = "]";

       for(int i =2; i<=row; i++)
       {
           for(int j =1;j<=col;j++)
           {
               String DynamicXpath = firstPart+i+secPart+j+last;
               String data = driver.findElement(By.xpath(DynamicXpath)).getText();
              // System.out.print(" "+data+"   ");
              // System.out.println();

               if(data.contains("Giovanni Rovelli"))
               {
                   String countryPath = DynamicXpath+"/following-sibling::td";
                   String CountryName = driver.findElement(By.xpath(countryPath)).getText();
                   System.out.print("- "+CountryName);
               }

           }


       }





    }



    @AfterTest()
    public void tearDown()
    {
        driver.quit();
    }


}
