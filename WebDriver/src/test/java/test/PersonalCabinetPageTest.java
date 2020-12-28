package test;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.PersonalCabinetPage;
import service.UserCreator;
import util.StringUtils;

public class PersonalCabinetPageTest extends CommonConditions {

    @Test
    public void birthDateValidationTest(){
        User user = UserCreator.withCredentialsFromProperty();
        String date = new PersonalCabinetPage(driver, user).openPage().getBirthDate();
        Assert.assertEquals(StringUtils.isDateValid(date), false);
    }
}
