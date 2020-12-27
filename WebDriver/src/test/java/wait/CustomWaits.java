package wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWaits {
    private static final int WAIT_TIMEOUT_SECONDS = 10;

    public static void untilPresenceOfElementLocated(WebDriver driver, String xpath) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public static void untilPresenceOfElementLocated(WebDriver driver, WebElement webElement) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(webElement));
    }
}
