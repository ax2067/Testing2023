package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webdriver.Browser;

public class SearchResultPage{
    private static final String pageURL = "testdata.search.page";

    public SearchResultPage() {
        PageFactory.initElements(Browser.getDriver(), this);
    }

    @FindBy(xpath = "//select[@class='css-v7it2b']")
    private WebElement dataFilter;

    @FindBy(xpath = "//option[@value='oldest']")
    private WebElement oldestDataOption;


    public SearchResultPage openPage(){
        Browser.getDriver().get(pageURL);
        Browser.getDriver().manage().window().fullscreen();
        return this;
    }

    public SearchResultPage chooseDataFilter(){
        dataFilter.click();
        return this;
    }
    public FilterResultPage chooseFilterDataOption(){
        oldestDataOption.click();
        return new FilterResultPage();
    }


}
