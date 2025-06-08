package windowHandles;

import ActionClass.DragAndDrop;
import Boilerplat.TestBoilerPlat;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

import static WaitHelperClasss.WaitHelper.jvmStop;

public class AdvanceTaskOfWindowHandle extends TestBoilerPlat {


    @Test
    public void switchTOWindowAndVerify(){

        driver.get("https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1&accountId=666400");



        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement campaign = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='js-heatmap-thumbnail']/following-sibling::li//img")));
        String mainWindow = driver.getWindowHandle();
        Actions actions = new Actions(driver);
        actions.moveToElement(campaign).click().build().perform();

        wait.until(driver -> driver.getWindowHandles().size() > 1);

        Set<String> childIds = driver.getWindowHandles();

        System.out.println(mainWindow);
        System.out.println(childIds);


        for(String id :childIds)
        {
            if(!id.equals(mainWindow))
            {
                System.out.println("i here");
                driver.switchTo().window(id);
                WebElement iframe = driver.findElement(By.xpath("//iframe[@id='heatmap-iframe']"));
                driver.switchTo().frame(iframe);
                WebElement clickMe = driver.findElement(By.xpath("  //div[@data-qa='liqokuxuba']"));
                actions.moveToElement(clickMe).build().perform();
                clickMe.click();
            }
        }




    }

}
