package pages;

import elements.Advertisement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.Browser;


public class MainPage {
    private static final String pageURL = "https://www.nytimes.com/wirecutter/";
    public static final String inputData = "Kitchen";
    @FindBy(xpath = "//input[@aria-label='Search Wirecutter']")
    private WebElement searchBar;

    @FindBy(xpath = "//button[@class='_43a6154d']")
    private WebElement closeAddButton;

    public MainPage() {
        PageFactory.initElements(Browser.getDriver(), this);
    }

    public MainPage clickCloseAddButton() {
        Advertisement addbutton = new Advertisement();
        if (addbutton.isAddBlockExist()) {
            Actions actions = new Actions(Browser.getDriver());
            actions.sendKeys(Keys.ESCAPE).perform();
        }
        return this;
    }

    public MainPage openPage() {
        Browser.getDriver().get(pageURL);
        Browser.getDriver().manage().window().fullscreen();
        return this;
    }

    public MainPage enterDataInSearchbar() {
        searchBar.sendKeys(inputData);
        return this;
    }

    public MainPage submitResult() {
        searchBar.submit();
        return this;
    }


}
