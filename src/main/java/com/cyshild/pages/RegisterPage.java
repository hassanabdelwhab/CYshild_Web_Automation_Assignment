package com.cyshild.pages;
import com.cyshild.base.PageBase;
import com.cyshild.constant.GeneralConstants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public class RegisterPage extends PageBase {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    private static final Duration waitTime = Duration.ofSeconds(30);


/////////////////////////////////////////ELEMENTS//////////////////////////////////////////////
    By titleRegisterPage= By.xpath("//h1[@class='entry-title']");
    By userIdHeader=By.xpath("//form/ul/li/label[text()='User id:']");
    By fieldHeaderList= By.xpath("//form[@name='registration']/ul/li/label");
    By userIdTextBox = By.xpath("//form[@name='registration']/ul/li/input[@name='userid']");
    By passwordTextBox = By.xpath("//form[@name='registration']/ul/li/input[@name='passid']");
    By nameTextBox = By.xpath("//form[@name='registration']/ul/li/input[@name='username']");
    By addressTXTBox=By.xpath("//form[@name='registration']/ul/li/input[@name='address']");
    By countryDDL= By.xpath("//form[@name='registration']/ul/li/select[@name='country']");
    By countryList= By.xpath("//form[@name='registration']/ul/li/select[@name='country']/option");
    By zipCodeTXTBox =By.xpath("//form[@name='registration']/ul/li/input[@name='zip']");
    By emailTXTBox= By.xpath("//form[@name='registration']/ul/li/input[@name='email']");
    By maleOption = By.xpath(" //form[@name='registration']/ul/li/input[@value='Male']");
    By registerButton = By.xpath("//input[@value='REGISTER']");

/////////////////////////////////////////////FUNCTIONS///////////////////////////////////////////////////

    public void navigateToRegisterForm(String url){
        navigateToURLAndWaitForElement(url,titleRegisterPage);
    }

    public void scrollToForm(){
        scrollToElement(userIdHeader);
    }

    public void enterUserID(String value) throws Exception {
        setText(userIdTextBox,value);
    }
    public void enterPassword(String value) throws Exception {
        setText(passwordTextBox,value);
    }
    public void enterName(String value) throws Exception {
        setText(nameTextBox,value);
    }
    public void enterAddress(String value) throws Exception {
        setText(addressTXTBox,value);
    }
    public void selectCountry() throws Exception {
        clickJSE(countryDDL);
        selectFromListByIndex(countryList, 1);
    }
    public void enterZIPCode(String value) throws Exception {
        setText(zipCodeTXTBox,value);
    }
    public void enterEmail(String value) throws Exception {
        setText(emailTXTBox,value);
    }
    public void selectMaleOption() throws Exception {
        clickJSE(maleOption);
    }

    public void clickingOnRegisterBTN() throws Exception {
        scrollAndClickByJSE(registerButton);
    }

    public void enterDataRegister(String Id, String password, String name,String address,String code, String email) throws Exception {
        enterUserID(Id);
        enterPassword(password);
        enterName(name);
        enterAddress(address);
        selectCountry();
        enterZIPCode(code);
        enterEmail(email);
        selectMaleOption();
    }
    public String getAlertMessage(){
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
       return alert.getText();
    }
    public void closeAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public String getCurrentURL() throws InterruptedException {
        return driver.getCurrentUrl();
    }

    public boolean validateList() throws Exception {
        return getListValues(fieldHeaderList).containsAll(GeneralConstants.REGISTER_FORM_HEADER);
    }


}
