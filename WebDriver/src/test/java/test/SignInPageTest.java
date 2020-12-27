package test;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.SignInPage;
import service.UserCreator;

public class SignInPageTest extends CommonConditions{

    @Test
    public void registrationValidationTest() {
        User user = UserCreator.getWrongEmail();
        String error = new SignInPage(driver).openPage().openRegistration().registration(user.getName(), user.getPhone(), user.getEmail()).getInvalidRegistrationError();
        Assert.assertEquals(error, "Email не корректен");
    }
}
