package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShopMainPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    @FindBy(className = "js-search-input")
    private WebElement searchField;

    @FindBy(className = "header-search-form")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"searchForm\"]/div[4]/div/div[1]/div[1]/a")
    private WebElement searchWord;

    @FindBy(xpath = "//*[@class=\"header-menu clearfix\"]/div[2]/div[2]")
    private WebElement salesHeader;

    @FindBy(xpath = "//*[@class=\"catalog-grid js-to-max-height-wrap js_catalog_list\"]/div[1]/div[2]/span")
    private WebElement redSalesField;

    public ShopMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ShopMainPage openPage() {
        driver.navigate().to("https://www.oma.by");
        logger.info("Main page opened");
        return this;
    }

//    public ShopMainPage wrongSearchWord(String searchword) {
//        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(searchField));
//        searchField.sendKeys(searchword);
//        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
//        return new ShopMainPage(driver);
//    }
//
//    public String getWordCorrected() {
//        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(searchWord));
//        return searchWord.getText();
//    }

    public String getSalesFieldColor(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(salesHeader));
        salesHeader.click();
        logger.info("Getting background color");
        return redSalesField.getCssValue("background-color");
    }

//    public ShopMainPage addInFavourites(){
//        driver.findElement(By.cssSelector(SALES_HEADER)).click();
//        Actions action = new Actions(driver);
//        action.moveToElement(driver.findElement(By.cssSelector(GOODS_BLOCK)));
//        action.build().perform();
//        driver.findElement(By.cssSelector(FAVOURITES_FIELD)).click();
//
//    }
}
