import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import webdriver.Browser;

public class BaseTest {
    @BeforeSuite
    public void init() {
        Browser.initDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void closePage() {
        //Browser.close();
    }
}
