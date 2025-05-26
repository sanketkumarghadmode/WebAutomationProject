package com.WebAutomationProject.SeleniumBasic;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ex_14_FormVerify {


    @Description("Verify the form submiting with valid inputs")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("sanket")
    @Test()
    public void verify_Form(){

        WebDriver driver = new EdgeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://bdcdev.in/work/godrej.com/latest/inquiry");


         driver.findElement(By.xpath("//label[@for='businessUnitInterestedIn']/parent::div")).click();
         List<WebElement> businessUnitlist = driver.findElements(By.xpath("//div//label[text()='Preferable Business Unit*']/following::div[1]//ul//li"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(businessUnitlist.get(2)));

        String businessunitname = businessUnitlist.get(2).getText();
         businessUnitlist.get(2).click();






         driver.findElement(By.xpath("//label[@for='business_category']/parent::div")).click();
         List<WebElement> businessCategory = driver.findElements(By.xpath("//li[@data-category-business]"));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for(WebElement buCatlist:businessCategory)
         {
             String list = buCatlist.getAttribute("data-category-business");
             if(businessunitname.equalsIgnoreCase(list))
             {
                 buCatlist.click();
                 break;

             }


         }




        driver.quit();

    }




}
