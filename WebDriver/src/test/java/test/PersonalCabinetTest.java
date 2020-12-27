package test;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.PersonalCabinet;
import service.UserCreator;
import util.StringUtils;

public class PersonalCabinetTest extends CommonConditions {

    @Test
    public void birthDateValidationTest(){
        User user = UserCreator.withCredentialsFromProperty();
        String date = new PersonalCabinet(driver, user).openPage().getBirthDate();
        Assert.assertEquals(StringUtils.isDateValid(date), false);
    }
}
