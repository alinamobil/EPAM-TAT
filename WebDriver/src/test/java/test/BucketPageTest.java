package test;

import model.Goods;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.BucketPage;
import pageobject.ShopMainPage;
import service.GoodsCreator;
import util.StringUtils;

public class BucketPageTest extends CommonConditions {

    @Test
    public void costValidationTest() {
        Goods goods = GoodsCreator.withCredentialsFromProperty();
        String[] costs = new ShopMainPage(driver).openPage().addToBucket().getCostValidationParams(goods.getToBuy());
        Assert.assertEquals(StringUtils.getCostsRatio(costs), 10.0);
    }
}
