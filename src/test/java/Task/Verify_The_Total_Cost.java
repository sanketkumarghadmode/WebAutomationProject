package Task;

import WaitHelperClasss.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Verify_The_Total_Cost {




    EdgeOptions option;
    WebDriver driver;
    WaitHelper helper;

    @BeforeTest
    public void setUp()
    {
        option = new EdgeOptions();
        option.addArguments("guest");
        option.addArguments("--start-maximized");
        driver = new EdgeDriver(option);
        helper = new WaitHelper();
    }

    @Test()
    public void verify_The_total_cost()
    {
        String url = "https://demo.applitools.com/index.html";
        driver.get(url);

        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("Admin");

        WebElement Password = driver.findElement(By.id("password"));
        Password.sendKeys("Password@123");

        WebElement loginBtn = driver.findElement(By.id("log-in"));
        loginBtn.click();

        WebElement afterloginText  = driver.findElement(By.cssSelector(".element-header"));
        Assert.assertEquals(afterloginText.getText().trim(),"Financial Overview");

        List<WebElement> amounts = driver.findElements(By.xpath("//td[contains(@class,'text-right')]/span"));
        double sum=0.0d;
        for(WebElement amount : amounts)
        {
            String number = amount.getText();
            number = number.replace("+","")
                    .replace("USD","")
                    .replace(",","")
                    .replace(" ","").trim();

           // number = number.replaceAll("[0-9]","")
            double value = Double.parseDouble(number);
            sum += value ;
        }
       Assert.assertEquals(sum,1996.22);
    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }
}
