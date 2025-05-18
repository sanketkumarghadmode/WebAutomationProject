package com.WebAutomationProject.SeleniumBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleTest {



    @Test
    public void startBrowser(){

        WebDriver driver =  new ChromeDriver();
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());

    }


}
