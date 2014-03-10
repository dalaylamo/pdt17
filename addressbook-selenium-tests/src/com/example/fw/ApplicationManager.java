package com.example.fw;

import com.example.tests.ContactData;
import com.example.tests.GroupData;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;


public class ApplicationManager {

    public WebDriver driver;
    public String baseUrl;

    public NavigationHelper navigationHelper;
    public GroupHelper groupHelper;
    public ContactHelper contactHelper;


    public ApplicationManager(){
        driver = new FirefoxDriver();
        baseUrl = "http://localhost/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void stop() {
        driver.quit();

    }


}
