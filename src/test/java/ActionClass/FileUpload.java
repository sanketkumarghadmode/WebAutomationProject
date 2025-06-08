package ActionClass;

import Boilerplat.TestBoilerPlat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUpload extends TestBoilerPlat {
    /*
     File upload is only possible when there is input type= file
    * */


    @Test()
    public void VerifyFileUpload()
    {
        driver.get("https://practice.expandtesting.com/upload");

        WebElement file = driver.findElement(By.id("fileInput"));
        file.sendKeys("C:\\Users\\Sanket\\Downloads\\MOCK_DATA.csv");

        WebElement fileSubmit = driver.findElement(By.id("fileSubmit"));
        fileSubmit.click();

        String status = driver.findElement(By.xpath("//h1[text()='File Uploaded!']")).getText();

        Assert.assertEquals(status,"File Uploaded!");


    }



}
