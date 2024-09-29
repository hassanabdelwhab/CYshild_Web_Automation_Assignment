package com.cyshild.constant;

import org.openqa.selenium.WebElement;

import java.util.List;

public class GeneralConstants{
    public static final String USER_DIR = "user.dir";
    public static final String INVALID_ID= "123";
    public static final String ALERT_MESSAGE= "User Id should not be empty / length be between 5 to 12";

    ////////////Valid Data///////////////////////////
    public static final String VALID_ID= "123456789";
    public static final String VALID_PASSWORD= "123456789";
    public static final String VALID_NAME= "TestAutomation";
    public static final String VALID_ADDRESS= "TestAddress";
    public static final String VALID_ZIP= "1234";
    public static final String VALID_MAIL= "test@test.com";
    public static final String REGISTER_URL= "https://testing.todorvachev.com/register-form/";
    public static final List<String> REGISTER_FORM_HEADER = List.of("User id:","Password:","Name:","Address:","Country:","ZIP Code:","Email:","Sex:","English:","About:");



}
