package com.cyshild.base;
import com.cyshild.utilities.PropertiesReader;
import com.cyshild.utilities.Waits;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
//
//import static com.cyshild.utilities.Waits.pollingTime;
//import static com.cyshild.utilities.Waits.waitTime;
//import com.fawry.utilities.CustomExpectedConditions;


public class PageBase {

    public WebDriver driver;
    protected Waits waits;
    public static PropertiesReader propertiesReader = new PropertiesReader();

    JavascriptExecutor jse;
    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.jse = (JavascriptExecutor) driver;
        this.waits = new Waits(driver);
    }


    public void navigateToURLAndWaitForElement(String URL, By elementShouldBeLoaded) {
        driver.get(URL);
        waits.waitForVisibility(elementShouldBeLoaded);
    }

    public void navigateTo(String URL) {
        driver.get((URL));
    }
    public WebElement findElement(By locator) {
        return waits.waitForElementToBePresent(locator);
    }

    public void scrollToElement(By locator) {
        jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});", findElement(locator));
        waits.waitForElementToBeInViewport(locator);
    }
    public void clickJSE(By locator) throws Exception {
        if (locator != null) {
            jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].click();", waits.waitForElementToBeClickable(locator));
        } else
            throw new Exception("Web element 'locator' is null .. it could not be located");
    }

    public void scrollAndClickByJSE(By locator) throws Exception {
        if (locator != null) {
            scrollToElement(locator);
            clickJSE(locator);
        } else
            throw new Exception("Web element 'locator' is null .. it could not be located");
    }
    public void setText(By locator, String text) throws Exception {
        if (locator != null) {
            scrollAndClickByJSE(locator);
            findElement(locator).sendKeys(text);
        } else
            throw new Exception("Web element 'locator' is null .. it could not be located");
    }

    public List<WebElement> findElements(By locator) {

        return driver.findElements(locator);
    }
    public String generateID() {
        Random random = new Random();
        return String.valueOf(random.nextInt(90000) + 10000);
    }
    public WebElement getElementFromListByIndex(By listLocator, int index) {
        waits.waitForVisibility(listLocator);
        List<WebElement> elements = driver.findElements(listLocator);
        if (index < 0 || index >= elements.size()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for list of size " + elements.size());
        }
        return elements.get(index);
    }
    public void selectFromListByIndex(By listLocator, int index) throws Exception {
        if (listLocator != null) {
            waits.waitForVisibilityOfList(listLocator);
            waits.waitForElementToBeClickable(getElementFromListByIndex(listLocator, index)).click();
        } else
            throw new Exception("Web element 'locator' is null .. it could not be located");
    }

    public boolean checkValueInList(List<String> options, String... searchTerms) {
        for (String term : searchTerms) {
            boolean found = false;
            for (String option : options) {
                if (option.contains(term)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }
    public String getText(WebElement element) throws Exception {
        if (element != null) {
            return element.getText();
        } else
            throw new Exception("Web element 'locator' is null .. it could not be located");
    }

    public List<String> getListValues(By list) throws Exception {
        waits.waitForVisibilityOfList(list);
        List<String> values = new LinkedList<>();
        List<WebElement> elementList = findElements(list);
        for (WebElement element : elementList) {
            values.add(getText(element));
        }
        return values;
    }







}
