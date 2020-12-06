package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.ShopMainPage;
import pageobject.SignInPage;

public class ShopMainPageTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }

    @Test
    public void correctSearchWordTest() {
        Assert.assertEquals(new ShopMainPage(driver).openPage().wrongSearchWord("дрэль").getWordCorrected().trim(), "Результаты по запросу «дрель»");
    }

    @Test
    public void registrationValidationTest() throws InterruptedException {
        String error = new SignInPage(driver).openPage().openRegistration().registration("Alina","123456789","wrongemail.com").getInvalidRegistrationError();
        Assert.assertEquals(error, "Email не корректен");
    }

}
