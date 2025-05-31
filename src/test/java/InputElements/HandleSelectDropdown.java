package InputElements;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.Test;

public class HandleSelectDropdown {


    @Description("Verify user should able to select option form the drop down")
    @Owner("sanket")
    @Test()
    public void verify_dropdownSelection()
    {

        EdgeOptions option = new EdgeOptions();
        option.addArguments("--incognito");
        option.addArguments("--start-maximized");

        WebDriver driver =  new EdgeDriver(option);
        driver.get("https://demoqa.com/select-menu");

        WebElement dropdown = driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));

        Select select =  new Select(dropdown);
        select.selectByValue("5");
        select.selectByVisibleText("Aqua");
        select.selectByIndex(4);


        // Multi select dropdown

        WebElement multiSelectDropdown =  driver.findElement(By.id("cars"));
        Select select1 = new Select(multiSelectDropdown);

        select1.selectByValue("volvo");
        select1.selectByIndex(1);

        select1.deselectByIndex(1);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        select1.deselectAll();

        driver.quit();
    }

}
