package webdriver;

import enums.BrowserType;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.BrowserFactory;

import java.util.List;

public class Browser {
    private static int DEFAULT_WAIT_IN_SECONDS = 30;
    private static WebDriver driver;

    public static void initDriver() {
        driver = BrowserFactory.createDriver(BrowserType.CHROME);
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public static void close() {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }

}