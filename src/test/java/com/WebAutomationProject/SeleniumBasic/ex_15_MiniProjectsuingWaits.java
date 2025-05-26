package com.WebAutomationProject.SeleniumBasic;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ex_15_MiniProjectsuingWaits {


    @Description("Verify that the error message should be display for invalid inputs")
    @Severity(SeverityLevel.NORMAL)
    @Owner("sanket")
    @Test
    public void verify_error_Message(){

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(options);

        driver.get("https://app.vwo.com/#/loign");

        WebElement emailID = driver.findElement(By.xpath("//input[@id ='login-username']"));
        emailID.sendKeys("sanket@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@id ='login-password']"));
        password.sendKeys("sanket");

        WebElement sumitBtn = driver.findElement(By.id("js-login-btn"));
        sumitBtn.click();

        WebElement erroeMsg = driver.findElement(By.id("js-notification-box-msg"));

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(erroeMsg));

        Assert.assertEquals(erroeMsg.getText(), "Your email, password, IP address or location did not match");



    }


}
