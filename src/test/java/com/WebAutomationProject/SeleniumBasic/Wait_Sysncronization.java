package com.WebAutomationProject.SeleniumBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Wait_Sysncronization {


    /*
         SYNCHRONIZATION  :-

    Synchronization is a condition where two systems (e.g., the web application and the WebDriver) work in parallel.
Since WebDriver is faster, it might try to interact with elements before they are available on the application.
This can lead to exceptions like NoSuchElementException, hence we use synchronization to handle such scenarios.

         there are two type of Synchronization
         1) Unconditional Synchronization
         2) Conditional Synchronization

         1)  Unconditional Synchronization

          Unconditional Synchronization is when the web driver wait for train amount of time it called as
          Unconditional Synchronization

          1) Thread.sleep(2000)

            Thread.sleep() is a Java method that pauses the execution for the given time.
            It accepts time in milliseconds.

         Drawback: Not recommended because:
           It waits unnecessarily even if the element loads early.
           It slows down the test execution.
           It doesn't check for any condition — it just waits.


           Conditional Synchronization

           Conditional Synchronization is when WebDriver waits only until a certain condition is met
           like element is visible, clickable etc. within a given timeout
           If the condition met early, execution continue to make test faster

           There are three type of   Conditional Synchronization

           1) implicit wait : -
              Implicit Wait is used to tell WebDriver to wait for a certain
              amount of time before throwing a NoSuchElementException.

              It automatically applies to all elements in the script after being set once

              t is used when the elements take some time to appear in the DOM.
              It does not wait for specific conditions like visibility or click ability.

           2) Explicit wait

              Explicit Wait is a type of conditional synchronization where WebDriver waits until a specific condition
              is met or the maximum time expires

              It is used to wait for specific elements or specific states,
              like visibility, clickable, presence, etc

              Sometimes, elements may take longer to load or become interactable.
              Using explicit wait helps avoid issues like:

              ElementNotVisibleException
              ElementNotInteractableException
              NoSuchElementException

              WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
              wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));


              FLUENT WAIT:
              fluent-wait is Mechanism to check the for the specific
              condition with defined polling frequency and timeout,
              while ignoring specified exception during wait

               Fluent Wait is a type of explicit wait that allows you to:

              Define the maximum timeout.
              Set a polling frequency (how often to check).
              Ignore specific exceptions (like NoSuchElementException).

              It is used when elements appear at varying intervals or under fluctuating load times.

              Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))        // Maximum wait time
                .pollingEvery(Duration.ofSeconds(5))        // Polling interval
                .ignoring(NoSuchElementException.class);    // Ignore this exception

                  WebElement element = wait.until(
                  ExpectedConditions.visibilityOfElementLocated(By.id("username")));


    * */



       @Test
       public void waits(){

           WebDriver driver = new ChromeDriver();
           driver.manage().deleteAllCookies();
           driver.manage().window().maximize();

           driver.get("https://www.google.com");
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

           try {
               Thread.sleep(100);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }


           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='gNO89b']")));



       }

}
