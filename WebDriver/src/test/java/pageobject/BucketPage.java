package pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BucketPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    private final String COSTS = "//*[@class=\"dot-line-list_item dot-line-row dot-line-row__basket-total\"]/span[2]";

    @FindBy(xpath = "//*[@class=\"count-box_input   js-add-one-box-input js-JTM-change-basket\"]")
    private WebElement amountOfGoodsInput;

    @FindBy(xpath = "//*[@class=\"basket-product-item_action\"]/a")
    private WebElement deleteGoods;

    @FindBy(xpath = "//*[@class=\"side-info-box_bottom\"]/ul/li[1]/span[2]")
    private WebElement totalGoods;

    public BucketPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AbstractPage openPage() {
        return null;
    }

    public String[] getCostValidationParams(String toBuy){
        String[] costs = new String[2];
        costs[0] = driver.findElement(By.xpath(COSTS)).getText();
        amountOfGoodsInput.sendKeys(toBuy);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).
                until(ExpectedConditions.textToBePresentInElement(totalGoods, totalGoods.getText() + toBuy));
        costs[1] = driver.findElement(By.xpath(COSTS)).getText();
        deleteGoods.click();
        return costs;
    }

}
