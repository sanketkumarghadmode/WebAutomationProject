package Boilerplat;

import WaitHelperClasss.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static WaitHelperClasss.WaitHelper.jvmStop;

public class TestBoilerPlat {


   public EdgeOptions option;
   public WebDriver driver;
   public WaitHelper helper;

    @BeforeTest
    public void setUp()
    {
        option = new EdgeOptions();
      //  option.addArguments("--incognito");
        option.addArguments("--start-maximized");
        driver = new EdgeDriver(option);
        helper = new WaitHelper();
    }



    @AfterTest
    public void tearDown(){
       jvmStop(3000);
        driver.quit();
    }


}
