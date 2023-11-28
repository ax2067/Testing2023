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

public class NYTimesTest {
    WebDriver driver = null;

    @BeforeMethod(alwaysRun = true)
    public void setUpDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\!Install\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test(description = "Test filters")
    public void testSearchFilters() {
        SearchResultPage page = new SearchResultPage(driver);
        page.openPage()
                .chooseDataFilter()
                .chooseFilterDataOption();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.nytimes.com/search?dropmab=false&query=Climate&sort=oldest", "Problems with filters");
    }

    @Test(description = "Test searchbar")
    public void testSearchField() throws InterruptedException {
        MainPage page = new MainPage(driver);
        page.openPage()
                .enterDataInSearchbar()
                .submitResult();
        Assert.assertTrue(driver.getCurrentUrl().contains(MainPage.inputData), "Problem lies in search");
    }

    @AfterMethod(alwaysRun = true)
    public void closeWebPage() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
        driver.quit();
        driver = null;
    }
}
