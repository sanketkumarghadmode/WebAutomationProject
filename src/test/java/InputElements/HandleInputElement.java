package InputElements;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class HandleInputElement {


    @Description("HandleInput Elements")
    @Severity(SeverityLevel.NORMAL)
    @Owner("sanket")
    @Test
    public void VerifyInputElements(){

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(options);

        driver.get("https://awesomeqa.com/practice.html");


        driver.findElement(By.name("firstname")).sendKeys("TestFristname");
        driver.findElement(By.name("lastname")).sendKeys("Testlstname");
        driver.findElement(By.cssSelector("#sex-1")).click();
        driver.findElement(By.cssSelector("#exp-6")).click();

        driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("13/09/1999");

        driver.findElement(By.xpath("//input[@id='profession-1']")).click();

        driver.quit();




    }
}
