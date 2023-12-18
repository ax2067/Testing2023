import junit.framework.Assert;
import listeners.RetryAnalyzer;
import org.testng.annotations.Test;
import pages.*;
import webdriver.Browser;

public class NYTimesTest extends BaseTest{

    // 1
    @Test(description = "Test changing language operation", retryAnalyzer = RetryAnalyzer.class)
    public void testChangeLanguage() throws InterruptedException {
        NYTimeMainPage mainPage = new NYTimeMainPage();
        mainPage.openPage().clickChangeLanguageButton();
        Assert.assertTrue(Browser.getDriver().getCurrentUrl().contains("ca"));
    }


    // 2
    @Test(description = "Test how user can save page", retryAnalyzer = RetryAnalyzer.class)
    public void testSavePage() {
        WirecutterMoney wirecutterMoney = new WirecutterMoney();
        wirecutterMoney.openPage()
                .clickCloseAddButton()
                .clickSavePageButton();
        Assert.assertTrue( wirecutterMoney.isElementExist());
    }

    // 3
    @Test(description = "Test filters", retryAnalyzer = RetryAnalyzer.class)
    public void testSearchFilters() {
        SearchResultPage page = new SearchResultPage();
        page.openPage()
                .chooseDataFilter()
               .chooseFilterDataOption();
        org.testng.Assert.assertEquals(Browser.getDriver().getCurrentUrl(), "https://www.nytimes.com/search?dropmab=false&query=Climate&sort=oldest", "Problems with filters");
    }

    // 4
    @Test(description = "Test searchbar", retryAnalyzer = RetryAnalyzer.class)
    public void testSearchField() throws InterruptedException {
        MainPage page = new MainPage();
        page.openPage()
                .clickCloseAddButton()
                .enterDataInSearchbar()
                .submitResult();
        org.testng.Assert.assertTrue(Browser.getDriver().getCurrentUrl().contains(MainPage.inputData), "Problem lies in search");
    }

    // 5
    @Test(description = "Test find article from author page", retryAnalyzer = RetryAnalyzer.class)
    public void findArticleTest() {
        AuthorPage page = new AuthorPage();
        page.openPage()
                .clickSearchPanel()
                .writeSearchPanelText();
        Assert.assertTrue(page.isSearchResultCorrect());
    }

    // 6
    @Test(description = "Test find article author page", retryAnalyzer = RetryAnalyzer.class)
    public void navigateToTheAuthorPageTest() throws InterruptedException {
        WirecutterMoney page = new WirecutterMoney();
        page.openPage()
                .clickCloseAddButton()
                .clickAuthorNameLink();
        Assert.assertTrue(page.isAuthorPage());
    }

    // 7
    @Test(description = "Test deals page", retryAnalyzer = RetryAnalyzer.class)
    public void testNavigationToDealPage() throws InterruptedException {
        DealPage page = new DealPage();
        page.openPage()
                .clickDealElement();
        Assert.assertFalse(page.isNotDealPage());
    }

    // 8
    @Test(description = "Test navigation to social sites", retryAnalyzer = RetryAnalyzer.class)
    public void testNavigationToSocialSite() throws InterruptedException {
        WirecutterMoney wirecutterMoney = new WirecutterMoney();
        wirecutterMoney.openPage()
                .clickCloseAddButton()
                .clickSocialSiteButton();
        Assert.assertTrue(wirecutterMoney.isSocialSitePage());
    }

    //9
    @Test(description = "Test adding cookies", retryAnalyzer = RetryAnalyzer.class)
    public void testAddingCookies() {
        WirecutterReviewsPage page = new WirecutterReviewsPage();
        page.openPage()
                .clickCloseAddButton();
        Assert.assertFalse(page.isCookiesEmpty());

    }
    //10
    @Test(description = "Test how site delete all cookies", retryAnalyzer = RetryAnalyzer.class)
    public void testDeleteCookiesLoggedUser() {
        NYTimeMainPage mainPage = new NYTimeMainPage();
        mainPage.openPage()
                .clickChangeLanguageButton();
        Assert.assertTrue(mainPage.isAllCookiesDeleted());
    }


}
