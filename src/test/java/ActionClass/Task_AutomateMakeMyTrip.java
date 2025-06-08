package ActionClass;

import Boilerplat.TestBoilerPlat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static WaitHelperClasss.WaitHelper.jvmStop;

public class Task_AutomateMakeMyTrip extends TestBoilerPlat {

    @Test
    public void verify_dropdownInput(){

        driver.get("https://www.makemytrip.com/");

        helper.checkVisiblityOfElementLocated
       (driver, By.xpath("//span[@class='commonModal__close']"));

        WebElement closeBtn = driver.findElement(By.xpath("//span[@class='commonModal__close']"));
        closeBtn.click();

        WebElement fromCity = driver.findElement(By.id("fromCity"));

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='fromCity']")));

        Actions actions = new Actions(driver);
        actions.moveToElement(fromCity).click().sendKeys(fromCity,"IXC").build().perform();

        jvmStop(3000);
        List<WebElement> citylist = driver.findElements(By.xpath("//li[@role='option']"));

        for(WebElement citys:citylist)
        {
            if(citys.getText().contains("Chandigarh"))
            {
                citys.click();
            }
        }



    }

}
