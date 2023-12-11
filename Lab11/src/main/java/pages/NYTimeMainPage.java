package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webdriver.Browser;

public class NYTimeMainPage {
    private static final String pageURL = "testdata.nyt.main.page.url";

    public NYTimeMainPage() {
        PageFactory.initElements(Browser.getDriver(), this);
    }

    @FindBy(xpath = "//a[@lang='en-CA']")
    private WebElement changeLanguageButton;

    public NYTimeMainPage openPage(){
        Browser.getDriver().get(pageURL);
        Browser.getDriver().manage().window().fullscreen();
        return this;
    }
    public NYTimeMainPage clickChangeLanguageButton(){
        changeLanguageButton.click();
        return this;
    }

    public boolean isAllCookiesDeleted(){
        Browser.getDriver().manage().deleteAllCookies();

        return (Browser.getDriver().manage().getCookies().size() == 0);
    }
}
