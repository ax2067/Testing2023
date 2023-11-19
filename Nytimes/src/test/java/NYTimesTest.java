import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class NYTimesTest {
    WebDriver driver = null;

    @BeforeMethod(alwaysRun = true)
    public void setUpDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\!Install\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test(description = "Test changing language operation")
    public void testChangeLanguage() {
        driver.get("https://www.nytimes.com/international/");
        WebElement changeLanguageButton = setWebElement(By.xpath("//a[@lang='es-ES']"));
        changeLanguageButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.nytimes.com/es/?redirect_uri=https%3A%2F%2Fwww.nytimes.com%2Finternational%2F", "Problem with changing language");
    }

    @Test(description = "Test how site delete all cookies")
    public void testDeleteCookiesLoggedUser() {
        driver.get("https://www.nytimes.com/subscription/onboarding-offer?campaignId=7JFJX&EXIT_URI=https%3A%2F%2Fwww.nytimes.com%2Finternational%2F&login=email&auth=login-email");
        WebElement changeLanguageButton = setWebElement(By.xpath("//a[@class='onOffPLObundle__getstarted']"));
        changeLanguageButton.click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        driver.manage().deleteAllCookies();
        Assert.assertEquals(driver.manage().getCookies().size(), 0, "Problems with cookies");
    }

    @Test(description = "Test how user can save page")
    public void testSavePage() {
        driver.get("https://www.nytimes.com/wirecutter/money/rei-gear-up-get-out-sale-2023-1114/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        driver.manage().window().fullscreen();
        WebElement savePageButton = setWebElement(By.xpath("//button[@data-save-content-name='save_article']"));
        savePageButton.click();
        List<WebElement> saveBlock = driver.findElements(By.xpath("//div[@class='a25d1d11']"));
        Assert.assertTrue(!saveBlock.isEmpty());
    }

    @Test(description = "Test find article from author page")
    public void findArticleTest() {
        driver.get("https://www.nytimes.com/by/claire-moses");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        WebElement searchPanel = setWebElement(By.xpath("//a[@data-id='search']"));
        searchPanel.click();
        WebElement searchPanelText = setWebElement(By.xpath("//input[@placeholder='Search']"));
        searchPanelText.sendKeys("A Grocery Chain Just Fired Its Self-Checkouts");
        WebElement searchResult = setWebElement(By.xpath("//h3[@class='css-p0xou9']"));
        Assert.assertTrue(searchResult.getText().contains("A Grocery Chain Just Fired Its Self-Checkouts"));
    }

    @Test(description = "Test find article author page")
    public void navigateToTheAuthorPageTest() throws InterruptedException {
        driver.get("https://www.nytimes.com/wirecutter/money/rei-gear-up-get-out-sale-2023-1114/");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        WebElement authorNameLink = setWebElement(By.xpath("//a[@data-gtm-trigger='author_name_link']"));
        authorNameLink.click();
        Thread.sleep(4000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.nytimes.com/wirecutter/authors/nathan-burrow/", "Author link doesn't work");
    }

    @Test(description = "Test searchbar")
    public void testEmailField() {
        driver.get("https://www.nytimes.com/wirecutter/");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        WebElement searchBar = setWebElement(By.xpath("//input[@aria-label='Search Wirecutter']"));
        searchBar.sendKeys("Kitchen");
        WebElement submitButton = setWebElement(By.xpath("//button[@type='submit']"));
        submitButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement titleResult = setWebElement(By.xpath("//h3[@class='c234c10f']"));
        Assert.assertTrue(titleResult.getText().contains("Kitchen"), "Problem lies in search");
    }

    @Test(description = "Test filters")
    public void testSearchFilters() {
        driver.get("https://www.nytimes.com/search?query=Climate");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        WebElement filterButton = setWebElement(By.xpath("//select[@class='css-v7it2b']"));
        filterButton.click();
        WebElement filterOption = setWebElement(By.xpath("//option[@value='oldest']"));
        filterOption.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.nytimes.com/search?dropmab=false&query=Climate&sort=oldest", "Problems with filters");
    }

    @Test(description = "Test deals page")
    public void testNavigationToDealPage() throws InterruptedException {
        driver.get("https://www.nytimes.com/wirecutter/deals/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        WebElement closeButton = setWebElement(By.xpath("//button[@class='_27f88555']"));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
        closeButton.click();
        WebElement dealOption = setWebElement(By.xpath("//li[@class='dea75f89 swiper-slide _7437d1fd swiper-slide-visible swiper-slide-active']"));
        dealOption.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String handle = driver.getWindowHandles().toArray()[1]
                .toString();
        driver.switchTo().window(handle);
        Thread.sleep(3000);
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://www.nytimes.com/wirecutter/deals/", "Problems with navigation");
    }

    @Test(description = "Test navigation to social sites")
    public void testNavigationToSocialSite() throws InterruptedException {
        driver.get("https://www.nytimes.com/wirecutter/reviews/best-cutting-board/");
        WebElement closeButton = setWebElement(By.xpath("//button[@class='_27f88555']"));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        closeButton.click();
        WebElement socialSiteButton = setWebElement(By.xpath("//a[@class='_4bf55385 _0d56c34f']"));
        socialSiteButton.click();
        String handle = driver.getWindowHandles().toArray()[1]
                .toString();
        driver.switchTo().window(handle);
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://twitter.com/i/flow/login?redirect_after_login=%2Fintent%2Ftweet%3Ftext%3DThe%2520Best%2520Cutting%2520Boards%2520%257C%2520Wirecutter%26url%3Dhttps%3A%2F%2Fwww.nytimes.com%2Fwirecutter%2Freviews%2Fbest-cutting-board%2F%26via%3Dwirecutter", "Problem with social site navigation");
    }

    @Test(description = "Test adding cookies")
    public void testAddingCookies() {
        driver.get("https://www.nytimes.com/wirecutter/reviews/the-best-refrigerator/");
        Assert.assertTrue(!driver.manage().getCookies().isEmpty(), "Problem lies in adding cookies");
    }


    @AfterMethod(alwaysRun = true)
    public void closeWebPage() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
        driver.quit();
        driver = null;

    }

    private WebElement setWebElement(By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(by));
    }


}

