package popUp_Handling;

import io.qameta.allure.Description;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonTypeInfo;
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

public class AlertPop_Handle_02 {


    @Description("handle the alert pop-up")
    @Test
    public void handleAlert() throws InterruptedException {


        EdgeOptions option = new EdgeOptions();
        option.addArguments("--incognito");
        option.addArguments("--start-maximized");

        WebDriver driver =  new EdgeDriver(option);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");


        WebElement pop_up_1 =  driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        pop_up_1.click();
        driver.switchTo().alert().accept();

        WebElement reuslt = driver.findElement(By.id("result"));
       String res =  reuslt.getText();
        Assert.assertEquals(res, "You successfully clicked an alert");



        WebElement pop_up_2 =  driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        pop_up_2.click();
        driver.switchTo().alert().dismiss();
       res =  reuslt.getText();
        Assert.assertEquals(res,"You clicked: Cancel");
        pop_up_2.click();
        driver.switchTo().alert().accept();
       res = reuslt.getText();
        Assert.assertEquals(res,"You clicked: Ok");



        WebElement pop_up_3 =  driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        pop_up_3.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().sendKeys("Sanket");
        driver.switchTo().alert().accept();
        res = reuslt.getText();
        Assert.assertEquals(res, "You entered: Sanket");

        driver.quit();
    }
}
