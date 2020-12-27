package pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage extends AbstractPage{

    private final Logger logger = LogManager.getRootLogger();
    private final static String EMAIL_ERROR = ".js_form_row_d5aecc26cfa2335ea63b0b1591b9b6b00 > span:nth-child(3)";

    @FindBy(id = "field_218dad245a1324b2aa93093438eeb1100")
    private WebElement nameField;

    @FindBy(id = "field_35483e3d9d7705b50f45291aa3a6cfad0")
    private WebElement phoneField;

    @FindBy(id = "field_d5aecc26cfa2335ea63b0b1591b9b6b00")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id=\"register-default_btn\"]" + "[@class='btn btn__orange btn__xl btn__widest js_submit_form']")
    private WebElement submitRegistration;

    @FindBy(id = "close-btn")
    private WebElement bannerButton;

    @FindBy(xpath = "//*[@id=\"register-email\"]")
    private WebElement signInEmail;

    @FindBy(xpath = "//*[@id=\"register-pass\"]")
    private WebElement signInPassword;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SignInPage openPage() {
        ShopMainPage home = new ShopMainPage(driver);
        home.openPage();
        driver.findElement(By.cssSelector(".dropdown-group__gray-arrow > a")).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.className("page-title_title-cell")));
        logger.info("SignIn page opened");
        return this;
    }

    public SignInPage openRegistration() {
        driver.findElement(By.cssSelector(".register-section_form-col > form > div > a")).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.className("page-title_title-cell")));
        logger.info("Registration page opened");
        return this;
    }

    public SignInPage registration(String name, String phone, String email) {
        fillNameField(name);
        fillPhoneField(phone);
        fillEmailField(email);
        driver.findElement(By.className("page-title_title-cell")).click();
        bannerButton.click();
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(250))
                .withMessage("Element was not found")
                .until(ExpectedConditions.visibilityOf(submitRegistration))
                .click();
        logger.info("Registration attempt committed");
        return this;
    }

    public ShopMainPage signIn(String email, String password) {
        signInEmail.sendKeys(email);
        signInPassword.sendKeys(password);
        driver.findElement(By.xpath("//Button[contains(text(), 'Войти на сайт')]")).click();
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[@class=\"content-profile\"]")));
        return new ShopMainPage(driver).openPage();
    }

    public String getInvalidRegistrationError() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(EMAIL_ERROR), "Email не корректен"));
        return driver.findElement(By.cssSelector(EMAIL_ERROR)).getText();
    }

    private void fillNameField(String name) {
        nameField.sendKeys(name);
    }

    private void fillPhoneField(String phone) {
        phoneField.sendKeys(phone);
    }

    private void fillEmailField(String email) {
        emailField.sendKeys(email);
    }
}
