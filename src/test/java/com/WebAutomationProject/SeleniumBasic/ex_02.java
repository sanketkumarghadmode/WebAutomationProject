package com.WebAutomationProject.SeleniumBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ex_02 {



    @Test
    public void Webdrivermethods()
    {
    //  selenium 3 browser setUp
    // System.setProperty("webdirver.chrome.driver","path of the browser driver which you want to user")


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://www.google.com");

        String title =  driver.getTitle();
        String currentUrl = driver.getCurrentUrl();
        String pageSource =  driver.getPageSource();


        System.out.println(title);
        System.out.println(currentUrl);
        System.out.println(pageSource);


        driver.manage().window().minimize();

    driver.quit();

    }


}
