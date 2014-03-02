package com.example.hw1;


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class TestBase {
    private static WebDriver driver;
    private static String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeTest
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://localhost/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }


    protected void returnToGroupsPage() {
        driver.findElement(By.linkText("group page")).click();
    }

    protected void submitGroupCreation() {
        driver.findElement(By.name("submit")).click();
    }

    protected void fillGroupForm(GroupData groupData) {
        driver.findElement(By.name("group_name")).clear();
        driver.findElement(By.name("group_name")).sendKeys(groupData.getName());
        driver.findElement(By.name("group_header")).clear();
        driver.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
        driver.findElement(By.name("group_footer")).clear();
        driver.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    protected void initGroupCreation() {
        driver.findElement(By.name("new")).click();
    }

    protected void gotoGroupsPage() {
         driver.findElement(By.linkText("groups")).click();
     }

    protected void openMainPage() {
         driver.get(baseUrl + "/addressbookv4.1.4/");
     }



    private boolean isElementPresent(By by) {
            try {
                driver.findElement(by);
                return true;
            } catch (NoSuchElementException e) {
                return false;
            }
        }

    private boolean isAlertPresent() {
            try {
                driver.switchTo().alert();
                return true;
            } catch (NoAlertPresentException e) {
                return false;
            }
        }

    private String closeAlertAndGetItsText() {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                if (acceptNextAlert) {
                    alert.accept();
                } else {
                    alert.dismiss();
                }
                return alertText;
            } finally {
                acceptNextAlert = true;
            }
        }
}
