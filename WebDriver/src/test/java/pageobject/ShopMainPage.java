package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopMainPage extends AbstractPage {

    private final static String HOMEPAGE_URL="https://www.oma.by";
    private final static String SEARCH_FIELD="js-search-input";
    private final static String SEARCH_BUTTON="header-search-form";
    private final static String SEARCH_WORD="//*[@id=\"searchForm\"]/div[4]/div/div[1]/div[1]/a";
    //private final static String SALES_HEADER=".header-menu_items:nth-child(1) > div:nth-child(2) > a";
    private final static String SALES_HEADER="//*[@class=\"header-menu clearfix\"]/div[2]/div[2]";
    private final static String RED_SALES_FIELD="//*[@class=\"catalog-grid js-to-max-height-wrap js_catalog_list\"]/div[1]/div[2]/span";


    @FindBy(className = SEARCH_FIELD)
    private WebElement searchField;

    @FindBy(className = SEARCH_BUTTON)
    private WebElement searchButton;

    @FindBy(xpath = SEARCH_WORD)
    private WebElement searchWord;

    @FindBy(xpath = SALES_HEADER)
    private WebElement salesHeader;

    @FindBy(xpath = RED_SALES_FIELD)
    private WebElement redSalesField;

    public ShopMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ShopMainPage openPage() {
        driver.navigate().to(HOMEPAGE_URL);
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
