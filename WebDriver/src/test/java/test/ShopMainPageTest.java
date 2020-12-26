package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.ShopMainPage;
import pageobject.SignInPage;

public class ShopMainPageTest extends CommonConditions {

    @Test
    public void checkSalesField() {
        String color = new ShopMainPage(driver).openPage().getSalesFieldColor();
        Assert.assertEquals(color,"rgba(239, 46, 35, 1)");
    }

    @Test
    public void registrationValidationTest() throws InterruptedException {
        String error = new SignInPage(driver).openPage().openRegistration().registration("Alina","123456789","wrongemail.com").getInvalidRegistrationError();
        Assert.assertEquals(error, "Email не корректен");
    }

}
