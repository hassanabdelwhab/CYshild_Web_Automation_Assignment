package com.cyshild.tests.base;


import com.cyshild.utilities.Log;
import com.paulhammant.ngwebdriver.NgWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.HashMap;

public class TestBase {
    public static WebDriver driver;
    JavascriptExecutor jse;
    public SoftAssert softAssert;
    NgWebDriver ngDriver;

@Parameters({"browserName"})
@BeforeTest(alwaysRun = true)
public void testSetup(@Optional("chrome")String browserName) throws Exception {
    try {
        Log.info("Initializing WebDriver for environment: ");
//GoogleChrome
        if (browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(setChromeOption());
        }
//FireFoxBrowser
        else if (browserName.equalsIgnoreCase("FireFox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(setFirefoxOptions());
        }

        jse = (JavascriptExecutor) driver;
        ngDriver = new NgWebDriver(jse).withRootSelector("\"app-root\"");
        driver.get("https://testing.todorvachev.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Log.info("Selenium WebDriver was initialized successfully ");

    } catch (Exception e) {
        Log.error("Error occurred while initializing selenium WebDriver for environment: ");
        driver.quit();
        System.exit(1);
    }
}



    private ChromeOptions setChromeOption() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default.content_settings.popups", 0);
        options.setExperimentalOption("prefs", chromePrefs);
        options.setAcceptInsecureCerts(true);
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
//        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-dev-shm-usage");

        // Automatically allow multiple downloads
        chromePrefs.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1);

        //hide popup Chrome message to save password
        chromePrefs.put("credentials_enable_service", false);
        //disable password manager
        chromePrefs.put("profile.password_manager_enabled", false);
        return options;
    }

    private FirefoxOptions setFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();

        // Set Firefox preferences
        options.addPreference("browser.download.folderList", 2); // Set download directory to Downloads folder
        options.addPreference("browser.download.manager.showWhenStarting", false); // Hide download manager
        options.addPreference("browser.download.panel.shown", false); // Hide download panel
        options.addPreference("browser.download.useDownloadDir", true); // Use default download directory
        options.addPreference("browser.helperApps.alwaysAsk.force", false); // Disable confirmation for downloads
        options.addPreference("browser.helperApps.defaultHandler.download", "application/octet-stream"); // Set default handler for downloads
        options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream,application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/zip");
        // Disable confirmation for specific file types

        // Set Firefox capabilities
        options.setCapability("marionette", true); // Enable Marionette
        options.setCapability("acceptInsecureCerts", true);
        options.setCapability("unhandledPromptBehaviour", "accept");

        // Set Firefox arguments
//        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-dev-shm-usage");

        return options;
    }


    @AfterTest
    public void quit() throws InterruptedException {
        Log.info("Closing selenium Web driver after test");
        driver.quit();
    }



}
