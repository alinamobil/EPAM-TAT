package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage extends AbstractPage{

    private final static String SIGN_IN_BUTTON = ".dropdown-group__gray-arrow > a";
    private final static String REGISTRATION_BUTTON = ".register-section_form-col > form > div > a";
    private final static String SIGN_IN_DESTINATION = "page-title_title-cell";
    private final static String NAME_FIELD = "field_218dad245a1324b2aa93093438eeb1100";
    private final static String PHONE_FIELD = "field_35483e3d9d7705b50f45291aa3a6cfad0";
    private final static String EMAIL_FIELD = "field_d5aecc26cfa2335ea63b0b1591b9b6b00";
    private final static String SUBMIT_REGISTRATION = "//*[@id=\"register-default_btn\"]" + "[@class='btn btn__orange btn__xl btn__widest js_submit_form']";
    private final static String EMAIL_ERROR = ".js_form_row_d5aecc26cfa2335ea63b0b1591b9b6b00 > span:nth-child(3)";
    private final static String BANNER_BUTTON = "close-btn";

    @FindBy(id = NAME_FIELD)
    private WebElement nameField;

    @FindBy(id = PHONE_FIELD)
    private WebElement phoneField;

    @FindBy(id = EMAIL_FIELD)
    private WebElement emailField;

    @FindBy(xpath = SUBMIT_REGISTRATION)
    private WebElement submitRegistration;

    @FindBy(id = BANNER_BUTTON)
    private WebElement bannerButton;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SignInPage openPage() {
        ShopMainPage home = new ShopMainPage(driver);
        home.openPage();
        driver.findElement(By.cssSelector(SIGN_IN_BUTTON)).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.className(SIGN_IN_DESTINATION)));
        return this;
    }

    public SignInPage openRegistration() {
        driver.findElement(By.cssSelector(REGISTRATION_BUTTON)).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.className(SIGN_IN_DESTINATION)));
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
        return this;
    }

    public String getInvalidRegistrationError() throws InterruptedException {
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
