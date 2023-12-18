import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import webdriver.Browser;

public class BaseTest {
    @BeforeMethod
    public void init() {
        Browser.initDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void closePage() {
        Browser.close();
    }
}
