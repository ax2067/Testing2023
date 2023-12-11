package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.Browser;

public class AuthorPage {

    private static final String pageURL = "testdata.author.page.url";
    @FindBy(xpath = "//a[@data-id='search']")
    private WebElement searchPanel;

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement searchPanelText;

    @FindBy(xpath = "//h3[@class='css-p0xou9']")
    private WebElement searchResult;

    public AuthorPage() {
        PageFactory.initElements(Browser.getDriver(), this);
    }

    public AuthorPage openPage(){
        Browser.getDriver().get(pageURL);
        Browser.getDriver().manage().window().fullscreen();
        return this;
    }
    public AuthorPage clickSearchPanel(){
        searchPanel.click();
        return this;
    }

    public AuthorPage writeSearchPanelText(){
        searchPanelText.sendKeys("A Grocery Chain Just Fired Its Self-Checkouts");
        return this;
    }

    public boolean isSearchResultCorrect(){
        new WebDriverWait(Browser.getDriver(), 10);
        return searchResult.getText().contains("A Grocery Chain Just Fired Its Self-Checkouts");
    }
}
