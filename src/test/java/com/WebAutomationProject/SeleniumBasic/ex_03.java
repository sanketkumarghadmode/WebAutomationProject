package com.WebAutomationProject.SeleniumBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ex_03 {



    @Test
    public void setUp(){

        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get("https://www.google.com");

        assertThat(driver.getTitle()).isNotNull().isNotBlank().isNotEmpty();

        driver.quit();


    }

}
