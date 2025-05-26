package InputElements;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class StaticSelect {

    /*
           practice link - https://demoqa.com/select-menu

 The Select class in Selenium is used to handle dropdowns start form the select tag
 (HTML <select> tags) — it can handle both single-select and multi-select dropdowns.
  */

    @Description("HandleInput Elements")
    @Severity(SeverityLevel.NORMAL)
    @Owner("sanket")
    @Test
    public void VerifyInputElements() {

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(options);

        driver.get("https://awesomeqa.com/practice.html");

        // we need to find the dropdown by using the locator
        WebElement Continents = driver.findElement(By.xpath("//select[@name='continents']"));

        // Create the object of select class and pass the dropdown element as argument to perform the operation
        Select dropdown = new Select(Continents);

        //we can select
        // selectByIndex(0)
        // selectByVisibleText("text")
        // selectByvalue("2")

        dropdown.selectByIndex(0);
        dropdown.selectByVisibleText("Europe");



        driver.quit();


    }
    }
