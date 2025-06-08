package WebTable;

import WaitHelperClasss.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static WaitHelperClasss.WaitHelper.jvmStop;

public class CustomeTable {

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

    @Test
    public void handleCustomeTable(){

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


        helper.checkVisiblityOfElementLocated(driver,By.name("username"),20);
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("Admin");

        WebElement passWord = driver.findElement(By.name("password"));
        passWord.sendKeys("admin123");

        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();

        helper.checkVisiblityOfElementLocated(driver,By.xpath("//span[text()='PIM']"));
        WebElement PIM = driver.findElement(By.xpath("//span[text()='PIM']"));
        PIM.click();

        helper.checkVisiblityOfElementLocated(driver,By.xpath("//div[@class='oxd-table-card']"));

         List<WebElement> tabeldata = driver.findElements(By.xpath("//div[@data-v-6c07a142]"));


         for(WebElement Alldata : tabeldata) {
             System.out.println(Alldata.getText());
         }
    }


    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
