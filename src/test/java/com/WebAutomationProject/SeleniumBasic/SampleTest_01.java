package com.WebAutomationProject.SeleniumBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SampleTest_01 {



    @Test
    public void startBrowser(){

        WebDriver driver =  new FirefoxDriver();
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        driver.quit();

    }


}
