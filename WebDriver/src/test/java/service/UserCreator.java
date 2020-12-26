package service;

import model.User;

public class UserCreator {
    public static final String TESTDATA_USER_NAME = "testdata.user.name";
    public static final String TESTDATA_USER_PHONE = "testdata.user.phone";
    public static final String TESTDATA_USER_EMAIL = "testdata.user.email";

    public static User withCredentialsFromProperty(){
        return new User(TestDataReader.getTestData(TESTDATA_USER_NAME),
                TestDataReader.getTestData(TESTDATA_USER_PHONE), TestDataReader.getTestData(TESTDATA_USER_EMAIL));
    }

    public static User getWrongEmail(){
        return new User(TestDataReader.getTestData(TESTDATA_USER_NAME),
                TestDataReader.getTestData(TESTDATA_USER_PHONE),
                TestDataReader.getTestData(TESTDATA_USER_EMAIL).substring(0,10));
    }
}
