package com.WebAutomationProject.SeleniumBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ex_10_miniProject {



    @Test
    public void VerifyErrorMessage(){

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(options);

        driver.navigate().to("https://app.vwo.com/#/login");

        WebElement emailInputBox = driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys("admin@admin.com");

        // Preferances rool
        // Id - name - class name  - tag name - link text/ partial link text(a tag) - Css selector - Xpath


        WebElement passwordInputBox =  driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("admin");

        WebElement submit_Btn = driver.findElement(By.id("js-login-btn"));
        submit_Btn.click();

        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        WebElement errorText = driver.findElement(By.className("notification-box-description"));
        String errorMessage = errorText.getText();



        Assert.assertEquals(errorMessage,"Your email, password, IP address or location did not match");


        driver.quit();
    }
}
