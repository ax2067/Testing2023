import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {
    private static final String pageURL = "https://www.nytimes.com/wirecutter/";
    protected static final String inputData = "Kitchen";
    @FindBy(xpath = "//input[@aria-label='Search Wirecutter']")
    private WebElement searchBar;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage openPage(){
        driver.get(pageURL);
        driver.manage().window().fullscreen();
        return this;
    }
    public MainPage enterDataInSearchbar(){
        searchBar.sendKeys(inputData);
        return this;
    }
    public MainPage submitResult(){
        searchBar.submit();
        return this;
    }



}
