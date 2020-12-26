package test;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.ShopMainPage;
import pageobject.SignInPage;
import service.UserCreator;

public class ShopMainPageTest extends CommonConditions {

    @Test
    public void checkSalesField() {
        String color = new ShopMainPage(driver).openPage().getSalesFieldColor();
        Assert.assertEquals(color,"rgba(239, 46, 35, 1)");
    }

    @Test
    public void registrationValidationTest() throws InterruptedException {
        User user = UserCreator.getWrongEmail();
        String error = new SignInPage(driver).openPage().openRegistration().registration(user.getName(), user.getPhone(), user.getEmail()).getInvalidRegistrationError();
        Assert.assertEquals(error, "Email не корректен");
    }

}
