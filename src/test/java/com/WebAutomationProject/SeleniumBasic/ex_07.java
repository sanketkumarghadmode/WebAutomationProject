package com.WebAutomationProject.SeleniumBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.io.File;

public class ex_07 {


    // all the option driver are used to customized
    // and configure the browser behaviour during the test automation

    // add the extension
    //  add the argument(before staring the browser)
    //  heading (no UI)
    //  incognito mode

    // from the below url we can add the argument
    // https://peter.sh/experiments/chromium-command-line-switches/


    @Test
    public void setEdgeOptions(){

     EdgeOptions edgeOptions = new EdgeOptions();

     edgeOptions.addArguments("--window-size = 1280,720");
     edgeOptions.addArguments("--window-size = 1280,720");
     edgeOptions.addArguments("--incognito");
     edgeOptions.addArguments("--start-maximized");

     // Headless mode
     // in the Headless there is no visible user interface
        // faster in execution
        // use less CPU more efficient
        // debugging is difficult

      edgeOptions.addArguments("--headless");

    //  how to add the extenstion in browser

        edgeOptions.addExtensions(new File("path of a file "));

      WebDriver driver = new EdgeDriver(edgeOptions);


    }



}
