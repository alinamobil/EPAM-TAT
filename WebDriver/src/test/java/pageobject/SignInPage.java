package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage extends AbstractPage{

    private final static String SIGN_IN_BUTTON = ".dropdown-group__gray-arrow > a";
    private final static String REGISTRATION_BUTTON = ".register-section_form-col > form > div > a";
    private final static String SIGN_IN_DESTINATION = "page-title_title-cell";
    private final static String NAME_FIELD = "field_218dad245a1324b2aa93093438eeb1100";
    private final static String PHONE_FIELD = "field_35483e3d9d7705b50f45291aa3a6cfad0";
    private final static String EMAIL_FIELD = "field_d5aecc26cfa2335ea63b0b1591b9b6b00";
    private final static String SUBMIT_REGISTRATION = "register-default_btn";
    private final static String EMAIL_ERROR = ".js_form_row_d5aecc26cfa2335ea63b0b1591b9b6b00 > span:nth-child(3)";

    @FindBy(id = NAME_FIELD)
    private WebElement nameField;

    @FindBy(id = PHONE_FIELD)
    private WebElement phoneField;

    @FindBy(id = EMAIL_FIELD)
    private WebElement emailField;

    @FindBy(id = SUBMIT_REGISTRATION)
    private WebElement submitRegistration;

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
        submitRegistration.click();
        return this;
    }

    public String getInvalidRegistrationError() throws InterruptedException {
        Thread.sleep(2000);
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
