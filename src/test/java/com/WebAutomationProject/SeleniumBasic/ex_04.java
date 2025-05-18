package com.WebAutomationProject.SeleniumBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class ex_04 {



    @Test
    public void verifyHeading() throws Exception{

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://katalon-demo-cura.herokuapp.com/");


        String pageSource = driver.getPageSource();

        if(pageSource.contains("CURA Healthcare Service"))
        {
            System.out.println("CURA Healthcare Service");
            Assert.assertTrue(true);
        }
        else
        {
            //Assert.assertTrue(false);
        throw new Exception("CURA Healthcare Service is not Found");
        }


        driver.quit();
    }

}
