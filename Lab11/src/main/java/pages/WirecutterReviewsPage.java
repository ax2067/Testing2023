package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.Browser;

public class WirecutterReviewsPage {

    private static final String pageURL = "https://www.nytimes.com/wirecutter/reviews/the-best-refrigerator/";

    @FindBy(xpath = "//button[@class='_43a6154d']")
    private WebElement closeAddButton;

    public WirecutterReviewsPage() {
        PageFactory.initElements(Browser.getDriver(), this);
    }
    public WirecutterReviewsPage openPage(){
        new WebDriverWait(Browser.getDriver(), 10);
        Browser.getDriver().get(pageURL);
        Browser.getDriver().manage().window().fullscreen();
        return this;
    }

    public WirecutterReviewsPage clickCloseAddButton(){
        new WebDriverWait(Browser.getDriver(), 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='_43a6154d']")));
        closeAddButton.click();
        return this;
    }
    public boolean isCookiesEmpty(){
        return (Browser.getDriver().manage().getCookies().isEmpty());
    }
}
