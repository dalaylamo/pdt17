package com.example.hw2;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class TestBase {

    private static WebDriver driver;
    private static String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://localhost/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }


    protected void clickSubmit() {
        driver.findElement(By.name("submit")).click();
    }

    protected void fillOutForm(ContactData contactData) {
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys(contactData.getAddress());
        driver.findElement(By.name("home")).clear();
        driver.findElement(By.name("home")).sendKeys(contactData.getHomePhone());
        driver.findElement(By.name("mobile")).clear();
        driver.findElement(By.name("mobile")).sendKeys(contactData.getMobilePhone());
        driver.findElement(By.name("work")).clear();
        driver.findElement(By.name("work")).sendKeys(contactData.getWorkPhone());
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(contactData.getEmailFirst());
        driver.findElement(By.name("email2")).clear();
        driver.findElement(By.name("email2")).sendKeys(contactData.getEmailSecond());
        new Select(driver.findElement(By.name("bday"))).selectByVisibleText(contactData.getDayOfBirth());
        new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getMonthOfBirth());
        driver.findElement(By.name("byear")).clear();
        driver.findElement(By.name("byear")).sendKeys(contactData.getYearOfBirth());
        new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getSelectGroup());
        driver.findElement(By.name("address2")).clear();
        driver.findElement(By.name("address2")).sendKeys(contactData.getAddressSecond());
        driver.findElement(By.name("phone2")).clear();
        driver.findElement(By.name("phone2")).sendKeys(contactData.getPhoneSecond());
    }

    protected void clickAddNew() {
        driver.findElement(By.linkText("add new")).click();
    }

    protected void openMain() {
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
