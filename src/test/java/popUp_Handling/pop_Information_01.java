package popUp_Handling;

public class pop_Information_01 {


    // A pop-up is small window which displayed when the page load or interaction with any element
    // it disrupts the normal flow of application
    /*
          Some of the pop-up are not directly handle by selenium web driver
          we can handle those pop-up by third party tool like autoid,  Sikuli etc

          1) Authentication pop-up
          2) Notification Pop-ups
          3) OS-level File Upload Dialog  etc


      we can handle some pop-up by selenium web driver

      1) alert pop-up : -
                        alert pop-up is small notification blocks user interaction
                         with the page until accepted/dismissed.

                   there are three type of alert pop-up
                   1) simple alert with ok button
                   2) prompt alert with ok and cancel button with the text input
                   3) Confirmation alert  ok and cancel button

       we can handle these pop-up using the selenium wedriver method

       simple alert which has ok  button we can handle by
       driver.switchTo().alert.accept();

       prompt alert which have the text box ok and cancel CTA
       we can handle by
       driver.switchTo().alert.sendKeys("Message");
       driver.switchTo().alert.accept();  -  to click on ok button
       driver.switchTo().alert.dismiss(); - to click on cancel button






    * */



}
