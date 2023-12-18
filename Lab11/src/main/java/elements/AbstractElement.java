package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.Browser;

import java.util.List;

public abstract class AbstractElement {
    protected List<WebElement> getElements(String locator) {
        new WebDriverWait(Browser.getDriver(), 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        return Browser.getDriver().findElements(By.xpath(locator));
    }
}