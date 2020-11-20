package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.SearchShopHomePage;
import pageobject.ShopMainPage;

public class ShopMainPageTest {
    private String searchWord = "дрэль";
    private String correctedWordMessage = "дрель";
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }

    @Test
    public void correctSearchWordTest() {
        SearchShopHomePage params = new SearchShopHomePage(searchWord, correctedWordMessage);
        Assert.assertEquals(new ShopMainPage(driver).openPage().wrongSearchWord(params).getWordCorrected().trim(), "Результаты по запросу «дрель»");
    }
}
