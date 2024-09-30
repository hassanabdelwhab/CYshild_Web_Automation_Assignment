package com.cyshild.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class Waits {

    WebDriver driver;
    private static final Duration waitTime = Duration.ofSeconds(30);
    private static final Duration pollingTime = Duration.ofMillis(500);

    public Waits(WebDriver driver) {
        this.driver = driver;
    }
    /////////////////////////////// VISIBILITY ///////////////////////////////
    public WebElement waitForVisibility(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(waitTime)
                .pollingEvery(pollingTime)
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(org.openqa.selenium.StaleElementReferenceException.class);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public static ExpectedCondition<WebElement> presenceOfElementLocated(final By locator) {
        return new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }

            public String toString() {
                return "presence of element located by: " + locator;
            }
        };
    }
    public void waitForElementToBeInViewport(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(waitTime)
                .pollingEvery(pollingTime)
                .ignoring(WebDriverException.class)
                .ignoring(org.openqa.selenium.StaleElementReferenceException.class)
                .ignoring(Exception.class);
        wait.until(presenceOfElementLocated(locator));
    }

    public WebElement waitForElementToBePresent(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(waitTime)
                .pollingEvery(pollingTime)
                .ignoring(NoSuchElementException.class)
                .ignoring(org.openqa.selenium.StaleElementReferenceException.class);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public WebElement waitForElementToBeClickable(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(waitTime)
                .pollingEvery(pollingTime)
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(org.openqa.selenium.StaleElementReferenceException.class);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));

    }
    public WebElement waitForElementToBeClickable(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(waitTime)
                .pollingEvery(pollingTime)
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(org.openqa.selenium.StaleElementReferenceException.class);
        return wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public void waitForVisibilityOfList(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(waitTime)
                .pollingEvery(pollingTime)
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(org.openqa.selenium.StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }




}
