package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.Browser;

import java.util.List;


public class Waiters {

    public static WebElement waitForElementPresence(By locator) {
        return new WebDriverWait(Browser.getDriver(), 10)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static Object getScriptToScrollPage() {
        return ((JavascriptExecutor) Browser.getDriver()).executeScript("window.scrollBy(0, 16000)");
    }

    public static Object getScriptToScrollPage(int value) {
        return ((JavascriptExecutor) Browser.getDriver()).executeScript("window.scrollBy(0, value)");
    }

    public static List<WebElement> waitForVisibilityAllElements(String pageElement) {
        return new WebDriverWait(Browser.getDriver(), 10)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(pageElement)));
    }

}
