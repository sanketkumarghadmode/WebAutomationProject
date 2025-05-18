package com.WebAutomationProject.SeleniumBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ex_11_TaskMarch23 {



    @Test
    public void verify_CurrentUrlChange(){

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement makeAppointment_Btn = driver.findElement(By.id("btn-make-appointment"));
        makeAppointment_Btn.click();

        WebElement userNameInputBox = driver.findElement(By.name("username"));
        userNameInputBox.sendKeys("John Doe");

        WebElement  passwordTextBox = driver.findElement(By.name("password"));
        passwordTextBox.sendKeys("ThisIsNotAPassword");

        WebElement login_Btn = driver.findElement(By.id("btn-login"));
        login_Btn.click();

        String currentUrl = driver.getCurrentUrl();

        WebElement Btn = driver.findElement(By.id("btn-make-appointment"));
        String Btn_text = Btn.getText();

        Assert.assertEquals(currentUrl,"https://katalon-demo-cura.herokuapp.com/#appointment");
        Assert.assertEquals(Btn_text,"Make Appointment");




    }

}
