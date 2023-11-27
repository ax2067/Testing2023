import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends AbstractPage {
    private static final String pageURL = "https://www.nytimes.com/search?query=Climate";

    @FindBy(xpath = "//select[@class='css-v7it2b']")
    private WebElement dataFilter;

    @FindBy(xpath = "//option[@value='oldest']")
    private WebElement oldestDataOption;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultPage openPage(){
        driver.get(pageURL);
        driver.manage().window().fullscreen();
        return this;
    }

    public SearchResultPage chooseDataFilter(){
        dataFilter.click();
        return this;
    }
    public FilterResultPage chooseFilterDataOption(){
        oldestDataOption.click();
        return new FilterResultPage(driver);
    }


}
