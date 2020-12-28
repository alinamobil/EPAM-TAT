package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import wait.CustomWaits;

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

    @FindBy(xpath = "//*[@class=\"catalog-grid js-to-max-height-wrap js_catalog_list\"]/div[2]/div[2]/span")
    private WebElement redSalesField;

    @FindBy(xpath = "//*[@class=\"js_insertAfterAjaxLazyLoad\"]/div[1]/div[1]/a")
    private WebElement goodsBlock;

    @FindBy(xpath = "//*[@class=\"product-rating-code\"]/div[1]/div[1]")
    private WebElement addToFavouriteButton;

    @FindBy(xpath = "//*[@class=\"small-dropdown_btn-row-alt\"]/div/div[2]/button")
    private WebElement commitAddToFavouriteButton;

    @FindBy(xpath = "//*[@class=\"basket-table-section_header\"]/sup")
    private WebElement numberOfFavourites;

    @FindBy(xpath = "//*[@class=\"basket-product-item_action\"]/div[4]/a")
    private WebElement deleteFavourite;

    @FindBy(xpath = "//*[@class=\"count-box_input   js-add-one-box-input\"]")
    private WebElement amountInput;

    @FindBy(xpath = "//*[@class=\"count-and-btn_btn\"]/button")
    private WebElement addToBucketButton;

    public ShopMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ShopMainPage openPage() {
        driver.navigate().to("https://www.oma.by");
        logger.info("Main page opened");
        return this;
    }

    public ShopMainPage openSales(){
        CustomWaits.untilPresenceOfElementLocated(driver, salesHeader);
        salesHeader.click();
        driver.navigate().refresh();
        return this;
    }

    public String getSalesFieldColor(){
        openSales();
        logger.info("Getting background color");
        return redSalesField.getCssValue("background-color");
    }

    public ShopMainPage addInFavourites(){
        openSales();
        goodsBlock.click();
        CustomWaits.untilPresenceOfElementLocated(driver, "//*[@class=\"product-rating-code\"]");
        addToFavouriteButton.click();
        CustomWaits.untilPresenceOfElementLocated(driver, "//*[@class=\"popup_title\"]");
        driver.findElements(By.xpath("//label[@class=\"checkbox-row\"]")).get(0).click();
        commitAddToFavouriteButton.click();
        CustomWaits.untilPresenceOfElementLocated(driver, "//*[@class=\"basket-table-section_header\"]/sup");
        driver.navigate().refresh();
        return this;
    }

    public String checkIsFavourite(){
        driver.findElement(By.xpath("//*[@class=\"popover-body\"]/div[2]/div/a")).click();
        String checked = numberOfFavourites.getText();
        deleteFavourite.click();
        return checked;
    }

    public String getActualAmountOfGoods(String amount) {
        openSales();
        goodsBlock.click();
        amountInput.sendKeys(amount);
        return amountInput.getAttribute("value");
    }

    public BucketPage addToBucket() {
        openSales();
        goodsBlock.click();
        addToBucketButton.click();
        CustomWaits.untilPresenceOfElementLocated(driver, "//*[@class=\"js-loyality-card-form buy-catalog\"]/div[2]/div[1]/a");
        driver.findElement(By.xpath("//*[@class=\"js-loyality-card-form buy-catalog\"]/div[2]/div[1]/a")).click();
        return new BucketPage(driver);
    }
}
