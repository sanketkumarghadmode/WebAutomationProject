package com.WebAutomationProject.SeleniumBasic;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ex_12_verify_errorMsg {

    @Owner("Sanket")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that the error message should display for invalid email on sign up page")
    @Test
    public void verify_the_errorMeesage()
    {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://app.vwo.com/#/login");

        WebElement a_tag_link = driver.findElement(By.partialLinkText("trial"));
        a_tag_link.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("free-trial"));

        WebElement textBox = driver.findElement(By.id("page-v1-step1-email"));
        textBox.sendKeys("abc");

        WebElement checkBox = driver.findElement(By.name("gdpr_consent_checkbox"));
        checkBox.click();

        List<WebElement> continueBtn = driver.findElements(By.tagName("button"));
        continueBtn.get(0).click();

        WebElement errorMsg = driver.findElement(By.className("invalid-reason"));
        Assert.assertEquals(errorMsg.getText(),"The email address you entered is incorrect.");

        driver.quit();
    }
}
