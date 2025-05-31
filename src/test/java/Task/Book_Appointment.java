package Task;

import WaitHelperClasss.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.sound.midi.Soundbank;
import java.util.Iterator;
import java.util.List;

import static WaitHelperClasss.WaitHelper.jvmStop;

public class Book_Appointment {

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
    public void test_book_Appointment()
    {
        String URL = "https://katalon-demo-cura.herokuapp.com/";
        driver.get(URL);

        WebElement bookAp_Btn = driver.findElement(By.cssSelector("#btn-make-appointment"));
        bookAp_Btn.click();

        WebElement username = driver.findElement(By.cssSelector("#txt-username"));
        username.sendKeys("John Doe");

        WebElement password = driver.findElement(By.cssSelector("#txt-password"));
        password.sendKeys("ThisIsNotAPassword");

        WebElement loginBtn = driver.findElement(By.cssSelector("#btn-login"));
        loginBtn.click();

        helper.checkVisiblityOfElementLocated(driver,By.xpath("//select"));
        WebElement facility = driver.findElement(By.xpath("//select"));

        Select select = new Select(facility);
        select.selectByVisibleText("Seoul CURA Healthcare Center");

        WebElement applycheckBox = driver.findElement(By.cssSelector(".checkbox-inline"));
        applycheckBox.click();

        List<WebElement> radioButton = driver.findElements(By.cssSelector(".radio-inline"));
        radioButton.get(0).click();

        WebElement calendar = driver.findElement(By.cssSelector("#txt_visit_date"));
        calendar.click();

        int attempt = 0;
         while (attempt < 12)
         {
             WebElement month  = driver.findElement(By.xpath("//th[@class='datepicker-switch']"));
             if(month.getText().contains("Sep")) {
                 WebElement date = driver.findElement(By.xpath("//td[@class= 'day' and text()='2']"));
                 date.click();
                 break;
             }
             WebElement nextBtn = driver.findElement(By.xpath("//th[@class='next']"));
             nextBtn.click();
         }


         WebElement comment = driver.findElement(By.name("comment"));
         comment.sendKeys("I want to check my full health");

         WebElement bookAp_btn = driver.findElement(By.id("btn-book-appointment"));
         bookAp_btn.click();

         helper.checkVisiblityOfElementLocated(driver,By.xpath("//p[@id='comment']"),10);

         WebElement status = driver.findElement(By.xpath("//p[@id='comment']"));
         Assert.assertEquals(status.getText(),"I want to check my full health");

         WebElement menu = driver.findElement(By.cssSelector("#menu-toggle"));
         menu.click();

         WebElement logout = driver.findElement(By.xpath("//a[text()='Logout']"));
         logout.click();

    }





    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }

}
