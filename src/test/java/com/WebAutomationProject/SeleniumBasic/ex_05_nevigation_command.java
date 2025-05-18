package com.WebAutomationProject.SeleniumBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ex_05_nevigation_command {


    @Test
    public void setUp(){

        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.google.com");
        driver.navigate().forward();
        driver.navigate().back();
        driver.navigate().refresh();


        driver.quit();

    }

}
