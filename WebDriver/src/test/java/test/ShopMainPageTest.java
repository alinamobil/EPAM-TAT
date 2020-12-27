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
    public void favouriteFunctionalTest() {
        User user = UserCreator.withCredentialsFromProperty();
        String  checked = new SignInPage(driver).openPage().signIn(user.getEmail(), user.getPassword()).addInFavourites().checkIsFavourite();
        Assert.assertEquals(checked,"1");
    }

}
