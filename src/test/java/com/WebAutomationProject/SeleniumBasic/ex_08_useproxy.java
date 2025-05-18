package com.WebAutomationProject.SeleniumBasic;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;



public class ex_08_useproxy {


    @Test
    public void addtheProxy()
    {

        Proxy proxy = new Proxy();
        proxy.setHttpProxy("188.255.245.205:1080");
        proxy.setSslProxy("188.255.245.205:1080"); // Optional, for HTTPS

        // Set Edge options and attach proxy
        EdgeOptions options = new EdgeOptions();
        options.setProxy(proxy);

        // Initialize EdgeDriver with options
        WebDriver driver = new EdgeDriver(options);

        // Open a site to test
        driver.get("https://www.google.com");


        driver.quit();



    }

}
