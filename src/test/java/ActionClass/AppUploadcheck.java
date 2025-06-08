package ActionClass;

import Boilerplat.TestBoilerPlat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static WaitHelperClasss.WaitHelper.jvmStop;

public class AppUploadcheck extends TestBoilerPlat {


     @Test
    public void verifyAppUpload(){


         driver.get("https://www.browserstack.com/users/sign_in?utm_source=Email&utm_medium=Email&utm_campaign=FreeTrial_Verification");
         WebElement userName = driver.findElement(By.cssSelector("#user_email_login"));
         userName.sendKeys("jolas14372@3dboxer.com");

         WebElement passWord = driver.findElement(By.cssSelector("#user_password"));
         passWord.sendKeys("Test@123");

         WebElement user_submit = driver.findElement(By.cssSelector("#user_submit"));
         user_submit.click();


          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Upload your App']")));

         WebElement AppUploadBtn = driver.findElement(By.xpath("//div[text()='Upload your App']"));
         AppUploadBtn.click();

         WebElement uploadBtn = driver.findElement(By.xpath("//div[@class='file-upload']//input"));
         uploadBtn.sendKeys("C:\\Users\\Sanket\\Downloads\\testdroid-sample-app.apk");

         helper.checkVisiblityOfElementLocated(driver, By.xpath("//div[@class='appuploader-app__name']"), 10);

         String uploadStatus = driver.findElement(By.xpath("//div[@class='appuploader-app__name']"))
                 .getText();

         Assert.assertEquals(uploadStatus, "testdroid-sample-app.apk");


     }



}
