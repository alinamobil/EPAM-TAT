package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.ShopMainPage;
import pageobject.SignInPage;

public class ShopMainPageTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\TAT\\WebDriver\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }

    @Test
    public void checkSalesField() {
        String color = new ShopMainPage(driver).openPage().getSalesFieldColor();
        Assert.assertEquals(color,"rgba(239, 46, 35, 1)");
    }

    @Test
    public void registrationValidationTest() throws InterruptedException {
        String error = new SignInPage(driver).openPage().openRegistration().registration("Alina","123456789","wrongemail.com").getInvalidRegistrationError();
        Assert.assertEquals(error, "Email не корректен");
    }

}
