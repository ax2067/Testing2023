package pages;

import elements.Advertisement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.Browser;

public class WirecutterReviewsPage {

    private static final String pageURL = "https://www.nytimes.com/wirecutter/reviews/the-best-refrigerator/";

    @FindBy(xpath = "//div[@class='b51cee81']/h3/following-sibling::div/following-sibling::button")
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
        Advertisement addbutton = new Advertisement();
        if(addbutton.isAddBlockExist()){
//        new WebDriverWait(Browser.getDriver(), 10)
//                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='b51cee81']/h3/following-sibling::div/following-sibling::button")));
            Actions actions = new Actions(Browser.getDriver());
            actions.sendKeys(Keys.ESCAPE).perform();
        }
        return this;
    }
    public boolean isCookiesEmpty(){
        return (Browser.getDriver().manage().getCookies().isEmpty());
    }
}
