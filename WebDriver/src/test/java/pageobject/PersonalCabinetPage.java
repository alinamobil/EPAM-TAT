package pageobject;

import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wait.CustomWaits;

public class PersonalCabinetPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    private User user;

    public PersonalCabinetPage(WebDriver driver, User user) {
        super(driver);
        this.user = user;
    }

    @Override
    public PersonalCabinetPage openPage(){
        SignInPage signIn = new SignInPage(driver);
        signIn.openPage();
        signIn.signIn(user.getEmail(), user.getPassword());
        driver.findElements(By.xpath("//a[@href=\"/personal/\"]")).get(1).click();
        CustomWaits.untilPresenceOfElementLocated(driver,"//*[@class=\"content-profile\"]");
        logger.info("Opened Personal cabinet");
        return this;
    }

    public String getBirthDate(){
        return driver.findElements(By.xpath("//*[@class=\"dot-line-row_end\"]")).get(12).getText().trim();
    }
}
