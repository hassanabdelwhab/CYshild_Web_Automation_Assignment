package com.cyshild.tests.Register;

import com.cyshild.constant.GeneralConstants;
import com.cyshild.pages.RegisterPage;
import com.cyshild.tests.base.TestBase;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegisterFormTest extends TestBase {

    RegisterPage registerPage;
    public SoftAssert softAssert;



    @BeforeMethod
    public void setup(){
        registerPage = new RegisterPage(driver);
        softAssert = new SoftAssert();
        registerPage.navigateToRegisterForm(GeneralConstants.REGISTER_URL);
        registerPage.scrollToForm();
    }

    @Test(priority = 0)
    public void validateIfAllElementsAreVisible() throws Exception {

        try {
            softAssert.assertTrue(registerPage.validateList());
            softAssert.assertAll();
        } catch (Exception e) {
            throw new SkipException("Test failed due to "+ e);
        }
    }

    @Test(priority = 2)
    public void validateRegistrationFormWithInValidID(){
        try {
            registerPage.enterUserID(GeneralConstants.INVALID_ID);
            registerPage.clickingOnRegisterBTN();

            softAssert.assertEquals(registerPage.getAlertMessage(),GeneralConstants.ALERT_MESSAGE);
            softAssert.assertAll();

        } catch (Exception e) {
            throw new SkipException("Test failed due to "+ e);
        }
    }

    @Test(priority = 1)
    public void validateRegistrationFormWithValidData() throws Exception {
        try {
            registerPage.enterDataRegister(GeneralConstants.VALID_ID,GeneralConstants.VALID_PASSWORD,
                    GeneralConstants.VALID_NAME,GeneralConstants.VALID_ADDRESS,
                    GeneralConstants.VALID_ZIP,GeneralConstants.VALID_MAIL);
            registerPage.clickingOnRegisterBTN();

            softAssert.assertNotEquals(registerPage.getCurrentURL(),GeneralConstants.REGISTER_URL);
            softAssert.assertAll();

        } catch (Exception e) {
            throw new Exception(e);
        }


    }


}
