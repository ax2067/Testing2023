package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.Browser;



public class DealPage {

    private static final String pageURL = "https://www.nytimes.com/wirecutter/deals/";

    public DealPage() {
        PageFactory.initElements(Browser.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='product-link']")
    private WebElement dealElement;

    public DealPage openPage(){
        Browser.getDriver().get(pageURL);
        Browser.getDriver().manage().window().fullscreen();
        return this;
    }
    public DealPage clickDealElement(){
        dealElement.click();
        return this;
    }
    public boolean isNotDealPage(){
        new WebDriverWait(Browser.getDriver(), 10);
        String handle = Browser.getDriver().getWindowHandles().toArray()[1]
                .toString();
        Browser.getDriver().switchTo().window(handle);
        return (Browser.getDriver().getCurrentUrl().equals("https://www.nytimes.com/wirecutter/deals/")) ;
    }
}
