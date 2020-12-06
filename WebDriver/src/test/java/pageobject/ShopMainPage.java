package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopMainPage extends AbstractPage {

    private final static String HOMEPAGE_URL="https://www.oma.by";
    private final static String SEARCH_FIELD="js-search-input";
    private final static String SEARCH_BUTTON="header-search-form";
    private final static String SEARCH_WORD="//*[@id=\"searchForm\"]/div[4]/div/div[1]/div[1]/a";


    @FindBy(className = SEARCH_FIELD)
    private WebElement searchField;

    @FindBy(className = SEARCH_BUTTON)
    private WebElement searchButton;

    @FindBy(xpath = SEARCH_WORD)
    private WebElement searchWord;

    public ShopMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ShopMainPage openPage() {
        driver.navigate().to(HOMEPAGE_URL);
        return this;
    }

    public ShopMainPage wrongSearchWord(String searchword) {
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(searchField));
        searchField.sendKeys(searchword);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return new ShopMainPage(driver);
    }

    public String getWordCorrected() {
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(searchWord));
        return searchWord.getText();
    }
}
