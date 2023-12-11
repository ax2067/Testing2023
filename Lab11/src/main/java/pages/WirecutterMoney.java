package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.Browser;

import static utils.Waiters.getScriptToScrollPage;

public class WirecutterMoney {
    private static final String pageURL = "testdata.wirecutter.money.page.url";

    public WirecutterMoney() {
        PageFactory.initElements(Browser.getDriver(), this);
    }
    public WirecutterMoney openPage(){
        Browser.getDriver().get(pageURL);
        Browser.getDriver().manage().window().fullscreen();
        return this;
    }

    @FindBy(xpath = "//button[@class='_43a6154d']")
    private WebElement closeAddButton;

    @FindBy(xpath = "//aside[@class='_575dd389 _50d75475']")
    private WebElement closeAddButton2;
    @FindBy(xpath = "//button[@data-save-content-name='save_article']")
    private WebElement savePageButton;

    @FindBy(xpath = "//div[@class='_93f997de']")
    private WebElement saveBlock;

    @FindBy(xpath = "//a[@data-gtm-trigger='author_name_link']")
    private WebElement authorNameLink;

    @FindBy(xpath = "//a[@data-gtm-trigger='share_twitter']")
    private WebElement socialSiteButton;

    @FindBy(xpath = "//li[@class='comment__share']")
    private WebElement copyPreLinkButton;
    @FindBy(xpath = "//input[@class='share__button link_url']")
    private WebElement copyLinkButton;

    public WirecutterMoney clickCopyPreLinkButton(){
        getScriptToScrollPage();
        new WebDriverWait(Browser.getDriver(), 10);
        getScriptToScrollPage(100);
        copyPreLinkButton.click();
        return this;
    }

    public WirecutterMoney clickCopyLinkButton(){
        copyLinkButton.click();
        return this;
    }

    public WirecutterMoney clickSocialSiteButton(){
        socialSiteButton.click();
        return this;
    }

    public WirecutterMoney clickAuthorNameLink(){
        authorNameLink.click();
        return this;
    }

    public WirecutterMoney clickCloseAddButton2(){
        new WebDriverWait(Browser.getDriver(), 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-testid='regi-modal']")));
        closeAddButton2.click();
        return this;
    }
    public WirecutterMoney clickCloseAddButton(){
        new WebDriverWait(Browser.getDriver(), 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='_43a6154d']")));
        closeAddButton.click();
        return this;
    }

    public WirecutterMoney clickSavePageButton(){
        savePageButton.click();
        return this;
    }


    public boolean isElementExist(){
        return closeAddButton2.isDisplayed();
    }

    public boolean isAuthorPage(){
        new WebDriverWait(Browser.getDriver(), 30).until(ExpectedConditions.urlToBe("https://www.nytimes.com/wirecutter/authors/nathan-burrow/"));
        return (Browser.getDriver().getCurrentUrl().equals("https://www.nytimes.com/wirecutter/authors/nathan-burrow/")) ;
    }

    public boolean isSocialSitePage(){

        String handle = Browser.getDriver().getWindowHandles().toArray()[1]
                .toString();
        Browser.getDriver().switchTo().window(handle);
        new WebDriverWait(Browser.getDriver(), 10);
        return (Browser.getDriver().getCurrentUrl().contains("twitter")) ;
    }

}
