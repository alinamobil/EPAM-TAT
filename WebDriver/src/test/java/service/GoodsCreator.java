package service;

import model.Goods;

public class GoodsCreator {
    public static final String TESTDATA_GOODS_AMOUNT = "testdata.goods.amount";
    public static final String TESTDATA_GOODS_TO_BUY = "testdata.goods.to.buy";

    public static Goods withCredentialsFromProperty(){
        return new Goods(TestDataReader.getTestData(TESTDATA_GOODS_AMOUNT), TestDataReader.getTestData(TESTDATA_GOODS_TO_BUY));
    }
}
